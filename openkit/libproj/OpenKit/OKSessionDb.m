//
//  OKSessionDb.m
//  OpenKit
//
//  Created by Louis Zell on 8/22/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "FMResultSet.h"
#import "FMDatabase.h"
#import "OKSessionDb.h"
#import "OKLocalCache.h"
#import "OKMacros.h"
#import "OKNetworker.h"
#import "OKUtils.h"

// TODO: Remove this dependency.
#import "OKUser.h"


static NSString *const kSessionTableCreateSql =
    @"CREATE TABLE 'sessions' "
    "("
    "'id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , "
    "'uuid' VARCHAR(255) , "
    "'fb_id' VARCHAR(40), "
    "'fb_active' BOOLEAN, "
    "'google_id' VARCHAR(40), "
    "'google_active' BOOLEAN, "
    "'custom_id' VARCHAR(40), "
    "'custom_active' BOOLEAN, "
    "'ok_id' VARCHAR(40), "
    "'ok_active' BOOLEAN, "
    "'push_token' VARCHAR(64), "
    "'client_created_at' DATETIME"
    ")"
    "\n"        // Important.
    "CREATE TABLE 'submissions' "
    "("
    "'id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , "
    "'payload' TEXT , "
    "'status' INTEGER "
    "); ";


static NSString *const kSessionTableVersion = @"0.0.38";

//
// Classes defined here are not part of the public API.  Please do
// not use them as implementation is subject to change.
//
@interface OKSessionTemplate : NSObject
@property (nonatomic, copy) NSString *uuid;
@property (nonatomic, copy) NSString *fbId;
@property (nonatomic, copy) NSString *googleId;
@property (nonatomic, copy) NSString *customId;
@property (nonatomic, copy) NSString *pushToken;
// Temporary.
@property (nonatomic, copy) NSString *okId;
@end

@implementation OKSessionTemplate

// TODO: Remove this dependency.
- (void)migrateUser
{
    OKUser *user = [OKUser currentUser];
    if (user) {
        self.okId = user.OKUserID ? [user.OKUserID stringValue] : nil;
        self.fbId = user.fbUserID ? user.fbUserID : nil;
        self.customId = user.customID ? user.customID : nil;
    }
}


@end

@interface OKSessionRow : OKSessionTemplate
@property (nonatomic, readonly, weak) OKSessionDb *db;
@property (nonatomic, assign) int rowId;
@property (nonatomic, retain) NSDate *clientCreatedAt;
@end

@implementation OKSessionRow

- (id)initWithDb:(OKSessionDb *)db
{
    if ((self = [super init])) {
        _db = db;
    }
    return self;
}

- (OKSessionTemplate *)templatize
{
    OKSessionTemplate *template = [[OKSessionTemplate alloc] init];
    template.uuid = self.uuid;
    template.fbId = self.fbId;
    template.googleId = self.googleId;
    template.customId = self.customId;
    template.pushToken = self.pushToken;
    template.okId = self.okId;
    return template;
}

- (NSMutableDictionary *)dictionary
{
    NSString *sqlDate = nil;
    if (self.clientCreatedAt) {
        sqlDate = [OKUtils sqlStringFromDate:self.clientCreatedAt];
    }
    
    return [[NSMutableDictionary alloc] initWithObjectsAndKeys:
            self.uuid, @"uuid",
            self.fbId ? self.fbId : [NSNull null], @"fb_id",
            self.googleId ? self.googleId : [NSNull null], @"google_id",
            self.customId ? self.customId : [NSNull null], @"custom_id",
            self.pushToken ? self.pushToken : [NSNull null], @"push_token",
            self.okId ? self.okId : [NSNull null], @"ok_id",
            sqlDate ? sqlDate : [NSNull null], @"client_created_at",
            nil];
}

- (void)enqueueForUpload
{
    OKLog(@"I'm not doing anything.  Weeee!");
    // Create an entry in OKSubmission, which is just a single
    // TEXT column and an enum for status (pending, submitting, submitted).
}
@end


@implementation OKSessionDb

+ (id)db
{
    id db = [[self alloc] initWithCacheName:@"Session" createSql:kSessionTableCreateSql version:kSessionTableVersion];
    return db;
}

- (OKSessionRow *)lastRow
{
    __block OKSessionRow *row = nil;
    [self access:^(FMDatabase *db){
        FMResultSet *rs = [db executeQuery:@"select * from sessions order by client_created_at DESC limit 1"];
        while ([rs next]) {
            row = [[OKSessionRow alloc] initWithDb:self];
            row.rowId = [rs intForColumn:@"id"];
            row.uuid = [rs stringForColumn:@"uuid"];
            row.fbId = [rs stringForColumn:@"fb_id"];
            row.googleId = [rs stringForColumn:@"google_id"];
            row.customId = [rs stringForColumn:@"custom_id"];
            row.pushToken = [rs stringForColumn:@"push_token"];
            row.okId = [rs stringForColumn:@"ok_id"];
            row.clientCreatedAt = [rs dateForColumn:@"client_created_at"];
        }
    }];

    return row;
}


// Session updates are always relayed to the backend.  It is the backend's job to
// figure out how to stitch sessions together into single OKUser's attributes, e.g
// facebook id, push tokens, google id, etc.
- (OKSessionRow *)insertRow:(OKSessionTemplate *)t
{
    NSDate *now = [NSDate date];
    if (![self update:@"insert into sessions (uuid, fb_id, google_id, custom_id, ok_id, push_token, client_created_at) values (?, ?, ?, ?, ?, ?, ?) ", t.uuid, t.fbId, t.googleId, t.customId, t.okId, t.pushToken, now]) {
        OKLogErr(@"Could not create new session.");
        return nil;
    }

    OKSessionRow *row = nil;
    if(!(row = [self lastRow])) {
        OKLogErr(@"New session created, but could not fetch it.");
        return nil;
    }

    // TODO: Stuff records into a submit queue and retrying if fail.
    NSMutableDictionary *dictionary = [row dictionary];
    [dictionary setObject:kSessionTableVersion forKey:@"client_db_version"];
    [OKNetworker postToPath:@"/client_sessions" parameters:dictionary handler:^(id responseObject, NSError *error) {
        if (!error) {
            OKLogInfo(@"Offloaded Session. Yay.");
        } else {
            OKLogErr(@"!!!!!!!!! %@", error.localizedDescription);
        }
    }];

    return row;
}

- (void)activate
{
    OKSessionRow *row = [self lastRow];
    if (row == nil) {
        OKSessionTemplate *template = [[OKSessionTemplate alloc] init];
        [template migrateUser];
        template.uuid = [OKUtils createUUID];
        row = [self insertRow:template];
    }
    OKLogInfo(@"Current OK Session: rowId: %i, uuid: %@, okId: %@, fbId: %@, pushToken: %@, clientCreatedAt: %@", row.rowId, row.uuid, row.okId, row.fbId, row.pushToken, row.clientCreatedAt);
}


- (void)registerPush:(NSString *)aPushToken
{
    [self newVal:aPushToken getSelName:@"pushToken" setSelName:@"setPushToken:"];
}

// See comment on -registerPush.
// DRY this.
- (void)loginFB:(NSString *)aFacebookId
{
    [self newVal:aFacebookId getSelName:@"fbId" setSelName:@"setFbId:"];
}

- (void)logoutFB
{

}

- (void)loginGoogle:(NSString *)aGoogleId
{

}

- (void)logoutGoogle
{

}

- (void)loginCustom:(NSString *)aCustomId
{

}

- (void)logoutCustom
{

}


// Temporary.
// See comment on -registerPush.
// DRY this.
- (void)loginOpenKit:(NSString *)anOpenKitId
{
    [self newVal:anOpenKitId getSelName:@"okId" setSelName:@"setOkId:"];
}

- (void)logoutOpenKit
{
    
}

// The logic here works like this:
// If there is no session, create a new session and set push token.
// If there is a previous session but no push token, create new row with same uuid and set token.
// If there is a previous session and push token, and the previous token matches next, do nothing.
// If there is a previous session and push token, and the previous token doesn't match next, create new row with _new_ uuid and set token.
- (void)newVal:(NSString *)newVal getSelName:(NSString *)getName setSelName:(NSString *)setName
{
    SEL getSelector = NSSelectorFromString(getName);
    SEL setSelector = NSSelectorFromString(setName);
    
    OKSessionRow *row = [self lastRow];
    OKSessionTemplate *template = nil;
    if (row == nil) {
        OKLogInfo(@"No previous session found.  Creating new row with new uuid and new %@.", getName);
        template = [[OKSessionTemplate alloc] init];
        [template migrateUser];
        template.uuid = [OKUtils createUUID];
    } else {
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Warc-performSelector-leaks"
        NSString *prevVal = [row performSelector:getSelector];
#pragma clang diagnostic pop
        if (prevVal == nil) {
            OKLogInfo(@"Row exists but no val, creating new row with same uuid and new %@.", getName);
            template = [row templatize];
        } else if (![prevVal isEqualToString:newVal]) {
            OKLogInfo(@"Prev and new vals do not match. Creating new row with new uuid and new %@.", getName);
            template = [row templatize];
            template.uuid = [OKUtils createUUID];
        } else {
            OKLogInfo(@"%@ is already up to date in db.  Not updating.", getName);
        }
    }

    if (template) {
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Warc-performSelector-leaks"
        [template performSelector:setSelector withObject:newVal];
#pragma clang diagnostic pop
        row = [self insertRow:template];
        if (!row) {
            OKLogErr(@"Could not create session row!  Trying to set: %@", getName);
        }
    }
}


@end

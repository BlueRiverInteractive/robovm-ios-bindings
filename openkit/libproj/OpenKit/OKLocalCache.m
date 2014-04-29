//
//  OKLocalCache.m
//  OpenKit
//
//  Created by Louis Zell on 8/20/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "FMResultSet.h"
#import "FMDatabase.h"
#import "OKLocalCache.h"
#import "OKMacros.h"
#import "OKFileUtil.h"


#if !OK_CACHE_USES_MAIN
dispatch_queue_t __OKCacheQueue = nil;
#endif


@implementation OKLocalCache



#pragma mark - API
- (id)initWithCacheName:(NSString *)name createSql:(NSString *)sql version:(NSString *)version
{
    if ((self = [super init])) {
        _name = [name copy];
        _createSql = [sql copy];
        _version = [version copy];
    }
    return self;
}


-(void)access:(void(^)(FMDatabase *))block
{
    [self sanity];
    FMDatabase *db = [self database];
    if ([db open]){
        block(db);
        [db close];
    } else {
        OKLogErr(@"Could not open db in local cache.");
    }
}

- (BOOL)update:(NSString *)sql, ...
{
    va_list args;
    va_start(args, sql);

    __block BOOL success;
    [self access:^(FMDatabase *db) {
        OKLogInfo(@"Performing cache update: %@", sql);
        success = [db executeUpdate:sql error:nil withArgumentsInArray:nil orDictionary:nil orVAList:args];
        OKLogInfo(@"...%@", (success ? @"success" : @"FAIL"));
        
        // We have to cache the last inserted row ID because
        // we open and close the connection the database on every exec statement
        if([db lastInsertRowId] != 0) {
            lastInsertRowID = [db lastInsertRowId];
        }
    }];
    va_end(args);

    return success;
}

-(int)lastInsertRowID
{
    return lastInsertRowID;
}

-(NSString*)lastErrorMessage
{
    return [[self database] lastErrorMessage];
}


#pragma mark - Private
-(FMDatabase *)database
{
    if (_database == nil) {
        _database = [FMDatabase databaseWithPath:[self dbPath]];
    }
    return _database;
}

- (BOOL)executeCreateSql
{
    if (![[self database] open]) {
        OKLogErr(@"Could not open database in OKLocalCache.");
        return NO;
    }

    BOOL failed = NO;
    for (NSString *create in [_createSql componentsSeparatedByString:@"\n"]) {
        if (![[self database] executeUpdate:create]) {
            failed = YES;
            break;
        }
    }
    [[self database] close];
    return !failed;
}

- (NSString *)cacheDirPath
{
    return [OKFileUtil localOnlyCachePath];
}

- (NSString *)dbPath
{
    NSString *s = [NSString stringWithFormat:@"%@-%@.sqlite", _name, _version];
    return [[self cacheDirPath] stringByAppendingPathComponent:s];
}


- (BOOL)dbExists
{
    return [[NSFileManager defaultManager] fileExistsAtPath:[self dbPath]];
}


-(void)sanity
{
    if (![self dbExists]) {
        OKLogInfo(@"Executing create sql for db at %@", [self dbPath]);
        if (![self executeCreateSql]) {
            OKLogErr(@"Could not execute create sql.");
        }
    }
}

#pragma mark - OKSpecific

- (BOOL)insertToken:(NSString *)tokenStr
{
    NSDate *now = [NSDate date];
    return [self update:@"insert into tokens (token, submitted, created_at) values (?, ?, ?) ", tokenStr, [NSNumber numberWithInt:0], now];
}




@end

//
//  OKUserUtilities.m
//  OKClient
//
//  Created by Suneet Shah on 1/8/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKUserUtilities.h"
#import "OKManager.h"
#import "OKUser.h"
#import "OKNetworker.h"
#import "OKDefines.h"
#import "OKMacros.h"
#import "OKError.h"
#import "OKHelper.h"
#import "OKSessionDb.h"
#import "AFNetworking.h"



@implementation OKUserUtilities

+ (void)updateSessionUserId:(NSNumber *)okId
{
    dispatch_async(OK_CACHE_QUEUE(), ^{
        [[OKSessionDb db] loginOpenKit:[okId stringValue]];
    });
}

+ (OKUser *)createOKUserWithJSONData:(NSDictionary *)jsonData
{
    OKUser *user = [[OKUser alloc] init];
    
    NSNumber *_OKUserID =   [OKHelper getNSNumberSafeForKey:@"id" fromJSONDictionary:jsonData];
    NSString *_fbID     =   [OKHelper getNSStringSafeForKey:@"fb_id" fromJSONDictionary:jsonData];
    NSString *_customID =   [OKHelper getNSStringSafeForKey:@"custom_id" fromJSONDictionary:jsonData];
    NSString *_userNick =   [OKHelper getNSStringSafeForKey:@"nick" fromJSONDictionary:jsonData];

    [user setOKUserID:_OKUserID];
    [user setUserNick:_userNick];
    [user setFbUserID:_fbID];
    [user setCustomID:_customID];
    
    // Can't have an OKUser without an OKUser ID
    if(_OKUserID == nil || [_OKUserID integerValue] == 0) {
        return nil;
    }
    
    return user;
}

+(OKUser*)guestUser
{
    OKUser *guestUser = [[OKUser alloc] init];
    [guestUser setUserNick:@"Me"];
    return guestUser;
}

+(void)checkIfErrorIsUnsubscribedUserError:(NSError *)error
{
    int errorCode = [OKNetworker getStatusCodeFromAFNetworkingError:error];
    
    // If the user is unsubscribed to the app, log out the user.
    if(errorCode == OK_UNSUBSCRIBED_USER_ERROR_CODE) {
        [[OKManager sharedManager] logoutCurrentUser];
        OKLog(@"Logging out current user b/c user is unsubscribed to app");
    }	
}

+ (NSDictionary *)getJSONRepresentationOfUser:(OKUser *)user
{
    NSMutableDictionary *dict = [[NSMutableDictionary alloc] initWithCapacity:4];
    
    [dict setValue:[user userNick] forKey:@"nick"];
    [dict setValue:[user OKUserID] forKey:@"id"];
    [dict setValue:[user fbUserID] forKey:@"fb_id"];
    [dict setValue:[user customID] forKey:@"custom_id"];
    
    return dict;
}

+(void)updateOKUser:(OKUser *)user withCompletionHandler:(void(^)(NSError *error))completionHandler
{
    if(!user){
        completionHandler([OKError noOKUserError]);
    }
    
    NSDictionary *userDict = [OKUserUtilities getJSONRepresentationOfUser:user];
    NSDictionary *params = [NSDictionary dictionaryWithObject:userDict forKey:@"user"];
    NSString *requestPath = [NSString stringWithFormat:@"/users/%@", [user.OKUserID stringValue]];
    
    [OKNetworker putToPath:requestPath parameters:params
                   handler:^(id responseObject, NSError *error)
     {
         if(!error){
             //Check to make sure the user was returned, that way we know the response was successful
             OKUser *responseUser = [OKUserUtilities createOKUserWithJSONData:responseObject];
             NSNumber *userId = [responseUser OKUserID];
             [OKUserUtilities updateSessionUserId:userId];
             
             // Update the OKUser with the latest info from the server
             [[OKManager sharedManager] saveCurrentUser:responseUser];
         } else {
             NSLog(@"Error updating OKUser: %@", error);
         }
         completionHandler(error);
     }];
}


+ (void)updateUserNickForOKUser:(OKUser *)user withNewNick:(NSString *)newNick withCompletionHandler:(void(^)(NSError *error))completionHandler
{    
    //Setup the parameters
    NSDictionary *userDict = [NSDictionary dictionaryWithObject:newNick forKey:@"nick"];
    NSDictionary *params = [NSDictionary dictionaryWithObjectsAndKeys:
                            userDict, @"user", nil];
    
    NSString *requestPath = [NSString stringWithFormat:@"/users/%@", [user.OKUserID stringValue]];
    
    [OKNetworker putToPath:requestPath parameters:params
                   handler:^(id responseObject, NSError *error)
     {
         if(!error){
             //Check to make sure the user was returned, that way we know the response was successful
             OKUser *responseUser = [OKUserUtilities createOKUserWithJSONData:responseObject];
            [[OKManager sharedManager] saveCurrentUser:responseUser];
        } else {
             NSLog(@"Error updating username: %@", error);
             // If the user is unsubscribed to the app, log out the user.
             [OKUserUtilities checkIfErrorIsUnsubscribedUserError:error];
         }
         completionHandler(error);
     }];
}


+(void)createOKUserWithUserIDType:(OKUserIDType)userIDtype withUserID:(NSString*)userID withUserNick:(NSString *)userNick withCompletionHandler:(void(^)(OKUser *user, NSError *errror))completionHandler
{
    NSMutableDictionary *params = [NSMutableDictionary dictionaryWithObjectsAndKeys:
                            userNick, @"nick", nil];
    
    
    // Set the correct parameter based on UserID type
    switch(userIDtype) {
        case FacebookIDType:
            [params setObject:userID forKey:@"fb_id"];
            break;
        case TwitterIDType:
            [params setObject:userID forKey:@"twitter_id"];
            break;
        case GoogleIDType:
            [params setObject:userID forKey:@"google_id"];
            break;
        case CustomIDType:
            [params setObject:userID forKey:@"custom_id"];
            break;
    }
    
    [OKNetworker postToPath:@"/users" parameters:params
                    handler:^(id responseObject, NSError *error)
     {
         OKUser *newUser = nil;
         if(!error) {
            //OKLog(@"Create user JSON response is: %@",responseObject);
             //Success
             NSNumber *userId = [responseObject valueForKeyPath:@"id"];
             OKLog(@"Successfully created/found user ID: %@", userId);
             [OKUserUtilities updateSessionUserId:userId];

             newUser = [OKUserUtilities createOKUserWithJSONData:responseObject];
             [[OKManager sharedManager] saveCurrentUser:newUser];
         } else {
             OKLog(@"Failed to create user with error: %@", error);
         }
         completionHandler(newUser, error);
     }];
}

@end

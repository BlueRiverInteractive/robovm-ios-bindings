//
//  OKFacebookUtilities.h
//  OKClient
//
//  Created by Suneet Shah on 1/3/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>

@class OKUser;
@interface OKFacebookUtilities : NSObject

+(BOOL)handleOpenURL:(NSURL *)url;
+(void)handleDidBecomeActive;
+(void)handleWillTerminate;


// Method to Login to OpenKit with Facebook Login
+(void)AuthorizeUserWithFacebookWithCompletionHandler:(void(^)(OKUser *user, NSError *error))completionHandler;
+(void)createOrUpdateCurrentOKUserWithFB;

// Methods to open Facebook session
+(void)OpenFBSessionWithCompletionHandler:(void(^)(NSError *error))completionHandler;
+(BOOL)OpenCachedFBSessionWithoutLoginUI;

// Other FB helper methods
+(BOOL)isFBSessionOpen;
+(void)handleErrorLoggingIntoFacebookAndShowAlertIfNecessary:(NSError *)error;
+(void)getListOfFriendsForCurrentUserWithCompletionHandler:(void(^)(NSArray *friends, NSError*error))completionHandler;
+(NSString*)serializeListOfFacebookFriends:(NSArray *)friendsJSON;

// FB Invites
+(void)sendFacebookRequest;

@end

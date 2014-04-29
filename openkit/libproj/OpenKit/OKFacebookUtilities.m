//
//  OKFacebookUtilities.m
//  OKClient
//
//  Created by Suneet Shah on 1/3/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <FacebookSDK/FacebookSDK.h>
#import "OKFacebookUtilities.h"
#import "OKUserUtilities.h"
#import "OKManager.h"
#import "OKNetworker.h"
#import <FacebookSDK/FBErrorUtility.h>
#import "OKMacros.h"
#import "OKError.h"
#import "OKUser.h"
#import "OKHelper.h"
#import "OKSessionDb.h"

@implementation OKFacebookUtilities

+(BOOL)handleOpenURL:(NSURL *)url
{
    return [FBSession.activeSession handleOpenURL:url];
}

+(void)handleDidBecomeActive
{
    [FBSession.activeSession handleDidBecomeActive];
}

+(void)handleWillTerminate
{
    [FBSession.activeSession close];
}

// Assuming already logged into Facebook, get's the user's ID and creates an OKUser Account with it
+(void)GetCurrentFacebookUsersIDAndCreateOKUserWithCompletionhandler:(void(^)(OKUser *user, NSError *error))compHandler
{
    [[FBRequest requestForMe] startWithCompletionHandler:^(FBRequestConnection *connection, id result, NSError *error) {
        // Did everything come back okay with no errors?
        if (!error && result)
        {
            NSString *fbUserID = [result objectForKey:@"id"];
            NSString *userNick = [result objectForKey:@"name"];

            dispatch_async(OK_CACHE_QUEUE(), ^{
                [[OKSessionDb db] loginFB:fbUserID];
            });

            [OKFacebookUtilities CreateOKUserWithFacebookID:fbUserID withUserNick:userNick withCompletionHandler:^(OKUser *user, NSError *error) {
                if(user && !error) {
                   compHandler(user, nil);
                }
                else {
                    compHandler(nil,error);
                }
            }];
        }
        else
        {
            //Error performing the FB request
            compHandler(nil, error);
        }
    }];
}

// This method creates or updates the current OKUser with Facebook ID
// IF there is an OKUser, update it. If not, create it.
+(void)createOrUpdateCurrentOKUserWithFB
{
    if([OKUser currentUser]) {
        OKLog(@"Updating current OKUser with new Facebook ID");
        [OKFacebookUtilities updateOKUserWithFacebookID:[OKUser currentUser]];
    }
    else {
        [OKFacebookUtilities GetCurrentFacebookUsersIDAndCreateOKUserWithCompletionhandler:^(OKUser *user, NSError *error) {
            if(user) {
                OKLog(@"Logged into OpenKit with Facebook ID successfully");
            } else {
                // Did not login to OpenKit
                if(error)
                    OKLog(@"Did not create OKUser with FBID, error %@", error);
            }

        }];
    }
    
}


+(void)updateOKUserWithFacebookID:(OKUser*)user 
{
    [[FBRequest requestForMe] startWithCompletionHandler:^(FBRequestConnection *connection, id result, NSError *error) {
        // Did everything come back okay with no errors?
        if (!error && result)
        {
            NSString *fbUserID = [result objectForKey:@"id"];
            NSString *userNick = [result objectForKey:@"name"];
            //NSNumber *fbIDNum = [NSNumber numberWithLongLong:[fbUserID longLongValue]];

            [user setFbUserID:fbUserID];
            [user setUserNick:userNick];

            dispatch_async(OK_CACHE_QUEUE(), ^{
                [[OKSessionDb db] loginFB:fbUserID];
            });

            //Save the current user locally
            OKLog(@"Updated OKUser locally with FB id");
            [[OKManager sharedManager] saveCurrentUser:user];
            
            [OKUserUtilities updateOKUser:user withCompletionHandler:^(NSError *error) {
                if(error) {
                    OKLog(@"Error updating OKUser with Facebook login info, error: %@",error);
                } else
                {
                    OKLog(@"Updated OKUser on server with FB id");
                }
            }];
            
        }
    }];
}

+(void)CreateOKUserWithFacebookID:(NSString *)facebookID withUserNick:(NSString *)userNick withCompletionHandler:(void(^)(OKUser *user, NSError *error))completionhandler
{
    [OKUserUtilities createOKUserWithUserIDType:FacebookIDType withUserID:facebookID withUserNick:userNick withCompletionHandler:^(OKUser *user, NSError *errror) {
        
        if(!errror) {
            // User was created successfully
            // createOKUserWithUserIDType saves the current user so we don't call it here (
        }
        
        // Call the passed in completionHandler
        completionhandler(user, errror);
    }];
}

// Opens a Facebook session and shows UI if necessary. Completion handler is called when session is opened, fails to open, or request is cancelled by user

+(void)OpenFBSessionWithCompletionHandler:(void(^)(NSError *error))completionHandler
{
    [FBSession openActiveSessionWithReadPermissions:nil allowLoginUI:YES completionHandler:^(FBSession *session, FBSessionState status, NSError *error) {
        
        switch(status)
        {
            case FBSessionStateOpen:
                NSLog(@"FBSessionStateOpen");
                if(!error)
                {
                    //We have a valid session
                    NSLog(@"Facebook user session found/opened successfully");
                    completionHandler(nil);
                }
                break;
            case FBSessionStateClosed:
                NSLog(@"FBSessionStateClosed");
                //break;
            case FBSessionStateClosedLoginFailed:
                NSLog(@"FBSessionStateClosedLoginFailed");
                [FBSession.activeSession closeAndClearTokenInformation];
                
                if([FBErrorUtility errorCategoryForError:error] == FBErrorCategoryUserCancelled){
                    NSLog(@"User cancelled FB login");
                    completionHandler(nil);
                } else {
                    completionHandler(error);
                }
                break;
            default:
                completionHandler(error);
                break;
        }
        
    }];
}




+(void)AuthorizeUserWithFacebookWithCompletionHandler:(void(^)(OKUser *user, NSError *error))completionHandler
{
    if([[FBSession activeSession] state] == FBSessionStateOpen)
    {
        NSLog(@"FBSessionStateOpen, just making request to get user ID");
        [self GetCurrentFacebookUsersIDAndCreateOKUserWithCompletionhandler:completionHandler];
    }
    else
    {
       [self OpenFBSessionWithCompletionHandler:^(NSError *error) {
           if(error){
               // There was an error when logging in with Facebook, so let's display the error
               completionHandler(nil, error);
           } else if ([[FBSession activeSession] state] == FBSessionStateOpen) {
               // The facebook session is open so let's get the Facebook ID and create an OpenKit user
               [self GetCurrentFacebookUsersIDAndCreateOKUserWithCompletionhandler:completionHandler];
           } else {
               // No error, and also no open FB session, so user most likely cancelled
               completionHandler(nil,nil);
           }
       }];
    }
}


+(void)handleErrorLoggingIntoFacebookAndShowAlertIfNecessary:(NSError *)error
{
    NSString *alertMessage, *alertTitle;
    if (!error) {
        alertMessage = nil;
    }
    else if ([FBErrorUtility shouldNotifyUserForError:error]) {
        // If the SDK has a message for the user, surface it. This conveniently
        // handles cases like password change or iOS6 app slider state.
        alertTitle = @"Facebook Error";
        alertMessage = [FBErrorUtility userMessageForError:error];
    } else if ([FBErrorUtility errorCategoryForError:error] == FBErrorCategoryAuthenticationReopenSession) {
        // It is important to handle session closures since they can happen
        // outside of the app. You can inspect the error for more context
        // but this sample generically notifies the user.
        alertTitle = @"Session Error";
        alertMessage = @"Your current session is no longer valid. Please log in again.";
    } else if ([FBErrorUtility errorCategoryForError:error] == FBErrorCategoryUserCancelled) {
        // The user has cancelled a login. You can inspect the error
        // for more context. For this sample, we will simply ignore it.
        NSLog(@"user cancelled login");
    } else {
        // For simplicity, this sample treats other errors blindly.
        alertTitle  = @"Unknown Error";
        alertMessage = @"Error. Please try again later.";
        NSLog(@"Unexpected FB login error:%@", error);
    }
    
    if (alertMessage) {
        [[[UIAlertView alloc] initWithTitle:alertTitle
                                    message:alertMessage
                                   delegate:nil
                          cancelButtonTitle:@"OK"
                          otherButtonTitles:nil] show];
    }
}



+(void)getListOfFriendsForCurrentUserWithCompletionHandler:(void(^)(NSArray *friends, NSError*error))completionHandler
{
    OKLog(@"Getting list of Facebook friends");
    
    // Check cache for list of friends (in-memory cache)
    if([[OKManager sharedManager] cachedFbFriendsList] != nil) {
        completionHandler([[OKManager sharedManager] cachedFbFriendsList], nil);
        OKLog(@"Returned cached list of FB friends: %d", [[[OKManager sharedManager] cachedFbFriendsList] count]);
        return;
    }
    
    FBRequest *getFriendsRequest = [FBRequest requestForMyFriends];
    
    [getFriendsRequest startWithCompletionHandler:^(FBRequestConnection *connection, id result, NSError *error) {
        
        if(error) {
            completionHandler(nil, error);
        }
        else {
            //NSArray *graphFriends = [result objectForKey:@"data"];
            NSArray *graphFriends = [OKHelper getNSArraySafeForKey:@"data" fromJSONDictionary:result];
            
            if(graphFriends) {
                OKLog(@"Received %d friends", [graphFriends count]);
                //Munge the list of friends into one single array of friend IDs
                NSArray *friendsList = [OKFacebookUtilities makeListOfFacebookFriends:graphFriends];
                [[OKManager sharedManager] setCachedFbFriendsList:friendsList];
                completionHandler(friendsList, error);
            } else {
                completionHandler(nil, [OKError unknownFacebookRequestError]);
            }
        }
    }];
}

+(NSString*)serializeListOfFacebookFriends:(NSArray *)friendsArray
{
    NSMutableString *serializedString = [[NSMutableString alloc] init];
    
    int x;
    for(x = 0; x < [friendsArray count]; x++)
    {
        NSString *userID = [friendsArray objectAtIndex:x];
        
        [serializedString appendString:userID];
        [serializedString appendString:@","];
    }
    
    //Delete the last comma added if it was added
    if(x > 0)
        [self deleteLastCharacterOfMutableString:serializedString];
    
    return serializedString;
}

+(void)deleteLastCharacterOfMutableString:(NSMutableString*)mutableString
{
    int size = [mutableString length];
    [mutableString deleteCharactersInRange:NSMakeRange(size-1, 1)];
}

+(NSArray*)makeListOfFacebookFriends:(NSArray*) friendsJSON
{
    NSMutableArray *list = [[NSMutableArray alloc] initWithCapacity:[friendsJSON count]];
    
    for(int x = 0; x < [friendsJSON count]; x++)
    {
        NSDictionary *friendDict = [friendsJSON objectAtIndex:x];
        NSString *friendID = [OKHelper getNSStringSafeForKey:@"id" fromJSONDictionary:friendDict];
        if(friendID != nil) {
            [list addObject:friendID];
        }
    }
    
    return list;
}

+(void)sendFacebookRequest {
    NSMutableDictionary* params =   [NSMutableDictionary dictionaryWithObjectsAndKeys:nil];
    [FBWebDialogs presentRequestsDialogModallyWithSession:nil
                                                  message:@"Check out this game!"
                                                    title:@"Invite Friends"
                                               parameters:params
                                                  handler:^(FBWebDialogResult result, NSURL *resultURL, NSError *error) {
                                                      if (error) {
                                                          // Case A: Error launching the dialog or sending request.
                                                          NSLog(@"Error sending request.");
                                                      } else {
                                                          if (result == FBWebDialogResultDialogNotCompleted) {
                                                              // Case B: User clicked the "x" icon
                                                              NSLog(@"User canceled request.");
                                                          } else {
                                                              NSLog(@"Request Sent.");
                                                          }
                                                      }}];
}



+(BOOL)isFBSessionOpen {
    return ([FBSession activeSession].state == FBSessionStateOpen);
}

// Returns YES if a cached session was found and opened, NO if not
+(BOOL)OpenCachedFBSessionWithoutLoginUI
{
    BOOL foundCachedSession = [FBSession openActiveSessionWithAllowLoginUI:NO];
    
    if(foundCachedSession)
    {
        NSLog(@"Opened cached FB session");
    }
    
    return foundCachedSession;
}

+(BOOL)openSessionWithAllowLoginUI:(BOOL)allowLoginUI
{
    return [FBSession openActiveSessionWithReadPermissions:nil allowLoginUI:allowLoginUI completionHandler:^(FBSession *session, FBSessionState status, NSError *error) {
        [self sessionStateChanged:session state:status error:error];
    }];
}

+(void)sessionStateChanged:(FBSession *)session state:(FBSessionState)state error:(NSError *)error
{
    switch(state)
    {
        case FBSessionStateOpen:
            if(!error)
            {
                //We have a valid session
                NSLog(@"Facebook user session found/opened successfully");
            }
            break;
        case FBSessionStateClosed:
            break;
        case FBSessionStateClosedLoginFailed:
            [FBSession.activeSession closeAndClearTokenInformation];
            break;
        default:
            break;
    }
}



@end

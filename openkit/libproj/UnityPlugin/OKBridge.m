//
//  OKBridge.m
//  OKBridge
//
//  Updated by Lou Zell on 2/14/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//
//  Email feedback and suggestions to Lou at lzell11@gmail.com
//

#import "OKBridge.h"
#import "OKManager.h"
#import "OKUnityHelper.h"
#import "OpenKit.h"
#import "OKGameCenterUtilities.h"
#import "OKFacebookUtilities.h"
#import "OKMacros.h"
#import "OKBridgeUIHelper.h"
#import "OKHelper.h"

#import <UIKit/UIKit.h>

extern void UnitySendMessage(const char *, const char *, const char *);

/*
#if TARGET_OS_IPHONE
#import "OKManager.h"
#import "OKGUI.h"
#endif
*/


void OKBridgeConfigureOpenKit(const char *appKey, const char *secretKey, const char *endpoint)
{
    NSString *ns_appKey = [NSString stringWithUTF8String:appKey];
    NSString *ns_secretKey = [NSString stringWithUTF8String:secretKey];
    
    NSString *ns_endpoint;
    if(endpoint != NULL) {
        ns_endpoint = [NSString stringWithUTF8String:endpoint];
    } else {
        ns_endpoint = nil;
    }
    
    [OKManager configureWithAppKey:ns_appKey secretKey:ns_secretKey endpoint:ns_endpoint];
}

void OKBridgeInitRemoteNotifications()
{
    [[UIApplication sharedApplication] registerForRemoteNotificationTypes:UIRemoteNotificationTypeAlert | UIRemoteNotificationTypeSound];
}

void OKBridgeSetLeaderboardListTag(const char *tag)
{
    OKBridgeLog(@"SetLeaderboardListTag");
    [[OKManager sharedManager] setLeaderboardListTag:[NSString stringWithUTF8String:tag]];
}

void OKBridgeShowLeaderboardsBase(BOOL showLandscapeOnly, int defaultLeaderboardID)
{
    UIWindow *win = [[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]];
    win.autoresizingMask = UIViewAutoresizingFlexibleWidth|UIViewAutoresizingFlexibleHeight;
    win.backgroundColor = [UIColor clearColor];

    // Set shouldShowLandscapeOnly & defaultLeaderboardID
    OKDashBridgeViewController *vc = [[OKDashBridgeViewController alloc] init];
    
    if(vc == nil) {
        if(win) {
            [win release];
        }
        OKLog(@"OKBridge: could not show leaderboard because OKDashBridgeViewController came back as nil");
        return;
    }
    
    [vc setShouldShowLandscapeOnly:showLandscapeOnly];
    [vc setDefaultLeaderboardID:defaultLeaderboardID];
    
    vc.window = win;
    [win release];
    // Bridge VC is now responsible for releasing win.  It holds the only reference
    // to it.
    [vc.window setRootViewController:vc];
    [vc.window makeKeyAndVisible];
}


void OKBridgeShowAchievementsBase(BOOL showLandscapeOnly)
{
    UIWindow *win = [[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]];
    win.autoresizingMask = UIViewAutoresizingFlexibleWidth|UIViewAutoresizingFlexibleHeight;
    win.backgroundColor = [UIColor clearColor];
    
    // Set shouldShowLandscapeOnly & defaultLeaderboardID
    OKBridgeAchievementsViewController *vc = [[OKBridgeAchievementsViewController alloc] init];
    
    if(vc == nil) {
        if(win) {
            [win release];
        }
        OKLog(@"OKBridge: could not show leaderboard because OKDashBridgeViewController came back as nil");
        return;
    }
    
    [vc setShouldShowLandscapeOnly:showLandscapeOnly];
    vc.window = win;
    [win release];
    // Bridge VC is now responsible for releasing win.  It holds the only reference
    // to it.
    [vc.window setRootViewController:vc];
    [vc.window makeKeyAndVisible];
}

void OKBridgeShowLeaderboardsAndAchievements()
{
    UIWindow *win = [[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]];
    win.autoresizingMask = UIViewAutoresizingFlexibleWidth|UIViewAutoresizingFlexibleHeight;
    win.backgroundColor = [UIColor clearColor];
    
    // Set shouldShowLandscapeOnly & defaultLeaderboardID
    OKBridgeLeaderboardsAndAchievmentsViewController *vc = [[OKBridgeLeaderboardsAndAchievmentsViewController alloc] init];
    
    if(vc == nil) {
        if(win) {
            [win release];
        }
        OKLog(@"OKBridge: could not show leaderboard because OKDashBridgeViewController came back as nil");
        return;
    }
    
    vc.window = win;
    [win release];
    // Bridge VC is now responsible for releasing win.  It holds the only reference
    // to it.
    [vc.window setRootViewController:vc];
    [vc.window makeKeyAndVisible];

    
}

void OKBridgeShowAchievements()
{
    OKBridgeShowAchievementsBase(NO);
}

void OKBridgeShowAchievementsLandscapeOnly()
{
    OKBridgeShowAchievementsBase(YES);
}

void OKBridgeShowLeaderboardIDWithLandscapeOnly(int leaderboardID, BOOL landscapeOnly)
{
    OKBridgeShowLeaderboardsBase(landscapeOnly, leaderboardID);
}

void OKBridgeShowLeaderboards()
{
    OKBridgeShowLeaderboardsBase(NO,0);
}

void OKBridgeShowLeaderboardID(int leaderboardID)
{
    OKBridgeShowLeaderboardIDWithLandscapeOnly(leaderboardID, NO);
}

void OKBridgeShowLeaderboardsLandscapeOnly()
{
    OKBridgeShowLeaderboardsBase(YES,0);
}

void OKBridgeLogoutCurrentUserFromOpenKit()
{
    OKBridgeLog(@"logout of OpenKit");
    [OKUser logoutCurrentUserFromOpenKit];
}

void OKBridgeAuthenticateLocalPlayerWithGameCenter()
{
    OKBridgeLog(@"authenticating local player with GC");
    [OKGameCenterUtilities authenticateLocalPlayerWithCompletionHandler:^(NSError *error) {
        OKBridgeLog(@"Finished showing GC UI");
    }];
}

void OKBridgeAuthenticateLocalPlayerWithGameCenterAndShowUIIfNecessary()
{
    OKBridgeLog(@"authenticating local player with GC and showing UI if necessary");
    
    //If we need to show UI from GameCenter, then create the OKGameCenterBridgeViewController and display it
    [OKGameCenterUtilities authorizeUserWithGameCenterWithBlockToHandleShowingGameCenterUI:^(UIViewController *viewControllerFromGC) {
        // Need to show gamecenter UI
        UIWindow *win = [[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]];
        win.autoresizingMask = UIViewAutoresizingFlexibleWidth|UIViewAutoresizingFlexibleHeight;
        win.backgroundColor = [UIColor clearColor];
        
        OKGameCenterBridgeViewController *vc = [[OKGameCenterBridgeViewController alloc] init];
        
        [vc setGcViewControllerToLaunch:viewControllerFromGC];
        
        vc.window = win;
        [win release];
        // Bridge VC is now responsible for releasing win.  It holds the only reference
        // to it.
        [vc.window setRootViewController:vc];
        [vc.window makeKeyAndVisible];
    } withGameCenterUICompletionHandler:^(NSError *error) {
        OKBridgeLog(@"Finished showing GC UI");
    }];
 
}

bool OKBridgeIsCurrentUserAuthenticated()
{
    return ([OKUser currentUser] != nil);
}

bool OKBridgeIsPlayerAuthenticatedWithGameCenter()
{
    return [OKGameCenterUtilities isPlayerAuthenticatedWithGameCenter];
}

void OKBridgeGetFacebookFriends(const char *gameObjectName)
{
    OKBridgeLog(@"Get fb friends list");
    __block NSString *objName = [[NSString alloc] initWithUTF8String:gameObjectName];
    
    [OKFacebookUtilities getListOfFriendsForCurrentUserWithCompletionHandler:^(NSArray *friends, NSError *error) {
        
        if(friends && !error){
            NSString *serializedFriends = [OKFacebookUtilities serializeListOfFacebookFriends:friends];
            
            UnitySendMessage([objName UTF8String], "asyncCallSucceeded",[serializedFriends UTF8String]);
        } else{
            if(error) {
                UnitySendMessage([objName UTF8String], "asyncCallFailed", [[error localizedDescription] UTF8String]);
            } else {
                UnitySendMessage([objName UTF8String], "asyncCallFailed", "Unknown error from native IOS when trying to get Facebook friends");
            }
        }
    }];
}

void OKBridgeShowLoginUI()
{
    OKLoginView *loginView = [[OKLoginView alloc] init];
    [loginView show];
    [loginView release];
}

// Base method for submitting a score
void OKBridgeSubmitScoreBase(OKScore *score, const char *gameObjectName)
{
    __block NSString *objName = [[NSString alloc] initWithUTF8String:gameObjectName];
    
    OKBridgeLog(@"Submit score base, game object name is: %s", [objName UTF8String]);
    
    [score submitScoreToOpenKitAndGameCenterWithCompletionHandler:^(NSError *error) {
        
        if(!error) {
            UnitySendMessage([objName UTF8String], "scoreSubmissionSucceeded", "");
        } else {
            UnitySendMessage([objName UTF8String], "scoreSubmissionFailed", [[error localizedDescription] UTF8String]);
        }
        [objName release];
    }];
}


void OKBridgeSubmitAchievementScore(int achievementID, int progress, const char *GKAchievementID, float GKpercentComplete, const char *gameObjectName)
{
    __block NSString *objName = [[NSString alloc] initWithUTF8String:gameObjectName];
    
    OKBridgeLog(@"submitting achievement score, game object name is: %@", objName);
    
    NSString *GKachievementIDNSString = nil;
    
    if(GKAchievementID != NULL) {
        GKachievementIDNSString = [[NSString alloc] initWithUTF8String:GKAchievementID];
    }
    
    OKAchievementScore *score = [[OKAchievementScore alloc] init];
    [score setOKAchievementID:achievementID];
    [score setProgress:progress];
    
    if(![OKHelper isEmpty:GKachievementIDNSString]) {
        [score setGKAchievementID:GKachievementIDNSString];
        [score setGKPercentComplete:GKpercentComplete];
    }
    
    [score submitAchievementScoreWithCompletionHandler:^(NSError *error) {
        if(!error) {
            UnitySendMessage([objName UTF8String], "scoreSubmissionSucceeded", "");
        } else {
            UnitySendMessage([objName UTF8String], "scoreSubmissionFailed", [[error localizedDescription] UTF8String]);
        }
    }];
    
}

void OKBridgeShowLoginUIWithBlock(const char *gameObjectName)
{
     __block NSString *objName = [[NSString alloc] initWithUTF8String:gameObjectName];
    
    OKBridgeLog(@"Showing OpenKit login window with block");
    OKLoginView *loginView = [[OKLoginView alloc] init];
    [loginView showWithCompletionHandler:^{
        OKBridgeLog(@"Login window completion block");
        NSString *paramString = @"OKLoginWindow completed";
        UnitySendMessage([objName UTF8String], "asyncCallSucceeded",[paramString UTF8String]);
        [loginView release];
        [objName release];
    }];
}


void OKBridgeSubmitScore(int64_t scoreValue, int leaderboardID, int metadata, const char *displayString, const char *gameObjectName )
{
    OKScore *score = [[OKScore alloc] init];
    score.scoreValue = scoreValue;
    score.OKLeaderboardID = leaderboardID;
    
    if(displayString != NULL) {
        score.displayString = [[NSString alloc] initWithUTF8String:displayString];
    }
    
    score.metadata = metadata;

    OKBridgeLog(@"Submitting score without GC");
    
    OKBridgeSubmitScoreBase(score, gameObjectName);
}


void OKBridgeSubmitScoreWithGameCenter(int64_t scoreValue, int leaderboardID, int metadata, const char *displayString, const char *gameObjectName, const char *gamecenterLeaderboardID)
{
    OKScore *score = [[OKScore alloc] init];
    score.scoreValue = scoreValue;
    score.OKLeaderboardID = leaderboardID;
    //score.displayString = [[NSString alloc] initWithCString:displayString encoding:NSUTF8StringEncoding];
    if(displayString != NULL) {
        score.displayString = [[NSString alloc] initWithUTF8String:displayString];
    }
    score.metadata = metadata;
    
    if(gamecenterLeaderboardID != NULL) {
        score.gamecenterLeaderboardID = [[NSString alloc] initWithUTF8String:gamecenterLeaderboardID];
    }
    
    OKBridgeLog(@"Gamecenter leaderboard ID is: %@, submitting score to GameCenter", score.gamecenterLeaderboardID);
    OKBridgeSubmitScoreBase(score, gameObjectName);
}


bool OKBridgeIsFBSessionOpen()
{
    return [OKFacebookUtilities isFBSessionOpen];
}


int OKBridgeGetCurrentUserOKID()
{
    OKUser *u = [OKUser currentUser];
    return (u ? [u.OKUserID intValue] : 0);
}

const char* OKBridgeGetCurrentUserNick()
{
    OKUser *u = [OKUser currentUser];
    return (u ? OK_HS([u.userNick UTF8String]) : (char *)0);
}

const char* OKBridgeGetCurrentUserFBID()
{
    OKUser *u = [OKUser currentUser];
    return (u ? OK_HS([u.fbUserID UTF8String]) : (char *)0);
}



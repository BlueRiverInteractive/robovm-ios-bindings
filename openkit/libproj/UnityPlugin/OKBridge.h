//
//  OKBridge.h
//  OKBridge
//
//  Updated by Lou Zell on 2/14/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//
//  Email feedback and suggestions to Lou at lzell11@gmail.com
//

#import <Foundation/Foundation.h>

/* Settings methods*/
void OKBridgeConfigureOpenKit(const char *appKey, const char *secretKey, const char *endpoint);
void OKBridgeSetLeaderboardListTag(const char *tag);
void OKBridgeInitRemoteNotifications();

/* Show leaderboards and UI methods */
void OKBridgeShowLeaderboards();
void OKBridgeShowLeaderboardsLandscapeOnly();
void OKBridgeShowLeaderboardIDWithLandscapeOnly(int leaderboardID, BOOL landscapeOnly);
void OKBridgeShowLeaderboardID(int leaderboardID);
void OKBridgeShowLoginUI();
void OKBridgeShowLoginUIWithBlock(const char *gameObjectName);

void OKBridgeShowAchievements();
void OKBridgeShowAchievementsLandscapeOnly();


/* Score and achievement submission*/
void OKBridgeSubmitScore(int64_t scoreValue, int leaderboardID, int metadata, const char *displayString, const char *gameObjectName);
void OKBridgeSubmitAchievementScore(int achievementID, int progress, const char *GKAchievementID, float GKpercentComplete, const char *gameObjectName);



/* GameCenter Methods */
void OKBridgeAuthenticateLocalPlayerWithGameCenter();
bool OKBridgeIsPlayerAuthenticatedWithGameCenter();
void OKBridgeAuthenticateLocalPlayerWithGameCenterAndShowUIIfNecessary();

/*OKUser methods*/
bool OKBridgeIsCurrentUserAuthenticated();
int OKBridgeGetCurrentUserOKID();
const char* OKBridgeGetCurrentUserNick();
const char* OKBridgeGetCurrentUserFBID();
bool OKBridgeIsFBSessionOpen();

void OKBridgeLogoutCurrentUserFromOpenKit();
void OKBridgeGetFacebookFriends(const char *gameObjectName);


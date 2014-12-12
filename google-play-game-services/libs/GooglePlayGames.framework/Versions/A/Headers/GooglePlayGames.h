//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <Foundation/Foundation.h>

#if  __IPHONE_OS_VERSION_MIN_REQUIRED < __IPHONE_7_0
#pragma message "Google Play Game Services SDK requires iOS 7.0 or later."
#endif

#import <GooglePlayGames/GPGEnums.h>

#import <GooglePlayGames/GPGAchievement.h>
#import <GooglePlayGames/GPGAchievementMetadata.h>
#import <GooglePlayGames/GPGApplicationModel.h>
#import <GooglePlayGames/GPGAppStateModel.h>
#import <GooglePlayGames/GPGEvent.h>
#import <GooglePlayGames/GPGKeyedModel.h>
#import <GooglePlayGames/GPGLauncherController.h>
#import <GooglePlayGames/GPGLeaderboard.h>
#import <GooglePlayGames/GPGLeaderboardMetadata.h>
#import <GooglePlayGames/GPGLocalPlayerRank.h>
#import <GooglePlayGames/GPGLocalPlayerScore.h>
#import <GooglePlayGames/GPGManager.h>
#import <GooglePlayGames/GPGMultiplayerConfig.h>
#import <GooglePlayGames/GPGPlayer.h>
#import <GooglePlayGames/GPGPlayerLevel.h>
#import <GooglePlayGames/GPGQuest.h>
#import <GooglePlayGames/GPGRealTimeRoom.h>
#import <GooglePlayGames/GPGRealTimeRoomData.h>
#import <GooglePlayGames/GPGRealTimeRoomMaker.h>
#import <GooglePlayGames/GPGScore.h>
#import <GooglePlayGames/GPGScoreReport.h>
#import <GooglePlayGames/GPGSnapshotMetadata.h>
#import <GooglePlayGames/GPGSnapshotMetadataChange.h>
#import <GooglePlayGames/GPGTurnBasedMatch.h>
#import <GooglePlayGames/GPGTurnBasedParticipant.h>
#import <GooglePlayGames/GPGTurnBasedParticipantResult.h>

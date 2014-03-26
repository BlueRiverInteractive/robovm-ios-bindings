//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <Foundation/Foundation.h>
     #if  __IPHONE_OS_VERSION_MIN_REQUIRED < __IPHONE_6_0
#pragma message "Google Play Game Services SDK requires iOS 6.0 or later."
#pragma message "If you must have Deployment Target lower than 6.0, weak link UIKit framework to prevent crashing."
#endif

#import <GooglePlayGames/GPGEnums.h>
#import <GooglePlayGames/GPGError.h>

#import <GooglePlayGames/GPGAchievement.h>
#import <GooglePlayGames/GPGAchievementController.h>
#import <GooglePlayGames/GPGAchievementMetadata.h>
#import <GooglePlayGames/GPGAchievementModel.h>
#import <GooglePlayGames/GPGAppStateModel.h>
#import <GooglePlayGames/GPGApplicationModel.h>
#import <GooglePlayGames/GPGKeyedModel.h>
#import <GooglePlayGames/GPGLeaderboard.h>
#import <GooglePlayGames/GPGLeaderboardController.h>
#import <GooglePlayGames/GPGLeaderboardMetadata.h>
#import <GooglePlayGames/GPGLeaderboardModel.h>
#import <GooglePlayGames/GPGLeaderboardsController.h>
#import <GooglePlayGames/GPGLocalPlayerRank.h>
#import <GooglePlayGames/GPGLocalPlayerScore.h>
#import <GooglePlayGames/GPGManager.h>
#import <GooglePlayGames/GPGMultiplayerConfig.h>
#import <GooglePlayGames/GPGPeoplePickerViewController.h>
#import <GooglePlayGames/GPGPlayer.h>
#import <GooglePlayGames/GPGPlayerModel.h>
#import <GooglePlayGames/GPGRealTimeRoom.h>
#import <GooglePlayGames/GPGRealTimeRoomData.h>
#import <GooglePlayGames/GPGRealTimeRoomMaker.h>
#import <GooglePlayGames/GPGRealTimeRoomViewController.h>
#import <GooglePlayGames/GPGScore.h>
#import <GooglePlayGames/GPGScoreReport.h>
#import <GooglePlayGames/GPGTurnBasedMatch.h>
#import <GooglePlayGames/GPGTurnBasedMatchViewController.h>
#import <GooglePlayGames/GPGTurnBasedModel.h>
#import <GooglePlayGames/GPGTurnBasedParticipant.h>
#import <GooglePlayGames/GPGTurnBasedParticipantResult.h>

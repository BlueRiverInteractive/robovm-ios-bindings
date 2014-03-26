//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import "GPGKeyedModel.h"

@class GPGAchievementModel;
@class GPGAppStateModel;
@class GPGGameMetadataModel;
@class GPGLeaderboardModel;
@class GPGPlayerModel;
@class GPGTurnBasedModel;

// GPGModel data keys.
extern NSString *const GPGModelAllAchievementMetadataKey;
extern NSString *const GPGModelAllPlayerAchievementsKey;
extern NSString *const GPGModelAllLeaderboardMetadataKey;
extern NSString *const GPGModelGameMetadataKey;
extern NSString *const GPGModelGetAllAppStateKey;
extern NSString *const GPGModelLocalPlayerKey;
extern NSString *const GPGModelAchievementIncremented;
extern NSString *const GPGModelAllMatchesKey;

@interface GPGApplicationModel : GPGKeyedModel

// Designated initializer
- (id)initWithApplicationId:(NSString *)applicationId;

#pragma mark Models 
// Models
@property(nonatomic, readonly, retain) GPGAchievementModel *achievement;

@property(nonatomic, readonly, retain) GPGGameMetadataModel *application;

@property(nonatomic, readonly, retain) GPGLeaderboardModel *leaderboard;

@property(nonatomic, readonly, retain) GPGPlayerModel *player;

@property(nonatomic, readonly, retain) GPGAppStateModel *appState;

@property(nonatomic, readonly, retain) GPGTurnBasedModel *turnBased;

@end


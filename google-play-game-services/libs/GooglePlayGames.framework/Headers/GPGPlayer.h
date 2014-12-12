//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <UIKit/UIKit.h>

#import "GPGEnums.h"

@class GPGPlayer;

typedef void (^GPGPlayerGetBlock)(GPGPlayer *player, NSError *error);

typedef void (^GPGPlayersGetBlock)(NSArray *players, NSError *error);

@class GPGPlayerLevel;

@interface GPGPlayer : NSObject

@property(nonatomic, readonly, copy) NSURL *imageUrl;

@property(nonatomic, readonly, copy) NSString *displayName;

@property(nonatomic, readonly, copy) NSString *playerId;

@property(nonatomic, readonly, copy) NSString *title;

@property(nonatomic, readonly, assign) int64_t currentExperiencePoints;

@property(nonatomic, readonly, assign) int64_t lastLevelUpTimestamp;

@property(nonatomic, readonly, copy) GPGPlayerLevel *currentLevel;
@property(nonatomic, readonly, copy) GPGPlayerLevel *nextLevel;

+ (void)localPlayerWithCompletionHandler:(GPGPlayerGetBlock)completionHandler;

+ (void)localPlayerFromDataSource:(GPGDataSource)dataSource
                completionHandler:(GPGPlayerGetBlock)completionHandler;

+ (void)recentlyPlayedPlayersWithCompletionHandler:(GPGPlayersGetBlock)completionHandler;

+ (void)recentlyPlayedPlayersFromDataSource:(GPGDataSource)dataSource
                          completionHandler:(GPGPlayersGetBlock)completionHandler;

+ (void)connectedPlayersWithCompletionHandler:(GPGPlayersGetBlock)completionHandler;

+ (void)connectedPlayersFromDataSource:(GPGDataSource)dataSource
                     completionHandler:(GPGPlayersGetBlock)completionHandler;

@end


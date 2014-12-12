//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <Foundation/Foundation.h>

#import "GPGEnums.h"

@class GPGScore, GPGLocalPlayerScore;

typedef void (^GPGLeaderboardLoadScoresBlock)(NSArray *scores, NSError *error);

typedef void (^GPGScoreResetBlock)(NSError *error);

@interface GPGLeaderboard : NSObject


- (instancetype)initWithLeaderboardId:(NSString *)leaderboardId;

+ (instancetype)leaderboardWithId:(NSString *)leaderboardId;

#pragma mark Constant Properties 
@property(nonatomic, readonly, copy) NSString *leaderboardId;

#pragma mark Configurable Properties 
@property(nonatomic, assign, getter=isPersonalWindow) BOOL personalWindow; // default: NO. NO means the window is focused around top players.

@property(nonatomic, assign) GPGLeaderboardTimeScope timeScope; // default: GPGLeaderboardTimeScopeAllTime

@property(nonatomic, assign, getter=isSocial) BOOL social; // default: NO. NO means load the public leaderboard.

#pragma mark Actions 
- (void)loadScoresWithCompletionHandler:(GPGLeaderboardLoadScoresBlock)completionHandler;

- (void)loadScoresFromDataSource:(GPGDataSource)dataSource
               completionHandler:(GPGLeaderboardLoadScoresBlock)completionHandler;

- (void)loadNextPageOfScoresWithCompletionHandler:(GPGLeaderboardLoadScoresBlock)completionHandler;

- (void)loadPreviousPageOfScoresWithCompletionHandler:(GPGLeaderboardLoadScoresBlock)completionHandler;

- (void)resetScoreWithCompletionHandler:(GPGScoreResetBlock)completionHandler;

#pragma mark In-Flight Status 

@property(nonatomic, getter=isLoading, readonly) BOOL loading;

@property(nonatomic, readonly, assign) BOOL loadingPreviousPage;

@property(nonatomic, readonly, assign) BOOL loadingNextPage;

#pragma mark Post-Load Results 

@property(nonatomic, readonly, copy) NSArray *scores; // [GPGScore,...]

@property(nonatomic, readonly, strong) GPGLocalPlayerScore *localPlayerScore;

@property(nonatomic, readonly, copy) NSString *name;

@property(nonatomic, readonly, assign) BOOL hasPreviousPage;

@property(nonatomic, readonly, assign) BOOL hasNextPage;

@end


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


// Designated initializer.
- (id)initWithLeaderboardId:(NSString *)leaderboardId;

+ (id)leaderboardWithId:(NSString *)leaderboardId;

#pragma mark Constant Properties 
@property (nonatomic, readonly, copy) NSString * leaderboardId;

#pragma mark Configurable Properties 
@property (nonatomic, readwrite, assign, getter=isPersonalWindow) BOOL personalWindow; // default: NO. NO means the window is focused around top players.

@property (nonatomic, readwrite, assign) GPGLeaderboardTimeScope timeScope; // default: GPGLeaderboardTimeScopeAllTime

@property (nonatomic, readwrite, assign, getter=isSocial) BOOL social; // default: NO. NO means load the public leaderboard.

#pragma mark Actions 
- (void)loadScoresWithCompletionHandler:(GPGLeaderboardLoadScoresBlock)completionHandler;

- (void)loadNextPageOfScoresWithCompletionHandler:(GPGLeaderboardLoadScoresBlock)completionHandler;

- (void)loadPreviousPageOfScoresWithCompletionHandler:(GPGLeaderboardLoadScoresBlock)completionHandler;

- (void)resetScoreWithCompletionHandler:(GPGScoreResetBlock)completionHandler;

#pragma mark In-Flight Status 

- (BOOL)isLoading;

- (BOOL)isLoadingPreviousPage;

- (BOOL)isLoadingNextPage;

#pragma mark Post-Load Results 

@property (nonatomic, readonly, copy) NSArray *scores; // [GPGScore,...]

@property (nonatomic, readonly, retain) GPGLocalPlayerScore *localPlayerScore;

@property (nonatomic, readonly, copy) NSString *name;

@property (nonatomic, readonly, assign) BOOL hasPreviousPage;

@property (nonatomic, readonly, assign) BOOL hasNextPage;

@end


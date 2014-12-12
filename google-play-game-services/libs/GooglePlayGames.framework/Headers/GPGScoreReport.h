//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <Foundation/Foundation.h>

@class GPGScore;

@interface GPGScoreReport : NSObject

@property(nonatomic, readonly, assign) BOOL isHighScoreForLocalPlayerToday;
@property(nonatomic, readonly, assign) BOOL isHighScoreForLocalPlayerThisWeek;
@property(nonatomic, readonly, assign) BOOL isHighScoreForLocalPlayerAllTime;
@property(nonatomic, readonly, copy) NSString *leaderboardId;
@property(nonatomic, readonly, assign) int64_t reportedScoreValue;
@property(nonatomic, readonly, strong) GPGScore *highScoreForLocalPlayerToday;
@property(nonatomic, readonly, strong) GPGScore *highScoreForLocalPlayerThisWeek;
@property(nonatomic, readonly, strong) GPGScore *highScoreForLocalPlayerAllTime;

@end


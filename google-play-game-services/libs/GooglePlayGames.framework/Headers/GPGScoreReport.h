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
@property(nonatomic, readonly, assign) unsigned long long reportedScoreValue;
// These scores are non-nil only if the reported score did not beat them.
@property(nonatomic, readonly, retain) GPGScore *highScoreForLocalPlayerToday;
@property(nonatomic, readonly, retain) GPGScore *highScoreForLocalPlayerThisWeek;
@property(nonatomic, readonly, retain) GPGScore *highScoreForLocalPlayerAllTime;

@end


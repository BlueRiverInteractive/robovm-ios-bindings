//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <Foundation/Foundation.h>

@class GPGScoreReport;

typedef void (^GPGScoreReportScoreBlock)(GPGScoreReport *report, NSError *error);

typedef void (^GPGScoreBatchReportBlock)(NSError *error);

@interface GPGScore : NSObject <NSCoding>

- (id)initWithLeaderboardId:(NSString *)leaderboardId;
+ (id)scoreWithLeaderboardId:(NSString *)leaderboardId;

#pragma mark Constant Properties 
@property (nonatomic, readonly, copy) NSString *leaderboardId;

#pragma mark Configurable Properties 
@property (nonatomic, readwrite, assign) unsigned long long value;

@property (nonatomic, readwrite, copy) NSString *scoreTag;

#pragma mark Actions 

- (BOOL)submitScoreWithCompletionHandler:(GPGScoreReportScoreBlock)completionHandler;

+ (void)submitScores:(NSArray *)scores withCompletionHandler:(GPGScoreBatchReportBlock)completionHandler __attribute__((deprecated));

+ (void)batchSubmitScores:(NSArray *)scores
    withCompletionHandler:(GPGScoreReportScoreBlock)completionHandler;

#pragma mark Post-Load Results 
@property (nonatomic, readonly, copy) NSURL *avatarUrl;

@property (nonatomic, readonly, copy) NSString *displayName;

@property (nonatomic, readonly, copy) NSString *formattedRank;

@property (nonatomic, readonly, copy) NSString *formattedScore;

@property (nonatomic, readonly, copy) NSString *playerId;

@property (nonatomic, readonly, assign) unsigned long long rank;

@property (nonatomic, readonly, copy) NSString *timeSpan;

@property (nonatomic, readonly, assign) long long writeTimestamp;

@end

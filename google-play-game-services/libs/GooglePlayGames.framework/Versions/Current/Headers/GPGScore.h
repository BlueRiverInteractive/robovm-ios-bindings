//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <Foundation/Foundation.h>

@class GPGPlayer;
@class GPGScoreReport;

typedef void (^GPGScoreReportScoreBlock)(GPGScoreReport *report, NSError *error);

typedef void (^GPGScoreBatchReportBlock)(NSError *error);

@interface GPGScore : NSObject <NSCoding>

- (instancetype)initWithLeaderboardId:(NSString *)leaderboardId;
+ (instancetype)scoreWithLeaderboardId:(NSString *)leaderboardId;

#pragma mark Constant Properties 
@property(nonatomic, readonly, copy) NSString *leaderboardId;

#pragma mark Configurable Properties 
@property(nonatomic, assign) int64_t value;

@property(nonatomic, copy) NSString *scoreTag;

#pragma mark Actions 
- (BOOL)submitScoreWithCompletionHandler:(GPGScoreReportScoreBlock)completionHandler;

+ (void)batchSubmitScores:(NSArray *)scores
    withCompletionHandler:(GPGScoreReportScoreBlock)completionHandler __attribute__((deprecated));

+ (void)batchSubmitScores:(NSArray *)scores
        completionHandler:(GPGScoreReportScoreBlock)completionHandler;


#pragma mark Post-Load Results 
@property(nonatomic, readonly, copy) NSURL *avatarUrl __attribute__((deprecated));

@property(nonatomic, readonly, copy) NSString *displayName __attribute__((deprecated));

@property(nonatomic, readonly, copy) NSString *formattedRank;

@property(nonatomic, readonly, copy) NSString *formattedScore;

@property(nonatomic, readonly, copy) NSString *playerId __attribute__((deprecated));

@property(nonatomic, readonly, strong) GPGPlayer *player;

@property(nonatomic, readonly, assign) int64_t rank;

@property(nonatomic, readonly, copy) NSString *timeSpan;

@property(nonatomic, readonly, assign) int64_t writeTimestamp;

@end

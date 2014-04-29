//
//  OKScoreDB.h
//  OpenKit
//
//  Created by Suneet Shah on 10/3/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "OKLocalCache.h"

@class OKScore;

@interface OKScoreDB : OKLocalCache

@property (nonatomic, strong) OKScore *previousSubmittedScore;

+ (OKScoreDB*)sharedCache;

-(NSArray*)getAllCachedScores;
-(NSArray*)getCachedScoresForLeaderboardID:(int)leaderboardID andOnlyGetSubmittedScores:(BOOL)submittedOnly;
-(void)submitCachedScore:(OKScore*)score;
-(void)submitAllCachedScores;
-(void)clearCachedSubmittedScores;

-(void)updateCachedScoreSubmitted:(OKScore*)score;

-(BOOL)isScoreBetterThanLocalCachedScores:(OKScore *)score;
-(void)storeScoreIfBetter:(OKScore*)score;
-(BOOL)isScoreBetterThanLocalCachedScores:(OKScore*)scoreToStore storeScore:(BOOL)shouldStoreScore force:(BOOL)shouldForce;

@end

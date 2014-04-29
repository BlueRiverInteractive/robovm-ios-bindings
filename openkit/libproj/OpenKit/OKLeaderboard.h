//
//  OKLeaderboard.h
//  OKClient
//
//  Created by Suneet Shah on 1/3/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <GameKit/GameKit.h>
#import "OKGKScoreWrapper.h"

#define NUM_SCORES_PER_PAGE 25

typedef enum {
    OKLeaderboardSortTypeHighValue,
    OKLeaderboardSortTypeLowValue
} OKLeaderBoardSortType;

typedef enum {
    OKLeaderboardTimeRangeOneDay,
    OKLeaderboardTimeRangeOneWeek,
    OKLeaderboardTimeRangeAllTime
} OKLeaderboardTimeRange;

@class OKScore;


@interface OKLeaderboard : NSObject


@property (nonatomic) int OKApp_id;
@property (nonatomic) NSInteger OKLeaderboard_id;
@property (nonatomic, strong) NSString *name;
@property (nonatomic) OKLeaderBoardSortType sortType;
@property (nonatomic, strong) NSString *icon_url;
@property (nonatomic) int playerCount;
@property (nonatomic, strong) NSString *gamecenter_id;
@property (nonatomic, strong) GKScore *localPlayerScore;


+(void)getLeaderboardsWithCompletionHandler:(void (^)(NSArray* leaderboards, int playerCount, NSError* error))completionHandler;
+(void)getLeaderboardWithID:(int)leaderboardID withCompletionHandler:(void (^)(OKLeaderboard *leaderboard, NSError *error))completionHandler;
-(NSString *)playerCountString;
-(id)initFromJSON:(NSDictionary*)jsonDict;

//OpenKit Methods
- (void)getScoresForTimeRange:(OKLeaderboardTimeRange)timeRange WithCompletionhandler:(void (^)(NSArray* scores, NSError *error))completionHandler;
-(void)getScoresForTimeRange:(OKLeaderboardTimeRange)timeRange forPageNumber:(int)pageNum
       WithCompletionhandler:(void (^)(NSArray* scores, NSError *error))completionHandler;
-(void)getPlayerTopScoreForLeaderboardForTimeRange:(OKLeaderboardTimeRange)range withCompletionHandler:(void (^)(OKScore *score, NSError *error))completionHandler;
-(void)getFacebookFriendsScoresWithCompletionHandler:(void (^)(NSArray *scores, NSError *error))completionHandler;

//Wrapper methods
-(void)getGlobalScoresWithPageNum:(int)pageNum withCompletionHandler:(void (^)(NSArray *scores, NSError *error))completionHandler;
-(void)getPlayerTopScoreWithCompletionHandler:(void (^)(id<OKScoreProtocol> score, NSError *error))completionHandler;

//GameCenter methods
-(void)getGameCenterFriendsScoreswithCompletionHandler:(void (^)(NSArray *scores, NSError *error))completionHandler;
-(void)getPlayerTopScoreFromGameCenterWithCompletionHandler:(void (^)(OKGKScoreWrapper *score, NSError *error))completionHandler;
-(BOOL)showGlobalScoresFromGameCenter;

-(NSSortDescriptor*)getSortDescriptor;
-(NSArray*)sortScoresBasedOnLeaderboardType:(NSArray*)scores;

@end

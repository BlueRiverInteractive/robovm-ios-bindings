//
//  OKScore.h
//  OKClient
//
//  Created by Suneet Shah on 1/3/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "OKScoreProtocol.h"

@class OKUser;
@interface OKScore : NSObject<OKScoreProtocol, NSCoding>

@property (nonatomic) NSInteger OKScoreID;
@property (nonatomic) int64_t scoreValue;
@property (nonatomic) NSInteger OKLeaderboardID;
@property (nonatomic, strong) OKUser *user;
@property (nonatomic) NSInteger scoreRank;
@property (nonatomic) int metadata;
@property (nonatomic, strong) NSString *displayString;
@property (nonatomic, strong) NSString *gamecenterLeaderboardID;
@property (nonatomic) BOOL submitted;

- (id)initFromJSON:(NSDictionary*)jsonDict;
- (void)submitScoreWithCompletionHandler:(void (^)(NSError *error))completionHandler;
- (void)forceSubmitScoreWithCompletionHandler:(void (^)(NSError *error))completionHandler;
- (void)submitScoreToOpenKitAndGameCenterWithCompletionHandler:(void (^)(NSError *error))completionHandler;
- (void)setRank:(NSInteger)rank;
- (void)cachedScoreSubmit:(void (^)(NSError *error))completionHandler;

@end

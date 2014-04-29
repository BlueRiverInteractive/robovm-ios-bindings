//
//  OKGKScoreWrapper.h
//  OpenKit
//
//  Created by Suneet Shah on 6/13/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <GameKit/GameKit.h>
#import "OKScoreProtocol.h"

@interface OKGKScoreWrapper : NSObject<OKScoreProtocol>

@property (nonatomic, strong) GKScore *score;
@property (nonatomic, strong) GKPlayer *player;
// Rank is a read only property of GKScore, and since we are showing social scores ranked against each other, we need a way to store a local rank
@property (nonatomic, strong) NSString *explicitlySetRank;

-(void)setRank:(NSInteger)rank;

@end

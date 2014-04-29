//
//  OKChallenge.h
//  OpenKit
//
//  Created by Suneet Shah on 9/13/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "OKScore.h"

@interface OKChallenge : NSObject

+(void)sendPushChallengewithScorePostResponseJSON:(id)responseObject withPreviousScore:(OKScore*)previousScore;

@end

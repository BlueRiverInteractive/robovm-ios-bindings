//
//  OKAchievementScore.h
//  OpenKit
//
//  Created by Suneet Shah on 12/10/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface OKAchievementScore : NSObject
@property (nonatomic) int progress, OKAchievementID;
@property (nonatomic, strong) NSString *GKAchievementID;
@property (nonatomic) float GKPercentComplete;

-(void)submitAchievementScoreWithCompletionHandler:(void (^)(NSError *error))completionHandler;

@end

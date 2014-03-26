//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <UIKit/UIKit.h>

#import "GPGEnums.h"


@interface GPGAchievementMetadata : NSObject <NSCopying, NSCoding>

@property(nonatomic, readonly, copy) NSString *achievementId;

@property(nonatomic, readonly, assign) GPGAchievementState state;

@property(nonatomic, readonly, assign) GPGAchievementType type;

@property(nonatomic, readonly, copy) NSString *name;

@property(nonatomic, readonly, copy) NSString *achievementDescription;

@property(nonatomic, readonly, copy) NSURL *revealedIconUrl;

@property(nonatomic, readonly, copy) NSURL *unlockedIconUrl;

@property(nonatomic, readonly, assign) NSInteger completedSteps;

@property(nonatomic, readonly, assign) NSInteger numberOfSteps;

@property(nonatomic, readonly, copy) NSString *formattedCompletedSteps;

@property(nonatomic, readonly, copy) NSString *formattedNumberOfSteps;

@property(nonatomic, readonly, assign) long long lastUpdatedTimestamp;

@property(nonatomic, readonly, assign) CGFloat progress;

@end

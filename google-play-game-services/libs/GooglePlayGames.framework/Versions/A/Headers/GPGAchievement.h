//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <UIKit/UIKit.h>

#import "GPGEnums.h"

typedef void (^GPGAchievementDidUnlockBlock)(BOOL newlyUnlocked, NSError *error);

typedef void (^GPGAchievementDidIncrementBlock)(
    BOOL newlyUnlocked, int currentSteps, NSError *error);

typedef void (^GPGAchievementDidSetStepsBlock)(
    BOOL newlyUnlocked, int currentSteps, NSError *error);

typedef void (^GPGAchievementDidRevealBlock)(GPGAchievementState state, NSError *error);

typedef void (^GPGAchievementDidResetBlock)(NSError *error);

typedef void (^GPGAllAchievementsDidResetBlock)(NSError *error);

@interface GPGAchievement : NSObject

- (instancetype)initWithAchievementId:(NSString *)achievementId;

+ (instancetype)achievementWithId:(NSString *)achievementId;

#pragma mark Constant Properties 

@property(nonatomic, readonly, copy) NSString *achievementId;

#pragma mark Configurable Properties 

@property(nonatomic, assign) BOOL showsCompletionNotification;

#pragma mark Actions 
- (void)unlockAchievementWithCompletionHandler:(GPGAchievementDidUnlockBlock)completionHandler;

- (void)revealAchievementWithCompletionHandler:(GPGAchievementDidRevealBlock)completionHandler;

- (void)incrementAchievementNumSteps:(NSInteger)steps
                   completionHandler:(GPGAchievementDidIncrementBlock)completionHandler;

- (void)setSteps:(NSInteger)steps
  completionHandler:(GPGAchievementDidSetStepsBlock)completionHandler;

- (void)resetAchievementWithCompletionHandler:(GPGAchievementDidResetBlock)completionHandler;

+ (void)resetAllAchievementsWithCompletionHandler:
      (GPGAllAchievementsDidResetBlock)completionHandler;

@end

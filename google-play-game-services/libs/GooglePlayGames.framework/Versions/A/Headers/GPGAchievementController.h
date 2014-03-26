//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <UIKit/UIKit.h>

@protocol GPGAchievementControllerDelegate;

@interface GPGAchievementController : UINavigationController

// Designated initializer.
- (id)init;

#pragma mark Properties 
@property (nonatomic, readwrite, assign) id<GPGAchievementControllerDelegate> achievementDelegate;

@end

@protocol GPGAchievementControllerDelegate <NSObject>
 @required

- (void)achievementViewControllerDidFinish:(GPGAchievementController *)viewController;

@end

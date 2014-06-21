//
//  CBMoreAppsButton.h
//  Chartboost
//  VERSION
//
//  Copyright 2011 Chartboost. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface CBMoreAppsButton : UIView

/// Set the number displayed in the badge
- (void)setBadgeNumber:(NSUInteger)count;

/// Provides a customizable button with update badge that launches the more apps page
+ (CBMoreAppsButton *)moreAppsButtonWithImage:(UIImage *)customImage;

@end

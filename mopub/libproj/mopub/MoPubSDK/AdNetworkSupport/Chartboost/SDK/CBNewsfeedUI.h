//
//  CBNewsfeedUI.h
//  Chartboost
//  VERSION
//
//  Copyright 2011 Chartboost. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

@class CBStory;

/**
 * Enum for Newsfeed UI display/dismiss animation.
 */
typedef enum {
    CBNewsfeedAnimationTypeSlideFromBottom = 0,
    CBNewsfeedAnimationTypeSlideFromTop,
    CBNewsfeedAnimationTypeSlideFromLeft,
    CBNewsfeedAnimationTypeSlideFromRight,
    CBNewsfeedAnimationTypeNone
} CBNewsfeedAnimationType;

/**
 * Enum for Newsfeed UI anchor point.
 */
typedef enum {
    CBNewsfeedUIPositionCenter = 0,
    CBNewsfeedUIPositionTop,
    CBNewsfeedUIPositionBottom,
    CBNewsfeedUIPositionLeft,
    CBNewsfeedUIPositionRight
} CBNewsfeedUIPosition;

/**
 * Enum for Notification UI click action.
 */
typedef enum {
    CBNotificationUIClickActionDisplayNewsfeedUI = 0,
    CBNotificationUIClickActionPerformLink,
    CBNotificationUIClickActionNone
} CBNotificationUIClickAction;

/**
 * CBNewsfeedUIProtocol
 *
 * Implement this protocol in a class and assign it with
 * [CBNewsfeed useCustomUI:] to override the default Newsfeed UI.
 */
@protocol CBNewsfeedUIProtocol

@required

/**
 * Display the Newsfeed UI.
 */
+ (void)displayNewsfeed;

/**
 * Dismiss the Newsfeed UI.
 */
+ (void)dismissNewsfeed;

/**
 * Check if the Newsfeed UI is visible.
 */
+ (BOOL)isNewsfeedUIVisible;

/**
 * Dismiss the Notification UI.
 */
+ (void)displayNotifcation;

/**
 * Display the Notification UI for a specific CBStory.
 *
 * @param CBStory
 */
+ (void)displayNotifcation:(CBStory *)story;

/**
 * Dismiss the Notification UI.
 */
+ (void)dismissNotification;

/**
 * Check if the Notification UI is visible.
 */
+ (BOOL)isNotificationUIVisible;

@end

/**
 * Default Newsfeed UI provided by the Chartboost SDK.
 *
 * Implements the CBNewsfeedUIProtocol.
 */
@interface CBNewsfeedUI : NSObject <CBNewsfeedUIProtocol>

/**
 * Get the CBNewsfeedUI singleton.
 */
+ (CBNewsfeedUI *)shared;

/**
 * CBNewsfeedUIProtocol methods.  See above for more information.
 */
+ (BOOL)isNewsfeedUIVisible;
+ (void)displayNewsfeed;
+ (void)dismissNewsfeed;
+ (BOOL)isNotificationUIVisible;
+ (void)displayNotifcation;
+ (void)displayNotifcation:(CBStory *)story;
+ (void)dismissNotification;

/**
 * Get CGSize for Default NewsfeedUI.
 *
 * You can use this to help size a custom header.
 */
- (CGSize)getNewsfeedUISize;

/**
 * Anchor point for Newsfeed UI in portrait mode.
 */
@property (nonatomic, assign) CBNewsfeedUIPosition newsfeedUIPortraitPosition;

/**
 * Anchor point for Newsfeed UI in landscape mode.
 */
@property (nonatomic, assign) CBNewsfeedUIPosition newsfeedUILandscapePosition;

/**
 * Display animation for Newsfeed UI in portrait mode.
 */
@property (nonatomic, assign) CBNewsfeedAnimationType portraitDisplayAnimation;

/**
 * Dismiss animation for Newsfeed UI in portrait mode.
 */
@property (nonatomic, assign) CBNewsfeedAnimationType portraitDismissAnimation;

/**
 * Display animation for Newsfeed UI in landscape mode.
 */
@property (nonatomic, assign) CBNewsfeedAnimationType landscapeDisplayAnimation;

/**
 * Dismiss animation for Newsfeed UI in landscape mode.
 */
@property (nonatomic, assign) CBNewsfeedAnimationType landscapeDismissAnimation;

/**
 * Controls what the Notification UI should attempt to do on click.
 */
@property (nonatomic, assign) CBNotificationUIClickAction notificationUIClickAction;

/**
 * Set Newsfeed UI background color.
 *
 * @param UIColor
 */
- (void)setNewsfeedBackgroundColor:(UIColor *)color;

/**
 * Set Newsfeed UI message cell background color.
 *
 * @param UIColor
 */
- (void)setNewsfeedMessageCellBackgroundColor:(UIColor *)color;

/**
 * Set Newsfeed UI header cell background color.
 *
 * @param UIColor
 */
- (void)setNewsfeedHeaderCellBackgroundColor:(UIColor *)color;

/**
 * Set Newsfeed UI message cell text color.
 *
 * @param UIColor
 */
- (void)setNewsfeedMessageCellTextColor:(UIColor *)color;

/**
 * Set Newsfeed UI header cell background color.
 *
 * @param UIColor
 */
- (void)setNewsfeedHeaderCellTextColor:(UIColor *)color;

/**
 * Set Newsfeed UI header cell text.
 *
 * @param NSString
 */
- (void)setNewsfeedHeaderCellText:(NSString *)text;

/**
 * Set Notification UI text color.
 *
 * @param UIColor
 */
- (void)setNotificationTextColor:(UIColor *)color;

/**
 * Set Notification UI background color.
 *
 * @param UIColor
 */
- (void)setNotificationBackgroundColor:(UIColor *)color;

/**
 * Set Notification UI text font.
 *
 * @param UIFont
 */
- (void)setNotificationTextFont:(UIFont *)font;

/**
 * Set a custom header UIView for the Newsfeed UI.
 *
 * @param UIView
 */
- (void)setCustomNewsfeedHeaderView:(UIView *)view;

/**
 * Get Newsfeed UI background color.
 *
 * @return UIColor
 */
- (UIColor *)getNewsfeedBackgroundColor;

/**
 * Get Newsfeed UI message cell background color.
 *
 * @return UIColor
 */
- (UIColor *)getNewsfeedMessageCellBackgroundColor;

/**
 * Get Newsfeed UI header cell background color.
 *
 * @return UIColor
 */
- (UIColor *)getNewsfeedHeaderCellBackgroundColor;

/**
 * Get Newsfeed UI message cell text color.
 *
 * @return UIColor
 */
- (UIColor *)getNewsfeedMessageCellTextColor;

/**
 * Get Newsfeed UI header cell text color.
 *
 * @return UIColor
 */
- (UIColor *)getNewsfeedHeaderCellTextColor;

/**
 * Get Newsfeed UI header cell text.
 *
 * @return NSString
 */
- (NSString *)getNewsfeedHeaderCellText;

/**
 * Get Notification UI text color.
 *
 * @return UIColor
 */
- (UIColor *)getNotificationTextColor;

/**
 * Get Notification UI background color.
 *
 * @return UIColor
 */
- (UIColor *)getNotificationBackgroundColor;

/**
 * Get Notification UI text font.
 *
 * @return UIFont
 */
- (UIFont *)getNotificationTextFont;

/**
 * Get a custom header UIView for the Newsfeed UI.
 *
 * @return UIView
 */
- (UIView *)getCustomNewsfeedHeaderView;

/**
 * Get the orientation of the CBNewsfeedUI.
 */
@property (nonatomic, readonly) UIInterfaceOrientation orientation;

@end


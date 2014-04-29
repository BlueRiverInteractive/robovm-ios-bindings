//
//  KGModal.h
//  KGModal
//
//  Created by David Keegan on 10/5/12.
//  Copyright (c) 2012 David Keegan. All rights reserved.
//

#import <UIKit/UIKit.h>

NS_ENUM(NSUInteger, KGModalBackgroundDisplayStyle){
    KGModalBackgroundDisplayStyleGradient,
    KGModalBackgroundDisplayStyleSolid
};


@interface KGModal : NSObject

//Create a delegate so that our BaseViewController gets retained
@property (nonatomic, strong) UIViewController *delegate;

// Determines if the modal should dismiss if the user taps outside of the modal view
// Defaults to YES
@property (nonatomic) BOOL tapOutsideToDismiss;

// Determins if the close button or tapping outside the modal should animate the dismissal
// Defaults to YES
@property (nonatomic) BOOL animateWhenDismissed;

// Determins if the close button is shown
// Defaults to YES
@property (nonatomic) BOOL showCloseButton;

// The background color of the modal window
// Defaults black with 0.5 opacity
@property (strong, nonatomic) UIColor *modalBackgroundColor;

// The background display style, can be a transparent radial gradient or a transparent black
// Defaults to gradient, this looks better but takes a bit more time to display on the retina iPad
@property (nonatomic) enum KGModalBackgroundDisplayStyle backgroundDisplayStyle;

// Determins if the modal should rotate when the device rotates
// Defaults to YES, only applies to iOS5
@property (nonatomic) BOOL shouldRotate;

// The shared instance of the modal
+ (id)sharedInstance;

// Set the content view to display in the modal and display with animations
- (void)showWithContentView:(UIView *)contentView;

// Set the content view to display in the modal and whether the modal should animate in
- (void)showWithContentView:(UIView *)contentView andAnimated:(BOOL)animated;

// Hide the modal with animations
- (void)hide;

// Hide the modal with animations,
// run the completion after the modal is hidden
- (void)hideWithCompletionBlock:(void(^)())completion;

// Hide the modal and whether the modal should animate away
- (void)hideAnimated:(BOOL)animated;

// Hide the modal and whether the modal should animate away,
// run the completion after the modal is hidden
- (void)hideAnimated:(BOOL)animated withCompletionBlock:(void(^)())completion;

@end

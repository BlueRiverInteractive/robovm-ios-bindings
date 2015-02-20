//  Copyright (c) 2014 Iddiction, Inc. All rights reserved.

#import "Xplode.h"
#import "XplodePromotionDelegate.h"
#import "XplodeConstants.h"

@interface Xplode (Promotions)

///---------------------
/// @name Promotions
///---------------------

/// Returns the promotion delegate.
///
/// Promotion delegates have to conform to the formal protocol XplodePromotionDelegate.
///
/// @return The promotion delegate.
+ (id<XplodePromotionDelegate>)promotionDelegate;

/// Sets the promotion delegate.
///
/// Promotion delegates have to conform to the formal protocol XplodePromotionDelegate.
///
/// @param delegate A promotion delegate.
+ (void)setPromotionDelegate:(id<XplodePromotionDelegate>)delegate;

/// Checks whether promotions are supported on the current device.
///
/// @return *YES* if the device is supported, *NO* otherwise.
+ (BOOL)isCurrentDeviceSupported;

/// Enable or disable preloading of all the promotions on each app launch.
/// Enabled by default.
///
/// @param enablePreloading Enable preloading if *YES*.
+ (void)setPromotionPreloadingOnLaunch:(BOOL)enablePreloading;

/// Preloads the promotion for a specific breakpoint for presenting it later.
///
/// Nothing is presented on-screen, the data is only loaded from the server and cached.
///
/// @warning This method does nothing. All promotions are now preloaded on launch.
/// @deprecated Since version 2.4.0.
///
/// @param breakpoint	Name of the breakpoint.
+ (void)cachePromotionForBreakpoint:(NSString *)breakpoint __attribute__((deprecated(" Since Xplode SDK v2.4.0. All promotions are now preloaded on launch.")));

/// Presents a view controller with the promotion for the specified breakpoint.
/// When a promotion has been set up using setupPromotionDockForBreakpoint:atPosition:, this method only presents the loaded promotion.
///
/// @deprecated Since version 2.4.1.
/// @param breakpoint			Name of the breakpoint.
/// @param completionHandler	A completion block that is executed when the promotion is closed.
+ (void)presentPromotionForBreakpoint:(NSString *)breakpoint
						 onCompletion:(void(^)(void))completionHandler __attribute__((deprecated(" Since Xplode SDK v2.4.1. Use presentPromotionForBreakpoint:withCompletionHandler:andDismissalHandler: for better promotion handling.")));

/// Presents a view controller with the promotion for the specified breakpoint.
/// When a promotion has been set up using setupPromotionDockForBreakpoint:atPosition:, this method only presents the loaded promotion.
///
/// @param breakpoint			Name of the breakpoint.
///	@param completionHandler	A completion block that is executed when the promotion finishes loading.
///	@param dismissalHandler		A completion block that is executed when the promotion is closed.
+ (void)presentPromotionForBreakpoint:(NSString *)breakpoint
				withCompletionHandler:(void(^)(BOOL isReadyToPresent, NSError *error))completionHandler
					andDismissHandler:(void(^)(void))dismissHandler;

/// Checks if the promotion for the specified breakpoint is cached.
///
/// @param breakpoint	Name of the breakpoint.
///
/// @return *YES* if a promotion is cached for the specified breakpoint, *NO* otherwise.
+ (BOOL)isPromotionCachedForBreakpoint:(NSString *)breakpoint;

/// Returns a value whether any promotion is currently presented in full-screen.
///
/// The state changes when the presentPromotionForBreakpoint:withCompletionHandler:andDismissalHandler:, dismissPromotion, removePromotionDock showPromotionDockAndBounce: and hidePromotionDock methods are called.
///
/// @return *YES* if open, *NO* if closed.
+ (BOOL)isPromotionOpen;

/// Returns the visibility of a dockable promotion. The promotion is visible if the dock is visible or if it is presented full-screen.
/// The state changes when the showPromotionDockAndBounce: and hidePromotionDock methods are called.
///
/// @note This method always returns *NO* when only a modal promotion is presented.
///
/// @return *YES* if visible, *NO* if hidden.
+ (BOOL)isPromotionDockVisible;

/// Initializes a dockable always-on-screen promotion for a specific breakpoint and optionally shows it at a specific position.
///
/// @deprecated Since version 2.4.1.
/// @param breakpoint      Name of the breakpoint.
/// @param position Dock the promotion on bottom (default), or at top.
+ (void)setupPromotionDockForBreakpoint:(NSString *)breakpoint
							 atPosition:(XPLPromotionDockingPosition)position __attribute__((deprecated(" Since Xplode SDK v2.4.1. Use setupPromotionDockForBreakpoint:atPosition:withCompletionHandler: for better promotion handling.")));

/// Initializes a dockable always-on-screen promotion for a specific breakpoint and optionally shows it at a specific position.
///
/// @param breakpoint      Name of the breakpoint.
/// @param position Dock the promotion on bottom (default), or at top.
///	@param completionHandler	A completion block that is executed when the promotion finishes loading.
+ (void)setupPromotionDockForBreakpoint:(NSString *)breakpoint
							 atPosition:(XPLPromotionDockingPosition)position
				  withCompletionHandler:(void(^)(BOOL isReadyToPresent, NSError *error))completionHandler;

/// Initializes a dockable always-on-screen promotion for a specific breakpoint and dimensions, optionally shown at a specific position.
///
/// Currently supported dimensions are (SW - Screen Width):
///
/// | Orientation | Xplode    | iAd       | IAB       |
/// |-------------|:---------:|:---------:|:---------:|
/// | Portrait    | SW x 35pt | SW x 32pt | SW x 50pt |
/// | Landscape   | SW x 35pt | SW x 32pt | SW x 50pt |
///
/// @see XPLPromotionDockingPosition
/// @see XPLPromotionDockDimensions
///
/// @deprecated Since version 2.4.1.
/// @param breakpoint      Name of the breakpoint.
/// @param position        Dock the promotion on bottom (default), or at top.
/// @param dimensions      Dimension standard as defined in XPLPromotionDockDimensions.
+ (void)setupPromotionDockForBreakpoint:(NSString *)breakpoint
							 atPosition:(XPLPromotionDockingPosition)position
						 withDimensions:(XPLPromotionDockDimensions)dimensions __attribute__((deprecated(" Since Xplode SDK v2.4.1. Use setupPromotionDockForBreakpoint:atPosition:withDimensions:andCompletionHandler: for better promotion handling.")));

/// Initializes a dockable always-on-screen promotion for a specific breakpoint and dimensions, optionally shown at a specific position.
///
/// Currently supported dimensions are (SW - Screen Width):
///
/// | Orientation | Xplode    | iAd       | IAB       |
/// |-------------|:---------:|:---------:|:---------:|
/// | Portrait    | SW x 35pt | SW x 32pt | SW x 50pt |
/// | Landscape   | SW x 35pt | SW x 32pt | SW x 50pt |
///
/// @see XPLPromotionDockingPosition
/// @see XPLPromotionDockDimensions
///
/// @param breakpoint      Name of the breakpoint.
/// @param position        Dock the promotion on bottom (default), or at top.
/// @param dimensions      Dimension standard as defined in XPLPromotionDockDimensions.
///	@param completionHandler	A completion block that is executed when the promotion finishes loading.
+ (void)setupPromotionDockForBreakpoint:(NSString *)breakpoint
							 atPosition:(XPLPromotionDockingPosition)position
						 withDimensions:(XPLPromotionDockDimensions)dimensions
				   andCompletionHandler:(void(^)(BOOL isReadyToPresent, NSError *error))completionHandler;

/// Shows the promotion dock if a promotion has been set up as dockable.
/// If you call this method with bounce *YES* while the dock is already visible then only the bounce animation is performed.
///
/// @note The promotion dock can only be shown after the promotion has been set up using setupPromotionDockForBreakpoint:atPosition:.
///
/// @param bounce *YES* for bouncing animation, *NO* for sliding animation.
+ (void)showPromotionDockAndBounce:(BOOL)bounce;

/// Hides the promotion dock if a promotion has been set up as dockable.
///
/// @note The promotion dock can only be hidden after the promotion has been set up using setupPromotionDockForBreakpoint:atPosition: or shown using showPromotionDockAndBounce:.
+ (void)hidePromotionDock;

/// Dismisses the promotion dock and removes it from memory.
+ (void)removePromotionDock;

/// Dismisses any presented modal promotion and removes it from memory.
+ (void)dismissPromotion;

/// Returns the allowed interface orientations for promotions.
///
/// @return A bit mask with the allowed orientations.
+ (UIInterfaceOrientationMask)allowedOrientations;

/// Optional. Sets the allowed interface orientations for promotions.
///
/// If you want to disable certain orientations for different view controllers, call this method before presenting any promotions.
///
/// @note This method is optional.
/// @param allowedOrientations Allowed promotion orientations. For possible values, see Apple's UIApplication documentation about UIInterfaceOrientationMask.
+ (void)setAllowedOrientations:(UIInterfaceOrientationMask)allowedOrientations;

/// Optional. Sets the allowed interface orientations for promotions.
///
/// If you want to disable certain orientations for different view controllers, call this method before presenting any promotions.
///
/// @note This method is optional.
/// @deprecated Since version 2.3.3.
/// @param allowedOrientations Allowed promotion orientations. For possible values, see Apple's UIApplication documentation about UIInterfaceOrientationMask.
+ (void)setAllowedPromotionOrientations:(UIInterfaceOrientationMask)allowedOrientations __attribute__((deprecated(" Since Xplode SDK v2.3.3. Use setAllowedOrientations: instead.")));

/// Returns the currently set preferences, if any.
///
/// @warning This method does nothing. Promotion preferences are managed through the Xplode portal.
/// @deprecated Since version 2.4.0.
+ (NSDictionary *)promotionPreferences  __attribute__((deprecated(" Since Xplode SDK v2.4.0. Promotion preferences are managed through the Xplode portal.")));

/// Use this method to set preferences for the promotions.
/// The keys for the preferences that you can set are defined in the Xplode+Promotions.h file.
///
/// @warning This method does nothing. Promotion preferences are managed through the Xplode portal.
/// @deprecated Since version 2.4.0.
/// @param preferences An NSDictionary object with the preferences. The object is copied.
+ (void)setPromotionPreferences:(NSDictionary *)preferences __attribute__((deprecated("since Xplode SDK v2.4.0. Promotion preferences are managed through the Xplode portal.")));

@end

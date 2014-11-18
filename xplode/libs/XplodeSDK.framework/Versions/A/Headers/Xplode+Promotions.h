//  Copyright (c) 2014 Iddiction, Inc. All rights reserved.

#import "Xplode.h"

/*!
 Promotion docking position. Can be bottom (default) or top.
 */
typedef NS_ENUM(u_int32_t, XPLPromotionDockingPosition) {
	/*! Dock at the bottom of the screen. */
	XPLPromotionDockingPositionBottom = 0,
	/*! Dock at the top of the screen. */
	XPLPromotionDockingPositionTop
};

/*!
 Dimensions of the promotion dock (SW - Screen Width):

 | Orientation | Default   | iAd       | IAB       |
 |-------------|:---------:|:---------:|:---------:|
 | Portrait    | SW x 35pt | SW x 50pt | SW x 50pt |
 | Landscape   | SW x 35pt | SW x 32pt | SW x 50pt |
 */
typedef NS_ENUM(u_int64_t, XPLPromotionDockDimensions) {
	/*! Xplode defaults. */
	XPLPromotionDockDimensionsDefault = 0,
	/*! Apple iAD dimensions. */
	XPLPromotionDockDimensionsIAd,
	/*! IAB Smartphone Static Wide Banner dimensions. */
	XPLPromotionDockDimensionsIAB
};

/* Notifications */
static NSString * const XPLPromotionWillOpenNotification						= @"com.iddiction.promotions.notification.willOpen";
static NSString * const XPLPromotionDidOpenNotification							= @"com.iddiction.promotions.notification.didOpen";
static NSString * const XPLPromotionWillCloseNotification						= @"com.iddiction.promotions.notification.willClose";
static NSString * const XPLPromotionDidCloseNotification						= @"com.iddiction.promotions.notification.didClose";
static NSString * const XPLPromotionWillLoadNotification						= @"com.iddiction.promotions.notification.willLoad";
static NSString * const XPLPromotionDidLoadNotification							= @"com.iddiction.promotions.notification.didLoad";
static NSString * const XPLPromotionDidFailLoadingNotification					= @"com.iddiction.promotions.notification.didFailLoading";

static NSString * const XPLPromotionWillShowDockNotification					= @"com.iddiction.promotions.notification.willShowDock";
static NSString * const XPLPromotionDidShowDockNotification						= @"com.iddiction.promotions.notification.didShowDock";
static NSString * const XPLPromotionWillHideDockNotification					= @"com.iddiction.promotions.notification.willHideDock";
static NSString * const XPLPromotionDidHideDockNotification						= @"com.iddiction.promotions.notification.didHideDock";

static NSString * const XPLPromotionDidClickNotification						= @"com.iddiction.promotions.notification.didClick";

static NSString * const XPLPromotionDidStartPlaybackNotification				= @"com.iddiction.promotions.notification.didStartPlayback";
static NSString * const XPLPromotionDidAbortPlaybackNotification				= @"com.iddiction.promotions.notification.didAbortPlayback";
static NSString * const XPLPromotionDidFinishPlaybackNotification				= @"com.iddiction.promotions.notification.didFinishPlayback";

/* Notification Keys */
static NSString * const XPLPromotionNotificationBreakpointKey					= @"com.iddiction.promotions.notification.key.breakpoint";
static NSString * const XPLPromotionNotificationIsReadyToPresentKey				= @"com.iddiction.promotions.notification.key.isReadyToPresent";

/// An object can conform to the XplodePromotionDelegate protocol in order to respond when promotions are loaded and presented.
@protocol XplodePromotionDelegate <NSObject>

@optional

//	Promotions

/// @brief A promotion is about to open.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionWillOpenForBreakpoint:(NSString *)breakpoint;

/// @brief A promotion's opening animation has finished.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidOpenForBreakpoint:(NSString *)breakpoint;

/// @brief A promotion is about to close.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionWillCloseForBreakpoint:(NSString *)breakpoint;

/// @brief A promotion's closing animation has finished.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidCloseForBreakpoint:(NSString *)breakpoint;

/// @brief A promotion will start loading.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionWillLoadForBreakpoint:(NSString *)breakpoint;

/// @brief A promotion finished loading.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidLoadForBreakpoint:(NSString *)breakpoint  __attribute__((deprecated(" Since Xplode SDK v2.4.1. Use promotionDidLoadForBreakpoint:isReadyToPresent: for better promotion handling.")));

/// @brief A promotion finished loading.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidLoadForBreakpoint:(NSString *)breakpoint isReadyToPresent:(BOOL)isReadyToPresent;

/// @brief A promotion failed to load.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidFailLoadingForBreakpoint:(NSString *)breakpoint;

/// @brief A promotion will show the dock.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionWillShowDockForBreakpoint:(NSString *)breakpoint;

/// @brief A promotion did show the dock.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidShowDockForBreakpoint:(NSString *)breakpoint;

/// @brief A promotion will hide the dock.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionWillHideDockForBreakpoint:(NSString *)breakpoint;

/// @brief A promotion did hide the dock.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidHideDockForBreakpoint:(NSString *)breakpoint;

/// @brief A video promotion did start playing.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidStartPlaybackForBreakpoint:(NSString *)breakpoint;

/// @brief A video promotion got canceled or aborted.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidAbortPlaybackForBreakpoint:(NSString *)breakpoint;

/// @brief A video promotion finishes playing.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidFinishPlaybackForBreakpoint:(NSString *)breakpoint;

///	@brief The promotion action has been triggered.
///
///	@param breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidClickForBreakpoint:(NSString *)breakpoint;

@end

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

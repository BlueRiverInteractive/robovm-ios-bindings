//
//  Chartboost.h
//  Chartboost
//  4.5.1
//
//  Copyright 2011 Chartboost. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

typedef enum {
    CBLoadErrorInternal,
    CBLoadErrorInternetUnavailable,
    CBLoadErrorTooManyConnections, /**< Too many requests are pending for that location  */
    CBLoadErrorWrongOrientation,    /**< Interstitial loaded with wrong orientation */
    CBLoadErrorFirstSessionInterstitialsDisabled, /**< Interstitial disabled, first session */
    CBLoadErrorNetworkFailure,  /**< Network request failed */
    CBLoadErrorNoAdFound,  /**<  No ad received */
    CBLoadErrorSessionNotStarted, /**< Session not started, use startSession method */
    CBLoadErrorAgeGateFailure,  /**< User failed to pass the Age Gate */
    CBLoadErrorUserCancellation, /**< User manually cancelled the impression */
} CBLoadError;

/**
 * Standard locations used to describe where Chartboost featrues show up in your game
 * For best performance, it is highly recommended to use standard locations
 *
 * Benefits include:
 * - Higher eCPMs
 * - Control of ad targeting and frequency
 * - Better reporting
 */
typedef NSString * const CBLocation;

extern CBLocation const CBLocationStartup; /** initial startup of your app */
extern CBLocation const CBLocationHomeScreen; /** home screen the player first sees */
extern CBLocation const CBLocationMainMenu; /** Menu that provides game options  */
extern CBLocation const CBLocationGameScreen; /** Game screen where all the magic happens */
extern CBLocation const CBLocationAchievements; /** Screen with list achievements in the game */
extern CBLocation const CBLocationQuests; /** Quest, missions or goals screen describing things for a player to do */
extern CBLocation const CBLocationPause; /**  Pause screen */
extern CBLocation const CBLocationLevelStart; /** Start of the level  */
extern CBLocation const CBLocationLevelComplete; /** Completion of the level */
extern CBLocation const CBLocationTurnComplete; /** Finishing a turn in a game  */
extern CBLocation const CBLocationIAPStore; /** The store where the player pays real money for currency or items  */
extern CBLocation const CBLocationItemStore; /** The store where a player buys virtual goods  */
extern CBLocation const CBLocationGameOver; /** The game over screen after a player is finished playing  */
extern CBLocation const CBLocationLeaderBoard; /** List of leaders in the game  */
extern CBLocation const CBLocationSettings; /** Screen where player can change settings such as sound  */
extern CBLocation const CBLocationQuit; /** Screen display right before the player exists an app  */

@protocol ChartboostDelegate;

@interface Chartboost : NSObject

/**
 * Main Chartboost API
 */

/// Get the singleton
+ (Chartboost *)sharedChartboost;

/// Start chartboost with required appId, appSignature and delegate.  This call also starts a new session.
+ (void)startWithAppId:(NSString*)appId appSignature:(NSString*)appSignature delegate:(id<ChartboostDelegate>)delegate;

/// Implement this to check if an interstitial is stored in cache for a specific location
- (BOOL)hasCachedInterstitial:(CBLocation)location;

/// Show an interstitial taking location and/or a view argument
- (void)showInterstitial:(CBLocation)location;

/// check if a more apps page is already cached
- (BOOL)hasCachedMoreApps:(CBLocation)location;

/// show the more apps page
- (void)showMoreApps:(CBLocation)location;

/// Confirm if an age gate passed or failed. When specified
/// Chartboost will wait for this call before showing the ios app store
- (void)didPassAgeGate:(BOOL)pass;

/// Open a URL using a Chartboost Custom Scheme
- (BOOL)handleOpenURL:(NSURL *)url
    sourceApplication:(NSString *)sourceApplication;

/// Open a URL using a Chartboost Custom Scheme
- (BOOL)handleOpenURL:(NSURL *)url
    sourceApplication:(NSString *)sourceApplication
           annotation:(id)annotation;

/**
 * Advanced configuration
*/

/// set the custom id used for rewarded video call
- (void)setCustomId:(NSString *)customId;

/// get the custom id used for rewarded video calls
- (NSString *)getCustomId;

/// Dismiss any Chartboost view programatically
- (void)dismissChartboostView;

/// Returns the device identifier for internal testing purposes
- (NSString *)deviceIdentifier;

/// Assign the delegate for status calls and configuration
@property (nonatomic, weak) id <ChartboostDelegate> delegate;

/// app id used to by chartboost to identify this application
@property (nonatomic, strong) NSString *appId;

/// signature used for this application
@property (nonatomic, strong) NSString *appSignature;

/// app public key used for crypto
@property (nonatomic, strong) NSString *appPublicKey;

/// Set this property to use chartboost with advanced view hierarchies
@property (nonatomic, strong) UIView *rootView;

/// Override the orientation (otherwise automatically detected from status bar)
@property (nonatomic, assign) UIInterfaceOrientation orientation;

/// Extra configuration settings
/// Timeout for requests (minimum is 10s, default is 30s)
@property (nonatomic, assign) NSUInteger timeout;

/**
 * Advanced caching options
 */

/// Cache an more apps (no location)
- (void)cacheMoreApps __attribute__((deprecated("As of version 4.4, use cacheMoreApps:(CBLocation)location")));

/// Cache an interstitial taking a location argument
- (void)cacheInterstitial:(CBLocation)location;

/// Cache more apps taking a location argument
- (void)cacheMoreApps:(CBLocation)location;

/// Explicitly prefetch videos.
- (void)prefetchVideos;

/// This property controls autocaching behavior
@property (nonatomic, assign) BOOL autoCacheAds;

/// check for cached images
@property (nonatomic, assign) BOOL scansBundleForCachedImages;

/**
 * Old interface without locations
 */

/// Indicate a new session is started after soft boot-up
/**
 * @deprecated Use startWithAppId:(NSString*)appId appSignature:(NSString*)appSignature delegate:(id<ChartboostDelegate>)delegate
 */
- (void)startSession __attribute__((deprecated("As of version 4.4, use startWithAppId:(NSString*)appId appSignature:(NSString*)appSignature delegate:(id<ChartboostDelegate>)delegate")));

/// Cache an interstitial
/**
 * @deprecated Use cacheInterstitial:(CBLocation)location
 */
- (void)cacheInterstitial __attribute__((deprecated("As of version 4.4, use cacheInterstitial:(CBLocation)location")));

/// Implement this to check if an interstitial is stored in cache for the default location
/**
 * @deprecated Use hasCachedInterstitial:(CBLocation)location
 */
- (BOOL)hasCachedInterstitial __attribute__((deprecated("As of version 4.4, use hasCachedInterstitial:(CBLocation)location")));

/// Show an interstitial
/**
 * @deprecated Use showInterstitial:(CBLocation)location
 */
- (void)showInterstitial __attribute__((deprecated("As of version 4.4, use showInterstitial:(CBLocation)location")));


/// show the more apps page (no location)
/**
 * @deprecated Use showMoreApps:(CBLocation)location
 */
- (void)showMoreApps __attribute__((deprecated("As of version 4.4, use showMoreApps:(CBLocation)location")));

@end


@protocol ChartboostDelegate <NSObject>
@optional

/// All of the delegate methods below are optional.
/// Implement them only when you need to more finely control Chartboost's behavior.

/// Called before requesting an interestitial from the back-end
- (BOOL)shouldRequestInterstitial:(CBLocation)location;

// Called when an interstitial has been displayed on the screen.
- (void)didDisplayInterstitial:(CBLocation)location;

/// Called when an interstitial has been received, before it is presented on screen
/// Return NO if showing an interstitial is currently innapropriate, for example if the user has entered the main game mode.
- (BOOL)shouldDisplayInterstitial:(CBLocation)location;

/// Called when an interstitial has been received and cached.
- (void)didCacheInterstitial:(CBLocation)location;

/// Called when an interstitial has failed to come back from the server
- (void)didFailToLoadInterstitial:(CBLocation)location  withError:(CBLoadError)error;

/// Called when a click is registered, but the user is not fowrwarded to the App Store
- (void)didFailToRecordClick:(CBLocation)location withError:(CBLoadError)error;

/// Called when the user dismisses the interstitial
/// If you are displaying the add yourself, dismiss it now.
- (void)didDismissInterstitial:(CBLocation)location;

/// Same as above, but only called when dismissed for a close
- (void)didCloseInterstitial:(CBLocation)location;

/// Same as above, but only called when dismissed for a click
- (void)didClickInterstitial:(CBLocation)location;

/// Called when the App Store sheet is dismissed, when displaying the embedded app sheet.
- (void)didCompleteAppStoreSheetFlow;

/// Whether Chartboost should show ads in the first session
/// Defaults to YES
- (BOOL)shouldRequestInterstitialsInFirstSession;

/// Implement this method to control the blocking for an age gate.
/// If the method returns NO, the callback should not be used
- (BOOL)shouldPauseClickForConfirmation;

/// Called before requesting the more apps view from the back-end
/// Return NO if when showing the loading view is not the desired user experience.
- (BOOL)shouldDisplayLoadingViewForMoreApps;

/// Called when an more apps page has been received, before it is presented on screen
/// Return NO if showing the more apps page is currently innapropriate
- (BOOL)shouldDisplayMoreApps;

/// Called when an more apps page has been displayed.
- (BOOL)didDisplayMoreApps;

/// Called when the More Apps page has been received and cached
- (void)didCacheMoreApps;

/// Called when the user dismisses the more apps view
/// If you are displaying the add yourself, dismiss it now.
- (void)didDismissMoreApps;

/// Same as above, but only called when dismissed for a close
- (void)didCloseMoreApps;

/// Same as above, but only called when dismissed for a click
- (void)didClickMoreApps;

/// Called when a more apps page has failed to come back from the server
- (void)didFailToLoadMoreApps:(CBLoadError)error;

/// This delegate method is called whenever the SDK is about to attempt to prefetch videos content.
///
/// Defaults to YES
- (BOOL)shouldPrefetchVideoContent;

/// This delegate method reports when an inplay object has been recieved.
- (void)didLoadInPlay;

@end



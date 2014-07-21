//
//  MPNativeAdAdapter.h
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import <UIKit/UIKit.h>

/**
 * The `MPNativeAdAdapter` protocol allows the MoPub SDK to interact with native ad objects obtained
 * from third-party ad networks. An object that adopts this protocol acts as a wrapper for a native
 * ad object, translating its proprietary interface into a common one that the MoPub SDK can
 * understand.
 *
 * An object that adopts this protocol must implement the `properties` property to specify a
 * dictionary of assets, such as title and text, that should be rendered as part of a native ad.
 * When possible, you should place values in the returned dictionary such that they correspond to
 * the pre-defined keys in `MPNativeAdConstants`.
 *
 * An adopting object must additionally implement -displayContentForURL:rootViewController:completion:
 * to supply the behavior that should occur when the user interacts with the ad.
 *
 * Optional methods of the protocol allow the adopting object to define when and how impressions
 * and interactions should be tracked.
 */
@protocol MPNativeAdAdapter <NSObject>

@required

/** @name Ad Resources */

/**
 * Provides a dictionary of all publicly accessible assets (such as title and text) for the
 * native ad.
 *
 * When possible, you should place values in the returned dictionary such that they correspond to
 * the pre-defined keys in `MPNativeAdConstants`.
 *
 * @see MPNativeAdConstants
 */
@property (nonatomic, readonly) NSDictionary *properties;

/**
 * The default click-through URL for the ad.
 *
 * This may safely be set to nil if your network doesn't expose this value (for example, it may only
 * provide a method to handle a click, lacking another for retrieving the URL itself).
 */
@property (nonatomic, readonly) NSURL *defaultActionURL;

/** @name Handling Ad Interactions */

/**
 * Tells the object to open the specified URL using an appropriate mechanism.
 *
 * @param URL The URL to be opened.
 * @param controller The view controller that should be used to present the modal view controller.
 * @param completionBlock The block to be executed when the action defined by the URL has been
 * completed, returning control to the application.
 *
 * Your implementation of this method should either forward the request to the underlying
 * third-party ad object (if it has built-in support for handling ad interactions), or open an
 * in-application modal web browser or a modal App Store controller.
 */
- (void)displayContentForURL:(NSURL *)URL
          rootViewController:(UIViewController *)controller
                  completion:(void (^)(BOOL success, NSError *error))completionBlock;

@optional

/**
 * Tracks an impression for this ad.
 *
 * To avoid reporting discrepancies, you should only implement this method if the third-party ad
 * network requires impressions to be reported manually.
 */
- (void)trackImpression;

/**
 * Tracks a click for this ad.
 *
 * To avoid reporting discrepancies, you should only implement this method if the third-party ad
 * network requires clicks to be reported manually.
 */
- (void)trackClick;

/**
 * Specifies how long your ad must be on screen before an impression is tracked.
 *
 * When a view containing a native ad is rendered and presented, the MoPub SDK begins tracking the
 * amount of time the view has been visible on-screen in order to automatically record impressions.
 * This value represents the time required for an impression to be tracked.
 *
 * The default value is `kDefaultRequiredSecondsForImpression`.
 *
 * @see MPNativeAdConstants
 */
@property (nonatomic, readonly) NSTimeInterval requiredSecondsForImpression;

/** @name Responding to an Ad Being Attached to a View */

/**
 * This method will be called when your ad's content is about to be loaded into a view.
 *
 * @param view A view that will contain the ad content.
 *
 * You should implement this method if the underlying third-party ad object needs to be informed
 * of this event.
 */
- (void)willAttachToView:(UIView *)view;

@end

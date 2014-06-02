//
//  MPNativeAd.h
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

@class MPAdConfiguration;

/**
 * The MPNativeAd class is used to render and manage events for a native advertisement. The
 * class provides methods for accessing JSON returned by the MoPub ad server, as well as
 * convenience methods for URL navigation and metrics gathering.
 */

@interface MPNativeAd : NSObject

/** @name Ad Resources */

/**
 * A dictionary representing the JSON data for the ad.
 */
@property (nonatomic, readonly, retain) NSDictionary *properties;

/**
 * The default click-through URL for the ad.
 *
 * This is configurable on the MoPub website.
 */
@property (nonatomic, readonly, retain) NSURL *defaultActionURL;

- (instancetype)initWithAdConfiguration:(MPAdConfiguration *)configuration;

/** @name Preparing Ad Content for Display */

/**
 * Instructs the ad object to configure the provided view with ad content.
 *
 * The provided view should implement the MPNativeAdRendering protocol to correctly display the
 * ad content.
 *
 * @param view A view that will contain the ad content.
 * @see MPNativeAdRendering
 */
- (void)prepareForDisplayInView:(UIView *)view;

/** @name Handling Ad Interactions */

/**
 * Records an impression event with the MoPub ad server.
 *
 * You should call this method after you have displayed the ad on-screen.
 *
 * Note: when -prepareForDisplayInView: is called before displaying the ad, an impression event will automatically be recorded, so there is no
 * need to additionally invoke -trackImpression.
 */
- (void)trackImpression;

/**
 * Records a click event with the MoPub ad server.
 * 
 * Note: when -displaycontentForURL:rootViewController:completion: is called, a click event will automatically be recorded, so there is no
 * need to additionally invoke -trackClick.
 */
- (void)trackClick;

/**
 * Opens a resource defined by URL using an appropriate mechanism (typically, an
 * in-application modal web browser or a modal App Store controller).
 *
 * @param URL The URL to be opened.
 * @param controller The view controller that should be used to present the modal view controller.
 * @param completionBlock The block to be executed when the action defined by the URL has been
 * completed, returning control to your application.
 *
 * You should call this method when you detect that a user has tapped on the ad (i.e. via button,
 * table view selection, or gesture recognizer).
 *
 * Note: when this method is called, a click event will automatically be recorded, so there is no
 * need to additionally invoke -trackClick.
 */
- (void)displayContentForURL:(NSURL *)URL rootViewController:(UIViewController *)controller
       completion:(void (^)(BOOL success, NSError *error))completionBlock;

- (void)trackMetricForURL:(NSURL *)URL;

/** @name Loading Specific Ad Resources into Views */

/**
 * Loads the ad object's icon image into the provided image view.
 *
 * This method may fetch the image asynchronously before placing it into the image view.
 *
 * @param imageView An image view.
 */
- (void)loadIconIntoImageView:(UIImageView *)imageView;

/**
 * Loads the ad object's main image into the provided image view.
 *
 * This method may fetch the image asynchronously before placing it into the image view.
 *
 * @param imageView An image view.
 */
- (void)loadImageIntoImageView:(UIImageView *)imageView;

/**
 * Loads the ad object's title into the provided label.
 *
 * @param label A label.
 */
- (void)loadTitleIntoLabel:(UILabel *)label;

/**
 * Loads the ad object's main text into the provided label.
 *
 * @param label A label.
 */
- (void)loadTextIntoLabel:(UILabel *)label;

/**
 * Loads the ad object's call-to-action text into the provided label.
 *
 * @param label A label.
 */
- (void)loadCallToActionTextIntoLabel:(UILabel *)label;

/**
 * Loads the ad object's call-to-action text into the provided button.
 *
 * @param button A button.
 */
- (void)loadCallToActionTextIntoButton:(UIButton *)button;

/**
 * Loads the image referenced by imageURL into the provided image view.
 *
 * This method will fetch the image asynchronously before placing it into the image view.
 *
 * @param imageURL A URL identifying an image resource.
 * @param imageView An image view.
 */
- (void)loadImageForURL:(NSURL *)imageURL intoImageView:(UIImageView *)imageView;

@end

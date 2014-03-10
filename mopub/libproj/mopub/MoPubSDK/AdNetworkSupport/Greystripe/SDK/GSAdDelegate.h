//
//  GSAdDelegate.h
//  GreystripeSDK
//
//  Created by Justine DiPrete on 11/10/11.
//  Copyright 2013 Greystripe
//
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
//

#import <UIKit/UIKit.h>
#import <Foundation/Foundation.h>
#import "GSAd.h"

/**
 * The GSAdDelegate protocol defines the methods a delegate of a GSFullscreenAd object or
 * a GSBannerAdView object should implement. The delegate receives notifications for
 * ad fetch successes and failures, ad clickthroughs, and for when a fullscreen ad will
 * take over the screen and dismiss from the screen. 
 *
 * The delegate is required to provide a UIViewController that ads should be displayed from,
 * and can optionally provide a global unique identifier for the application and a value
 * for the autoload property. 
 */
@protocol GSAdDelegate <NSObject>

@optional

/**
 * The view controller that the banner ad's browser should be displayed from.
 * @warning This must be implemented for banner ads. This view controller cannot
 * be popped or removed from the view heiarchy while the browser is being displayed.
 */
- (UIViewController *)greystripeBannerDisplayViewController;


/**
 * The global unique identifier for the application.
 *
 * This must be set if it is not passed in on ad initialization.
 * @warning This can only be set once by the application. All subsquent setting of
 * the GUID will be ignored.
 */
- (NSString *)greystripeGUID;

/**
 * A BOOL indicating whether the first banner ad should be fetched automatically.
 * 
 * The default value is YES.
 * @warning If this method is implemented, all subsequent setting of this property
 * will be ignored.
 */
- (BOOL)greystripeBannerAutoload;

/**
 * Sent when an ad has successfully been fetched and is ready to be displayed.
 *
 * @param a_ad The ad that succeeded.
 */
- (void)greystripeAdFetchSucceeded:(id<GSAd>)a_ad;

/**
  Sent if the ad fetch request failed. 
 
  The possible errors that may occur are:
 
   **kGSNoNetwork:** This error is dispatched when there is no available network connection.
 
   **kGSNoAd:** This error is dispatched when a blank ad is returned by the server.
 
   **kGSTimeout:** This error is dispatched when the request took too long to complete.
 
   **kGSServerError:** This error is dispatched when a server error occurs.
 
   **kGSInvalidApplicationIdentifier:** This error is dispatched when the GUID provided by the application is not a valid Greystripe GUID.
 
   **kGSAdExpired:** This error is dispatched when the ad that is fetched is expired and cannot be displayed.
 
   **kGSFetchLimitExceeded:** This error is dispatched after the SDK prevents a fetch from occurring when it is highly unlikely
  that an ad would be returned. This error can occur in high volume, low fill situations or when too
  many ad requests are made in a short period of time. This error will resolve itself after a short
  timeout. If you frequently receive this message you should reduce the frequency of your requests
  or use an alternate fallback method when no ad is available.
 
   **kGSUnknown:** This error is dispatched when the cause of the error is unknown.
 
  @param a_ad The ad that failed.
  @param a_error The GSAdError that occured during fetching.
 */
- (void)greystripeAdFetchFailed:(id<GSAd>)a_ad withError:(GSAdError)a_error;

/**
 * Sent when the ad is clicked through to the browser or to an external app.
 *
 * @param a_ad The ad that clicked through.
 */
- (void)greystripeAdClickedThrough:(id<GSAd>)a_ad;

/**
 * Sent when a fullscreen ad is about to take over the screen, or when the browser
 * is about to present modally for banner ads.
 */
- (void)greystripeWillPresentModalViewController;

/**
 * Sent when the fullscreen ad's view controller or the browser view controller
 * is about to animate off screen. If a view controller needs to be pushed or 
 * popped when the ad is dismissed, it should be done here.
 */
- (void)greystripeWillDismissModalViewController;

/**
 * Sent after the fullscreen ad's view controller or the browser view controller
 * has fully animated off screen. If the app wants to present a modal view controller after
 * an ad has been dismissed, it must be done in this method. Modal presentation will not work
 * from the greystripeWillDismissModalViewController method.
 */
- (void)greystripeDidDismissModalViewController;

/**
 * Sent when a banner ad's view is about to expand to take over the
 * full screen.
 */
- (void)greystripeBannerWillExpand;

/**
 * Sent after an expanded banner ad has collapsed back to it's normal
 * size.
 */
- (void)greystripeBannerDidCollapse;

/**
 * Return YES in this method in order to log out the ID for each ad. This
 * defaults to NO.
 */
- (BOOL)greystripeShouldLogAdID;

@end

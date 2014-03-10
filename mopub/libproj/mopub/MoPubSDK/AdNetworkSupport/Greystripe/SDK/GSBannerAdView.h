//
//  GSBannerAdView.h
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

#import "GSAd.h"

#ifndef GS_PUBLIC
#ifndef _GSAdView_h_included_
#define _GSAdView_h_included_
@interface GSAdView : UIView
@end
#endif
#else
#import "GSAdView.h"
#endif

/**
 * The base class for all banner ad views.
 * @warning This class should not be instantiated. Instead instantiate one
 * of its subclasses, GSMobileBannerAdView, GSMediumRectangleAdView, or GSLeaderboardAdView,
 * depending on what ad size you are using.
 */
@interface GSBannerAdView : GSAdView <GSAd>
{
    id<GSAdDelegate> m_delegate;
}

/**
 * The delegate that will be receive all ad notification messages. This delegate
 * is also responsible for providing a view controller that the ad will be displayed from.
 */
@property (nonatomic, retain) IBOutlet id<GSAdDelegate> delegate;

/**
 * Convenience method for initializing a GSBannerAdView.
 *
 * @param a_delegate The delegate that will receive all ad notification messages.
 */
- (id)initWithDelegate:(id<GSAdDelegate>)a_delegate;

/**
 * Convenience method for initializing a GSBannerAdView.
 *
 * @param a_delegate The delegate that will receive all ad notification messages.
 * @param a_GUID The global unique identifier for the application.
 */
- (id)initWithDelegate:(id<GSAdDelegate>)a_delegate GUID:(NSString *)a_GUID;

/**
 * Convenience method for initializing a GSBannerAdView.
 *
 * @param a_delegate The delegate that will receive all ad notification messages.
 * @param a_GUID The global unique identifier for the application.
 * @param a_autoload A BOOL indicating if the first ad should be auto-fetched.
 */
- (id)initWithDelegate:(id<GSAdDelegate>)a_delegate GUID:(NSString *)a_GUID autoload:(BOOL)a_autoload;

@end

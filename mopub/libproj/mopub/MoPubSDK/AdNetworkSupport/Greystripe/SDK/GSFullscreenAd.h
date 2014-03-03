//
//  GSFullscreenAd.h
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

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "GSAd.h"

#ifndef GS_PUBLIC
#ifndef _GSAdModel_h_included_
#define _GSAdModel_h_included_
@interface GSAdModel : NSObject <GSAd, UIWebViewDelegate>
@end
#endif
#else
#import "GSAdModel.h"
#endif

/**
 * A GSFullscreenAd can be used to fetch and display fullscreen ads. 
 *
 * This conforms to the GSAd protocol.
 */

@interface GSFullscreenAd : GSAdModel


/**
 * Initialize a GSFullscreenAd with a delegate. If this init is used, the
 * host app must implement the GUID method.
 *
 * @param a_delegate The delegate that will receive all ad notification messages.
 */
- (id)initWithDelegate:(id<GSAdDelegate>)a_delegate;

/**
 * Initialize a GSFullscreenAd with a delegate and a GUID. If the host app does
 * not implement the GUID method, this is the init method that needs to be called.
 * Otherwise an exception will be raised.
 *
 * @param a_delegate The delegate that will receive all ad notification messages.
 * @param a_GUID The global unique identifier for the application.
 */
- (id)initWithDelegate:(id<GSAdDelegate>)a_delegate GUID:(NSString *)a_GUID;

/**
 * Tells the shared GSFullscreenAdViewController to display the ad from the 
 * given view controller. This should be the view controller that is currently
 * displaying.
 *
 * @param a_viewController the view controller that the ad should be displayed from.
 */
- (BOOL)displayFromViewController:(UIViewController *)a_viewController;

@end
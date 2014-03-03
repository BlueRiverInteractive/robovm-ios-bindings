//
//  GSAd.h
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

/**
 * The possible errors that can occur when fetching an ad.
 */
typedef enum GSAdError 
{
    kGSNoError = 0,
    
    /**
     * This error is dispatched when there is no available network connection.
     */
    kGSNoNetwork,
    
    /**
     * This error is dispatched when a blank ad is returned by the server.
     */
    kGSNoAd,
    
    /**
     * This error is dispatched when the request took too long
     * to complete. 
     */
    kGSTimeout,
    
    /**
     * This error is dispatched when a server error occurs.
     */
    kGSServerError,
    
    /**
     * This error is dispatched when the GUID provided by the application
     * is not a valid Greystripe GUID.
     */
    kGSInvalidApplicationIdentifier,
    
    /**
     * This error is dispatched when the ad that is fetched is expired
     * and cannot be displayed.
     */
    kGSAdExpired,
    
    /**
     * This error is dispatched after the SDK prevents a fetch from occurring when it is 
     * highly unlikely that an ad would be returned. This error can occur in high volume,
     * low fill situations or when too many ad requests are made in a short period of time.
     * This error will resolve itself after a short timeout.  If you frequently receive
     * this message you should reduce the frequency of your requests or use an alternate
     * fallback method when no ad is available.
     */
    kGSFetchLimitExceeded,
    
    /**
     * This error is dispatched when the cause of the error is unknown.
     */
    kGSUnknown
} GSAdError;

@protocol GSAdDelegate;

/**
 * A protocol that each ad model implements. 
 */

@protocol GSAd <NSObject>

/**
 * The delegate that will be receive all ad notification messages. This delegate
 * is also responsible for providing a view controller that the ad will be displayed from.
 */
@property (nonatomic, retain) id<GSAdDelegate> delegate;

/**
 * A BOOL indicating whether an ad has been fetched and is ready to be displayed.
 *
 * @return a BOOL indicating whether or not the ad is ready to be displayed
 */
- (BOOL)isAdReady;

/**
 * Attempts to fetch a new ad. This should only be called if there is not already a 
 * valid ad ready to be displayed.
 */
- (void)fetch;

- (NSString *)adID;

@end

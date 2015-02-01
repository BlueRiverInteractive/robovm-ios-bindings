//
//  ChartboostInterstitialCustomEvent.h
//  MoPub
//
//  Copyright (c) 2012 MoPub, Inc. All rights reserved.
//

#if __has_include(<MoPub/MoPub.h>)
    #import <MoPub/MoPub.h>
#else
    #import "MPInterstitialCustomEvent.h"
#endif

/*
 * Certified with version 5.0.1 of the Chartboost SDK.
 */

@interface ChartboostInterstitialCustomEvent : MPInterstitialCustomEvent

/**
 * Registers a Chartboost app ID to be used when initializing the Chartboost SDK.
 *
 * At initialization, the Chartboost SDK requires you to provide your Chartboost app ID. When
 * integrating Chartboost using a MoPub custom event, this ID is typically configured via your
 * Chartboost network settings on the MoPub website. However, if you wish, you may use this method to
 * manually provide the custom event with your app ID.
 *
 * IMPORTANT: If you choose to use this method, be sure to call it before making any ad requests,
 * and avoid calling it more than once. Otherwise, the Chartboost SDK may be initialized improperly.
 */
+ (void)setAppId:(NSString *)appId;

/**
 * Registers a Chartboost app signature to be used when initializing the Chartboost SDK.
 *
 * At initialization, the Chartboost SDK requires you to provide your Chartboost app signature. When
 * integrating Chartboost using a MoPub custom event, this value is typically configured via your
 * Chartboost network settings on the MoPub website. However, if you wish, you may use this method to
 * manually provide the custom event with your app signature.
 *
 * IMPORTANT: If you choose to use this method, be sure to call it before making any ad requests,
 * and avoid calling it more than once. Otherwise, the Chartboost SDK may be initialized improperly.
 */
+ (void)setAppSignature:(NSString *)appSignature;

@end

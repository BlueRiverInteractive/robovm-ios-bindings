//
//  VungleInterstitialCustomEvent.h
//  MoPub
//
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import "MPInterstitialCustomEvent.h"

#import "VungleSDK.h"

/*
 * Certified with version 3.0.8 of the Vungle SDK.
 *
 * The Vungle SDK does not provide an ad clicked callback. As a result, this custom event will not invoke delegate methods
 * interstitialCustomEventDidReceiveTapEvent: and interstitialCustomEventWillLeaveApplication:
 */

@interface VungleInterstitialCustomEvent : MPInterstitialCustomEvent <VungleSDKDelegate>

@end

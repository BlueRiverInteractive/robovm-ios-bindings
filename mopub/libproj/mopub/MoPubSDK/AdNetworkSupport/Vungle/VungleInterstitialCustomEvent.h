//
//  VungleInterstitialCustomEvent.h
//  MoPubSampleApp
//
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import "MPInterstitialCustomEvent.h"

#import "vunglepub.h"

/*
 * Certified with version 1.4.3 of the Vungle SDK.
 *
 * The Vungle SDK does not provide an ad clicked callback. As a result, this custom event will not invoke delegate methods 
 * interstitialCustomEventDidReceiveTapEvent: and interstitialCustomEventWillLeaveApplication:
 */

@interface VungleInterstitialCustomEvent : MPInterstitialCustomEvent <VGVunglePubDelegate>

@end

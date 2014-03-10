//
//  GreystripeInterstitialCustomEvent.h
//  MoPub
//
//  Copyright (c) 2012 MoPub, Inc. All rights reserved.
//

#import "MPInterstitialCustomEvent.h"

#import "GSFullscreenAd.h"
#import "GSAdDelegate.h"

/*
 * Compatible with version 4.2.1 of the Greystripe SDK.
 */

@interface GreystripeInterstitialCustomEvent : MPInterstitialCustomEvent <GSAdDelegate>

@end

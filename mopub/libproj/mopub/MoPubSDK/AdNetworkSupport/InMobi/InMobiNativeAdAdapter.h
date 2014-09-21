//
//  InMobiNativeAdAdapter.h
//  MoPub
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "MPNativeAdAdapter.h"

@class IMNative;

/*
 * Certified with version 4.4.1 of the InMobi SDK.
 */

@interface InMobiNativeAdAdapter : NSObject <MPNativeAdAdapter>

- (instancetype)initWithInMobiNativeAd:(IMNative *)nativeAd;

@end

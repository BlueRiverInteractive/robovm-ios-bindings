//
//  FacebookNativeAdAdapter.h
//  MoPub
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import "MPNativeAdAdapter.h"

@class FBNativeAd;

/**
 * Certified with the Facebook iOS SDK version 3.14.1
 */

@interface FacebookNativeAdAdapter : NSObject <MPNativeAdAdapter>

- (instancetype)initWithFBNativeAd:(FBNativeAd *)fbNativeAd;

@end

//
//  UIView+MPNativeAd.h
//  MoPubSDK
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import <UIKit/UIKit.h>

@class MPNativeAd;

@interface UIView (MPNativeAd)

- (void)mp_setNativeAd:(MPNativeAd *)adObject;
- (void)mp_removeNativeAd;
- (MPNativeAd *)mp_nativeAd;

@end

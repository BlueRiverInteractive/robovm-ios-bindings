//
//  UITableViewCell+MPNativeAd.m
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import "UITableViewCell+MPNativeAd.h"
#import <objc/runtime.h>

static char MPNativeAdKey;

@implementation UITableViewCell (MPNativeAd)

- (void)mp_removeNativeAd
{
    [self mp_setNativeAd:nil];
}

- (void)mp_setNativeAd:(MPNativeAd *)adObject
{
    objc_setAssociatedObject(self, &MPNativeAdKey, adObject, OBJC_ASSOCIATION_ASSIGN);
}

- (MPNativeAd *)mp_nativeAd
{
    return (MPNativeAd *)objc_getAssociatedObject(self, &MPNativeAdKey);
}

@end

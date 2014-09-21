//
//  MPNativeAdData.m
//  MoPub
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import "MPNativeAdData.h"

@implementation MPNativeAdData

- (void)dealloc
{
    [_adUnitID release];
    [_ad release];
    [super dealloc];
}

@end

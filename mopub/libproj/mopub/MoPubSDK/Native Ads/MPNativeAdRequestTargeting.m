//
//  MPNativeAdRequestTargeting.m
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import "MPNativeAdRequestTargeting.h"

@implementation MPNativeAdRequestTargeting

+ (MPNativeAdRequestTargeting *)targeting
{
    return [[[MPNativeAdRequestTargeting alloc] init] autorelease];
}

- (void)dealloc
{
    [_keywords release];
    [_location release];
    [super dealloc];
}

@end

//
//  GADAdSizeWrapped.m
//  GADAdSize
//
//  Copyright (c) 2014 BlueRiver Interactive. All rights reserved.
//

#import "GADAdSizeWrapped.h"

@implementation GADAdSizeWrapped
+ (const struct GADAdSize)banner
{
    return kGADAdSizeBanner;
}

+ (const struct GADAdSize) mediumRectangle
{
    return kGADAdSizeMediumRectangle;
}
+ (const struct GADAdSize) fullBanner
{
    return kGADAdSizeFullBanner;
}
+ (const struct GADAdSize) leaderboard
{
    return kGADAdSizeLeaderboard;
}
+ (const struct GADAdSize) skyscraper
{
    return kGADAdSizeSkyscraper;
}
+ (const struct GADAdSize) smartBannerPortrait
{
    return kGADAdSizeSmartBannerPortrait;
}
+ (const struct GADAdSize) smartBannerLandscape
{
    return kGADAdSizeSmartBannerLandscape;
}
+ (const struct GADAdSize) invalid
{
    return kGADAdSizeInvalid;
}

+ (const struct GADAdSize) fromCGSize:(CGSize)size
{
    return GADAdSizeFromCGSize(size);
}
+ (const struct GADAdSize) fullWidthPortraitWithHeight:(CGFloat)height
{
    return GADAdSizeFullWidthPortraitWithHeight(height);
}
+ (const struct GADAdSize) fullWidthLandscapeWithHeight:(CGFloat)height
{
    return GADAdSizeFullWidthLandscapeWithHeight(height);
}
+ (BOOL) equalToSize:(GADAdSize)size1 and:(GADAdSize)size2
{
    return GADAdSizeEqualToSize(size1, size2);
}
+ (CGSize) fromAdSize:(GADAdSize) size
{
    return CGSizeFromGADAdSize(size);
}
+ (BOOL) isValid:(GADAdSize)size
{
    return IsGADAdSizeValid(size);
}
+ (NSString *) toString:(GADAdSize)size
{
    return NSStringFromGADAdSize(size);
}

@end

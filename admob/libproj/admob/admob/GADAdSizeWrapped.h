//
//  GADAdSizeWrapped.h
//  GADAdSize
//
//  Copyright (c) 2014 BlueRiver Interactive. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "GADAdSize.h"

@interface GADAdSizeWrapped : NSObject

+ (const struct GADAdSize) banner;
+ (const struct GADAdSize) mediumRectangle;
+ (const struct GADAdSize) fullBanner;
+ (const struct GADAdSize) leaderboard;
+ (const struct GADAdSize) skyscraper;
+ (const struct GADAdSize) smartBannerPortrait;
+ (const struct GADAdSize) smartBannerLandscape;
+ (const struct GADAdSize) invalid;

+ (const struct GADAdSize) fromCGSize:(CGSize)size;
+ (const struct GADAdSize) fullWidthPortraitWithHeight:(CGFloat)height;
+ (const struct GADAdSize) fullWidthLandscapeWithHeight:(CGFloat)height;
+ (BOOL) equalToSize:(GADAdSize)size1 and:(GADAdSize)size2;
+ (CGSize) fromAdSize:(GADAdSize) size;
+ (BOOL) isValid:(GADAdSize)size;
+ (NSString *) toString:(GADAdSize)size;
@end

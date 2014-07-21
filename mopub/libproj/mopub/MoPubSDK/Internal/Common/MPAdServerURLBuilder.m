//
//  MPAdServerURLBuilder.m
//  MoPub
//
//  Copyright (c) 2012 MoPub. All rights reserved.
//

#import "MPAdServerURLBuilder.h"

#import "MPConstants.h"
#import "MPGlobal.h"
#import "MPKeywordProvider.h"
#import "MPIdentityProvider.h"
#import "MPCoreInstanceProvider.h"
#import "MPReachability.h"

NSString * const kMoPubInterfaceOrientationPortrait = @"p";
NSString * const kMoPubInterfaceOrientationLandscape = @"l";

////////////////////////////////////////////////////////////////////////////////////////////////////

@interface MPAdServerURLBuilder ()

+ (NSString *)queryParameterForKeywords:(NSString *)keywords;
+ (NSString *)queryParameterForOrientation;
+ (NSString *)queryParameterForScaleFactor;
+ (NSString *)queryParameterForTimeZone;
+ (NSString *)queryParameterForLocation:(CLLocation *)location;
+ (NSString *)queryParameterForMRAID;
+ (NSString *)queryParameterForDNT;
+ (NSString *)queryParameterForConnectionType;
+ (NSString *)queryParameterForApplicationVersion;
+ (NSString *)queryParameterForCarrierName;
+ (NSString *)queryParameterForISOCountryCode;
+ (NSString *)queryParameterForMobileNetworkCode;
+ (NSString *)queryParameterForMobileCountryCode;
+ (NSString *)queryParameterForDeviceName;
+ (NSString *)queryParameterForTwitterAvailability;
+ (NSString *)queryParameterForDesiredAdAssets:(NSArray *)assets;
+ (BOOL)advertisingTrackingEnabled;

@end

////////////////////////////////////////////////////////////////////////////////////////////////////

@implementation MPAdServerURLBuilder

+ (NSURL *)URLWithAdUnitID:(NSString *)adUnitID
                  keywords:(NSString *)keywords
                  location:(CLLocation *)location
                   testing:(BOOL)testing
{
    return [self URLWithAdUnitID:adUnitID
                        keywords:keywords
                        location:location
            versionParameterName:@"nv"
                         version:MP_SDK_VERSION
                         testing:testing
                   desiredAssets:nil];
}

+ (NSURL *)URLWithAdUnitID:(NSString *)adUnitID
                  keywords:(NSString *)keywords
                  location:(CLLocation *)location
      versionParameterName:(NSString *)versionParameterName
                   version:(NSString *)version
                   testing:(BOOL)testing
             desiredAssets:(NSArray *)assets
{
    NSString *URLString = [NSString stringWithFormat:@"http://%@/m/ad?v=%@&udid=%@&id=%@&%@=%@",
                           testing ? HOSTNAME_FOR_TESTING : HOSTNAME,
                           MP_SERVER_VERSION,
                           [MPIdentityProvider identifier],
                           [adUnitID stringByAddingPercentEscapesUsingEncoding:NSUTF8StringEncoding],
                           versionParameterName, version];

    URLString = [URLString stringByAppendingString:[self queryParameterForKeywords:keywords]];
    URLString = [URLString stringByAppendingString:[self queryParameterForOrientation]];
    URLString = [URLString stringByAppendingString:[self queryParameterForScaleFactor]];
    URLString = [URLString stringByAppendingString:[self queryParameterForTimeZone]];
    URLString = [URLString stringByAppendingString:[self queryParameterForLocation:location]];
    URLString = [URLString stringByAppendingString:[self queryParameterForMRAID]];
    URLString = [URLString stringByAppendingString:[self queryParameterForDNT]];
    URLString = [URLString stringByAppendingString:[self queryParameterForConnectionType]];
    URLString = [URLString stringByAppendingString:[self queryParameterForApplicationVersion]];
    URLString = [URLString stringByAppendingString:[self queryParameterForCarrierName]];
    URLString = [URLString stringByAppendingString:[self queryParameterForISOCountryCode]];
    URLString = [URLString stringByAppendingString:[self queryParameterForMobileNetworkCode]];
    URLString = [URLString stringByAppendingString:[self queryParameterForMobileCountryCode]];
    URLString = [URLString stringByAppendingString:[self queryParameterForDeviceName]];
    URLString = [URLString stringByAppendingString:[self queryParameterForTwitterAvailability]];
    URLString = [URLString stringByAppendingString:[self queryParameterForDesiredAdAssets:assets]];

    return [NSURL URLWithString:URLString];
}


+ (NSString *)queryParameterForKeywords:(NSString *)keywords
{
    NSMutableArray *keywordsArray = [NSMutableArray array];
    NSString *trimmedKeywords = [keywords stringByTrimmingCharactersInSet:
                                 [NSCharacterSet whitespaceCharacterSet]];
    if ([trimmedKeywords length] > 0) {
        [keywordsArray addObject:trimmedKeywords];
    }

    // Append the Facebook attribution keyword (if available).
    Class fbKeywordProviderClass = NSClassFromString(@"MPFacebookKeywordProvider");
    if ([fbKeywordProviderClass conformsToProtocol:@protocol(MPKeywordProvider)])
    {
        NSString *fbAttributionKeyword = [(Class<MPKeywordProvider>) fbKeywordProviderClass keyword];
        if ([fbAttributionKeyword length] > 0) {
            [keywordsArray addObject:fbAttributionKeyword];
        }
    }

    if ([keywordsArray count] == 0) {
        return @"";
    } else {
        NSString *keywords = [[keywordsArray componentsJoinedByString:@","]
                              stringByAddingPercentEscapesUsingEncoding:NSUTF8StringEncoding];
        return [NSString stringWithFormat:@"&q=%@", keywords];
    }
}

+ (NSString *)queryParameterForOrientation
{
    UIInterfaceOrientation orientation = [UIApplication sharedApplication].statusBarOrientation;
    NSString *orientString = UIInterfaceOrientationIsPortrait(orientation) ?
        kMoPubInterfaceOrientationPortrait : kMoPubInterfaceOrientationLandscape;
    return [NSString stringWithFormat:@"&o=%@", orientString];
}

+ (NSString *)queryParameterForScaleFactor
{
    return [NSString stringWithFormat:@"&sc=%.1f", MPDeviceScaleFactor()];
}

+ (NSString *)queryParameterForTimeZone
{
    static NSDateFormatter *formatter;
    @synchronized(self)
    {
        if (!formatter) formatter = [[NSDateFormatter alloc] init];
    }
    [formatter setDateFormat:@"Z"];
    NSDate *today = [NSDate date];
    return [NSString stringWithFormat:@"&z=%@", [formatter stringFromDate:today]];
}

+ (NSString *)queryParameterForLocation:(CLLocation *)location
{
    NSString *result = @"";

    if (location && location.horizontalAccuracy >= 0) {
        result = [NSString stringWithFormat:@"&ll=%@,%@",
                  [NSNumber numberWithDouble:location.coordinate.latitude],
                  [NSNumber numberWithDouble:location.coordinate.longitude]];

        if (location.horizontalAccuracy) {
            result = [result stringByAppendingFormat:@"&lla=%@",
                      [NSNumber numberWithDouble:location.horizontalAccuracy]];
        }
    }

    return result;
}

+ (NSString *)queryParameterForMRAID
{
    if (NSClassFromString(@"MPMRAIDBannerCustomEvent") &&
        NSClassFromString(@"MPMRAIDInterstitialCustomEvent")) {
        return @"&mr=1";
    } else {
        return @"";
    }
}

+ (NSString *)queryParameterForDNT
{
    return [self advertisingTrackingEnabled] ? @"" : @"&dnt=1";
}

+ (NSString *)queryParameterForConnectionType
{
    return [[[MPCoreInstanceProvider sharedProvider] sharedMPReachability] hasWifi] ? @"&ct=2" : @"&ct=3";
}

+ (NSString *)queryParameterForApplicationVersion
{
    NSString *applicationVersion = [[[NSBundle mainBundle] infoDictionary] objectForKey:@"CFBundleShortVersionString"];
    return [NSString stringWithFormat:@"&av=%@",
            [applicationVersion URLEncodedString]];
}

+ (NSString *)queryParameterForCarrierName
{
    NSString *carrierName = [[[MPCoreInstanceProvider sharedProvider] sharedCarrierInfo] objectForKey:@"carrierName"];
    return carrierName ? [NSString stringWithFormat:@"&cn=%@",
                          [carrierName URLEncodedString]] : @"";
}

+ (NSString *)queryParameterForISOCountryCode
{
    NSString *code = [[[MPCoreInstanceProvider sharedProvider] sharedCarrierInfo] objectForKey:@"isoCountryCode"];
    return code ? [NSString stringWithFormat:@"&iso=%@", [code URLEncodedString]] : @"";
}

+ (NSString *)queryParameterForMobileNetworkCode
{
    NSString *code = [[[MPCoreInstanceProvider sharedProvider] sharedCarrierInfo] objectForKey:@"mobileNetworkCode"];
    return code ? [NSString stringWithFormat:@"&mnc=%@", [code URLEncodedString]] : @"";
}

+ (NSString *)queryParameterForMobileCountryCode
{
    NSString *code = [[[MPCoreInstanceProvider sharedProvider] sharedCarrierInfo] objectForKey:@"mobileCountryCode"];
    return code ? [NSString stringWithFormat:@"&mcc=%@", [code URLEncodedString]] : @"";
}

+ (NSString *)queryParameterForDeviceName
{
    NSString *deviceName = [[UIDevice currentDevice] hardwareDeviceName];
    return deviceName ? [NSString stringWithFormat:@"&dn=%@", [deviceName URLEncodedString]] : @"";
}

+ (NSString *)queryParameterForTwitterAvailability
{
    MPTwitterAvailability twitterAvailability = [[MPCoreInstanceProvider sharedProvider] twitterAvailabilityOnDevice];
    NSString *queryString = @"";

    if (twitterAvailability)
    {
        queryString = [NSString stringWithFormat:@"&ts=%u", twitterAvailability];
    }

    return queryString;
}

+ (NSString *)queryParameterForDesiredAdAssets:(NSArray *)assets
{
    NSString *concatenatedAssets = [assets componentsJoinedByString:@","];
    return [concatenatedAssets length] ? [NSString stringWithFormat:@"&assets=%@", concatenatedAssets] : @"";
}

+ (BOOL)advertisingTrackingEnabled
{
    return [MPIdentityProvider advertisingTrackingEnabled];
}

@end

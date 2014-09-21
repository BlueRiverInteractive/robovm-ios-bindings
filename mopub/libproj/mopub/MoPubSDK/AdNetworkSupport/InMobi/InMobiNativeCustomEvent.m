//
//  InMobieNativeCustomEvent.m
//  MoPub
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import "InMobiNativeCustomEvent.h"
#import "IMNative.h"
#import "InMobiNativeAdAdapter.h"
#import "MPNativeAd.h"
#import "MPLogging.h"
#import "MPNativeAdError.h"
#import "MPNativeAdConstants.h"
#import "MPNativeAdUtils.h"

@interface InMobiNativeCustomEvent () <IMNativeDelegate>

@property (nonatomic, retain) IMNative *inMobiAd;

@end

@implementation InMobiNativeCustomEvent

- (void)dealloc
{
    [_inMobiAd release];

    [super dealloc];
}

- (void)requestAdWithCustomEventInfo:(NSDictionary *)info
{
    NSString *appID = [info objectForKey:@"app_id"];
    if ([appID length]) {
        _inMobiAd = [[IMNative alloc] initWithAppId:appID];
        self.inMobiAd.delegate = self;
        [self.inMobiAd loadAd];
    } else {
        [self.delegate nativeCustomEvent:self didFailToLoadAdWithError:[NSError errorWithDomain:MoPubNativeAdsSDKDomain code:MPNativeAdErrorInvalidServerResponse userInfo:nil]];
    }
}

#pragma mark - IMNativeDelegate

-(void)nativeAdDidFinishLoading:(IMNative*)native
{
    InMobiNativeAdAdapter *adAdapter = [[[InMobiNativeAdAdapter alloc] initWithInMobiNativeAd:native] autorelease];
    MPNativeAd *interfaceAd = [[[MPNativeAd alloc] initWithAdAdapter:adAdapter] autorelease];

    NSMutableArray *imageURLs = [NSMutableArray array];

    if ([[interfaceAd.properties objectForKey:kAdIconImageKey] length]) {
        if (![MPNativeAdUtils addURLString:[interfaceAd.properties objectForKey:kAdIconImageKey] toURLArray:imageURLs]) {
            [self.delegate nativeCustomEvent:self didFailToLoadAdWithError:[NSError errorWithDomain:MoPubNativeAdsSDKDomain code:MPNativeAdErrorInvalidServerResponse userInfo:nil]];
        }
    }

    if ([[interfaceAd.properties objectForKey:kAdMainImageKey] length]) {
        if (![MPNativeAdUtils addURLString:[interfaceAd.properties objectForKey:kAdMainImageKey] toURLArray:imageURLs]) {
            [self.delegate nativeCustomEvent:self didFailToLoadAdWithError:[NSError errorWithDomain:MoPubNativeAdsSDKDomain code:MPNativeAdErrorInvalidServerResponse userInfo:nil]];
        }
    }

    [super precacheImagesWithURLs:imageURLs completionBlock:^(NSArray *errors) {
        if (errors) {
            MPLogDebug(@"%@", errors);
            MPLogInfo(@"Error: data received was invalid.");
            [self.delegate nativeCustomEvent:self didFailToLoadAdWithError:[NSError errorWithDomain:MoPubNativeAdsSDKDomain code:MPNativeAdErrorInvalidServerResponse userInfo:nil]];
        } else {
            [self.delegate nativeCustomEvent:self didLoadAd:interfaceAd];
        }
    }];
}

-(void)nativeAd:(IMNative*)native didFailWithError:(IMError*)error
{
    [self.delegate nativeCustomEvent:self didFailToLoadAdWithError:[NSError errorWithDomain:MoPubNativeAdsSDKDomain code:MPNativeAdErrorInvalidServerResponse userInfo:nil]];
}

@end

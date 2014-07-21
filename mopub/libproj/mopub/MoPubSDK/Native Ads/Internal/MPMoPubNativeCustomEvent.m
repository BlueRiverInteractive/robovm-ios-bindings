//
//  MPMoPubNativeCustomEvent.m
//  MoPubSDK
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import "MPMoPubNativeCustomEvent.h"
#import "MPMoPubNativeAdAdapter.h"
#import "MPNativeAd+Internal.h"
#import "MPNativeAdError.h"
#import "MPLogging.h"

@implementation MPMoPubNativeCustomEvent

- (void)requestAdWithCustomEventInfo:(NSDictionary *)info
{
    MPMoPubNativeAdAdapter *adAdapter = [[MPMoPubNativeAdAdapter alloc] initWithAdProperties:[[info mutableCopy] autorelease]];

    if (adAdapter.properties) {
        MPNativeAd *interfaceAd = [[[MPNativeAd alloc] initWithAdAdapter:adAdapter] autorelease];
        [interfaceAd.impressionTrackers addObjectsFromArray:adAdapter.impressionTrackers];

        // Get the image urls so we can download them prior to returning the ad.
        NSMutableArray *imageURLs = [NSMutableArray array];
        for (NSString *key in [info allKeys]) {
            if ([[key lowercaseString] hasSuffix:@"image"] && [[info objectForKey:key] isKindOfClass:[NSString class]]) {
                [imageURLs addObject:[NSURL URLWithString:[info objectForKey:key]]];
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
    } else {
        [self.delegate nativeCustomEvent:self didFailToLoadAdWithError:[NSError errorWithDomain:MoPubNativeAdsSDKDomain code:MPNativeAdErrorInvalidServerResponse userInfo:nil]];
    }

    [adAdapter release];
}

@end

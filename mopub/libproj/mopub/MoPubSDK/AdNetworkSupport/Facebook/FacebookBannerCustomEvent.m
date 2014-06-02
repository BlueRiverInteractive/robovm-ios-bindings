//
//  FacebookBannerCustomEvent.m
//  MoPub
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import "FacebookBannerCustomEvent.h"

#import "MPInstanceProvider.h"
#import "MPLogging.h"

@interface MPInstanceProvider (FacebookBanners)

- (FBAdView *)buildFBAdViewWithPlacementID:(NSString *)placementID
                        rootViewController:(UIViewController *)controller
                                  delegate:(id<FBAdViewDelegate>)delegate;
@end

@implementation MPInstanceProvider (FacebookBanners)

- (FBAdView *)buildFBAdViewWithPlacementID:(NSString *)placementID
                        rootViewController:(UIViewController *)controller
                                  delegate:(id<FBAdViewDelegate>)delegate
{
    FBAdView *adView = [[[FBAdView alloc] initWithPlacementID:placementID
                                                       adSize:kFBAdSize320x50
                                           rootViewController:controller] autorelease];
    adView.delegate = delegate;
    return adView;
}

@end

@interface FacebookBannerCustomEvent ()

@property (nonatomic, retain) FBAdView *fbAdView;

@end

@implementation FacebookBannerCustomEvent

- (BOOL)enableAutomaticImpressionAndClickTracking
{
    return NO;
}

- (void)requestAdWithSize:(CGSize)size customEventInfo:(NSDictionary *)info
{
    if (!CGSizeEqualToSize(size, kFBAdSize320x50.size)) {
        MPLogError(@"Invalid size for Facebook banner ad");
        [self.delegate bannerCustomEvent:self didFailToLoadAdWithError:nil];
        return;
    }

    if (![info objectForKey:@"placement_id"]) {
        MPLogError(@"Placement ID is required for Facebook banner ad");
        [self.delegate bannerCustomEvent:self didFailToLoadAdWithError:nil];
        return;
    }

    MPLogInfo(@"Requesting Facebook banner ad");
    self.fbAdView =
        [[MPInstanceProvider sharedProvider] buildFBAdViewWithPlacementID:[info objectForKey:@"placement_id"]
                                                       rootViewController:[self.delegate viewControllerForPresentingModalView]
                                                                 delegate:self];

    if (!self.fbAdView) {
        [self.delegate bannerCustomEvent:self didFailToLoadAdWithError:nil];
        return;
    }

    [self.fbAdView loadAd];
}

- (void)dealloc
{
    [_fbAdView release];
    [super dealloc];
}

#pragma mark FBAdViewDelegate methods

- (void)adView:(FBAdView *)adView didFailWithError:(NSError *)error;
{
    MPLogInfo(@"Facebook banner failed to load with error: %@", error.description);
    [self.delegate bannerCustomEvent:self didFailToLoadAdWithError:error];
}

- (void)adViewDidLoad:(FBAdView *)adView;
{
    MPLogInfo(@"Facebook banner ad did load");
    [self.delegate trackImpression];
    [self.delegate bannerCustomEvent:self didLoadAd:adView];
}

- (void)adViewDidClick:(FBAdView *)adView
{
    MPLogInfo(@"Facebook banner ad was clicked");
    [self.delegate trackClick];
}

@end

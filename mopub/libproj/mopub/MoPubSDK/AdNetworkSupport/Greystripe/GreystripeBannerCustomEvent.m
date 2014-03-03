//
//  GreystripeBannerCustomEvent.m
//  MoPub
//
//  Copyright (c) 2012 MoPub, Inc. All rights reserved.
//

#import "GreystripeBannerCustomEvent.h"
#import "GSMobileBannerAdView.h"
#import "GSMediumRectangleAdView.h"
#import "GSLeaderboardAdView.h"
#import "MPConstants.h"
#import "MPLogging.h"
#import "MPInstanceProvider.h"
#import "GSSDKInfo.h"

#define kGreystripeGUID @"YOUR_GREYSTRIPE_GUID"

@interface MPInstanceProvider (GreystripeBanners)

- (GSBannerAdView *)buildGreystripeBannerAdViewWithDelegate:(id<GSAdDelegate>)delegate GUID:(NSString *)GUID size:(CGSize)size;

@end

@implementation MPInstanceProvider (GreystripeBanners)

- (GSBannerAdView *)buildGreystripeBannerAdViewWithDelegate:(id<GSAdDelegate>)delegate GUID:(NSString *)GUID size:(CGSize)size
{
    if (CGSizeEqualToSize(size, MOPUB_BANNER_SIZE)) {
        return [[GSMobileBannerAdView alloc] initWithDelegate:delegate GUID:GUID autoload:NO];
    } else if (CGSizeEqualToSize(size, MOPUB_MEDIUM_RECT_SIZE)) {
        return [[GSMediumRectangleAdView alloc] initWithDelegate:delegate GUID:GUID autoload:NO];
    } else if (CGSizeEqualToSize(size, MOPUB_LEADERBOARD_SIZE)) {
        return [[GSLeaderboardAdView alloc] initWithDelegate:delegate GUID:GUID autoload:NO];
    } else {
        MPLogInfo(@"Failed to create a Greystripe Banner with invalid size %@", NSStringFromCGSize(size));
        return nil;
    }
}

@end


@interface GreystripeBannerCustomEvent ()

@property (nonatomic, retain) GSBannerAdView *greystripeBanner;

@end

@implementation GreystripeBannerCustomEvent

@synthesize greystripeBanner = _greystripeBanner;

#pragma mark - MPBannerCustomEvent Subclass Methods

- (void)requestAdWithSize:(CGSize)size customEventInfo:(NSDictionary *)info
{
    MPLogInfo(@"Requesting Greystripe banner");
    self.greystripeBanner = [[MPInstanceProvider sharedProvider] buildGreystripeBannerAdViewWithDelegate:self GUID:kGreystripeGUID size:size];
    if (!self.greystripeBanner) {
        [self.delegate bannerCustomEvent:self didFailToLoadAdWithError:nil];
        return;
    }

    if (self.delegate.location) {
        [GSSDKInfo updateLocation:self.delegate.location];
    }

    [self.greystripeBanner fetch];
}

- (UIViewController *)greystripeBannerDisplayViewController
{
    return [self.delegate viewControllerForPresentingModalView];
}

- (void)dealloc
{
    self.greystripeBanner.delegate = nil;
    self.greystripeBanner = nil;
    [super dealloc];
}

#pragma mark - GSAdDelegate

- (BOOL)greystripeBannerAutoload {
    return NO;
}

- (void)greystripeAdFetchSucceeded:(id<GSAd>)a_ad
{
    MPLogInfo(@"Greystripe banner did load");
    [self.delegate bannerCustomEvent:self didLoadAd:self.greystripeBanner];
}

- (void)greystripeAdFetchFailed:(id<GSAd>)a_ad withError:(GSAdError)a_error
{
    MPLogInfo(@"Greystripe banner failed to load with GSAdError: %d", a_error);
    [self.delegate bannerCustomEvent:self didFailToLoadAdWithError:nil];
}

- (void)greystripeWillPresentModalViewController
{
    MPLogInfo(@"Greystripe banner will present modal");
    [self.delegate bannerCustomEventWillBeginAction:self];
}

- (void)greystripeDidDismissModalViewController
{
    MPLogInfo(@"Greystripe banner did dismiss modal");
    [self.delegate bannerCustomEventDidFinishAction:self];
}

@end

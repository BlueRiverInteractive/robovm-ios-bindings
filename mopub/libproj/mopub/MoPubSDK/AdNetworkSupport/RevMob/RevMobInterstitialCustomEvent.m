#import "RevMobInterstitialCustomEvent.h"
#import "MPInterstitialAdController.h"
#import "MPLogging.h"
#import "MPAdConfiguration.h"

////////////////////////////////////////////////////////////////////////////////////////////////////

@implementation RevMobInterstitialCustomEvent

#pragma mark - MPInterstitialCustomEvent Subclass Methods

- (void)requestInterstitialWithCustomEventInfo:(NSDictionary *)info
{
    MPLogInfo(@"Requesting RevMob interstitial");
    [RevMobAds startSessionWithAppID:([info objectForKey:@"appId"])];
    
    NSString *placementId = [info objectForKey:@"placementId"];
    if (!placementId) {
        self.interstitial = [[RevMobAds session]fullscreen];
    } else {
        self.interstitial = [[RevMobAds session]fullscreenWithPlacementId:(placementId)];
    }

    self.interstitial.delegate = self;
    [self.interstitial loadAd];
}

- (void)showInterstitialFromRootViewController:(UIViewController *)rootViewController
{
    [self.interstitial showAd];
}

- (void)dealloc
{
    self.interstitial.delegate = nil;
    self.interstitial = nil;
    [super dealloc];
}

#pragma mark - RevMobAdsDelegate

- (void)revmobAdDidFailWithError:(NSError *)error
{
    MPLogInfo(@"RevMob Interstitial failed to load with error: %@", error.localizedDescription);
    [self.delegate interstitialCustomEvent:self didFailToLoadAdWithError:error];
}

- (void)revmobAdDidReceive
{
    MPLogInfo(@"RevMob Interstitial did load");
    [self.delegate interstitialCustomEvent:self didLoadAd:self];
}

- (void)revmobAdDisplayed
{
    MPLogInfo(@"RevMob Interstitial did present");
    [self.delegate interstitialCustomEventWillAppear:self];
    [self.delegate interstitialCustomEventDidAppear:self];
}

- (void)revmobUserClickedInTheAd
{
    MPLogInfo(@"RevMob Interstitial received tap");
    [self.delegate interstitialCustomEventDidReceiveTapEvent:self];
}

- (void)revmobUserClosedTheAd
{
    MPLogInfo(@"RevMob Interstitial did dismiss");
    [self.delegate interstitialCustomEventWillDisappear:self];
    [self.delegate interstitialCustomEventDidDisappear:self];
}

@end
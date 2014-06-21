#import "MPBannerCustomEvent.h"

#import "ALAdView.h"

@interface AppLovinBannerCustomEvent : MPBannerCustomEvent<ALAdLoadDelegate> {
    ALAdView * _applovinBannerView;
}


@end

#import "MPInterstitialCustomEvent.h"
#import "RevMobAds.h"
#import "RevMobAdsDelegate.h"
#import "RevMobFullscreen.h"

@interface RevMobInterstitialCustomEvent : MPInterstitialCustomEvent <RevMobAdsDelegate>

@property (nonatomic, retain) RevMobFullscreen *interstitial;

@end

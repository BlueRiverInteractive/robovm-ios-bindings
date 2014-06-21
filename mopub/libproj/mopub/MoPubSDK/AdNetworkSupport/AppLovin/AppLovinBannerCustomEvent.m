#if   __has_feature(objc_arc)
#error This file must be compiled without ARC. Use the -fno-objc-arc flag in the XCode build phases tab.
#endif

#import "AppLovinBannerCustomEvent.h"

#import "MPConstants.h"

@implementation AppLovinBannerCustomEvent

#pragma mark - MPBannerCustomEvent Subclass Methods

- (void)requestAdWithSize:(CGSize)size customEventInfo:(NSDictionary *)info
{
    if (CGSizeEqualToSize(size, MOPUB_BANNER_SIZE)) {
        _applovinBannerView = [[ALAdView alloc] initBannerAd];
        _applovinBannerView.adLoadDelegate = self;
        
        [_applovinBannerView loadNextAd];
    }
    else
    {
        NSLog(@"Failed to load AppLovin banner: ad size %@ is not supported.",
              NSStringFromCGSize(size));
        
        [self.delegate bannerCustomEvent:self didFailToLoadAdWithError:nil];
    }
}

- (void)dealloc
{
    _applovinBannerView.adLoadDelegate = nil;
    [_applovinBannerView release];
    
    [super dealloc];
}

#pragma mark -
#pragma mark ALAdLoadDelegate methods

-(void)adService:(ALAdService *)adService didLoadAd:(ALAd *)ad
{
    [self.delegate bannerCustomEvent:self didLoadAd:_applovinBannerView];
    
}

-(void)adService:(ALAdService *)adService didFailToLoadAdWithError:(int)code
{
    NSLog(@"Failed to load AppLovin banner: %i", code);
    
    [self.delegate bannerCustomEvent:self didFailToLoadAdWithError:nil];
}

@end
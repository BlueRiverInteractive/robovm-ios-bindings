#if   __has_feature(objc_arc)
#error This file must be compiled without ARC. Use the -fno-objc-arc flag in the XCode build phases tab.
#endif

#import "AppLovinInterstitialCustomEvent.h"

@implementation AppLovinInterstitialCustomEvent

- (void)requestInterstitialWithCustomEventInfo:(NSDictionary *)info
{
    static dispatch_once_t once;
    dispatch_once(&once, ^{
       [ALSdk initializeSdk];
    });
    
    ALAdService * adService = [[ALSdk shared] adService];
    [adService loadNextAd: [ALAdSize sizeInterstitial]
                andNotify: self];
}

- (void)showInterstitialFromRootViewController:(UIViewController *)rootViewController
{
    if (_loadedAd)
    {
        UIWindow * window = rootViewController.view.window;
        
        UIInterfaceOrientation currentOrientation = [[UIApplication sharedApplication] statusBarOrientation];
        
        CGRect localFrame;
        
        if(currentOrientation == UIDeviceOrientationPortrait || currentOrientation == UIDeviceOrientationPortraitUpsideDown)
        {
            localFrame = CGRectMake(0, 0, window.frame.size.width, window.frame.size.height - [UIApplication sharedApplication].statusBarFrame.size.height);
        }
        else // Landscape
        {
            localFrame = CGRectMake(0, 0, window.frame.size.width - [UIApplication sharedApplication].statusBarFrame.size.width, window.frame.size.height);
        }
        
        _interstitialAd = [ALInterstitialAd shared];
        _interstitialAd.adDisplayDelegate = self;
        _interstitialAd.frame = localFrame;
        [_interstitialAd showOver:window andRender:_loadedAd];
    }
    else
    {
        [self.delegate interstitialCustomEvent:self didFailToLoadAdWithError:nil];
    }
}

#pragma mark -
#pragma mark ALAdLoadDelegate methods
-(void)adService:(ALAdService *)adService didLoadAd:(ALAd *)ad
{
    // Release existing ad
    [_loadedAd release];
    
    // Save the newly loaded ad
    _loadedAd = ad;
    [_loadedAd retain];
    
    [self.delegate interstitialCustomEvent:self didLoadAd:ad];
}

-(void)adService:(ALAdService *)adService didFailToLoadAdWithError:(int)code
{
    [self.delegate interstitialCustomEvent:self didFailToLoadAdWithError:nil];
}


#pragma mark ALAdDisplayDelegate methods
-(void)ad:(ALAd *)ad wasHiddenIn:(UIView *)view
{
    [self.delegate interstitialCustomEventWillDisappear: self];
    [self.delegate interstitialCustomEventDidDisappear:self];
}


-(void)ad:(ALAd *)ad wasDisplayedIn:(UIView *)view
{
    [self.delegate interstitialCustomEventWillAppear: self];
    [self.delegate interstitialCustomEventDidAppear: self];
}

-(void)ad:(ALAd *)ad wasClickedIn:(UIView *)view
{
    [self.delegate interstitialCustomEventWillLeaveApplication: self];
}

- (void)dealloc
{
    _interstitialAd.adDisplayDelegate = nil;
    
    [_interstitialAd release];
    [_loadedAd release];
    
    [super dealloc];
}

@end

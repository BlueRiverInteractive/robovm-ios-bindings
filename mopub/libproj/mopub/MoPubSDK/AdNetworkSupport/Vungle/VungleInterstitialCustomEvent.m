//
//  VungleInterstitialCustomEvent.m
//  MoPubSampleApp
//
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import "VungleInterstitialCustomEvent.h"
#import "MPInstanceProvider.h"
#import "MPLogging.h"

// This is a sample Vungle app ID. You will need to replace it with your Vungle app ID.
#define kVungleAppID @"YOUR_VUNGLE_APP_ID"

@interface VungleInterstitialCustomEvent ()

@property (nonatomic, assign) BOOL respondedToStatusEvent;

@end

@implementation VungleInterstitialCustomEvent

@synthesize respondedToStatusEvent = _respondedToStatusEvent;

#pragma mark - MPInterstitialCustomEvent Subclass Methods

- (void)requestInterstitialWithCustomEventInfo:(NSDictionary *)info
{
    MPLogInfo(@"Requesting Vungle video interstitial");
    
    VGUserData *data = [VGUserData defaultUserData];
    if([self.delegate location])
    {
        data.locationEnabled = YES;
    }
    
    self.respondedToStatusEvent = NO;
    
    if(![VGVunglePub running])
    {
        NSString *appId = [info objectForKey:@"appId"];
        if(appId == nil)
        {
            appId = kVungleAppID;
        }
        
        [VGVunglePub startWithPubAppID:appId userData:data];
    }
    
    [VGVunglePub setDelegate:self];
    
    // let Vungle notify us through the delegate's vungleStatusUpdate when a video is ready, or we hit our MoPub timeout
}

- (void)showInterstitialFromRootViewController:(UIViewController *)rootViewController
{
    if([VGVunglePub adIsAvailable])
    {
        [VGVunglePub playModalAd:rootViewController animated:MP_ANIMATED];
    }
    else
    {
        MPLogInfo(@"Failed to show Vungle video interstitial: Vungle now claims that there is no available video ad.");
        [self.delegate interstitialCustomEvent:self didFailToLoadAdWithError:nil];
    }
}

- (void)dealloc
{
    [self clearSelfAsVGDelegate];
    
    [super dealloc];
}

- (void)invalidate
{
    [self clearSelfAsVGDelegate];
}

- (void)clearSelfAsVGDelegate
{
    // if we're the current delegate, nil it out
    if([VGVunglePub delegate] == self)
    {
        [VGVunglePub setDelegate:nil];
    }
}

#pragma mark - VGVunglePubDelegate

- (void)vungleMoviePlayed:(VGPlayData *)playData
{
    MPLogInfo(@"Vungle video interstitial movie complete");
}

- (void)vungleStatusUpdate:(VGStatusData *)statusData
{
    // this is a continuous polling update from Vungle, we only want to notify our delegate once per ad "request"
    if(self.respondedToStatusEvent)
    {
        return;
    }
    
    if(statusData.status == VGStatusOkay)
    {
        if([VGVunglePub adIsAvailable])
        {
            self.respondedToStatusEvent = YES;
            [self.delegate interstitialCustomEvent:self didLoadAd:nil];
        }
    }
    else
    {
        self.respondedToStatusEvent = YES;
        [self.delegate interstitialCustomEvent:self didFailToLoadAdWithError:nil];
    }
}

- (void)vungleViewDidDisappear:(UIViewController *)viewController
{
    MPLogInfo(@"Vungle video interstitial did disappear");
    
    [self.delegate interstitialCustomEventWillDisappear:self];
    [self.delegate interstitialCustomEventDidDisappear:self];
}

- (void)vungleViewWillAppear:(UIViewController *)viewController
{
    MPLogInfo(@"Vungle video interstitial will appear");
    
    [self.delegate interstitialCustomEventWillAppear:self];
    [self.delegate interstitialCustomEventDidAppear:self];
}

- (void)vungleAppStoreViewDidDisappear
{
    MPLogInfo(@"Vungle video interstitial app store view did disappear");
}

@end

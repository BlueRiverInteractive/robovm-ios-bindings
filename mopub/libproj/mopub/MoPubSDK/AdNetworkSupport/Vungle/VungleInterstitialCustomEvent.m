//
//  VungleInterstitialCustomEvent.m
//  MoPub
//
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import "VungleInterstitialCustomEvent.h"
#import "MPInstanceProvider.h"
#import "MPLogging.h"

// This is a sample Vungle app ID. You will need to replace it with your Vungle app ID.
#define kVungleAppID @"YOUR_VUNGLE_APP_ID"

// If you need to play ads with vungle options, you may modify playVungleAdFromRootViewController and create an options dictionary and call the playAd:withOptions: method on the vungle SDK.

@interface VungleInterstitialCustomEvent ()

@property (nonatomic, assign) BOOL handledAdAvailable;

@end

@implementation VungleInterstitialCustomEvent

#pragma mark - MPInterstitialCustomEvent Subclass Methods

- (void)requestInterstitialWithCustomEventInfo:(NSDictionary *)info
{
    MPLogInfo(@"Requesting Vungle video interstitial");

    self.handledAdAvailable = NO;

    VungleSDK *sdk = [VungleSDK sharedSDK];

    static dispatch_once_t vungleInitToken;
    dispatch_once(&vungleInitToken, ^{
        NSString *appId = [info objectForKey:@"appId"];
        if(appId == nil)
        {
            appId = kVungleAppID;
        }

        [sdk startWithAppId:appId];
    });

    [sdk setDelegate:self];

    // Need to check immediately as an ad may be cached.
    if ([sdk isCachedAdAvailable]) {
        [self handleAdAvailable];
    }

    // MoPub timeout will handle the case for an ad failing to load.
}

- (void)showInterstitialFromRootViewController:(UIViewController *)rootViewController
{
    if ([[VungleSDK sharedSDK] isCachedAdAvailable]) {
        [self playVungleAdFromRootViewController:rootViewController];
    } else {
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
    VungleSDK *sdk = [VungleSDK sharedSDK];

    // if we're the current delegate, nil it out.
    if([sdk delegate] == self)
    {
        [sdk setDelegate:nil];
    }
}

- (void)playVungleAdFromRootViewController:(UIViewController *)rootViewController
{
    VungleSDK* sdk = [VungleSDK sharedSDK];

    // By default, don't call with options.  Here you can create your own options dictionary and change the following method call to playAd:withOptions.
    [sdk playAd:rootViewController];
}

- (void)handleAdAvailable
{
    if (!self.handledAdAvailable) {
        self.handledAdAvailable = YES;
        [self.delegate interstitialCustomEvent:self didLoadAd:nil];
    }
}

- (void)handleVungleAdViewWillClose
{
    MPLogInfo(@"Vungle video interstitial did disappear");

    [self.delegate interstitialCustomEventWillDisappear:self];
    [self.delegate interstitialCustomEventDidDisappear:self];
}

#pragma mark - VungleSDKDelegate

- (void)vungleSDKhasCachedAdAvailable
{
    [self handleAdAvailable];
}

- (void)vungleSDKwillShowAd
{
    MPLogInfo(@"Vungle video interstitial will appear");

    [self.delegate interstitialCustomEventWillAppear:self];
    [self.delegate interstitialCustomEventDidAppear:self];
}

- (void)vungleSDKwillCloseAdWithViewInfo:(NSDictionary *)viewInfo willPresentProductSheet:(BOOL)willPresentProductSheet
{
    if (!willPresentProductSheet) {
        [self handleVungleAdViewWillClose];
    }
}

- (void)vungleSDKwillCloseProductSheet:(id)productSheet
{
    [self handleVungleAdViewWillClose];
}

@end

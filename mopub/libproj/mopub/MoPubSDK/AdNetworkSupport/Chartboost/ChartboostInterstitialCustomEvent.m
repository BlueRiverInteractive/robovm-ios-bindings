//
//  ChartboostInterstitialCustomEvent.m
//  MoPub
//
//  Copyright (c) 2012 MoPub, Inc. All rights reserved.
//

#import "ChartboostInterstitialCustomEvent.h"
#import "MPInstanceProvider.h"
#import "MPLogging.h"

#define kChartboostAppID        @"YOUR_CHARTBOOST_APP_ID"
#define kChartboostAppSignature @"YOUR_CHARTBOOST_APP_SIGNATURE"

////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////

@interface ChartboostInterstitialCustomEvent ()

@property (nonatomic, retain) NSString *location;
@property (nonatomic, retain) NSMutableDictionary *events;
@property (nonatomic, retain) NSMutableSet *activeLocations;

@end

@implementation ChartboostInterstitialCustomEvent

BOOL started = NO;
@synthesize location = _location;

- (void)invalidate
{
   // [self unregisterEvent:self];
    self.location = nil;
}

#pragma mark - MPInterstitialCustomEvent Subclass Methods

- (void)requestInterstitialWithCustomEventInfo:(NSDictionary *)info
{
    NSString *appId = [info objectForKey:@"appId"];
    if (!appId) {
        appId = kChartboostAppID;
    }
    NSString *appSignature = [info objectForKey:@"appSignature"];
    if (!appSignature) {
        appSignature = kChartboostAppSignature;
    }
    NSString *location = [info objectForKey:@"location"];
    self.location = location ? location : @"Default";

    MPLogInfo(@"Requesting Chartboost interstitial.");
    if ([self.activeLocations containsObject:location]) {
        MPLogInfo(@"Failed to load Chartboost interstitial: this location is already in use.");
        [self didFailToLoadInterstitial:location withError:CBLoadErrorInternal];
        return;
    }
    
    if ([appId length] > 0 && [appSignature length] > 0) {
        //[self setEvent:event forLocation:location];
        if (!started) {
            [Chartboost startWithAppId:appId appSignature:appSignature delegate:self];
            started = YES;
        }
        [Chartboost cacheInterstitial:location];
    } else {
        MPLogInfo(@"Failed to load Chartboost interstitial: missing either appId or appSignature.");
        [self didFailToLoadInterstitial:location withError:CBLoadErrorInternal];
    }
}

- (void)showInterstitialFromRootViewController:(UIViewController *)rootViewController
{
    if ([Chartboost hasInterstitial:self.location]) {
        MPLogInfo(@"Chartboost interstitial will be shown.");

        // Normally, we call the "will appear" and "did appear" methods in response to
        // callbacks from Third Party Integrations. Unfortunately, Chartboost doesn't seem to have
        // such callbacks, so we call the methods manually.
        [self.delegate interstitialCustomEventWillAppear:self];
        [Chartboost showInterstitial:self.location];
        [self.delegate interstitialCustomEventDidAppear:self];
    } else {
        MPLogInfo(@"Failed to show Chartboost interstitial.");
        [self.delegate interstitialCustomEvent:self didFailToLoadAdWithError:nil];
    }
}

#pragma mark - ChartboostDelegate

- (void)didCacheInterstitial:(NSString *)location
{
    MPLogInfo(@"Successfully loaded Chartboost interstitial. Location: %@", location);

    [self.delegate interstitialCustomEvent:self didLoadAd:nil];
}

- (void)didFailToLoadInterstitial:(NSString *)location withError:(CBLoadError)error
{
    MPLogInfo(@"Failed to load Chartboost interstitial. Location: %@", location);

    [self.delegate interstitialCustomEvent:self didFailToLoadAdWithError:nil];
}

- (void)didDismissInterstitial:(NSString *)location
{
    MPLogInfo(@"Chartboost interstitial was dismissed. Location: %@", location);

    // Chartboost doesn't seem to have a separate callback for the "will disappear" event, so we
    // signal "will disappear" manually.

    [self.delegate interstitialCustomEventWillDisappear:self];
    [self.delegate interstitialCustomEventDidDisappear:self];
}

- (void)didClickInterstitial:(NSString *)location
{
    MPLogInfo(@"Chartboost interstitial was clicked. Location: %@", location);
    [self.delegate interstitialCustomEventDidReceiveTapEvent:self];
}

@end


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

@interface MPChartboostRouter : NSObject <ChartboostDelegate>

@property (nonatomic, retain) NSMutableDictionary *events;
@property (nonatomic, retain) NSMutableSet *activeLocations;
@property (nonatomic, retain) Chartboost *chartboost;

+ (MPChartboostRouter *)sharedRouter;

- (void)cacheInterstitialWithAppId:(NSString *)appId
                      appSignature:(NSString *)appSignature
                          location:(NSString *)location
forChartboostInterstitialCustomEvent:(ChartboostInterstitialCustomEvent *)event;
- (ChartboostInterstitialCustomEvent *)eventForLocation:(NSString *)location;
- (void)setEvent:(ChartboostInterstitialCustomEvent *)event forLocation:(NSString *)location;
- (void)unregisterEventForLocation:(NSString *)location;
- (BOOL)hasCachedInterstitialForLocation:(NSString *)location;
- (void)showInterstitialForLocation:(NSString *)location;
- (void)unregisterEvent:(ChartboostInterstitialCustomEvent *)event;

@end

////////////////////////////////////////////////////////////////////////////////////////////////////

@interface MPInstanceProvider (ChartboostInterstitials)
- (Chartboost *)buildChartboost;
- (MPChartboostRouter *)sharedMPCharboostRouter;
@end

@implementation MPInstanceProvider (ChartboostInterstitials)

- (Chartboost *)buildChartboost
{
    return [Chartboost sharedChartboost];
}

- (MPChartboostRouter *)sharedMPCharboostRouter
{
    return [self singletonForClass:[MPChartboostRouter class]
                          provider:^id{
                              return [[[MPChartboostRouter alloc] init] autorelease];
                          }];
}

@end

////////////////////////////////////////////////////////////////////////////////////////////////////

@interface ChartboostInterstitialCustomEvent ()

@property (nonatomic, retain) NSString *location;

@end

@implementation ChartboostInterstitialCustomEvent

@synthesize location = _location;

- (void)invalidate
{
    [[MPChartboostRouter sharedRouter] unregisterEvent:self];
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
    [[MPChartboostRouter sharedRouter] cacheInterstitialWithAppId:appId
                                                     appSignature:appSignature
                                                         location:self.location
                             forChartboostInterstitialCustomEvent:self];
}

- (void)showInterstitialFromRootViewController:(UIViewController *)rootViewController
{
    if ([[MPChartboostRouter sharedRouter] hasCachedInterstitialForLocation:self.location]) {
        MPLogInfo(@"Chartboost interstitial will be shown.");
        
        // Normally, we call the "will appear" and "did appear" methods in response to
        // callbacks from Third Party Integrations. Unfortunately, Chartboost doesn't seem to have
        // such callbacks, so we call the methods manually.
        [self.delegate interstitialCustomEventWillAppear:self];
        [[MPChartboostRouter sharedRouter] showInterstitialForLocation:self.location];
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

////////////////////////////////////////////////////////////////////////////////////////////////////

/*
 * Chartboost only provides a shared instance, so only one object may be the Chartboost delegate at
 * any given time. However, because it is common to request Chartboost interstitials for separate
 * "locations" in a single app session, we may have multiple instances of our custom event class,
 * all of which are interested in delegate callbacks.
 *
 * MPChartboostRouter is a singleton that is always the Chartboost delegate, and dispatches
 * events to all of the custom event instances.
 */

@implementation MPChartboostRouter

@synthesize events = _events;
@synthesize activeLocations = _activeLocations;
@synthesize chartboost = _chartboost;

+ (MPChartboostRouter *)sharedRouter
{
    return [[MPInstanceProvider sharedProvider] sharedMPCharboostRouter];
}

- (id)init
{
    self = [super init];
    if (self) {
        self.events = [NSMutableDictionary dictionary];
        
        /*
         * We need the activeLocations set to keep track of locations that are currently being
         * cached/ready to show/visible on screen.
         * It is *not* enough to just use the events dictionary.  The reason is that when a user
         * taps a Chartboost interstitial.  Chartboost calls didDismissInterstitial *before* it calls
         * didClickInterstitial.  Since we *must* mark the location as available for reuse when
         * the interstitial is dismissed (e.g. the user simply closes it) the only way to allow
         * for click tracking, is to ensure that the event is still available after dismissal, but
         * is marked as free to be released.
         */
        self.activeLocations = [NSMutableSet set];
        
        self.chartboost = [[MPInstanceProvider sharedProvider] buildChartboost];
        self.chartboost.delegate = self;
    }
    return self;
}

- (void)dealloc
{
    self.chartboost = nil;
    self.events = nil;
    self.activeLocations = nil;
    [super dealloc];
}

- (void)cacheInterstitialWithAppId:(NSString *)appId
                      appSignature:(NSString *)appSignature
                          location:(NSString *)location
forChartboostInterstitialCustomEvent:(ChartboostInterstitialCustomEvent *)event
{
    if ([self.activeLocations containsObject:location]) {
        MPLogInfo(@"Failed to load Chartboost interstitial: this location is already in use.");
        [event didFailToLoadInterstitial:location withError:CBLoadErrorInternal];
        return;
    }
    
    if ([appId length] > 0 && [appSignature length] > 0) {
        [self setEvent:event forLocation:location];
        
        self.chartboost.appId = appId;
        self.chartboost.appSignature = appSignature;
        
        [self.chartboost startSession];
        [self.chartboost cacheInterstitial:location];
    } else {
        MPLogInfo(@"Failed to load Chartboost interstitial: missing either appId or appSignature.");
        [event didFailToLoadInterstitial:location withError:CBLoadErrorInternal];
    }
}

- (BOOL)hasCachedInterstitialForLocation:(NSString *)location
{
    return [self.chartboost hasCachedInterstitial:location];
}

- (void)showInterstitialForLocation:(NSString *)location
{
    [self.chartboost showInterstitial:location];
}

- (ChartboostInterstitialCustomEvent *)eventForLocation:(NSString *)location
{
    return [self.events objectForKey:location];
}

- (void)setEvent:(ChartboostInterstitialCustomEvent *)event forLocation:(NSString *)location
{
    [self.events setObject:event forKey:location];
    [self.activeLocations addObject:location];
}

- (void)unregisterEventForLocation:(NSString *)location
{
    [self.activeLocations removeObject:location];
}

- (void)unregisterEvent:(ChartboostInterstitialCustomEvent *)event
{
    if ([[self.events objectForKey:event.location] isEqual:event]) {
        [self unregisterEventForLocation:event.location];
    }
}

- (void)didCacheInterstitial:(NSString *)location
{
    [[self eventForLocation:location] didCacheInterstitial:location];
}

- (void)didFailToLoadInterstitial:(NSString *)location withError:(CBLoadError)error
{
    [[self eventForLocation:location] didFailToLoadInterstitial:location withError:CBLoadErrorInternal];
    [self unregisterEventForLocation:location];
}

- (void)didDismissInterstitial:(NSString *)location
{
    [[self eventForLocation:location] didDismissInterstitial:location];
    [self unregisterEventForLocation:location];
}

- (void)didClickInterstitial:(NSString *)location
{
    [[self eventForLocation:location] didClickInterstitial:location];
}

@end

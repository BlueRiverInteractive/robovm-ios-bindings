//
//  ChartboostInterstitialCustomEvent.m
//  MoPub
//
//  Copyright (c) 2012 MoPub, Inc. All rights reserved.
//

#import "ChartboostInterstitialCustomEvent.h"
#import <Chartboost/Chartboost.h>
#import "MPInstanceProvider.h"
#import "MPLogging.h"

static NSString *gAppId = nil;
static NSString *gAppSignature = nil;

#define kChartboostAppID        @"YOUR_CHARTBOOST_APP_ID"
#define kChartboostAppSignature @"YOUR_CHARTBOOST_APP_SIGNATURE"

////////////////////////////////////////////////////////////////////////////////////////////////////

@interface MPChartboostRouter : NSObject <ChartboostDelegate>

@property (nonatomic, strong) NSMutableDictionary *events;
@property (nonatomic, strong) NSMutableSet *activeLocations;

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

- (MPChartboostRouter *)sharedMPCharboostRouter;

@end

@implementation MPInstanceProvider (ChartboostInterstitials)

- (MPChartboostRouter *)sharedMPCharboostRouter
{
    return [self singletonForClass:[MPChartboostRouter class]
                          provider:^id{
                              return [[MPChartboostRouter alloc] init];
                          }];
}

@end

////////////////////////////////////////////////////////////////////////////////////////////////////

@interface ChartboostInterstitialCustomEvent () <ChartboostDelegate>

@property (nonatomic, strong) NSString *location;

@end

@implementation ChartboostInterstitialCustomEvent

@synthesize location = _location;

+ (void)setAppId:(NSString *)appId
{
    gAppId = [appId copy];
}

+ (void)setAppSignature:(NSString *)appSignature
{
    gAppSignature = [appSignature copy];
}

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
        appId = gAppId;

        if ([appId length] == 0) {
            appId = kChartboostAppID;
        }
    }
    NSString *appSignature = [info objectForKey:@"appSignature"];
    if (!appSignature) {
        appSignature = gAppSignature;

        if ([appSignature length] == 0) {
            appSignature = kChartboostAppSignature;
        }
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

        [[MPChartboostRouter sharedRouter] showInterstitialForLocation:self.location];
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

- (void)didDisplayInterstitial:(NSString *)location
{
    MPLogInfo(@"Chartboost interstitial was displayed. Location: %@", location);

    // Chartboost doesn't seem to have a separate callback for the "will appear" event, so we
    // signal "will appear" manually.

    [self.delegate interstitialCustomEventWillAppear:self];
    [self.delegate interstitialCustomEventDidAppear:self];
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
    }
    return self;
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

        static dispatch_once_t once;
        dispatch_once(&once, ^{
            [Chartboost startWithAppId:appId appSignature:appSignature delegate:self];
        });

        if ([self hasCachedInterstitialForLocation:location]) {
            [self didCacheInterstitial:location];
        } else {
            [Chartboost cacheInterstitial:location];
        }
    } else {
        MPLogInfo(@"Failed to load Chartboost interstitial: missing either appId or appSignature.");
        [event didFailToLoadInterstitial:location withError:CBLoadErrorInternal];
    }
}

- (BOOL)hasCachedInterstitialForLocation:(NSString *)location
{
    return [Chartboost hasInterstitial:location];
}

- (void)showInterstitialForLocation:(NSString *)location
{
    [Chartboost showInterstitial:location];
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

- (void)didDisplayInterstitial:(NSString *)location
{
    [[self eventForLocation:location] didDisplayInterstitial:location];
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


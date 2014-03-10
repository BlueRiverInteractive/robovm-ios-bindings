//
//  AdColonyInterstitialCustomEvent.m
//  MoPubSampleApp
//
//  Created by Yuan Ren on 10/22/13.
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import "AdColonyInterstitialCustomEvent.h"
#import "MPInstanceProvider.h"
#import "MPLogging.h"

#define kAdColonyAppId @"YOUR_ADCOLONY_APPID"
#define kAdColonyDefaultZoneId @"YOUR_ADCOLONY_DEFAULT_ZONEID" // This zone id will be used if "zoneId" is not passed through the custom info dictionary

#define AdColonyZoneIds() [NSArray arrayWithObjects:@"YOUR_ADCOLONY_ZONEID1", @"YOUR_ADCOLONY_ZONEID2", nil]

////////////////////////////////////////////////////////////////////////////////////////////////////

@interface MPAdColonyRouter : NSObject <AdColonyDelegate>

@property (nonatomic, retain) NSMutableDictionary *events;

+ (MPAdColonyRouter *)sharedRouter;

- (void)addEvent:(AdColonyInterstitialCustomEvent *)event forZone:(NSString *)zone;
- (void)removeEvent:(AdColonyInterstitialCustomEvent *)event forZone:(NSString *)zone;

@end

////////////////////////////////////////////////////////////////////////////////////////////////////

@interface MPInstanceProvider (AdColony)

- (MPAdColonyRouter *)sharedMPAdColonyRouter;

@end

@implementation MPInstanceProvider (AdColony)

- (MPAdColonyRouter *)sharedMPAdColonyRouter
{
    return [self singletonForClass:[MPAdColonyRouter class]
                          provider:^id
            {
                return [[[MPAdColonyRouter alloc] init] autorelease];
            }];
}

@end

////////////////////////////////////////////////////////////////////////////////////////////////////

@interface AdColonyInterstitialCustomEvent ()

@property (nonatomic, copy) NSString *zoneId;
@property (nonatomic, assign) BOOL zoneAvailable;

@end

@implementation AdColonyInterstitialCustomEvent

@synthesize zoneId = _zoneId;

- (void)dealloc
{
    self.zoneId = nil;
    
    [super dealloc];
}

#pragma mark - MPInterstitialCustomEvent Subclass Methods

- (void)requestInterstitialWithCustomEventInfo:(NSDictionary *)info
{
    NSString *appId = [info objectForKey:@"appId"];
    if(appId == nil)
    {
        appId = kAdColonyAppId;
    }
    
    NSArray *allZoneIds = [info objectForKey:@"allZoneIds"];
    if(allZoneIds.count == 0)
    {
        allZoneIds = AdColonyZoneIds();
    }

    static dispatch_once_t once;
    dispatch_once(&once, ^{
        [AdColony configureWithAppID:appId
                             zoneIDs:allZoneIds
                            delegate:[MPAdColonyRouter sharedRouter]
                             logging:NO];
    });
    
    NSString *zoneId = [info objectForKey:@"zoneId"];
    if(zoneId == nil)
    {
        zoneId = kAdColonyDefaultZoneId;
    }
    
    self.zoneId = zoneId;
    self.zoneAvailable = NO;
    
    if(self.zoneId != nil && appId != nil)
    {
        [[MPAdColonyRouter sharedRouter] addEvent:self forZone:self.zoneId];
    }
    
    if([AdColony zoneStatusForZone:self.zoneId] == ADCOLONY_ZONE_STATUS_ACTIVE)
    {
        MPLogInfo(@"AdColony zone %@ available", self.zoneId);
        [self zoneDidLoad];
    }
    
    // let AdColony inform us when the zone becomes available
}
- (void)showInterstitialFromRootViewController:(UIViewController *)rootViewController
{
    if ([AdColony zoneStatusForZone:self.zoneId] == ADCOLONY_ZONE_STATUS_ACTIVE)
    {
        MPLogInfo(@"AdColony zone %@ attempting to start", self.zoneId);
        [AdColony playVideoAdForZone:self.zoneId withDelegate:self];
        [self.delegate interstitialCustomEventWillAppear:self];
    }
    else
    {
        MPLogInfo(@"Failed to show AdColony video interstitial: AdColony now claims zone %@ is not available", self.zoneId);
        [self.delegate interstitialCustomEvent:self didFailToLoadAdWithError:nil];
    }
}

- (void)invalidate
{
    [[MPAdColonyRouter sharedRouter] removeEvent:self forZone:self.zoneId];
}

- (void)zoneDidLoad
{
    self.zoneAvailable = YES;
    [self.delegate interstitialCustomEvent:self didLoadAd:nil];
}

- (void)zoneDidExpire
{
    self.zoneAvailable = NO;
    [self.delegate interstitialCustomEventDidExpire:self];
}

#pragma mark - AdColonyAdDelegate

- (void)onAdColonyAdStartedInZone:(NSString *)zoneID
{
    MPLogInfo(@"AdColony zone %@ started", zoneID);
    [self.delegate interstitialCustomEventDidAppear:self];
}
- (void)onAdColonyAdAttemptFinished:(BOOL)shown inZone:(NSString *)zoneID
{
    MPLogInfo(@"AdColony zone %@ finished", zoneID);
    [self.delegate interstitialCustomEventWillDisappear:self];
    [self.delegate interstitialCustomEventDidDisappear:self];
}

@end

////////////////////////////////////////////////////////////////////////////////////////////////////

@implementation MPAdColonyRouter

@synthesize events = _events;

+ (MPAdColonyRouter *)sharedRouter
{
    return [[MPInstanceProvider sharedProvider] sharedMPAdColonyRouter];
}

- (id)init
{
    self = [super init];
    if(self != nil)
    {
        self.events = [NSMutableDictionary dictionary];
    }
    return self;
}

- (void)dealloc
{
    self.events = nil;
    
    [super dealloc];
}

- (void)addEvent:(AdColonyInterstitialCustomEvent *)event forZone:(NSString *)zone
{
    [self.events setObject:event forKey:zone];
}

- (void)removeEvent:(AdColonyInterstitialCustomEvent *)event forZone:(NSString *)zone
{
    if([[self.events objectForKey:zone] isEqual:event])
    {
        [self.events removeObjectForKey:zone];
    }
}

#pragma mark - AdColonyDelegate

- (void)onAdColonyAdAvailabilityChange:(BOOL)available inZone:(NSString *)zoneID
{
    AdColonyInterstitialCustomEvent *event = [self.events objectForKey:zoneID];
    
    if(available)
    {
        MPLogInfo(@"AdColony zone %@ just became available", zoneID);
        if(!event.zoneAvailable)
        {
            [event zoneDidLoad];
        }
    }
    else
    {
        MPLogInfo(@"AdColony zone %@ just became unavailable", zoneID);
        if(event.zoneAvailable)
        {
            [event zoneDidExpire];
        }
    }
}

@end
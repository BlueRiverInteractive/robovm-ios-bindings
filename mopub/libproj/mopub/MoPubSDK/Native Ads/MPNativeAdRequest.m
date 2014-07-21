//
//  MPNativeAdRequest.m
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import "MPNativeAdRequest.h"

#import "MPAdServerURLBuilder.h"
#import "MPCoreInstanceProvider.h"
#import "MPNativeAdError.h"
#import "MPNativeAd+Internal.h"
#import "MPNativeAdRequestTargeting.h"
#import "MPLogging.h"
#import "MPImageDownloadQueue.h"
#import "MPConstants.h"
#import "MPNativeCustomEventDelegate.h"
#import "MPNativeCustomEvent.h"
#import "MPInstanceProvider.h"
#import "NSJSONSerialization+MPAdditions.h"
#import "MPAdServerCommunicator.h"

#import "MPMoPubNativeCustomEvent.h"

////////////////////////////////////////////////////////////////////////////////////////////////////

@interface MPNativeAdRequest () <MPNativeCustomEventDelegate, MPAdServerCommunicatorDelegate>

@property (nonatomic, copy) NSString *adUnitIdentifier;
@property (nonatomic, retain) NSURL *URL;
@property (nonatomic, retain) MPAdServerCommunicator *communicator;
@property (nonatomic, copy) MPNativeAdRequestHandler completionHandler;
@property (nonatomic, retain) MPNativeCustomEvent *nativeCustomEvent;
@property (nonatomic, retain) MPAdConfiguration *adConfiguration;
@property (nonatomic, assign) BOOL loading;

@end

@implementation MPNativeAdRequest

- (id)initWithAdUnitIdentifier:(NSString *)identifier
{
    self = [super init];
    if (self) {
        _adUnitIdentifier = [identifier copy];
        _communicator = [[[MPCoreInstanceProvider sharedProvider] buildMPAdServerCommunicatorWithDelegate:self] retain];
    }
    return self;
}

- (void)dealloc
{
    [_adConfiguration release];
    [_adUnitIdentifier release];
    [_URL release];
    [_communicator cancel];
    [_communicator setDelegate:nil];
    [_communicator release];
    [_completionHandler release];
    [_targeting release];
    [_nativeCustomEvent setDelegate:nil];
    [_nativeCustomEvent release];
    [super dealloc];
}

#pragma mark - Public

+ (MPNativeAdRequest *)requestWithAdUnitIdentifier:(NSString *)identifier
{
    return [[[self alloc] initWithAdUnitIdentifier:identifier] autorelease];
}

- (void)startWithCompletionHandler:(MPNativeAdRequestHandler)handler
{
    if (handler)
    {
        self.URL = [MPAdServerURLBuilder URLWithAdUnitID:self.adUnitIdentifier
                                                keywords:self.targeting.keywords
                                                location:self.targeting.location
                                    versionParameterName:@"nsv"
                                                 version:MP_SDK_VERSION
                                                 testing:NO
                                           desiredAssets:[self.targeting.desiredAssets allObjects]];

        self.completionHandler = handler;

        [self loadAdWithURL:self.URL];
    }
    else
    {
        MPLogWarn(@"Native Ad Request did not start - requires completion handler block.");
    }
}

#pragma mark - Private

- (void)loadAdWithURL:(NSURL *)URL
{
    if (self.loading) {
        MPLogWarn(@"Native ad request is already loading an ad. Wait for previous load to finish.");
        return;
    }

    [self retain];

    MPLogInfo(@"Starting ad request with URL: %@", self.URL);

    self.loading = YES;
    [self.communicator loadURL:URL];
}

- (void)getAdWithConfiguration:(MPAdConfiguration *)configuration
{
    MPLogInfo(@"Looking for custom event class named %@.", configuration.customEventClass);\
    // Adserver doesn't return a customEventClass for MoPub native ads
    if([configuration.networkType isEqualToString:kAdTypeNative] && configuration.customEventClass == nil) {
        configuration.customEventClass = [MPMoPubNativeCustomEvent class];
        NSDictionary *classData = [NSJSONSerialization mp_JSONObjectWithData:configuration.adResponseData options:0 clearNullObjects:YES error:nil];
        configuration.customEventClassData = classData;
    }

    self.nativeCustomEvent = [[MPInstanceProvider sharedProvider] buildNativeCustomEventFromCustomClass:configuration.customEventClass delegate:self];

    if (self.nativeCustomEvent) {
        [self.nativeCustomEvent requestAdWithCustomEventInfo:configuration.customEventClassData];
    } else if ([[self.adConfiguration.failoverURL absoluteString] length]) {
        self.loading = NO;
        [self loadAdWithURL:self.adConfiguration.failoverURL];
        [self release];
    } else {
        [self completeAdRequestWithAdObject:nil error:[NSError errorWithDomain:MoPubNativeAdsSDKDomain code:MPNativeAdErrorInvalidServerResponse userInfo:nil]];
        [self release];
    }
}

- (void)completeAdRequestWithAdObject:(MPNativeAd *)adObject error:(NSError *)error
{
    self.loading = NO;
    if (self.completionHandler) {
        self.completionHandler(self, adObject, error);
        self.completionHandler = nil;
    }
}

#pragma mark - <MPAdServerCommunicatorDelegate>

- (void)communicatorDidReceiveAdConfiguration:(MPAdConfiguration *)configuration
{
    self.adConfiguration = configuration;

    if ([configuration.networkType isEqualToString:kAdTypeClear]) {
        MPLogInfo(@"No inventory available for ad unit: %@", self.adUnitIdentifier);

        [self completeAdRequestWithAdObject:nil error:[NSError errorWithDomain:MoPubNativeAdsSDKDomain code:MPNativeAdErrorNoInventory userInfo:nil]];
        [self release];
    }
    else {
        MPLogInfo(@"Received data from MoPub to construct Native ad.");

        [self getAdWithConfiguration:configuration];
    }
}

- (void)communicatorDidFailWithError:(NSError *)error
{
    MPLogDebug(@"Error: Couldn't retrieve an ad from MoPub. Message: %@", error);

    [self completeAdRequestWithAdObject:nil error:[NSError errorWithDomain:MoPubNativeAdsSDKDomain code:MPNativeAdErrorHTTPError userInfo:nil]];
    [self release];
}

#pragma mark - <MPNativeCustomEventDelegate>

- (void)nativeCustomEvent:(MPNativeCustomEvent *)event didLoadAd:(MPNativeAd *)adObject
{
    // Take the click tracking URL from the header if the ad object doesn't already have one.
    [adObject setEngagementTrackingURL:(adObject.engagementTrackingURL ? : self.adConfiguration.clickTrackingURL)];

    // Add the impression tracker from the header to our set.
    if (self.adConfiguration.impressionTrackingURL) {
        [adObject.impressionTrackers addObject:[self.adConfiguration.impressionTrackingURL absoluteString]];
    }

    // Error if we don't have click tracker or impression trackers.
    if (!adObject.engagementTrackingURL || adObject.impressionTrackers.count < 1) {
        [self completeAdRequestWithAdObject:nil error:[NSError errorWithDomain:MoPubNativeAdsSDKDomain code:MPNativeAdErrorInvalidServerResponse userInfo:nil]];
    } else {
        [self completeAdRequestWithAdObject:adObject error:nil];
    }

    [self release];

}

- (void)nativeCustomEvent:(MPNativeCustomEvent *)event didFailToLoadAdWithError:(NSError *)error
{
    if ([[self.adConfiguration.failoverURL absoluteString] length]) {
        self.loading = NO;
        [self loadAdWithURL:self.adConfiguration.failoverURL];
    } else {
        [self completeAdRequestWithAdObject:nil error:error];
    }

    [self release];
}


@end

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
@property (nonatomic, strong) NSURL *URL;
@property (nonatomic, strong) MPAdServerCommunicator *communicator;
@property (nonatomic, copy) MPNativeAdRequestHandler completionHandler;
@property (nonatomic, strong) MPNativeCustomEvent *nativeCustomEvent;
@property (nonatomic, strong) MPAdConfiguration *adConfiguration;
@property (nonatomic, assign) BOOL loading;

@end

@implementation MPNativeAdRequest

- (id)initWithAdUnitIdentifier:(NSString *)identifier
{
    self = [super init];
    if (self) {
        _adUnitIdentifier = [identifier copy];
        _communicator = [[MPCoreInstanceProvider sharedProvider] buildMPAdServerCommunicatorWithDelegate:self];
    }
    return self;
}

- (void)dealloc
{
    [_communicator cancel];
    [_communicator setDelegate:nil];
    [_nativeCustomEvent setDelegate:nil];
}

#pragma mark - Public

+ (MPNativeAdRequest *)requestWithAdUnitIdentifier:(NSString *)identifier
{
    return [[self alloc] initWithAdUnitIdentifier:identifier];
}

- (void)startWithCompletionHandler:(MPNativeAdRequestHandler)handler
{
    if (handler) {
        self.URL = [MPAdServerURLBuilder URLWithAdUnitID:self.adUnitIdentifier
                                                keywords:self.targeting.keywords
                                                location:self.targeting.location
                                    versionParameterName:@"nsv"
                                                 version:MP_SDK_VERSION
                                                 testing:NO
                                           desiredAssets:[self.targeting.desiredAssets allObjects]];

        [self assignCompletionHandler:handler];

        [self loadAdWithURL:self.URL];
    } else {
        MPLogWarn(@"Native Ad Request did not start - requires completion handler block.");
    }
}

- (void)startForAdSequence:(NSInteger)adSequence withCompletionHandler:(MPNativeAdRequestHandler)handler
{
    if (handler) {
        self.URL = [MPAdServerURLBuilder URLWithAdUnitID:self.adUnitIdentifier
                                                keywords:self.targeting.keywords
                                                location:self.targeting.location
                                    versionParameterName:@"nsv"
                                                 version:MP_SDK_VERSION
                                                 testing:NO
                                           desiredAssets:[self.targeting.desiredAssets allObjects]
                                              adSequence:adSequence];

        [self assignCompletionHandler:handler];

        [self loadAdWithURL:self.URL];
    } else {
        MPLogWarn(@"Native Ad Request did not start - requires completion handler block.");
    }
}

#pragma mark - Private

- (void)assignCompletionHandler:(MPNativeAdRequestHandler)handler
{
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Warc-retain-cycles"
    // we explicitly create a block retain cycle here to prevent self from being deallocated if the developer
    // removes his strong reference to the request. This retain cycle is broken in
    // - (void)completeAdRequestWithAdObject:(MPNativeAd *)adObject error:(NSError *)error
    // when self.completionHandler is set to nil.
    self.completionHandler = ^(MPNativeAdRequest *request, MPNativeAd *response, NSError *error) {
        handler(self, response, error);
    };
#pragma clang diagnostic pop
}

- (void)loadAdWithURL:(NSURL *)URL
{
    if (self.loading) {
        MPLogWarn(@"Native ad request is already loading an ad. Wait for previous load to finish.");
        return;
    }

    MPLogInfo(@"Starting ad request with URL: %@", self.URL);

    self.loading = YES;
    [self.communicator loadURL:URL];
}

- (void)getAdWithConfiguration:(MPAdConfiguration *)configuration
{
    if (configuration.customEventClass) {
        MPLogInfo(@"Looking for custom event class named %@.", configuration.customEventClass);
    }

    // Adserver doesn't return a customEventClass for MoPub native ads
    if ([configuration.networkType isEqualToString:kAdTypeNative] && configuration.customEventClass == nil) {
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
    } else {
        [self completeAdRequestWithAdObject:nil error:[NSError errorWithDomain:MoPubNativeAdsSDKDomain code:MPNativeAdErrorInvalidServerResponse userInfo:nil]];
    }
}

- (void)completeAdRequestWithAdObject:(MPNativeAd *)adObject error:(NSError *)error
{
    self.loading = NO;

    if (!error) {
        MPLogInfo(@"Successfully loaded native ad.");
    } else {
        MPLogError(@"Native ad failed to load with error: %@", error);
    }

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
        MPLogInfo(kMPClearErrorLogFormatWithAdUnitID, self.adUnitIdentifier);

        [self completeAdRequestWithAdObject:nil error:[NSError errorWithDomain:MoPubNativeAdsSDKDomain code:MPNativeAdErrorNoInventory userInfo:nil]];
    } else {
        MPLogInfo(@"Received data from MoPub to construct native ad.\n");
        [self getAdWithConfiguration:configuration];
    }
}

- (void)communicatorDidFailWithError:(NSError *)error
{
    MPLogDebug(@"Error: Couldn't retrieve an ad from MoPub. Message: %@", error);

    [self completeAdRequestWithAdObject:nil error:[NSError errorWithDomain:MoPubNativeAdsSDKDomain code:MPNativeAdErrorHTTPError userInfo:nil]];
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
}

- (void)nativeCustomEvent:(MPNativeCustomEvent *)event didFailToLoadAdWithError:(NSError *)error
{
    if ([[self.adConfiguration.failoverURL absoluteString] length]) {
        self.loading = NO;
        [self loadAdWithURL:self.adConfiguration.failoverURL];
    } else {
        [self completeAdRequestWithAdObject:nil error:error];
    }
}


@end

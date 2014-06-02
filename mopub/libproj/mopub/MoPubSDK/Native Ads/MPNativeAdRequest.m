//
//  MPNativeAdRequest.m
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import "MPNativeAdRequest.h"

#import "MPAdServerURLBuilder.h"
#import "MPCoreInstanceProvider.h"
#import "MPNativeAdError.h"
#import "MPNativeAd.h"
#import "MPNativeAdRequestTargeting.h"
#import "MPLogging.h"
#import "MPImageDownloadQueue.h"
#import "MPConstants.h"

////////////////////////////////////////////////////////////////////////////////////////////////////

@interface MPNativeAdRequest ()

@property (nonatomic, copy) NSString *adUnitIdentifier;
@property (nonatomic, retain) NSURL *URL;
@property (nonatomic, retain) MPAdServerCommunicator *communicator;
@property (nonatomic, copy) MPNativeAdRequestHandler completionHandler;
@property (nonatomic, retain) MPImageDownloadQueue *imageDownloadQueue;

@end

@implementation MPNativeAdRequest

- (id)initWithAdUnitIdentifier:(NSString *)identifier
{
    self = [super init];
    if (self) {
        _adUnitIdentifier = [identifier copy];
        _communicator = [[[MPCoreInstanceProvider sharedProvider] buildMPAdServerCommunicatorWithDelegate:self] retain];
        _imageDownloadQueue = [[MPImageDownloadQueue alloc] init];
    }
    return self;
}

- (void)dealloc
{
    [_adUnitIdentifier release];
    [_URL release];
    [_communicator cancel];
    [_communicator setDelegate:nil];
    [_communicator release];
    [_completionHandler release];
    [_imageDownloadQueue release];
    [_targeting release];
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
                                                 testing:NO];
        
        MPLogInfo(@"Starting ad request with URL: %@", self.URL);
        
        [self retain];
        
        self.completionHandler = handler;
        [self.communicator loadURL:self.URL];
    }
    else
    {
        MPLogWarn(@"Native Ad Request did not start - requires completion handler block.");
    }
}

#pragma mark - <MPAdServerCommunicatorDelegate>

- (void)communicatorDidReceiveAdConfiguration:(MPAdConfiguration *)configuration
{
    if ([configuration.networkType isEqualToString:kAdTypeClear]) {
        MPLogInfo(@"No inventory available for ad unit: %@", self.adUnitIdentifier);
        if (self.completionHandler)
        {
            self.completionHandler(self, nil, [NSError errorWithDomain:MoPubNativeAdsSDKDomain code:MPNativeAdErrorNoInventory userInfo:nil]);
        }
    } else {
        MPLogInfo(@"Received data from MoPub to construct Native ad.");
        MPNativeAd *adObject = [[[MPNativeAd alloc] initWithAdConfiguration:configuration] autorelease];
        
        if (!adObject.properties) {
            MPLogInfo(@"Error: data received was invalid.");
            if (self.completionHandler)
            {
                self.completionHandler(self, nil, [NSError errorWithDomain:MoPubNativeAdsSDKDomain code:MPNativeAdErrorInvalidServerResponse userInfo:nil]);
            }
        }
        
        NSMutableArray *imageURLs = [NSMutableArray array];
        for (NSString *key in [adObject.properties allKeys]) {
            if ([[key lowercaseString] hasSuffix:@"image"] && [[adObject.properties objectForKey:key] isKindOfClass:[NSString class]]) {
                [imageURLs addObject:[NSURL URLWithString:[adObject.properties objectForKey:key]]];
            }
        }
        
        if (imageURLs.count > 0) {
            [_imageDownloadQueue addDownloadImageURLs:imageURLs
                                      completionBlock:^(NSArray *errors) {
                                          if (errors) {
                                              MPLogDebug(@"%@", errors);
                                              MPLogInfo(@"Error: data received was invalid.");
                                              if (self.completionHandler)
                                              {
                                                  self.completionHandler(self, nil, [NSError errorWithDomain:MoPubNativeAdsSDKDomain code:MPNativeAdErrorInvalidServerResponse userInfo:nil]);
                                              }
                                          } else {
                                              if (self.completionHandler)
                                              {
                                                  self.completionHandler(self, adObject, nil);
                                              }
                                          }
                                          
                                          self.completionHandler = nil;
                                      }];
        }
        else {
            self.completionHandler(self, adObject, nil);
        }
    }
    
    [self release];
}

- (void)communicatorDidFailWithError:(NSError *)error
{
    MPLogDebug(@"Error: Couldn't retrieve an ad from MoPub. Message: %@", error);
    
    if (self.completionHandler)
    {
        self.completionHandler(self, nil, [NSError errorWithDomain:MoPubNativeAdsSDKDomain code:MPNativeAdErrorHTTPError userInfo:nil]);
    }
    
    self.completionHandler = nil;
    [self release];
}

@end

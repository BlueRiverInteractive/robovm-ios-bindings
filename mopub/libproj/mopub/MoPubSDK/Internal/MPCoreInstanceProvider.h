//
//  MPCoreInstanceProvider.h
//  MoPub
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "MPGlobal.h"


@class MPAdConfiguration;

// Fetching Ads
@class MPAdServerCommunicator;
@protocol MPAdServerCommunicatorDelegate;

// URL Handling
@class MPURLResolver;
@class MPAdDestinationDisplayAgent;
@protocol MPAdDestinationDisplayAgentDelegate;

// Utilities
@class MPAdAlertManager, MPAdAlertGestureRecognizer;
@class MPAnalyticsTracker;
@class MPReachability;
@class MPTimer;

typedef id(^MPSingletonProviderBlock)();

typedef enum {
    MPTwitterAvailabilityNone = 0,
    MPTwitterAvailabilityApp = 1 << 0,
    MPTwitterAvailabilityNative = 1 << 1,
} MPTwitterAvailability;

@interface MPCoreInstanceProvider : NSObject

+ (instancetype)sharedProvider;
- (id)singletonForClass:(Class)klass provider:(MPSingletonProviderBlock)provider;

#pragma mark - Fetching Ads
- (NSMutableURLRequest *)buildConfiguredURLRequestWithURL:(NSURL *)URL;
- (MPAdServerCommunicator *)buildMPAdServerCommunicatorWithDelegate:(id<MPAdServerCommunicatorDelegate>)delegate;

#pragma mark - URL Handling
- (MPURLResolver *)buildMPURLResolver;
- (MPAdDestinationDisplayAgent *)buildMPAdDestinationDisplayAgentWithDelegate:(id<MPAdDestinationDisplayAgentDelegate>)delegate;

#pragma mark - Utilities
- (id<MPAdAlertManagerProtocol>)buildMPAdAlertManagerWithDelegate:(id)delegate;
- (MPAdAlertGestureRecognizer *)buildMPAdAlertGestureRecognizerWithTarget:(id)target action:(SEL)action;
- (NSOperationQueue *)sharedOperationQueue;
- (MPAnalyticsTracker *)sharedMPAnalyticsTracker;
- (MPReachability *)sharedMPReachability;

// This call may return nil and may not update if the user hot-swaps the device's sim card.
- (NSDictionary *)sharedCarrierInfo;

- (MPTimer *)buildMPTimerWithTimeInterval:(NSTimeInterval)seconds target:(id)target selector:(SEL)selector repeats:(BOOL)repeats;

- (MPTwitterAvailability)twitterAvailabilityOnDevice;
- (void)resetTwitterAppInstallCheck;


@end

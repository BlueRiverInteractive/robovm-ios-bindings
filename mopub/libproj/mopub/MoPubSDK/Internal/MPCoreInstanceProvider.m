//
//  MPCoreInstanceProvider.m
//  MoPub
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import "MPCoreInstanceProvider.h"

#import <CoreTelephony/CTTelephonyNetworkInfo.h>
#import <CoreTelephony/CTCarrier.h>

#import "MPAdServerCommunicator.h"
#import "MPURLResolver.h"
#import "MPAdDestinationDisplayAgent.h"
#import "MPReachability.h"
#import "MPTimer.h"
#import "MPAnalyticsTracker.h"


#define MOPUB_CARRIER_INFO_DEFAULTS_KEY @"com.mopub.carrierinfo"


typedef enum
{
    MPTwitterDeepLinkNotChecked,
    MPTwitterDeepLinkEnabled,
    MPTwitterDeepLinkDisabled
} MPTwitterDeepLink;

@interface MPCoreInstanceProvider ()

@property (nonatomic, copy) NSString *userAgent;
@property (nonatomic, retain) NSMutableDictionary *singletons;
@property (nonatomic, retain) NSMutableDictionary *carrierInfo;
@property (nonatomic, assign) MPTwitterDeepLink twitterDeepLinkStatus;

@end

@implementation MPCoreInstanceProvider

@synthesize userAgent = _userAgent;
@synthesize singletons = _singletons;
@synthesize carrierInfo = _carrierInfo;
@synthesize twitterDeepLinkStatus = _twitterDeepLinkStatus;

static MPCoreInstanceProvider *sharedProvider = nil;

+ (instancetype)sharedProvider
{
    static dispatch_once_t once;
    dispatch_once(&once, ^{
        sharedProvider = [[self alloc] init];
    });
    
    return sharedProvider;
}

- (id)init
{
    self = [super init];
    if (self) {
        self.singletons = [NSMutableDictionary dictionary];
        
        [self initializeCarrierInfo];
    }
    return self;
}

- (void)dealloc
{
    self.singletons = nil;
    self.carrierInfo = nil;
    [super dealloc];
}

- (id)singletonForClass:(Class)klass provider:(MPSingletonProviderBlock)provider
{
    id singleton = [self.singletons objectForKey:klass];
    if (!singleton) {
        singleton = provider();
        [self.singletons setObject:singleton forKey:(id<NSCopying>)klass];
    }
    return singleton;
}

#pragma mark - Initializing Carrier Info

- (void)initializeCarrierInfo
{
    self.carrierInfo = [NSMutableDictionary dictionary];
    
    // check if we have a saved copy
    NSDictionary *saved = [[NSUserDefaults standardUserDefaults] dictionaryForKey:MOPUB_CARRIER_INFO_DEFAULTS_KEY];
    if(saved != nil) {
        [self.carrierInfo addEntriesFromDictionary:saved];
    }
    
    // now asynchronously load a fresh copy
    dispatch_async(dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_DEFAULT, 0), ^{
        CTTelephonyNetworkInfo *networkInfo = [[[CTTelephonyNetworkInfo alloc] init] autorelease];
        [self performSelectorOnMainThread:@selector(updateCarrierInfoForCTCarrier:) withObject:networkInfo.subscriberCellularProvider waitUntilDone:NO];
    });
}

- (void)updateCarrierInfoForCTCarrier:(CTCarrier *)ctCarrier
{
    // use setValue instead of setObject here because ctCarrier could be nil, and any of its properties could be nil
    [self.carrierInfo setValue:ctCarrier.carrierName forKey:@"carrierName"];
    [self.carrierInfo setValue:ctCarrier.isoCountryCode forKey:@"isoCountryCode"];
    [self.carrierInfo setValue:ctCarrier.mobileCountryCode forKey:@"mobileCountryCode"];
    [self.carrierInfo setValue:ctCarrier.mobileNetworkCode forKey:@"mobileNetworkCode"];
    
    [[NSUserDefaults standardUserDefaults] setObject:self.carrierInfo forKey:MOPUB_CARRIER_INFO_DEFAULTS_KEY];
    [[NSUserDefaults standardUserDefaults] synchronize];
}

#pragma mark - Fetching Ads
- (NSMutableURLRequest *)buildConfiguredURLRequestWithURL:(NSURL *)URL
{
    NSMutableURLRequest *request = [NSMutableURLRequest requestWithURL:URL];
    [request setHTTPShouldHandleCookies:YES];
    [request setValue:self.userAgent forHTTPHeaderField:@"User-Agent"];
    return request;
}

- (NSString *)userAgent
{
    if (!_userAgent) {
        self.userAgent = [[[[UIWebView alloc] init] autorelease] stringByEvaluatingJavaScriptFromString:@"navigator.userAgent"];
    }
    
    return _userAgent;
}

- (MPAdServerCommunicator *)buildMPAdServerCommunicatorWithDelegate:(id<MPAdServerCommunicatorDelegate>)delegate
{
    return [[(MPAdServerCommunicator *)[MPAdServerCommunicator alloc] initWithDelegate:delegate] autorelease];
}


#pragma mark - URL Handling

- (MPURLResolver *)buildMPURLResolver
{
    return [MPURLResolver resolver];
}

- (MPAdDestinationDisplayAgent *)buildMPAdDestinationDisplayAgentWithDelegate:(id<MPAdDestinationDisplayAgentDelegate>)delegate
{
    return [MPAdDestinationDisplayAgent agentWithDelegate:delegate];
}

#pragma mark - Utilities

- (id<MPAdAlertManagerProtocol>)buildMPAdAlertManagerWithDelegate:(id)delegate
{
    id<MPAdAlertManagerProtocol> adAlertManager = nil;
    
    Class adAlertManagerClass = NSClassFromString(@"MPAdAlertManager");
    if(adAlertManagerClass != nil)
    {
        adAlertManager = [[[adAlertManagerClass alloc] init] autorelease];
        [adAlertManager performSelector:@selector(setDelegate:) withObject:delegate];
    }
    
    return adAlertManager;
}

- (MPAdAlertGestureRecognizer *)buildMPAdAlertGestureRecognizerWithTarget:(id)target action:(SEL)action
{
    MPAdAlertGestureRecognizer *gestureRecognizer = nil;
    
    Class gestureRecognizerClass = NSClassFromString(@"MPAdAlertGestureRecognizer");
    if(gestureRecognizerClass != nil)
    {
        gestureRecognizer = [[[gestureRecognizerClass alloc] initWithTarget:target action:action] autorelease];
    }
    
    return gestureRecognizer;
}

- (NSOperationQueue *)sharedOperationQueue
{
    static NSOperationQueue *sharedOperationQueue = nil;
    static dispatch_once_t pred;
    
    dispatch_once(&pred, ^{
        sharedOperationQueue = [[NSOperationQueue alloc] init];
    });
    
    return sharedOperationQueue;
}

- (MPAnalyticsTracker *)sharedMPAnalyticsTracker
{
    return [self singletonForClass:[MPAnalyticsTracker class] provider:^id{
        return [MPAnalyticsTracker tracker];
    }];
}

- (MPReachability *)sharedMPReachability
{
    return [self singletonForClass:[MPReachability class] provider:^id{
        return [MPReachability reachabilityForLocalWiFi];
    }];
}

- (NSDictionary *)sharedCarrierInfo
{
    return self.carrierInfo;
}

- (MPTimer *)buildMPTimerWithTimeInterval:(NSTimeInterval)seconds target:(id)target selector:(SEL)selector repeats:(BOOL)repeats
{
    return [MPTimer timerWithTimeInterval:seconds target:target selector:selector repeats:repeats];
}

#pragma mark - Twitter Availability

- (void)resetTwitterAppInstallCheck
{
    self.twitterDeepLinkStatus = MPTwitterDeepLinkNotChecked;
}

- (BOOL)isTwitterInstalled
{
    
    if (self.twitterDeepLinkStatus == MPTwitterDeepLinkNotChecked)
    {
        BOOL twitterDeepLinkEnabled = [[UIApplication sharedApplication] canOpenURL:[NSURL URLWithString:@"twitter://timeline"]];
        if (twitterDeepLinkEnabled)
        {
            self.twitterDeepLinkStatus = MPTwitterDeepLinkEnabled;
        }
        else
        {
            self.twitterDeepLinkStatus = MPTwitterDeepLinkDisabled;
        }
    }
    
    return (self.twitterDeepLinkStatus == MPTwitterDeepLinkEnabled);
}

+ (BOOL)deviceHasTwitterIntegration
{
    return !![MPCoreInstanceProvider tweetComposeVCClass];
}

+ (Class)tweetComposeVCClass
{
    return NSClassFromString(@"TWTweetComposeViewController");
}

- (BOOL)isNativeTwitterAccountPresent
{
    BOOL nativeTwitterAccountPresent = NO;
    if ([MPCoreInstanceProvider deviceHasTwitterIntegration])
    {
        nativeTwitterAccountPresent = (BOOL)[[MPCoreInstanceProvider tweetComposeVCClass] performSelector:@selector(canSendTweet)];
    }
    
    return nativeTwitterAccountPresent;
}

- (MPTwitterAvailability)twitterAvailabilityOnDevice
{
    MPTwitterAvailability twitterAvailability = MPTwitterAvailabilityNone;
    
    if ([self isTwitterInstalled])
    {
        twitterAvailability |= MPTwitterAvailabilityApp;
    }
    
    if ([self isNativeTwitterAccountPresent])
    {
        twitterAvailability |= MPTwitterAvailabilityNative;
    }
    
    return twitterAvailability;
}



@end

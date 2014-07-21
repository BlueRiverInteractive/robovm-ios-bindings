//
//  MPInstanceProvider.m
//  MoPub
//
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import "MPInstanceProvider.h"
#import "MPAdWebView.h"
#import "MPAdWebViewAgent.h"
#import "MPInterstitialAdManager.h"
#import "MPInterstitialCustomEventAdapter.h"
#import "MPLegacyInterstitialCustomEventAdapter.h"
#import "MPHTMLInterstitialViewController.h"
#import "MPMRAIDInterstitialViewController.h"
#import "MPInterstitialCustomEvent.h"
#import "MPBaseBannerAdapter.h"
#import "MPBannerCustomEventAdapter.h"
#import "MPLegacyBannerCustomEventAdapter.h"
#import "MPBannerCustomEvent.h"
#import "MPBannerAdManager.h"
#import "MPLogging.h"
#import "MRJavaScriptEventEmitter.h"
#import "MRImageDownloader.h"
#import "MRBundleManager.h"
#import "MRCalendarManager.h"
#import "MRPictureManager.h"
#import "MRVideoPlayerManager.h"
#import <EventKit/EventKit.h>
#import <EventKitUI/EventKitUI.h>
#import <MediaPlayer/MediaPlayer.h>
#import "MPNativeCustomEvent.h"



@interface MPInstanceProvider ()

@property (nonatomic, retain) NSMutableDictionary *singletons;

@end


@implementation MPInstanceProvider

static MPInstanceProvider *sharedAdProvider = nil;

+ (instancetype)sharedProvider
{
    static dispatch_once_t once;
    dispatch_once(&once, ^{
        sharedAdProvider = [[self alloc] init];
    });

    return sharedAdProvider;
}

- (id)init
{
    self = [super init];
    if (self) {
        self.singletons = [NSMutableDictionary dictionary];
    }
    return self;
}

- (void)dealloc
{
    self.singletons = nil;
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

#pragma mark - Banners

- (MPBannerAdManager *)buildMPBannerAdManagerWithDelegate:(id<MPBannerAdManagerDelegate>)delegate
{
    return [[(MPBannerAdManager *)[MPBannerAdManager alloc] initWithDelegate:delegate] autorelease];
}

- (MPBaseBannerAdapter *)buildBannerAdapterForConfiguration:(MPAdConfiguration *)configuration
                                                   delegate:(id<MPBannerAdapterDelegate>)delegate
{
    if (configuration.customEventClass) {
        return [[(MPBannerCustomEventAdapter *)[MPBannerCustomEventAdapter alloc] initWithDelegate:delegate] autorelease];
    } else if (configuration.customSelectorName) {
        return [[(MPLegacyBannerCustomEventAdapter *)[MPLegacyBannerCustomEventAdapter alloc] initWithDelegate:delegate] autorelease];
    }

    return nil;
}

- (MPBannerCustomEvent *)buildBannerCustomEventFromCustomClass:(Class)customClass
                                                      delegate:(id<MPBannerCustomEventDelegate>)delegate
{
    MPBannerCustomEvent *customEvent = [[[customClass alloc] init] autorelease];
    if (![customEvent isKindOfClass:[MPBannerCustomEvent class]]) {
        MPLogError(@"**** Custom Event Class: %@ does not extend MPBannerCustomEvent ****", NSStringFromClass(customClass));
        return nil;
    }
    customEvent.delegate = delegate;
    return customEvent;
}

#pragma mark - Interstitials

- (MPInterstitialAdManager *)buildMPInterstitialAdManagerWithDelegate:(id<MPInterstitialAdManagerDelegate>)delegate
{
    return [[(MPInterstitialAdManager *)[MPInterstitialAdManager alloc] initWithDelegate:delegate] autorelease];
}


- (MPBaseInterstitialAdapter *)buildInterstitialAdapterForConfiguration:(MPAdConfiguration *)configuration
                                                               delegate:(id<MPInterstitialAdapterDelegate>)delegate
{
    if (configuration.customEventClass) {
        return [[(MPInterstitialCustomEventAdapter *)[MPInterstitialCustomEventAdapter alloc] initWithDelegate:delegate] autorelease];
    } else if (configuration.customSelectorName) {
        return [[(MPLegacyInterstitialCustomEventAdapter *)[MPLegacyInterstitialCustomEventAdapter alloc] initWithDelegate:delegate] autorelease];
    }

    return nil;
}

- (MPInterstitialCustomEvent *)buildInterstitialCustomEventFromCustomClass:(Class)customClass
                                                                  delegate:(id<MPInterstitialCustomEventDelegate>)delegate
{
    MPInterstitialCustomEvent *customEvent = [[[customClass alloc] init] autorelease];
    if (![customEvent isKindOfClass:[MPInterstitialCustomEvent class]]) {
        MPLogError(@"**** Custom Event Class: %@ does not extend MPInterstitialCustomEvent ****", NSStringFromClass(customClass));
        return nil;
    }
    if ([customEvent respondsToSelector:@selector(customEventDidUnload)]) {
        MPLogWarn(@"**** Custom Event Class: %@ implements the deprecated -customEventDidUnload method.  This is no longer called.  Use -dealloc for cleanup instead ****", NSStringFromClass(customClass));
    }
    customEvent.delegate = delegate;
    return customEvent;
}

- (MPHTMLInterstitialViewController *)buildMPHTMLInterstitialViewControllerWithDelegate:(id<MPInterstitialViewControllerDelegate>)delegate
                                                                        orientationType:(MPInterstitialOrientationType)type
                                                                   customMethodDelegate:(id)customMethodDelegate
{
    MPHTMLInterstitialViewController *controller = [[[MPHTMLInterstitialViewController alloc] init] autorelease];
    controller.delegate = delegate;
    controller.orientationType = type;
    controller.customMethodDelegate = customMethodDelegate;
    return controller;
}

- (MPMRAIDInterstitialViewController *)buildMPMRAIDInterstitialViewControllerWithDelegate:(id<MPInterstitialViewControllerDelegate>)delegate
                                                                            configuration:(MPAdConfiguration *)configuration
{
    MPMRAIDInterstitialViewController *controller = [[[MPMRAIDInterstitialViewController alloc] initWithAdConfiguration:configuration] autorelease];
    controller.delegate = delegate;
    return controller;
}

#pragma mark - HTML Ads

- (MPAdWebView *)buildMPAdWebViewWithFrame:(CGRect)frame delegate:(id<UIWebViewDelegate>)delegate
{
    MPAdWebView *webView = [[[MPAdWebView alloc] initWithFrame:frame] autorelease];
    webView.delegate = delegate;
    return webView;
}

- (MPAdWebViewAgent *)buildMPAdWebViewAgentWithAdWebViewFrame:(CGRect)frame delegate:(id<MPAdWebViewAgentDelegate>)delegate customMethodDelegate:(id)customMethodDelegate
{
    return [[[MPAdWebViewAgent alloc] initWithAdWebViewFrame:frame delegate:delegate customMethodDelegate:customMethodDelegate] autorelease];
}

#pragma mark - MRAID

- (MRAdView *)buildMRAdViewWithFrame:(CGRect)frame
                     allowsExpansion:(BOOL)allowsExpansion
                    closeButtonStyle:(MRAdViewCloseButtonStyle)style
                       placementType:(MRAdViewPlacementType)type
                            delegate:(id<MRAdViewDelegate>)delegate
{
    MRAdView *mrAdView = [[[MRAdView alloc] initWithFrame:frame allowsExpansion:allowsExpansion closeButtonStyle:style placementType:type] autorelease];
    mrAdView.delegate = delegate;
    return mrAdView;
}

- (MRBundleManager *)buildMRBundleManager
{
    return [MRBundleManager sharedManager];
}

- (UIWebView *)buildUIWebViewWithFrame:(CGRect)frame
{
    return [[[UIWebView alloc] initWithFrame:frame] autorelease];
}

- (MRJavaScriptEventEmitter *)buildMRJavaScriptEventEmitterWithWebView:(UIWebView *)webView
{
    return [[[MRJavaScriptEventEmitter alloc] initWithWebView:webView] autorelease];
}

- (MRCalendarManager *)buildMRCalendarManagerWithDelegate:(id<MRCalendarManagerDelegate>)delegate
{
    return [[[MRCalendarManager alloc] initWithDelegate:delegate] autorelease];
}

- (EKEventEditViewController *)buildEKEventEditViewControllerWithEditViewDelegate:(id<EKEventEditViewDelegate>)editViewDelegate
{
    EKEventEditViewController *controller = [[[EKEventEditViewController alloc] init] autorelease];
    controller.editViewDelegate = editViewDelegate;
    controller.eventStore = [self buildEKEventStore];
    return controller;
}

- (EKEventStore *)buildEKEventStore
{
    return [[[EKEventStore alloc] init] autorelease];
}

- (MRPictureManager *)buildMRPictureManagerWithDelegate:(id<MRPictureManagerDelegate>)delegate
{
    return [[[MRPictureManager alloc] initWithDelegate:delegate] autorelease];
}

- (MRImageDownloader *)buildMRImageDownloaderWithDelegate:(id<MRImageDownloaderDelegate>)delegate
{
    return [[[MRImageDownloader alloc] initWithDelegate:delegate] autorelease];
}

- (MRVideoPlayerManager *)buildMRVideoPlayerManagerWithDelegate:(id<MRVideoPlayerManagerDelegate>)delegate
{
    return [[[MRVideoPlayerManager alloc] initWithDelegate:delegate] autorelease];
}

- (MPMoviePlayerViewController *)buildMPMoviePlayerViewControllerWithURL:(NSURL *)URL
{
    // ImageContext used to avoid CGErrors
    // http://stackoverflow.com/questions/13203336/iphone-mpmovieplayerviewcontroller-cgcontext-errors/14669166#14669166
    UIGraphicsBeginImageContext(CGSizeMake(1,1));
    MPMoviePlayerViewController *playerViewController = [[[MPMoviePlayerViewController alloc] initWithContentURL:URL] autorelease];
    UIGraphicsEndImageContext();

    return playerViewController;
}

#pragma mark - Native

- (MPNativeCustomEvent *)buildNativeCustomEventFromCustomClass:(Class)customClass
                                                      delegate:(id<MPNativeCustomEventDelegate>)delegate
{
    MPNativeCustomEvent *customEvent = [[[customClass alloc] init] autorelease];
    if (![customEvent isKindOfClass:[MPNativeCustomEvent class]]) {
        MPLogError(@"**** Custom Event Class: %@ does not extend MPNativeCustomEvent ****", NSStringFromClass(customClass));
        return nil;
    }
    customEvent.delegate = delegate;
    return customEvent;
}


@end


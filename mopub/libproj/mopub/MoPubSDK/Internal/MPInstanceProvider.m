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
#import "MRImageDownloader.h"
#import "MRBundleManager.h"
#import "MRCalendarManager.h"
#import "MRPictureManager.h"
#import "MRVideoPlayerManager.h"
#import <EventKit/EventKit.h>
#import <EventKitUI/EventKitUI.h>
#import <MediaPlayer/MediaPlayer.h>
#import "MPNativeCustomEvent.h"
#import "MPNativeAdSource.h"
#import "MPNativePositionSource.h"
#import "MPStreamAdPlacementData.h"
#import "MPStreamAdPlacer.h"
#import "MRNativeCommandHandler.h"
#import "MRBridge.h"
#import "MRController.h"
#import "MPClosableView.h"

@interface MPInstanceProvider ()

@property (nonatomic, strong) NSMutableDictionary *singletons;

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
    return [(MPBannerAdManager *)[MPBannerAdManager alloc] initWithDelegate:delegate];
}

- (MPBaseBannerAdapter *)buildBannerAdapterForConfiguration:(MPAdConfiguration *)configuration
                                                   delegate:(id<MPBannerAdapterDelegate>)delegate
{
    if (configuration.customEventClass) {
        return [(MPBannerCustomEventAdapter *)[MPBannerCustomEventAdapter alloc] initWithDelegate:delegate];
    } else if (configuration.customSelectorName) {
        return [(MPLegacyBannerCustomEventAdapter *)[MPLegacyBannerCustomEventAdapter alloc] initWithDelegate:delegate];
    }

    return nil;
}

- (MPBannerCustomEvent *)buildBannerCustomEventFromCustomClass:(Class)customClass
                                                      delegate:(id<MPBannerCustomEventDelegate>)delegate
{
    MPBannerCustomEvent *customEvent = [[customClass alloc] init];
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
    return [(MPInterstitialAdManager *)[MPInterstitialAdManager alloc] initWithDelegate:delegate];
}


- (MPBaseInterstitialAdapter *)buildInterstitialAdapterForConfiguration:(MPAdConfiguration *)configuration
                                                               delegate:(id<MPInterstitialAdapterDelegate>)delegate
{
    if (configuration.customEventClass) {
        return [(MPInterstitialCustomEventAdapter *)[MPInterstitialCustomEventAdapter alloc] initWithDelegate:delegate];
    } else if (configuration.customSelectorName) {
        return [(MPLegacyInterstitialCustomEventAdapter *)[MPLegacyInterstitialCustomEventAdapter alloc] initWithDelegate:delegate];
    }

    return nil;
}

- (MPInterstitialCustomEvent *)buildInterstitialCustomEventFromCustomClass:(Class)customClass
                                                                  delegate:(id<MPInterstitialCustomEventDelegate>)delegate
{
    MPInterstitialCustomEvent *customEvent = [[customClass alloc] init];
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
    MPHTMLInterstitialViewController *controller = [[MPHTMLInterstitialViewController alloc] init];
    controller.delegate = delegate;
    controller.orientationType = type;
    controller.customMethodDelegate = customMethodDelegate;
    return controller;
}

- (MPMRAIDInterstitialViewController *)buildMPMRAIDInterstitialViewControllerWithDelegate:(id<MPInterstitialViewControllerDelegate>)delegate
                                                                            configuration:(MPAdConfiguration *)configuration
{
    MPMRAIDInterstitialViewController *controller = [[MPMRAIDInterstitialViewController alloc] initWithAdConfiguration:configuration];
    controller.delegate = delegate;
    return controller;
}

#pragma mark - HTML Ads

- (MPAdWebView *)buildMPAdWebViewWithFrame:(CGRect)frame delegate:(id<UIWebViewDelegate>)delegate
{
    MPAdWebView *webView = [[MPAdWebView alloc] initWithFrame:frame];
    webView.delegate = delegate;
    return webView;
}

- (MPAdWebViewAgent *)buildMPAdWebViewAgentWithAdWebViewFrame:(CGRect)frame delegate:(id<MPAdWebViewAgentDelegate>)delegate customMethodDelegate:(id)customMethodDelegate
{
    return [[MPAdWebViewAgent alloc] initWithAdWebViewFrame:frame delegate:delegate customMethodDelegate:customMethodDelegate];
}

#pragma mark - MRAID

- (MPClosableView *)buildMRAIDMPClosableViewWithFrame:(CGRect)frame webView:(UIWebView *)webView delegate:(id<MPClosableViewDelegate>)delegate
{
    MPClosableView *adView = [[MPClosableView alloc] initWithFrame:frame closeButtonType:MPClosableViewCloseButtonTypeTappableWithImage];
    adView.delegate = delegate;
    adView.clipsToBounds = YES;
    webView.frame = adView.bounds;
    [adView addSubview:webView];
    return adView;
}

- (MRBundleManager *)buildMRBundleManager
{
    return [MRBundleManager sharedManager];
}

- (MRController *)buildBannerMRControllerWithFrame:(CGRect)frame delegate:(id<MRControllerDelegate>)delegate
{
    return [self buildMRControllerWithFrame:frame placementType:MRAdViewPlacementTypeInline delegate:delegate];
}

- (MRController *)buildInterstitialMRControllerWithFrame:(CGRect)frame delegate:(id<MRControllerDelegate>)delegate
{
    return [self buildMRControllerWithFrame:frame placementType:MRAdViewPlacementTypeInterstitial delegate:delegate];
}

- (MRController *)buildMRControllerWithFrame:(CGRect)frame placementType:(MRAdViewPlacementType)placementType delegate:(id<MRControllerDelegate>)delegate
{
    MRController *controller = [[MRController alloc] initWithAdViewFrame:frame adPlacementType:placementType];
    controller.delegate = delegate;
    return controller;
}

- (MRBridge *)buildMRBridgeWithWebView:(UIWebView *)webView delegate:(id<MRBridgeDelegate>)delegate
{
    MRBridge *bridge = [[MRBridge alloc] initWithWebView:webView];
    bridge.delegate = delegate;
    bridge.shouldHandleRequests = YES;
    return bridge;
}

- (UIWebView *)buildUIWebViewWithFrame:(CGRect)frame
{
    return [[UIWebView alloc] initWithFrame:frame];
}

- (MRCalendarManager *)buildMRCalendarManagerWithDelegate:(id<MRCalendarManagerDelegate>)delegate
{
    return [[MRCalendarManager alloc] initWithDelegate:delegate];
}

- (EKEventEditViewController *)buildEKEventEditViewControllerWithEditViewDelegate:(id<EKEventEditViewDelegate>)editViewDelegate
{
    EKEventEditViewController *controller = [[EKEventEditViewController alloc] init];
    controller.editViewDelegate = editViewDelegate;
    controller.eventStore = [self buildEKEventStore];
    return controller;
}

- (EKEventStore *)buildEKEventStore
{
    return [[EKEventStore alloc] init];
}

- (MRPictureManager *)buildMRPictureManagerWithDelegate:(id<MRPictureManagerDelegate>)delegate
{
    return [[MRPictureManager alloc] initWithDelegate:delegate];
}

- (MRImageDownloader *)buildMRImageDownloaderWithDelegate:(id<MRImageDownloaderDelegate>)delegate
{
    return [[MRImageDownloader alloc] initWithDelegate:delegate];
}

- (MRVideoPlayerManager *)buildMRVideoPlayerManagerWithDelegate:(id<MRVideoPlayerManagerDelegate>)delegate
{
    return [[MRVideoPlayerManager alloc] initWithDelegate:delegate];
}

- (MPMoviePlayerViewController *)buildMPMoviePlayerViewControllerWithURL:(NSURL *)URL
{
    // ImageContext used to avoid CGErrors
    // http://stackoverflow.com/questions/13203336/iphone-mpmovieplayerviewcontroller-cgcontext-errors/14669166#14669166
    UIGraphicsBeginImageContext(CGSizeMake(1,1));
    MPMoviePlayerViewController *playerViewController = [[MPMoviePlayerViewController alloc] initWithContentURL:URL];
    UIGraphicsEndImageContext();

    return playerViewController;
}

- (MRNativeCommandHandler *)buildMRNativeCommandHandlerWithDelegate:(id<MRNativeCommandHandlerDelegate>)delegate
{
    return [[MRNativeCommandHandler alloc] initWithDelegate:delegate];
}

#pragma mark - Native

- (MPNativeCustomEvent *)buildNativeCustomEventFromCustomClass:(Class)customClass
                                                      delegate:(id<MPNativeCustomEventDelegate>)delegate
{
    MPNativeCustomEvent *customEvent = [[customClass alloc] init];
    if (![customEvent isKindOfClass:[MPNativeCustomEvent class]]) {
        MPLogError(@"**** Custom Event Class: %@ does not extend MPNativeCustomEvent ****", NSStringFromClass(customClass));
        return nil;
    }
    customEvent.delegate = delegate;
    return customEvent;
}

- (MPNativeAdSource *)buildNativeAdSourceWithDelegate:(id<MPNativeAdSourceDelegate>)delegate
{
    MPNativeAdSource *source = [MPNativeAdSource source];
    source.delegate = delegate;
    return source;
}

- (MPNativePositionSource *)buildNativePositioningSource
{
    return [[MPNativePositionSource alloc] init];
}

- (MPStreamAdPlacementData *)buildStreamAdPlacementDataWithPositioning:(MPAdPositioning *)positioning
{
    MPStreamAdPlacementData *placementData = [[MPStreamAdPlacementData alloc] initWithPositioning:positioning];
    return placementData;
}

- (MPStreamAdPlacer *)buildStreamAdPlacerWithViewController:(UIViewController *)controller adPositioning:(MPAdPositioning *)positioning defaultAdRenderingClass:defaultAdRenderingClass
{
    return [MPStreamAdPlacer placerWithViewController:controller adPositioning:positioning defaultAdRenderingClass:defaultAdRenderingClass];
}

@end


//
//  MPInstanceProvider.h
//  MoPub
//
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import "MPGlobal.h"
#import "MPCoreInstanceProvider.h"

// Banners
@class MPBannerAdManager;
@protocol MPBannerAdManagerDelegate;
@class MPBaseBannerAdapter;
@protocol MPBannerAdapterDelegate;
@class MPBannerCustomEvent;
@protocol MPBannerCustomEventDelegate;

// Interstitials
@class MPInterstitialAdManager;
@protocol MPInterstitialAdManagerDelegate;
@class MPBaseInterstitialAdapter;
@protocol MPInterstitialAdapterDelegate;
@class MPInterstitialCustomEvent;
@protocol MPInterstitialCustomEventDelegate;
@class MPHTMLInterstitialViewController;
@class MPMRAIDInterstitialViewController;
@protocol MPInterstitialViewControllerDelegate;

// HTML Ads
@class MPAdWebView;
@class MPAdWebViewAgent;
@protocol MPAdWebViewAgentDelegate;

// MRAID
@class MRController;
@protocol MRControllerDelegate;
@class MPClosableView;
@class MRBridge;
@protocol MRBridgeDelegate;
@protocol MPClosableViewDelegate;
@class MRBundleManager;
@class MRCalendarManager;
@protocol MRCalendarManagerDelegate;
@class EKEventStore;
@class EKEventEditViewController;
@protocol EKEventEditViewDelegate;
@class MRPictureManager;
@protocol MRPictureManagerDelegate;
@class MRImageDownloader;
@protocol MRImageDownloaderDelegate;
@class MRVideoPlayerManager;
@protocol MRVideoPlayerManagerDelegate;
@class MPMoviePlayerViewController;
@class MRNativeCommandHandler;
@protocol MRNativeCommandHandlerDelegate;

//Native
@protocol MPNativeCustomEventDelegate;
@class MPNativeCustomEvent;
@class MPNativeAdSource;
@protocol MPNativeAdSourceDelegate;
@class MPNativePositionSource;
@class MPStreamAdPlacementData;
@class MPStreamAdPlacer;
@class MPAdPositioning;

@interface MPInstanceProvider : NSObject

+(instancetype)sharedProvider;
- (id)singletonForClass:(Class)klass provider:(MPSingletonProviderBlock)provider;

#pragma mark - Banners
- (MPBannerAdManager *)buildMPBannerAdManagerWithDelegate:(id<MPBannerAdManagerDelegate>)delegate;
- (MPBaseBannerAdapter *)buildBannerAdapterForConfiguration:(MPAdConfiguration *)configuration
                                                   delegate:(id<MPBannerAdapterDelegate>)delegate;
- (MPBannerCustomEvent *)buildBannerCustomEventFromCustomClass:(Class)customClass
                                                      delegate:(id<MPBannerCustomEventDelegate>)delegate;

#pragma mark - Interstitials
- (MPInterstitialAdManager *)buildMPInterstitialAdManagerWithDelegate:(id<MPInterstitialAdManagerDelegate>)delegate;
- (MPBaseInterstitialAdapter *)buildInterstitialAdapterForConfiguration:(MPAdConfiguration *)configuration
                                                               delegate:(id<MPInterstitialAdapterDelegate>)delegate;
- (MPInterstitialCustomEvent *)buildInterstitialCustomEventFromCustomClass:(Class)customClass
                                                                  delegate:(id<MPInterstitialCustomEventDelegate>)delegate;
- (MPHTMLInterstitialViewController *)buildMPHTMLInterstitialViewControllerWithDelegate:(id<MPInterstitialViewControllerDelegate>)delegate
                                                                        orientationType:(MPInterstitialOrientationType)type
                                                                   customMethodDelegate:(id)customMethodDelegate;
- (MPMRAIDInterstitialViewController *)buildMPMRAIDInterstitialViewControllerWithDelegate:(id<MPInterstitialViewControllerDelegate>)delegate
                                                                            configuration:(MPAdConfiguration *)configuration;

#pragma mark - HTML Ads
- (MPAdWebView *)buildMPAdWebViewWithFrame:(CGRect)frame
                                  delegate:(id<UIWebViewDelegate>)delegate;
- (MPAdWebViewAgent *)buildMPAdWebViewAgentWithAdWebViewFrame:(CGRect)frame
                                                     delegate:(id<MPAdWebViewAgentDelegate>)delegate
                                         customMethodDelegate:(id)customMethodDelegate;

#pragma mark - MRAID
- (MPClosableView *)buildMRAIDMPClosableViewWithFrame:(CGRect)frame webView:(UIWebView *)webView delegate:(id<MPClosableViewDelegate>)delegate;
- (MRBundleManager *)buildMRBundleManager;
- (MRController *)buildBannerMRControllerWithFrame:(CGRect)frame delegate:(id<MRControllerDelegate>)delegate;
- (MRController *)buildInterstitialMRControllerWithFrame:(CGRect)frame delegate:(id<MRControllerDelegate>)delegate;
- (MRBridge *)buildMRBridgeWithWebView:(UIWebView *)webView delegate:(id<MRBridgeDelegate>)delegate;
- (UIWebView *)buildUIWebViewWithFrame:(CGRect)frame;
- (MRCalendarManager *)buildMRCalendarManagerWithDelegate:(id<MRCalendarManagerDelegate>)delegate;
- (EKEventEditViewController *)buildEKEventEditViewControllerWithEditViewDelegate:(id<EKEventEditViewDelegate>)editViewDelegate;
- (EKEventStore *)buildEKEventStore;
- (MRPictureManager *)buildMRPictureManagerWithDelegate:(id<MRPictureManagerDelegate>)delegate;
- (MRImageDownloader *)buildMRImageDownloaderWithDelegate:(id<MRImageDownloaderDelegate>)delegate;
- (MRVideoPlayerManager *)buildMRVideoPlayerManagerWithDelegate:(id<MRVideoPlayerManagerDelegate>)delegate;
- (MPMoviePlayerViewController *)buildMPMoviePlayerViewControllerWithURL:(NSURL *)URL;
- (MRNativeCommandHandler *)buildMRNativeCommandHandlerWithDelegate:(id<MRNativeCommandHandlerDelegate>)delegate;

#pragma mark - Native

- (MPNativeCustomEvent *)buildNativeCustomEventFromCustomClass:(Class)customClass
                                                      delegate:(id<MPNativeCustomEventDelegate>)delegate;
- (MPNativeAdSource *)buildNativeAdSourceWithDelegate:(id<MPNativeAdSourceDelegate>)delegate;
- (MPNativePositionSource *)buildNativePositioningSource;
- (MPStreamAdPlacementData *)buildStreamAdPlacementDataWithPositioning:(MPAdPositioning *)positioning;
- (MPStreamAdPlacer *)buildStreamAdPlacerWithViewController:(UIViewController *)controller adPositioning:(MPAdPositioning *)positioning defaultAdRenderingClass:defaultAdRenderingClass;

@end

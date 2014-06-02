//
//  MPNativeAd.m
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import "MPNativeAd.h"

#import "MPAdConfiguration.h"
#import "MPAdDestinationDisplayAgent.h"
#import "MPCoreInstanceProvider.h"
#import "MPNativeAdError.h"
#import "MPLogging.h"
#import "MPNativeCache.h"
#import "MPNativeAdRendering.h"
#import "MPImageDownloadQueue.h"
#import "UIImageView+MPNativeAd.h"
#import "NSJSONSerialization+MPAdditions.h"

#define kImpressionTrackerURLsKey   @"imptracker"
#define kDefaultActionURLKey        @"clk"
#define kClickTrackerURLKey         @"clktracker"
#define kAdTitleKey                 @"title"
#define kAdTextKey                  @"text"
#define kAdIconImageKey             @"iconimage"
#define kAdMainImageKey             @"mainimage"
#define kAdCTATextKey               @"ctatext"

#define kRequiredSecondsForImpression   1.0

////////////////////////////////////////////////////////////////////////////////////////////////////

@interface MPNativeAd () <MPAdDestinationDisplayAgentDelegate>

@property (nonatomic, readwrite, retain) NSDictionary *properties;
@property (nonatomic, readwrite, retain) NSURL *defaultActionURL;
@property (nonatomic, retain) NSArray *impressionTrackers;
@property (nonatomic, retain) NSURL *engagementTrackingURL;
@property (nonatomic, retain) MPAdDestinationDisplayAgent *destinationDisplayAgent;
@property (nonatomic, assign) UIViewController *rootViewController;
@property (nonatomic, copy) void (^actionCompletionBlock)(BOOL, NSError *);
@property (nonatomic, assign) BOOL hasTrackedImpression;
@property (nonatomic, assign) BOOL hasTrackedClick;
@property (nonatomic, retain) NSMutableSet *managedImageViews;

@property (nonatomic, copy) NSString *adIdentifier;
@property (nonatomic, retain) UIView *associatedView;
@property (nonatomic, retain) NSTimer *associatedViewVisibilityTimer;
@property (nonatomic, assign) NSTimeInterval firstVisibilityTimestamp;
@property (nonatomic, assign) BOOL visible;
@property (nonatomic, retain) MPImageDownloadQueue *imageDownloadQueue;

@end

////////////////////////////////////////////////////////////////////////////////////////////////////

@implementation MPNativeAd

- (instancetype)initWithAdConfiguration:(MPAdConfiguration *)configuration
{
    static int sequenceNumber = 0;
    
    self = [super init];
    if (self) {
        BOOL valid = YES;
        NSError *error = nil;
        
        NSMutableDictionary *properties = [NSJSONSerialization mp_JSONObjectWithData:configuration.adResponseData options:NSJSONReadingMutableContainers clearNullObjects:YES error:nil];
        
        if (error) {
            MPLogDebug(@"JSON deserialization failed: %@", error);
            valid = NO;
        }
        
        NSArray *impressionTrackers = [properties objectForKey:kImpressionTrackerURLsKey];
        if (![impressionTrackers isKindOfClass:[NSArray class]] || [impressionTrackers count] < 1) {
            valid = NO;
        } else {
            _impressionTrackers = [impressionTrackers retain];
        }
        
        NSString *engagementTracker = [properties objectForKey:kClickTrackerURLKey];
        if (engagementTracker == nil) {
            valid = NO;
        } else {
            _engagementTrackingURL = [[NSURL URLWithString:engagementTracker] retain];
        }
        
        _defaultActionURL = [[NSURL URLWithString:[properties objectForKey:kDefaultActionURLKey]] retain];
        _destinationDisplayAgent = [[[MPCoreInstanceProvider sharedProvider] buildMPAdDestinationDisplayAgentWithDelegate:self] retain];
        
        [properties removeObjectsForKeys:[NSArray arrayWithObjects:kImpressionTrackerURLsKey, kClickTrackerURLKey, kDefaultActionURLKey, nil]];
        _properties = [properties retain];
        
        _adIdentifier = [[NSString stringWithFormat:@"%d", sequenceNumber++] copy];
        
        _firstVisibilityTimestamp = -1;
        
        _imageDownloadQueue = [[MPImageDownloadQueue alloc] init];
        
        _managedImageViews = [[NSMutableSet alloc] init];
        
        if (!valid) {
            [self release];
            return nil;
        }
    }
    return self;
}

- (void)dealloc
{
    _rootViewController = nil;
    [_properties release];
    [_defaultActionURL release];
    [_impressionTrackers release];
    [_engagementTrackingURL release];
    [_destinationDisplayAgent cancel];
    [_destinationDisplayAgent setDelegate:nil];
    [_destinationDisplayAgent release];
    [_actionCompletionBlock release];
    [_adIdentifier release];
    [_associatedView release];
    [_associatedViewVisibilityTimer invalidate];
    [_associatedViewVisibilityTimer release];
    [_imageDownloadQueue release];
    
    [self removeAssociatedObjectsFromManagedImageViews];
    [_managedImageViews release];
    
    [super dealloc];
}

- (void)removeAssociatedObjectsFromManagedImageViews
{
    for (UIImageView *imageView in _managedImageViews) {
        if ([imageView mp_nativeAd] == self) {
            [imageView mp_removeNativeAd];
        }
    }
}

#pragma mark - Public

- (void)trackImpression
{
    if (self.hasTrackedImpression) {
        MPLogDebug(@"Impression already tracked.");
        return;
    }
    
    MPLogDebug(@"Tracking an impression for %@.", self.adIdentifier);
    self.hasTrackedImpression = YES;
    for (NSString *URLString in self.impressionTrackers) {
        NSURL *URL = [NSURL URLWithString:URLString];
        if (URL) {
            [self trackMetricForURL:[NSURL URLWithString:URLString]];
        }
    }
}

- (void)trackClick
{
    if (self.hasTrackedClick) {
        return;
    }
    
    self.hasTrackedClick = YES;
    
    if (self.engagementTrackingURL) {
        [self trackMetricForURL:self.engagementTrackingURL];
    }
}

- (void)trackMetricForURL:(NSURL *)URL
{
    NSMutableURLRequest *request = [[MPCoreInstanceProvider sharedProvider] buildConfiguredURLRequestWithURL:URL];
    request.cachePolicy = NSURLRequestReloadIgnoringCacheData;
    [NSURLConnection connectionWithRequest:request delegate:nil];
}

- (void)performActionForURL:(NSURL *)URL completion:(void (^)(BOOL willLeaveApplication))completionBlock;
{
    if (URL) {
        [self trackClick];
        [self.destinationDisplayAgent displayDestinationForURL:URL];
    }
}

- (void)displayContentForURL:(NSURL *)URL rootViewController:(UIViewController *)controller
       completion:(void (^)(BOOL success, NSError *error))completionBlock
{
    NSError *error = nil;
    
    if (!controller) {
        NSDictionary *userInfo = [NSDictionary dictionaryWithObject:@"Cannot display content without a root view controller."
                                                             forKey:MPNativeAdErrorContentDisplayErrorReasonKey];
        error = [NSError errorWithDomain:MoPubNativeAdsSDKDomain
                                    code:MPNativeAdErrorContentDisplayError
                                userInfo:userInfo];
    }
    
    if (!URL || ![URL isKindOfClass:[NSURL class]] || ![URL.absoluteString length]) {
        NSDictionary *userInfo = [NSDictionary dictionaryWithObject:@"Cannot display content without a valid URL."
                                                             forKey:MPNativeAdErrorContentDisplayErrorReasonKey];
        error = [NSError errorWithDomain:MoPubNativeAdsSDKDomain
                                    code:MPNativeAdErrorContentDisplayError
                                userInfo:userInfo];
    }
    
    if (error) {
        completionBlock(NO, error);
        return;
    }
    
    self.rootViewController = controller;
    self.actionCompletionBlock = completionBlock;
    
    [self trackClick];
    [self.destinationDisplayAgent displayDestinationForURL:URL];
}

- (void)prepareForDisplayInView:(UIView *)view
{
    self.associatedView = view;
    
    if ([view conformsToProtocol:@protocol(MPNativeAdRendering)]) {
        [(id<MPNativeAdRendering>)view layoutAdAssets:self];
    }
    
    [self.associatedViewVisibilityTimer invalidate];
    self.associatedViewVisibilityTimer = [NSTimer timerWithTimeInterval:0.25 target:self selector:@selector(tick:) userInfo:nil repeats:YES];
    
    [[NSRunLoop currentRunLoop] addTimer:self.associatedViewVisibilityTimer forMode:NSRunLoopCommonModes];
}

- (void)tick:(NSTimer *)timer
{
    if ([self hasTrackedImpression]) {
        [self.associatedViewVisibilityTimer invalidate];
        self.associatedViewVisibilityTimer = nil;
    }
    
    [self setVisible:MPViewIsVisible(self.associatedView)];
}

#pragma mark - Rendering

- (void)loadIconIntoImageView:(UIImageView *)imageView
{
    NSURL *imageURL = [NSURL URLWithString:[self.properties objectForKey:kAdIconImageKey]];
    [self loadImageForURL:imageURL intoImageView:imageView];
}

- (void)loadImageIntoImageView:(UIImageView *)imageView
{
    NSURL *imageURL = [NSURL URLWithString:[self.properties objectForKey:kAdMainImageKey]];
    [self loadImageForURL:imageURL intoImageView:imageView];
}

- (void)loadTextIntoLabel:(UILabel *)label
{
    label.text = [self.properties objectForKey:kAdTextKey];
}

- (void)loadTitleIntoLabel:(UILabel *)label
{
    label.text = [self.properties objectForKey:kAdTitleKey];
}

- (void)loadCallToActionTextIntoLabel:(UILabel *)label
{
    label.text = [self.properties objectForKey:kAdCTATextKey];
}

- (void)loadCallToActionTextIntoButton:(UIButton *)button
{
    [button setTitle:[self.properties objectForKey:kAdCTATextKey] forState:UIControlStateNormal];
}

- (void)loadImageForURL:(NSURL *)imageURL intoImageView:(UIImageView *)imageView
{
    imageView.image = nil;
    [imageView mp_setNativeAd:self];
    [self.managedImageViews addObject:imageView];
    
    dispatch_async(dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_BACKGROUND, 0), ^{
        NSData *cachedImageData = [[MPNativeCache sharedCache] retrieveDataForKey:imageURL.absoluteString];
        UIImage *image = [UIImage imageWithData:cachedImageData];
        
        if (image) {
            [self safeMainQueueSetImage:image intoImageView:imageView];
        } else if (imageURL) {
            MPLogDebug(@"Cache miss on %@. Re-downloading...", imageURL);
            
            [self.imageDownloadQueue addDownloadImageURLs:@[imageURL]
                                          completionBlock:^(NSArray *errors) {
                                              if (errors.count == 0) {
                                                  UIImage *image = [UIImage imageWithData:[[MPNativeCache sharedCache] retrieveDataForKey:imageURL.absoluteString]];

                                                  [self safeMainQueueSetImage:image intoImageView:imageView];
                                              } else {
                                                  MPLogDebug(@"Failed to download %@ on cache miss. Giving up for now.", imageURL);
                                              }
                                          }];
        }
    });
}

#pragma mark - Internal

- (void)safeMainQueueSetImage:(UIImage *)image intoImageView:(UIImageView *)imageView
{
    dispatch_async(dispatch_get_main_queue(), ^{
        MPNativeAd *ad = [imageView mp_nativeAd];
        if (ad && ad != self) {
            MPLogDebug(@"Cell was recycled. Don't bother setting the image.");
            return;
        }
        
        if (image) {
            imageView.image = image;
        }
    });
}

- (void)setVisible:(BOOL)visible
{
    if (visible) {
        NSTimeInterval now = [[NSDate date] timeIntervalSinceReferenceDate];
        
        if (self.firstVisibilityTimestamp == -1) {
            self.firstVisibilityTimestamp = now;
        } else if (now - self.firstVisibilityTimestamp >= kRequiredSecondsForImpression) {
            self.firstVisibilityTimestamp = -1;
            [self trackImpression];
        }
    } else {
        self.firstVisibilityTimestamp = -1;
    }
}

#pragma mark - <MPAdDestinationDisplayAgent>

- (UIViewController *)viewControllerForPresentingModalView
{
    return self.rootViewController;
}

- (void)displayAgentWillPresentModal
{
    
}

- (void)displayAgentWillLeaveApplication
{
    self.actionCompletionBlock(YES, nil);
    self.actionCompletionBlock = nil;
}

- (void)displayAgentDidDismissModal
{
    self.actionCompletionBlock(YES, nil);
    self.actionCompletionBlock = nil;
    self.rootViewController = nil;
}

@end

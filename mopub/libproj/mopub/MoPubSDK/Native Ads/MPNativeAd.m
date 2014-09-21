//
//  MPNativeAd.m
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import "MPNativeAd+Internal.h"
#import "MPAdConfiguration.h"
#import "MPCoreInstanceProvider.h"
#import "MPNativeAdError.h"
#import "MPLogging.h"
#import "MPNativeCache.h"
#import "MPNativeAdRendering.h"
#import "MPImageDownloadQueue.h"
#import "UIView+MPNativeAd.h"
#import "NSJSONSerialization+MPAdditions.h"
#import "MPNativeCustomEvent.h"
#import "MPNativeAdAdapter.h"
#import "MPNativeAdConstants.h"
#import "MPTimer.h"

////////////////////////////////////////////////////////////////////////////////////////////////////

@interface MPNativeAd ()

@property (nonatomic, retain) NSDate *creationDate;

@property (nonatomic, retain) NSURL *engagementTrackingURL;
@property (nonatomic, retain) NSMutableSet *impressionTrackers;

@property (nonatomic, readonly, retain) id<MPNativeAdAdapter> adAdapter;
@property (nonatomic, assign) BOOL hasTrackedImpression;
@property (nonatomic, assign) BOOL hasTrackedClick;

@property (nonatomic, copy) NSString *adIdentifier;
@property (nonatomic, retain) UIView *associatedView;
@property (nonatomic, retain) MPTimer *associatedViewVisibilityTimer;
@property (nonatomic, assign) NSTimeInterval firstVisibilityTimestamp;
@property (nonatomic, assign) BOOL visible;

@property (nonatomic, retain) NSMutableSet *managedImageViews;
@property (nonatomic, retain) MPImageDownloadQueue *imageDownloadQueue;

@end

////////////////////////////////////////////////////////////////////////////////////////////////////

@implementation MPNativeAd

- (instancetype)initWithAdAdapter:(id<MPNativeAdAdapter>)adAdapter
{
    static int sequenceNumber = 0;

    self = [super init];
    if (self) {
        _adAdapter = [adAdapter retain];
        _adIdentifier = [[NSString stringWithFormat:@"%d", sequenceNumber++] copy];
        _firstVisibilityTimestamp = -1;
        _impressionTrackers = [[NSMutableSet alloc] init];
        _imageDownloadQueue = [[MPImageDownloadQueue alloc] init];
        _managedImageViews = [[NSMutableSet alloc] init];
        _creationDate = [[NSDate date] retain];
    }
    return self;
}

- (void)dealloc
{
    [_adAdapter release];
    [_impressionTrackers release];
    [_engagementTrackingURL release];
    [_adIdentifier release];
    [_associatedView mp_removeNativeAd];
    [_associatedView release];
    [_associatedViewVisibilityTimer invalidate];
    [_associatedViewVisibilityTimer release];
    [_imageDownloadQueue release];
    [_creationDate release];

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

- (NSNumber *)starRating
{
    NSNumber *starRatingNum = [self.properties objectForKey:kAdStarRatingKey];

    if (![starRatingNum isKindOfClass:[NSNumber class]] || starRatingNum.floatValue < kStarRatingMinValue || starRatingNum.floatValue > kStarRatingMaxValue) {
        starRatingNum = nil;
    }

    return starRatingNum;
}

- (NSDictionary *)properties
{
    return self.adAdapter.properties;
}

- (NSURL *)defaultActionURL
{
    return self.adAdapter.defaultActionURL;
}

- (NSTimeInterval)requiredSecondsForImpression
{
    if ([self.adAdapter respondsToSelector:@selector(requiredSecondsForImpression)]) {
        return self.adAdapter.requiredSecondsForImpression;
    }

    return kDefaultRequiredSecondsForImpression;
}

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
            [self trackMetricForURL:URL];
        }
    }

    if ([self.adAdapter respondsToSelector:@selector(trackImpression)]) {
        [self.adAdapter trackImpression];
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

    if ([self.adAdapter respondsToSelector:@selector(trackClick)]) {
        [self.adAdapter trackClick];
    }

}

- (void)trackMetricForURL:(NSURL *)URL
{
    NSMutableURLRequest *request = [[MPCoreInstanceProvider sharedProvider] buildConfiguredURLRequestWithURL:URL];
    request.cachePolicy = NSURLRequestReloadIgnoringCacheData;
    [NSURLConnection connectionWithRequest:request delegate:nil];
}

- (void)displayContentFromRootViewController:(UIViewController *)controller completion:(void (^)(BOOL, NSError *))completionBlock
{
    [self displayContentForURL:self.adAdapter.defaultActionURL rootViewController:controller completion:completionBlock];
}

- (void)displayContentForURL:(NSURL *)URL rootViewController:(UIViewController *)controller
       completion:(void (^)(BOOL success, NSError *error))completionBlock
{
    [self trackClick];
    [self.adAdapter displayContentForURL:URL rootViewController:controller completion:completionBlock];
}

- (void)prepareForDisplayInView:(UIView *)view
{
    // If the view already had a native ad, we need to detach the view from that ad.
    MPNativeAd *oldNativeAd = [view mp_nativeAd];
    [oldNativeAd detachFromAssociatedView];
    [view mp_setNativeAd:self];

    self.associatedView = view;

    if ([view conformsToProtocol:@protocol(MPNativeAdRendering)]) {
        [self willAttachToView:view];
        [(id<MPNativeAdRendering>)view layoutAdAssets:self];
    }

    [self.associatedViewVisibilityTimer invalidate];
    self.associatedViewVisibilityTimer = [MPTimer timerWithTimeInterval:0.25 target:self selector:@selector(tick:) repeats:YES];
    self.associatedViewVisibilityTimer.runLoopMode = NSRunLoopCommonModes;
    [self.associatedViewVisibilityTimer scheduleNow];
}

- (void)addImpressionTrackers:(NSArray *)trackers
{
    [self.impressionTrackers addObjectsFromArray:trackers];
}

- (void)tick:(NSTimer *)timer
{
    if ([self hasTrackedImpression]) {
        [self.associatedViewVisibilityTimer invalidate];
        self.associatedViewVisibilityTimer = nil;
    }

    [self setVisible:MPViewIsVisible(self.associatedView) && MPViewIntersectsApplicationWindowWithPercent(self.associatedView, (CGFloat)0.5)];
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
        __block BOOL imageViewWasRecycled = NO;

        // Try to prevent unnecessary work if the imageview has already been recycled.
        // Note that this doesn't prevent 100% of the cases as the imageview can still be recycled after this passes.
        // We have an additional 100% accurate check in safeMainQueueSetImage to ensure that we don't overwrite.
        dispatch_sync(dispatch_get_main_queue(), ^{
            imageViewWasRecycled = ![self isCurrentAdForImageView:imageView];
        });

        if (imageViewWasRecycled) {
            MPLogDebug(@"Cell was recycled. Don't bother rendering the image.");
            return;
        }

        NSData *cachedImageData = [[MPNativeCache sharedCache] retrieveDataForKey:imageURL.absoluteString];
        UIImage *image = [UIImage imageWithData:cachedImageData];

        if (image) {
            // By default, the image data isn't decompressed until set on a UIImageView, on the main thread. This
            // can result in poor scrolling performance. To fix this, we force decompression in the background before
            // assignment to a UIImageView.
            UIGraphicsBeginImageContext(CGSizeMake(1, 1));
            [image drawAtPoint:CGPointZero];
            UIGraphicsEndImageContext();

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

- (BOOL)isCurrentAdForImageView:(UIImageView *)imageView
{
    MPNativeAd *ad = [imageView mp_nativeAd];
    return ad == self;
}

- (void)willAttachToView:(UIView *)view
{
    if ([self.adAdapter respondsToSelector:@selector(willAttachToView:)]) {
        [self.adAdapter willAttachToView:view];
    }
}

- (void)detachFromAssociatedView
{
    self.associatedView = nil;
}

- (void)safeMainQueueSetImage:(UIImage *)image intoImageView:(UIImageView *)imageView
{
    dispatch_async(dispatch_get_main_queue(), ^{
        if (![self isCurrentAdForImageView:imageView]) {
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
        } else if (now - self.firstVisibilityTimestamp >= self.requiredSecondsForImpression) {
            self.firstVisibilityTimestamp = -1;
            [self trackImpression];
        }
    } else {
        self.firstVisibilityTimestamp = -1;
    }
}

@end

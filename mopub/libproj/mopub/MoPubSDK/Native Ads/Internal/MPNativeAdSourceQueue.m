//
//  MPNativeAdSourceQueue.m
//  MoPub
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import "MPNativeAdSourceQueue.h"
#import "MPNativeAd+Internal.h"
#import "MPNativeAdRequestTargeting.h"
#import "MPNativeAdRequest+MPNativeAdSource.h"
#import "MPLogging.h"
#import "MPNativeAdError.h"

static NSUInteger const kCacheSizeLimit = 3;
static NSTimeInterval const kMaxBackoffTimeInterval = 300;
static CGFloat const kBaseBackoffTimeMultiplier = 1.5;

@interface MPNativeAdSourceQueue ()

@property (nonatomic, strong) NSMutableArray *adQueue;
@property (nonatomic, assign) NSUInteger backoffCounter;
@property (nonatomic, copy) NSString *adUnitIdentifier;
@property (nonatomic, strong) MPNativeAdRequestTargeting *targeting;
@property (nonatomic, assign) BOOL isAdLoading;

@end

@implementation MPNativeAdSourceQueue

#pragma mark - Object Lifecycle

- (instancetype)initWithAdUnitIdentifier:(NSString *)identifier andTargeting:(MPNativeAdRequestTargeting *)targeting
{
    self = [super init];
    if (self) {
        _adUnitIdentifier = [identifier copy];
        _targeting = targeting;
        _adQueue = [[NSMutableArray alloc] init];
    }
    return self;
}


#pragma mark - Public Methods

- (MPNativeAd *)dequeueAd
{
    MPNativeAd *nextAd = [self.adQueue firstObject];
    [self.adQueue removeObject:nextAd];
    [self loadAds];
    return nextAd;
}

- (MPNativeAd *)dequeueAdWithMaxAge:(NSTimeInterval)age
{
    MPNativeAd *nextAd = [self dequeueAd];

    while (nextAd && ![self isAdAgeValid:nextAd withMaxAge:age]) {
        nextAd = [self dequeueAd];
    }

    return nextAd;
}

- (void)addNativeAd:(MPNativeAd *)nativeAd
{
    [self.adQueue addObject:nativeAd];
}

- (NSUInteger)count
{
    return [self.adQueue count];
}

- (void)cancelRequests
{
    [self resetBackoff];
}

#pragma mark - Internal Logic

- (BOOL)isAdAgeValid:(MPNativeAd *)ad withMaxAge:(NSTimeInterval)maxAge
{
    NSTimeInterval adAge = [ad.creationDate timeIntervalSinceNow];

    return abs(adAge) < maxAge;
}

#pragma mark - Ad Requests

- (void)resetBackoff
{
    [NSObject cancelPreviousPerformRequestsWithTarget:self];
    self.backoffCounter = 0;
}

- (void)loadAds
{
    if (self.backoffCounter == 0) {
        [self replenishCache];
    }
}

- (void)replenishCache
{
    if ([self count] >= kCacheSizeLimit || self.isAdLoading) {
        return;
    }

    self.isAdLoading = YES;
    MPNativeAdRequest *adRequest = [MPNativeAdRequest requestWithAdUnitIdentifier:self.adUnitIdentifier];
    adRequest.targeting = self.targeting;

    [adRequest startForAdSequence:self.currentSequence withCompletionHandler:^(MPNativeAdRequest *request, MPNativeAd *response, NSError *error) {
        if (response && !error) {
            self.backoffCounter = 0;

            [self addNativeAd:response];
            self.currentSequence++;
            if ([self count] == 1) {
                [self.delegate adSourceQueueAdIsAvailable:self];
            }
        } else {
            MPLogDebug(@"%@", error);
            //increment in this failure case to prevent retrying a request that wasn't bid on.
            //currently under discussion on whether we do this or not.
            if (error.code == MPNativeAdErrorNoInventory) {
                self.currentSequence++;
            }

            NSTimeInterval backoffTime = [self backoffTime];
            self.backoffCounter++;
            if (backoffTime < kMaxBackoffTimeInterval) {
                [self performSelector:@selector(replenishCache) withObject:nil afterDelay:backoffTime];
                MPLogDebug(@"Scheduled the backoff to try again in %.1f seconds.", backoffTime);
            } else {
                MPLogDebug(@"Backoff has timed out", backoffTime);
                self.backoffCounter = 0;
            }
        }
        self.isAdLoading = NO;
        [self loadAds];
    }];
}

- (NSTimeInterval)backoffTime
{
    NSTimeInterval timeInterval = 0;
    if (self.backoffCounter > 0) {
        timeInterval = powf(kBaseBackoffTimeMultiplier, self.backoffCounter - 1);
    }
    return timeInterval;
}



@end

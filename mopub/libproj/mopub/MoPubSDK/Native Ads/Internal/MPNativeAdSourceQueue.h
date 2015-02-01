//
//  MPNativeAdSourceQueue.h
//  MoPub
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import <Foundation/Foundation.h>
@class MPNativeAdRequestTargeting;
@class MPNativeAd;

@protocol MPNativeAdSourceQueueDelegate;

@interface MPNativeAdSourceQueue : NSObject

@property (nonatomic, weak) id <MPNativeAdSourceQueueDelegate> delegate;
@property (nonatomic, assign) NSUInteger currentSequence;


- (instancetype)initWithAdUnitIdentifier:(NSString *)identifier andTargeting:(MPNativeAdRequestTargeting *)targeting;
- (MPNativeAd *)dequeueAdWithMaxAge:(NSTimeInterval)age;
- (NSUInteger)count;
- (void)loadAds;
- (void)cancelRequests;

@end

@protocol MPNativeAdSourceQueueDelegate <NSObject>

- (void)adSourceQueueAdIsAvailable:(MPNativeAdSourceQueue *)source;

@end

//
//  MPNativeAdSource.h
//  MoPub
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "MPNativeAdSourceDelegate.h"
@class MPNativeAdRequestTargeting;

@interface MPNativeAdSource : NSObject

@property (nonatomic, assign) id <MPNativeAdSourceDelegate> delegate;

+ (instancetype)source;
- (void)loadAdsWithAdUnitIdentifier:(NSString *)identifier andTargeting:(MPNativeAdRequestTargeting *)targeting;
- (void)deleteCacheForAdUnitIdentifier:(NSString *)identifier;
- (id)dequeueAdForAdUnitIdentifier:(NSString *)identifier;


@end

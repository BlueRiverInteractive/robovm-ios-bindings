//
//  MPMoPubNativeAdAdapter.h
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import "MPNativeAdAdapter.h"

@interface MPMoPubNativeAdAdapter : NSObject <MPNativeAdAdapter>

@property (nonatomic, strong) NSArray *impressionTrackers;
@property (nonatomic, strong) NSURL *engagementTrackingURL;

- (instancetype)initWithAdProperties:(NSMutableDictionary *)properties;

@end

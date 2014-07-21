//
//  MPMoPubNativeAdAdapter.h
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import "MPNativeAdAdapter.h"

@interface MPMoPubNativeAdAdapter : NSObject <MPNativeAdAdapter>

@property (nonatomic, retain) NSArray *impressionTrackers;
@property (nonatomic, retain) NSURL *engagementTrackingURL;

- (instancetype)initWithAdProperties:(NSMutableDictionary *)properties;

@end

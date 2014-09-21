//
//  MPNativeAd+Internal.h
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import "MPNativeAd.h"

@interface MPNativeAd (Internal)

@property (nonatomic, readonly) NSDate *creationDate;

- (NSTimeInterval)requiredSecondsForImpression;
- (void)willAttachToView:(UIView *)view;
- (void)setVisible:(BOOL)visible;
- (NSMutableSet *)impressionTrackers;
- (NSURL *)engagementTrackingURL;

- (void)setEngagementTrackingURL:(NSURL *)engagementTrackingURL;

@end

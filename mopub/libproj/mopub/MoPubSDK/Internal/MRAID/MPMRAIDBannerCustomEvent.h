//
//  MPMRAIDBannerCustomEvent.h
//  MoPub
//
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import "MPBannerCustomEvent.h"
#import "MPPrivateBannerCustomEventDelegate.h"

@interface MPMRAIDBannerCustomEvent : MPBannerCustomEvent

@property (nonatomic, weak) id<MPPrivateBannerCustomEventDelegate> delegate;

@end

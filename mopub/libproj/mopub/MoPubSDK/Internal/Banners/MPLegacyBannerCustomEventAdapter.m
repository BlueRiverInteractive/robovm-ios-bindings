//
//  MPLegacyBannerCustomEventAdapter.m
//  MoPub
//
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import "MPLegacyBannerCustomEventAdapter.h"
#import "MPAdConfiguration.h"
#import "MPLogging.h"
#import "MPInternalUtils.h"

@implementation MPLegacyBannerCustomEventAdapter

- (void)getAdWithConfiguration:(MPAdConfiguration *)configuration containerSize:(CGSize)size
{
    MPLogInfo(@"Looking for custom event selector named %@.", configuration.customSelectorName);

    SEL customEventSelector = NSSelectorFromString(configuration.customSelectorName);
    if ([self.delegate.bannerDelegate respondsToSelector:customEventSelector]) {
        SUPPRESS_PERFORM_SELECTOR_LEAK_WARNING(
            [self.delegate.bannerDelegate performSelector:customEventSelector withObject:nil]
        );
        return;
    }

    NSString *oneArgumentSelectorName = [configuration.customSelectorName
                                         stringByAppendingString:@":"];

    MPLogInfo(@"Looking for custom event selector named %@.", oneArgumentSelectorName);

    SEL customEventOneArgumentSelector = NSSelectorFromString(oneArgumentSelectorName);
    if ([self.delegate.bannerDelegate respondsToSelector:customEventOneArgumentSelector]) {
        SUPPRESS_PERFORM_SELECTOR_LEAK_WARNING(
            [self.delegate.bannerDelegate performSelector:customEventOneArgumentSelector withObject:self.delegate.banner]
        );
        return;
    }

    [self.delegate adapter:self didFailToLoadAdWithError:nil];
}

- (void)startTimeoutTimer
{
    // Override to do nothing as we don't want to time out these legacy custom events.
}

@end

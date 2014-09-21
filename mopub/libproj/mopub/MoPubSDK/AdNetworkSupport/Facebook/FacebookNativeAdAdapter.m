//
//  FacebookNativeAdAdapter.m
//  MoPub
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import "FBAudienceNetwork.h"
#import "FacebookNativeAdAdapter.h"
#import "MPNativeAdConstants.h"
#import "MPNativeAdError.h"

@interface FacebookNativeAdAdapter ()

@property (nonatomic, readonly, retain) FBNativeAd *fbNativeAd;

@end

@implementation FacebookNativeAdAdapter

@synthesize properties = _properties;

- (instancetype)initWithFBNativeAd:(FBNativeAd *)fbNativeAd
{
    if (self = [super init]) {
        _fbNativeAd = [fbNativeAd retain];

        NSNumber *starRating = nil;

        // Normalize star rating to 5 stars.
        if (fbNativeAd.starRating.scale != 0) {
            CGFloat ratio = 0.0f;
            ratio = kUniversalStarRatingScale/fbNativeAd.starRating.scale;
            starRating = [NSNumber numberWithFloat:ratio*fbNativeAd.starRating.value];
        }

        NSMutableDictionary *properties = [NSMutableDictionary dictionary];

        if (starRating) {
            [properties setObject:starRating forKey:kAdStarRatingKey];
        }

        if (fbNativeAd.title) {
            [properties setObject:fbNativeAd.title forKey:kAdTitleKey];
        }

        if (fbNativeAd.body) {
            [properties setObject:fbNativeAd.body forKey:kAdTextKey];
        }

        if (fbNativeAd.callToAction) {
            [properties setObject:fbNativeAd.callToAction forKey:kAdCTATextKey];
        }

        if (fbNativeAd.icon.url.absoluteString) {
            [properties setObject:fbNativeAd.icon.url.absoluteString forKey:kAdIconImageKey];
        }

        if (fbNativeAd.coverImage.url.absoluteString) {
            [properties setObject:fbNativeAd.coverImage.url.absoluteString forKey:kAdMainImageKey];
        }

        if (fbNativeAd.placementID) {
            [properties setObject:fbNativeAd.placementID forKey:@"placementID"];
        }

        if (fbNativeAd.socialContext) {
            [properties setObject:fbNativeAd.socialContext forKey:@"socialContext"];
        }

        _properties = [properties retain];
    }

    return self;
}

- (void)dealloc
{
    [_fbNativeAd release];
    [_properties release];

    [super dealloc];
}

#pragma mark - MPNativeAdAdapter

- (NSTimeInterval)requiredSecondsForImpression
{
    return 0.0;
}

- (NSURL *)defaultActionURL
{
    return nil;
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

        if (completionBlock) {
            completionBlock(NO, error);
        }

        return;
    }

    [self.fbNativeAd handleClickWithViewController:controller
                                        callback:^(FBNativeAd *nativeAd) {
                                            if (completionBlock) {
                                                completionBlock(YES, nil);
                                            }
                                        }];
}

- (void)trackImpression
{
    [self.fbNativeAd logImpression];
}

@end

//
//  InMobiNativeAdAdapter.m
//  MoPub
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import "InMobiNativeAdAdapter.h"
#import "IMNative.h"
#import "MPNativeAdError.h"
#import "MPNativeAdConstants.h"
#import "MPAdDestinationDisplayAgent.h"
#import "MPCoreInstanceProvider.h"

/*
 * Default keys for InMobi Native Ads
 *
 * These values must correspond to the strings configured with InMobi.
 */
static NSString *const kInMobiTitle = @"title";
static NSString *const kInMobiDescription = @"description";
static NSString *const kInMobiCallToAction = @"cta";
static NSString *const kInMobiRating = @"rating";
static NSString *const kInMobiScreenshot = @"screenshots";
static NSString *const kInMobiIcon = @"icon";
// As of 6-25-2014 this key is editable on InMobi's site
static NSString *const kInMobiActionURL = @"landing_url";

/*
 * InMobi Keys - Do Not Change.
 */
static NSString *const kInMobiImageURL = @"url";

@interface InMobiNativeAdAdapter() <MPAdDestinationDisplayAgentDelegate>

@property (nonatomic, readonly, retain) IMNative *inMobiNativeAd;

@property (nonatomic, readonly, retain) MPAdDestinationDisplayAgent *destinationDisplayAgent;
@property (nonatomic, assign) UIViewController *rootViewController;
@property (nonatomic, copy) void (^actionCompletionBlock)(BOOL, NSError *);

@end

@implementation InMobiNativeAdAdapter

@synthesize properties = _properties;
@synthesize defaultActionURL = _defaultActionURL;

- (instancetype)initWithInMobiNativeAd:(IMNative *)nativeAd
{
    self = [super init];
    if (self) {
        _inMobiNativeAd = [nativeAd retain];

        NSDictionary *inMobiProperties = [self inMobiProperties];
        NSMutableDictionary *properties = [NSMutableDictionary dictionary];

        if ([inMobiProperties objectForKey:kInMobiRating]) {
            [properties setObject:[inMobiProperties objectForKey:kInMobiRating] forKey:kAdStarRatingKey];
        }

        if ([[inMobiProperties objectForKey:kInMobiTitle] length]) {
            [properties setObject:[inMobiProperties objectForKey:kInMobiTitle] forKey:kAdTitleKey];
        }

        if ([[inMobiProperties objectForKey:kInMobiDescription] length]) {
            [properties setObject:[inMobiProperties objectForKey:kInMobiDescription] forKey:kAdTextKey];
        }

        if ([[inMobiProperties objectForKey:kInMobiCallToAction] length]) {
            [properties setObject:[inMobiProperties objectForKey:kInMobiCallToAction] forKey:kAdCTATextKey];
        }

        NSDictionary *iconDictionary = [inMobiProperties objectForKey:kInMobiIcon];

        if ([[iconDictionary objectForKey:kInMobiImageURL] length]) {
            [properties setObject:[iconDictionary objectForKey:kInMobiImageURL] forKey:kAdIconImageKey];
        }

        NSDictionary *mainImageDictionary = [inMobiProperties objectForKey:kInMobiScreenshot];

        if ([[mainImageDictionary objectForKey:kInMobiImageURL] length]) {
            [properties setObject:[mainImageDictionary objectForKey:kInMobiImageURL] forKey:kAdMainImageKey];
        }

        _properties = [properties retain];

        if ([[inMobiProperties objectForKey:kInMobiActionURL] length]) {
            _defaultActionURL = [[NSURL URLWithString:[inMobiProperties objectForKey:kInMobiActionURL]] retain];
        }

        _destinationDisplayAgent = [[[MPCoreInstanceProvider sharedProvider] buildMPAdDestinationDisplayAgentWithDelegate:self] retain];
    }
    return self;
}

- (void)dealloc
{
    [_actionCompletionBlock release];
    [_destinationDisplayAgent cancel];
    [_destinationDisplayAgent setDelegate:nil];
    [_destinationDisplayAgent release];

    [_inMobiNativeAd release];
    [_defaultActionURL release];
    [_properties release];

    [super dealloc];
}

- (NSDictionary *)inMobiProperties
{
    NSData *data = [self.inMobiNativeAd.content dataUsingEncoding:NSUTF8StringEncoding];
    NSError* error = nil;
    NSDictionary *propertyDictionary = nil;
    if (data) {
        propertyDictionary = [NSJSONSerialization JSONObjectWithData:data options:kNilOptions error:&error];
    }
    if (propertyDictionary && !error) {
        return propertyDictionary;
    }
    else {
        return nil;
    }
}

#pragma mark - MPNativeAdAdapter

- (NSTimeInterval)requiredSecondsForImpression
{
    return 0.0;
}

- (void)willAttachToView:(UIView *)view
{
    [self.inMobiNativeAd attachToView:view];
}

- (void)trackClick
{
    [self.inMobiNativeAd handleClick:nil];
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
    }

    if (!URL || ![URL isKindOfClass:[NSURL class]] || ![URL.absoluteString length]) {
        NSDictionary *userInfo = [NSDictionary dictionaryWithObject:@"Cannot display content without a valid URL."
                                                             forKey:MPNativeAdErrorContentDisplayErrorReasonKey];
        error = [NSError errorWithDomain:MoPubNativeAdsSDKDomain
                                    code:MPNativeAdErrorContentDisplayError
                                userInfo:userInfo];
    }

    if (error) {

        if (completionBlock) {
            completionBlock(NO, error);
        }
        return;
    }

    self.rootViewController = controller;
    self.actionCompletionBlock = completionBlock;

    [self.destinationDisplayAgent displayDestinationForURL:URL];
}

#pragma mark - <MPAdDestinationDisplayAgent>

- (UIViewController *)viewControllerForPresentingModalView
{
    return self.rootViewController;
}

- (void)displayAgentWillPresentModal
{

}

- (void)displayAgentWillLeaveApplication
{
    if (self.actionCompletionBlock) {
        self.actionCompletionBlock(YES, nil);
        self.actionCompletionBlock = nil;
    }
}

- (void)displayAgentDidDismissModal
{
    if (self.actionCompletionBlock) {
        self.actionCompletionBlock(YES, nil);
        self.actionCompletionBlock = nil;
    }
    self.rootViewController = nil;
}


@end

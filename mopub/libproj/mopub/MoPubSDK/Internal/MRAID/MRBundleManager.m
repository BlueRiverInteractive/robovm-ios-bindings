//
//  MRBundleManager.m
//  MoPub
//
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import "MRBundleManager.h"

@implementation MRBundleManager

static MRBundleManager *sharedManager = nil;

+ (MRBundleManager *)sharedManager
{
    if (!sharedManager) {
        sharedManager = [[MRBundleManager alloc] init];
    }
    return sharedManager;
}

- (NSString *)mraidPath
{
    NSBundle *parentBundle = [NSBundle mainBundle];

#ifdef MP_FABRIC
    // If we're in Fabric, all resources live inside MoPub.bundle.
    NSString *parentBundlePath = [[NSBundle mainBundle] pathForResource:@"MoPub" ofType:@"bundle"];
    parentBundle = [NSBundle bundleWithPath:parentBundlePath];
#endif

    NSString *mraidBundlePath = [parentBundle pathForResource:@"MRAID" ofType:@"bundle"];
    NSBundle *mraidBundle = [NSBundle bundleWithPath:mraidBundlePath];
    return [mraidBundle pathForResource:@"mraid" ofType:@"js"];
}

@end

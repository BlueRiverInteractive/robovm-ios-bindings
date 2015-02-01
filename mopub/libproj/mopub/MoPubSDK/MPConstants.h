//
//  MPConstants.h
//  MoPub
//
//  Copyright 2011 MoPub, Inc. All rights reserved.
//

#import <UIKit/UIKit.h>

#define MP_DEBUG_MODE               1

#define HOSTNAME                    @"ads.mopub.com"
#define HOSTNAME_FOR_TESTING        @"testing.ads.mopub.com"
#define DEFAULT_PUB_ID              @"agltb3B1Yi1pbmNyDAsSBFNpdGUYkaoMDA"
#define MP_SERVER_VERSION           @"8"
#define MP_BUNDLE_IDENTIFIER        @"com.mopub.mopub"

#ifdef MP_FABRIC
    #define MP_SDK_VERSION              @"3.4.0+kit"
#else
    #define MP_SDK_VERSION              @"3.4.0"
#endif

// Sizing constants.
extern CGSize const MOPUB_BANNER_SIZE;
extern CGSize const MOPUB_MEDIUM_RECT_SIZE;
extern CGSize const MOPUB_LEADERBOARD_SIZE;
extern CGSize const MOPUB_WIDE_SKYSCRAPER_SIZE;

// Miscellaneous constants.
#define MINIMUM_REFRESH_INTERVAL            5.0
#define DEFAULT_BANNER_REFRESH_INTERVAL     60
#define BANNER_TIMEOUT_INTERVAL             10
#define INTERSTITIAL_TIMEOUT_INTERVAL       30

// Feature Flags
#define SESSION_TRACKING_ENABLED            1

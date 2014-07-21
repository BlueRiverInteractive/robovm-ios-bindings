//
//  IMConstants.h
//  InMobi Monetization SDK
//
//  Copyright (c) 2013 InMobi. All rights reserved.
//



#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>

/**
 * Console log levels
 */
typedef enum {
    // No logs.
    IMLogLevelNone      = 0,

    // Minimal set of logs for debugging.
    IMLogLevelDebug     = 1,

    // Log everything
    // @note: Please turn off verbose mode before wide distribution like
    // AppStore. Keeping the verbose mode turned on might impact performance.
    IMLogLevelVerbose   = 2,
} IMLogLevel;

/**
 * Device Id collection masks
 */
typedef enum {
    // Use default ids for sdk device id collection. (default)
    IMDeviceIdMaskIncludeDefaultIds = 0,

    // Exclude odin1 identifier from sdk device id collection.
    IMDeviceIdMaskExcludeODIN1 = 1<<0,

    // Exclude advertiser identifier from sdk device id collection. (iOS 6+)
    IMDeviceIdMaskExcludeAdvertisingId = 1<<1,

    // Exclude vendor identifier from sdk device id collection. (iOS 6+)
    IMDeviceIdMaskExcludeVendorId = 1<<2,

    // @deprecated
    // @note: This flag is deprecated as sdk does not collect UDID any more.
    //        Exclude udid identifier from sdk device id collection.
    IMDeviceIdMaskExcludeUDID = 1<<3,

    // Exclude facebook's attribution id from sdk device id collection.
    IMDeviceIdMaskExcludeFacebookAttributionId = 1<<4,
} IMDeviceIdMask;

/**
 * User ids to help deliver more relevant ads.
 */
typedef enum {
    // User login id such as facebook, twitter, etc.
    kIMUserIdLogin,

    // For maintaining different sessions within the same login id.
    kIMUserIdSession,
} IMUserId;

/**
 * User Gender
 */
typedef enum {
    kIMGenderMale = 1,
    kIMGenderFemale,
    kIMGenderUnknown,
} IMGender;

/**
 * User Ethnicity
 */
typedef enum {
    kIMEthnicityHispanic = 1,
    kIMEthnicityCaucasian,
    kIMEthnicityAsian,
    kIMEthnicityAfricanAmerican,
    kIMEthnicityOther,
    kIMEthnicityUnknown,
} IMEthnicity;

/**
 * User Education
 */
typedef enum {
    kIMEducationHighSchoolOrLess = 1,
    kIMEducationCollegeOrGraduate,
    kIMEducationPostGraduateOrAbove,
    kIMEducationUnknown,
} IMEducation;

/**
 * Different Interstitial states
 */
typedef enum {
    // The state of interstitial cannot be determined.
    kIMInterstitialStateUnknown = 0,

    // The default state of an interstitial.
    // If an interstitial ad request fails, or if the user dismisses the
    // interstitial, the state will be changed back to init.
	kIMInterstitialStateInit,

    // Indicates that an interstitial ad request is in progress.
    kIMInterstitialStateLoading,

    // Indicates that an interstitial ad is ready to be displayed.
    // An interstitial ad can be displayed only if the state is ready.
    // You can call presentFromRootViewController: to display this ad.
    kIMInterstitialStateReady,

    // Indicates that an interstitial ad is displayed on the user's screen.
    kIMInterstitialStateActive

} IMInterstitialState;

/**
 * Interstitial ad mode
 */
typedef enum  {
    // Interstitial for AdNetwork.
    IMAdModeNetwork,

    // Interstitial for App Gallery.
    IMAdModeAppGallery
} IMAdMode;

/**
 * User HasChildren
 */
typedef enum {
    kIMHasChildrenTrue = 1,
    kIMHasChildrenFalse,
    kIMHasChildrenUnknown,
} IMHasChildren;

/**
 * User Marital Status
 */
typedef enum {
    kIMMaritalStatusSingle = 1,
    kIMMaritalStatusDivorced,
    kIMMaritalStatusEngaged,
    kIMMaritalStatusRelationship,
    kIMMaritalStatusUnknown,
} IMMaritalStatus;

/**
 * User Sexual Orientation
 */
typedef enum {
    kIMSexualOrientationStraight = 1,
    kIMSexualOrientationBisexual,
    kIMSexualOrientationGay,
    kIMSexualOrientationUnknown,
} IMSexualOrientation;



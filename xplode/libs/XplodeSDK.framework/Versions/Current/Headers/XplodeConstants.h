//  Copyright (c) 2014 Iddiction, Inc. All rights reserved.

#import <Foundation/Foundation.h>

/*!
 Promotion docking position. Can be bottom (default) or top.
 */
typedef NS_ENUM(u_int32_t, XPLPromotionDockingPosition) {
	/*! Dock at the bottom of the screen. */
	XPLPromotionDockingPositionBottom = 0,
	/*! Dock at the top of the screen. */
	XPLPromotionDockingPositionTop
};

/*!
 Dimensions of the promotion dock (SW - Screen Width):
 
 | Orientation | Default   | iAd       | IAB       |
 |-------------|:---------:|:---------:|:---------:|
 | Portrait    | SW x 35pt | SW x 50pt | SW x 50pt |
 | Landscape   | SW x 35pt | SW x 32pt | SW x 50pt |
 */
typedef NS_ENUM(u_int64_t, XPLPromotionDockDimensions) {
	/*! Xplode defaults. */
	XPLPromotionDockDimensionsDefault = 0,
	/*! Apple iAD dimensions. */
	XPLPromotionDockDimensionsIAd,
	/*! IAB Smartphone Static Wide Banner dimensions. */
	XPLPromotionDockDimensionsIAB
};


/* Notifications */
extern NSString *const XPLPromotionWillOpenNotification;
extern NSString *const XPLPromotionDidOpenNotification;
extern NSString *const XPLPromotionWillCloseNotification;
extern NSString *const XPLPromotionDidCloseNotification;
extern NSString *const XPLPromotionWillLoadNotification;
extern NSString *const XPLPromotionDidLoadNotification;
extern NSString *const XPLPromotionDidFailLoadingNotification;
extern NSString *const XPLPromotionWillShowDockNotification;
extern NSString *const XPLPromotionDidShowDockNotification;
extern NSString *const XPLPromotionWillHideDockNotification;
extern NSString *const XPLPromotionDidHideDockNotification;

extern NSString *const XPLPromotionDidClickNotification;

extern NSString *const XPLPromotionDidStartPlaybackNotification;
extern NSString *const XPLPromotionDidAbortPlaybackNotification;
extern NSString *const XPLPromotionDidFinishPlaybackNotification;

/* Notification Keys */
extern NSString *const XPLPromotionNotificationBreakpointKey;
extern NSString *const XPLPromotionNotificationIsReadyToPresentKey;


//
//  MPNativeAdRendering.h
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import <Foundation/Foundation.h>

#import "MPNativeAd.h"

/**
 * The MPNativeAdRendering protocol provides methods for displaying ad content in
 * custom view classes.
 */

@protocol MPNativeAdRendering <NSObject>

/**
 * Populates a view's relevant subviews with ad content.
 *
 * Your implementation of this method should call one or more of the methods listed below.
 *
 * @param adObject An object containing ad assets (text, images) which may be loaded
 * into appropriate subviews (UILabel, UIImageView) via convenience methods.
 * @see [MPNativeAd loadTextIntoLabel:]
 * @see [MPNativeAd loadTitleIntoLabel:]
 * @see [MPNativeAd loadIconIntoImageView:]
 * @see [MPNativeAd loadImageIntoImageView:]
 * @see [MPNativeAd loadCallToActionTextIntoLabel:]
 * @see [MPNativeAd loadCallToActionTextIntoButton:]
 * @see [MPNativeAd loadImageForURL:intoImageView:]
 */
- (void)layoutAdAssets:(MPNativeAd *)adObject;

@end

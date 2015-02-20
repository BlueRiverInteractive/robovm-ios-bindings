//
//  XplodePromotionDelegate.h
//  XplodeSDK
//
//  Created by Jure Lajlar on 21/11/14.
//  Copyright (c) 2014 Iddiction, Inc. All rights reserved.
//

#import <Foundation/Foundation.h>

@protocol XplodePromotionDelegate <NSObject>

@optional

//	Promotions

/// @brief A promotion is about to open.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionWillOpenForBreakpoint:(NSString *)breakpoint;

/// @brief A promotion's opening animation has finished.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidOpenForBreakpoint:(NSString *)breakpoint;

/// @brief A promotion is about to close.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionWillCloseForBreakpoint:(NSString *)breakpoint;

/// @brief A promotion's closing animation has finished.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidCloseForBreakpoint:(NSString *)breakpoint;

/// @brief A promotion will start loading.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionWillLoadForBreakpoint:(NSString *)breakpoint;

/// @brief A promotion finished loading.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidLoadForBreakpoint:(NSString *)breakpoint  __attribute__((deprecated(" Since Xplode SDK v2.4.1. Use promotionDidLoadForBreakpoint:isReadyToPresent: for better promotion handling.")));

/// @brief A promotion finished loading.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidLoadForBreakpoint:(NSString *)breakpoint isReadyToPresent:(BOOL)isReadyToPresent;

/// @brief A promotion failed to load.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidFailLoadingForBreakpoint:(NSString *)breakpoint;

/// @brief A promotion will show the dock.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionWillShowDockForBreakpoint:(NSString *)breakpoint;

/// @brief A promotion did show the dock.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidShowDockForBreakpoint:(NSString *)breakpoint;

/// @brief A promotion will hide the dock.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionWillHideDockForBreakpoint:(NSString *)breakpoint;

/// @brief A promotion did hide the dock.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidHideDockForBreakpoint:(NSString *)breakpoint;

/// @brief A video promotion did start playing.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidStartPlaybackForBreakpoint:(NSString *)breakpoint;

/// @brief A video promotion got canceled or aborted.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidAbortPlaybackForBreakpoint:(NSString *)breakpoint;

/// @brief A video promotion finishes playing.
///
/// @param	breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidFinishPlaybackForBreakpoint:(NSString *)breakpoint;

///	@brief The promotion action has been triggered.
///
///	@param breakpoint	The breakpoint of the promotion which caused this method to be called.
- (void)promotionDidClickForBreakpoint:(NSString *)breakpoint;


@end

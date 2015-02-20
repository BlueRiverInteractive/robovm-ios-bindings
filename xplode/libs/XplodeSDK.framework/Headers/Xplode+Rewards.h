//
//  Xplode+Rewards.h
//  XplodeSDK
//
//  Copyright (c) 2015 Iddiction, Inc. All rights reserved.
//

#import "Xplode.h"
#import "XPLReward.h"

@interface Xplode (Rewards)

/// To provide custom UI for sharing affiliate links, use this method. Before using it, configure breakpoint with rewarded content on the Xplode portal.
/// @param breakpoint			The name of the breakpoint configured with the rewarded content
/// @param completionHandler	A block that is executed when the shareLink is loaded from the server. Parameter shareLink may be nil if rewarded content is not configured or if an error occurs while downloading content
+ (void)affiliateLinkForBreakpoint:(NSString *)breakpoint withCompletionHandler:(void (^)(NSURL *shareLink))completionHandler;

/// Call this method to load all awailable rewards for this user.
/// @param completionHandler	A block that is executed when the rewards are loaded from the server. Parameter rewards contains objects of type XPLReward. Parameter rewards may be nil if rewards are not available or if an error occurs while downloading content
+ (void)loadAvailableRewards:(void (^)(NSArray *rewards))completionHandler;

@end

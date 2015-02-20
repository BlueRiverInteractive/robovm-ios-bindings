//
//  XPLReward.h
//  XplodeSDK
//
//  Copyright (c) 2015 Iddiction, Inc. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface XPLReward : NSObject

/// Returns the reward identifier specified on the Xplode portal
/// @return The reward identifier.
@property (nonatomic, strong, readonly) NSString *identifier;

/// Returns the reward value specified on the Xplode portal (optional, may be nil)
/// @return The reward value.
@property (nonatomic, strong, readonly) NSNumber *value;


/// After you reward your user, you must call this method.
/// Otherwise reward will show up again when you call checkForAvailableRewards:.
- (void)consumeReward;

@end

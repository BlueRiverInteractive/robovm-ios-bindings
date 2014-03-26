//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <Foundation/Foundation.h>

#import "GPGEnums.h"

@interface GPGMultiplayerConfig : NSObject

@property(nonatomic, assign) int exclusiveBitMask;

@property(nonatomic, retain) NSArray *invitedPlayerIds;

@property(nonatomic, assign) int maxAutoMatchingPlayers;

@property(nonatomic, assign) int minAutoMatchingPlayers;

@property(nonatomic, assign) int variant;

@end


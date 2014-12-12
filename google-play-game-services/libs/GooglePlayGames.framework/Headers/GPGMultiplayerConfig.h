//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <Foundation/Foundation.h>

#import "GPGEnums.h"

@interface GPGMultiplayerConfig : NSObject<NSCopying>

@property(nonatomic, assign) uint64_t exclusiveBitMask;

@property(nonatomic, copy) NSArray *invitedPlayerIds;

@property(nonatomic, assign) int maxAutoMatchingPlayers;

@property(nonatomic, assign) int minAutoMatchingPlayers;

@property(nonatomic, assign) int variant;

@end


//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <Foundation/Foundation.h>

#import "GPGEnums.h"

@class GPGPlayer;

@interface GPGTurnBasedParticipant : NSObject

@property(nonatomic, readonly, copy) NSString *displayName;

@property(nonatomic, readonly, copy) NSURL *imageUrl;

@property(nonatomic, readonly, copy) NSString *participantId;

@property(nonatomic, readonly, strong) GPGPlayer *player;

@property(nonatomic, readonly, assign) GPGTurnBasedParticipantStatus status;

@end

//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <Foundation/Foundation.h>

#import "GPGEnums.h"

@class GPGPlayer;

@interface GPGTurnBasedParticipant : NSObject

@property(nonatomic, readonly, copy) NSString *participantId;

@property(nonatomic, readonly, assign) BOOL isAutoMatchedPlayer;

@property(nonatomic, readonly, retain) GPGPlayer *player;

@property(nonatomic, readonly, assign) GPGTurnBasedParticipantStatus status;

@end

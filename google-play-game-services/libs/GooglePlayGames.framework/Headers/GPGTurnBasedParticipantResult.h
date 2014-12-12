//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <Foundation/Foundation.h>

#import "GPGEnums.h"

@interface GPGTurnBasedParticipantResult : NSObject

@property(nonatomic, copy) NSString *participantId;

@property(nonatomic, assign) int placing;

@property(nonatomic, assign) GPGTurnBasedParticipantResultStatus result;

- (instancetype)initWithParticipantId:(NSString *)participantId;

@end

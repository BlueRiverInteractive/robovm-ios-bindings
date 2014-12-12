//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <Foundation/Foundation.h>

#import "GPGEnums.h"

@class GPGMultiplayerConfig;
@class GPGRealTimeRoomModifyDetails;

@interface GPGRealTimeRoomData : NSObject

@property(nonatomic, readonly, strong) GPGMultiplayerConfig *config;

@property(nonatomic, readonly, strong) GPGRealTimeRoomModifyDetails *creationDetails;

@property(nonatomic, readonly, copy) NSArray *participants;

@property(nonatomic, readonly, copy) NSString *roomDescription;

@property(nonatomic, readonly, copy) NSString *roomID;

@property(nonatomic, readonly, assign) GPGRealTimeRoomStatus status;

@end

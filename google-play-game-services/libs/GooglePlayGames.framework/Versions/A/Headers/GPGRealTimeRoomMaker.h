//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <Foundation/Foundation.h>

#import "GPGMultiplayerConfig.h"
#import "GPGRealTimeRoom.h"
#import "GPGRealTimeRoomData.h"

@class GPGRealTimeRoom;
@class GPGMultiplayerConfig;
@class GPGRealTimeRoomMaker;

typedef void (^GPGListRoomsHandler)(NSArray *rooms, NSError *error);
typedef void (^GPGRoomRequestHandler)(GPGRealTimeRoomData *data, NSError *error);
typedef void (^GPGRoomDismissHandler)(NSError *error);

@interface GPGRealTimeRoomMaker : NSObject

+ (GPGRealTimeRoomCreationResult)createRoomFromConfig:(GPGMultiplayerConfig *)config;

+ (GPGRealTimeRoomCreationResult)createRoomFromConfig:(GPGMultiplayerConfig *)config
    operationHandle:(GPGRealTimeRoomCreationHandle * __autoreleasing *)handle;

+ (GPGRealTimeRoomCreationResult)joinRoomFromData:(GPGRealTimeRoomData *)data;

+ (GPGRealTimeRoomCreationResult)joinRoomFromData:(GPGRealTimeRoomData *)data
    operationHandle:(GPGRealTimeRoomCreationHandle * __autoreleasing *)handle;

+ (void)listRoomsWithMaxResults:(int)maxResults
              completionHandler:(GPGListRoomsHandler)completionHandler;

+ (void)getRoomWithId:(NSString *)roomId
    completionHandler:(GPGRoomRequestHandler)completionHandler;

+ (void)getRoomFromData:(GPGRealTimeRoomData *)roomData
      completionHandler:(GPGRoomRequestHandler)completionHandler;

+ (void)declineRoomFromData:(GPGRealTimeRoomData *)data
          completionHandler:(GPGRoomRequestHandler)completionHandler;

+ (void)dismissRoomFromData:(GPGRealTimeRoomData *)data
          completionHandler:(GPGRoomDismissHandler)completionHandler;

+ (GPGRealTimeRoom *)activeRoom;

@end

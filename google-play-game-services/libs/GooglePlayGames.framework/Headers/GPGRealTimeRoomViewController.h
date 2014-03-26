//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <UIKit/UIKit.h>

@class GPGMultiplayerConfig;
@class GPGRealTimeRoomViewController;
@class GPGRealTimeRoomData;

@interface GPGRealTimeRoomViewController : UINavigationController

@property(nonatomic, assign) int minPlayers;

@property(nonatomic, assign) int maxPlayers;

- (id)initWithMinPlayers:(int)minPlayers
              maxPlayers:(int)maxPlayers
        exclusiveBitMask:(int)exclusiveBitMask
                 variant:(int)variant;

- (id)initWithMinPlayers:(int)minPlayers maxPlayers:(int)maxPlayers;

- (id)initAndCreateRoomWithConfig:(GPGMultiplayerConfig *)config;

- (id)initWithRoomDataList:(NSMutableArray *)roomDataList;

@end

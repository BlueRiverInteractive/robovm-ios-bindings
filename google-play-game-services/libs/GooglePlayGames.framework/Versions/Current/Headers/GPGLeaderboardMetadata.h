//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <Foundation/Foundation.h>

#import "GPGEnums.h"

@interface GPGLeaderboardMetadata : NSObject

@property(nonatomic, readonly, copy) NSURL *iconUrl;

@property(nonatomic, readonly, copy) NSString *leaderboardId;

@property(nonatomic, readonly, assign) GPGLeaderboardOrder order;

@property(nonatomic, readonly, copy) NSString *title;

@end

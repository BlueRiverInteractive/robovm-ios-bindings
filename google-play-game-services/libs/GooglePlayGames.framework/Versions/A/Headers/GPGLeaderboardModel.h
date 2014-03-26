//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <Foundation/Foundation.h>

@class GPGLeaderboardMetadata;

@interface GPGLeaderboardModel : NSObject

- (NSArray *)allMetadata; // GPGLeaderboardMetadata objects

- (GPGLeaderboardMetadata *)metadataForLeaderboardId:(NSString *)leaderboardId;

@end

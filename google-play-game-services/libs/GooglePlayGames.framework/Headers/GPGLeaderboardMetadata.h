//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <Foundation/Foundation.h>

#import "GPGEnums.h"

@class GPGLeaderboardMetadata;

typedef void (^GPGLeaderboardAllMetadataBlock)(NSArray *metadata, NSError *error);

typedef void (^GPGLeaderboardMetadataBlock)(GPGLeaderboardMetadata *metadata, NSError *error);

@interface GPGLeaderboardMetadata : NSObject

@property(nonatomic, readonly, copy) NSURL *iconUrl;

@property(nonatomic, readonly, copy) NSString *leaderboardId;

@property(nonatomic, readonly, assign) GPGLeaderboardOrder order;

@property(nonatomic, readonly, copy) NSString *title;

+ (void)allMetadataWithCompletionHandler:(GPGLeaderboardAllMetadataBlock)completionHandler;

+ (void)allMetadataFromDataSource:(GPGDataSource)dataSource
                completionHandler:(GPGLeaderboardAllMetadataBlock)completionHandler;

+ (void)metadataForLeaderboardId:(NSString *)leaderboardId
               completionHandler:(GPGLeaderboardMetadataBlock)completionHandler;

+ (void)metadataForLeaderboardId:(NSString *)leaderboardId
                      dataSource:(GPGDataSource)dataSource
               completionHandler:(GPGLeaderboardMetadataBlock)completionHandler;

@end

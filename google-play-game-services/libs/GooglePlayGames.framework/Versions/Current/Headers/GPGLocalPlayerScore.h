//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <Foundation/Foundation.h>

@class GPGLocalPlayerRank;

@interface GPGLocalPlayerScore : NSObject <NSCoding>

@property(nonatomic, readonly, strong) GPGLocalPlayerRank *publicRank;

@property(nonatomic, readonly, copy) NSString *leaderboardId;

@property(nonatomic, readonly, copy) NSString *scoreString;

@property(nonatomic, readonly, assign) uint64_t scoreValue;

@property(nonatomic, readonly, copy) NSString *scoreTag;

@property(nonatomic, readonly, strong) GPGLocalPlayerRank *socialRank;

@property(nonatomic, readonly, assign) int64_t writeTimestamp;
@end

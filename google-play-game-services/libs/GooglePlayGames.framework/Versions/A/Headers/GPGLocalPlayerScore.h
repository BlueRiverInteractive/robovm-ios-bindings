//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <Foundation/Foundation.h>

@class GPGLocalPlayerRank;

@interface GPGLocalPlayerScore : NSObject <NSCoding>

@property (nonatomic, readonly, retain) GPGLocalPlayerRank *publicRank;

@property (nonatomic, readonly, copy) NSString *leaderboardId;

@property (nonatomic, readonly, copy) NSString *scoreString;

@property (nonatomic, readonly, assign) unsigned long long scoreValue;

@property (nonatomic, readonly, copy) NSString *scoreTag;

@property (nonatomic, readonly, retain) GPGLocalPlayerRank *socialRank;

@property (nonatomic, readonly, assign) long long writeTimestamp;
@end

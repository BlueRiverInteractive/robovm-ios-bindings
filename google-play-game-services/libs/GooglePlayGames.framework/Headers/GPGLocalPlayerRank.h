//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <Foundation/Foundation.h>

@interface GPGLocalPlayerRank : NSObject <NSCoding>

@property(nonatomic, readonly, copy) NSString *formattedRank;

@property(nonatomic, readonly, copy) NSString *formattedNumScores;

@property(nonatomic, readonly, assign) uint64_t numScores;

@property(nonatomic, readonly, assign) uint64_t rank;

@end

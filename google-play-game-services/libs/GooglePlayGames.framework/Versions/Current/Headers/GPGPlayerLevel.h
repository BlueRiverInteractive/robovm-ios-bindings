//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
@interface GPGPlayerLevel : NSObject<NSCopying>

@property(nonatomic, readonly, assign) int level;


@property(nonatomic, readonly, assign) uint64_t minExperiencePoints;

@property(nonatomic, readonly, assign) uint64_t maxExperiencePoints;

@end

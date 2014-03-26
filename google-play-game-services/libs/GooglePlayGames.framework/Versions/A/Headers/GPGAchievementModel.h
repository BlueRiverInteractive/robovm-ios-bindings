//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <Foundation/Foundation.h>

@class GPGAchievementMetadata;

@interface GPGAchievementModel : NSObject

- (NSArray *)allMetadata; // GPGAchievementMetadata objects

- (GPGAchievementMetadata *)metadataForAchievementId:(NSString *)achievementId;

@end

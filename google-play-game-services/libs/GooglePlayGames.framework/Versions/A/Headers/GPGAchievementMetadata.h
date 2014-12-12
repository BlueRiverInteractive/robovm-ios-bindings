//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <UIKit/UIKit.h>

#import "GPGEnums.h"

@class GPGAchievementMetadata;

typedef void (^GPGAchievementMetadataBlock)(GPGAchievementMetadata *metadata, NSError *error);

typedef void (^GPGAchievementAllMetadataBlock)(NSArray *metadata, NSError *error);


@interface GPGAchievementMetadata : NSObject <NSCopying, NSCoding>

@property(nonatomic, readonly, copy) NSString *achievementId;

@property(nonatomic, readonly, assign) GPGAchievementState state;

@property(nonatomic, readonly, assign) GPGAchievementType type;

@property(nonatomic, readonly, copy) NSString *name;

@property(nonatomic, readonly, copy) NSString *achievementDescription;

@property(nonatomic, readonly, copy) NSURL *revealedIconUrl;

@property(nonatomic, readonly, copy) NSURL *unlockedIconUrl;

@property(nonatomic, readonly, assign) int32_t completedSteps;

@property(nonatomic, readonly, assign) int32_t numberOfSteps;

@property(nonatomic, readonly, copy) NSString *formattedCompletedSteps;

@property(nonatomic, readonly, copy) NSString *formattedNumberOfSteps;

@property(nonatomic, readonly, assign) int64_t lastUpdatedTimestamp;

@property(nonatomic, readonly, assign) CGFloat progress;

@property(nonatomic, readonly, assign) int32_t experiencePoints;

+ (void)metadataForAchievementId:(NSString *)achievementId
               completionHandler:(GPGAchievementMetadataBlock)completionHandler;

+ (void)metadataForAchievementId:(NSString *)achievementId
                      dataSource:(GPGDataSource)dataSource
               completionHandler:(GPGAchievementMetadataBlock)completionHandler;

+ (void)allMetadataWithCompletionHandler:(GPGAchievementAllMetadataBlock)completionHandler;

+ (void)allMetadataFromDataSource:(GPGDataSource)dataSource
                completionHandler:(GPGAchievementAllMetadataBlock)completionHandler;

@end

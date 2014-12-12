//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import "GPGEnums.h"

@class GPGQuest;
@class GPGQuestMilestone;

typedef void (^GPGQuestFetchBlock)(GPGQuest *quest, NSError *error);

typedef void (^GPGQuestListBlock)(NSArray *quests, NSError *error);

typedef void (^GPGQuestCompletionBlock)(NSError *error);

@protocol GPGQuestDelegate<NSObject>
@optional

- (void)didCompleteQuest:(GPGQuest *)quest;

@end

@interface GPGQuest : NSObject

@property(nonatomic, readonly, copy) NSString *questId;

@property(nonatomic, readonly, copy) NSString *name;

@property(nonatomic, readonly, copy) NSString *questDescription;

@property(nonatomic, readonly, copy) NSURL *iconUrl;

@property(nonatomic, readonly, copy) NSURL *bannerUrl;

@property(nonatomic, readonly, strong) GPGQuestMilestone *currentMilestone;

@property(nonatomic, readonly, assign) GPGQuestState state;

@property(nonatomic, readonly, assign) int64_t startTimestamp;

@property(nonatomic, readonly, assign) int64_t expirationTimestamp;

@property(nonatomic, readonly, assign) int64_t acceptedTimestamp;

+ (void)fetchQuestWithId:(NSString *)questId
       completionHandler:(GPGQuestFetchBlock)completionHandler;

+ (void)allQuestsWithCompletionHandler:(GPGQuestListBlock)completionHandler;

+ (void)allQuestsFromDataSource:(GPGDataSource)dataSource
              completionHandler:(GPGQuestListBlock)completionHandler;

+ (void)questsForState:(GPGQuestState)state completionHandler:(GPGQuestListBlock)completionHandler;

- (void)acceptWithCompletionHandler:(GPGQuestCompletionBlock)completionHandler;

@end

@interface GPGQuestMilestone : NSObject

@property(nonatomic, readonly, copy) NSString *questMilestoneId;

@property(nonatomic, readonly, copy) NSString *questId;

@property(nonatomic, readonly, copy) NSString *eventId;

@property(nonatomic, readonly, assign) GPGQuestMilestoneState state;

@property(nonatomic, readonly, assign) NSInteger currentCount;

@property(nonatomic, readonly, assign) NSInteger targetCount;

@property(nonatomic, readonly, strong) NSData *rewardData;

- (void)claimWithCompletionHandler:(GPGQuestCompletionBlock)completionHandler;

@end

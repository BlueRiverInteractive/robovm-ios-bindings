//
//  CBStory.h
//  Chartboost
//  VERSION
//
//  Copyright 2011 Chartboost. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <CoreData/CoreData.h>

@class CBStory;

typedef void (^CBStoryCallbackBlock)(CBStory *story);
typedef void (^CBStoryFailureCallbackBlock)(NSError *error, NSDictionary *response);

@interface CBStory : NSManagedObject

@property (nonatomic, strong, readonly) NSString *storyID;
@property (nonatomic, strong, readonly) NSNumber *storySent;
@property (nonatomic, strong, readonly) NSString *storyTitle;
@property (nonatomic, strong, readonly) NSString *storyContent;
@property (nonatomic, strong, readonly) NSString *storyImageURL;
@property (nonatomic, strong, readonly) NSNumber *storyViews;
@property (nonatomic, strong, readonly) NSNumber *storyClicks;
@property (nonatomic, strong, readonly) NSNumber *storyExpires;
@property (nonatomic, strong, readonly) NSNumber *storyMaxClicks;
@property (nonatomic, strong, readonly) NSNumber *storyMaxViews;
@property (nonatomic, strong, readonly) NSString *storyLink;
@property (nonatomic, strong, readonly) NSString *storyImageChecksum;
@property (nonatomic, strong, readonly) NSNumber *storyShowNotification;
@property (nonatomic, strong, readonly) NSNumber *storyShowExpiration;
@property (nonatomic, strong, readonly) NSNumber *storyViewed;
@property (nonatomic, strong, readonly) NSNumber *storyExpiresHours;

- (void)markViewedWithSuccessBlock:(CBStoryCallbackBlock)successBlock
                  withFailureBlock:(CBStoryFailureCallbackBlock)failureBlock;

- (void)markClickedWithSuccessBlock:(CBStoryCallbackBlock)successBlock
                   withFailureBlock:(CBStoryFailureCallbackBlock)failureBlock;

- (void)markNotificationClickedWithSuccessBlock:(CBStoryCallbackBlock)successBlock
                               withFailureBlock:(CBStoryFailureCallbackBlock)failureBlock;

- (void)markNotificationViewedWithSuccessBlock:(CBStoryCallbackBlock)successBlock
                              withFailureBlock:(CBStoryFailureCallbackBlock)failureBlock;

@end

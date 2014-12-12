//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import "GPGEnums.h"

@class GPGEvent;

typedef void (^GPGEventListBlock)(NSArray *events, NSError *error);
typedef void (^GPGEventOperationBlock)(GPGEvent *event, NSError *error);

@interface GPGEvent : NSObject

@property(nonatomic, readonly) uint64_t count;

@property(nonatomic, readonly, copy) NSString *eventDescription;

@property(nonatomic, readonly, copy) NSString *eventId;

@property(nonatomic, readonly, copy) NSURL *imageUrl;

@property(nonatomic, readonly, copy) NSString *name;

@property(nonatomic, readonly) BOOL visible;

+ (void)allEventsWithCompletionHandler:(GPGEventListBlock)completionHandler;

+ (void)eventForId:(NSString *)eventId completionHandler:(GPGEventOperationBlock)completionHandler;

- (void)increment;

- (void)incrementBy:(uint64_t)steps;

- (void)incrementWithCompletionHandler:(GPGEventOperationBlock)completionHandler;

- (void)incrementBy:(uint64_t)steps completionHandler:(GPGEventOperationBlock)completionHandler;

@end

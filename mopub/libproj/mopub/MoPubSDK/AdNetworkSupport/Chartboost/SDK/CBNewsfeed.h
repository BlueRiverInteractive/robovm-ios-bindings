//
//  CBNewsfeed.h
//  Chartboost
//  VERSION
//
//  Copyright 2011 Chartboost. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

@class CBStory;
@protocol CBNewsfeedDelegate;

typedef void (^CBStoryRetrieveMessagesSuccessBlock)(NSArray *newMessages, NSArray *updatedMessages, NSArray *deletedMessages, NSArray *deletedIndexes);
typedef void (^CBStoryRetrieveMessagesFailureBlock)(NSError *error, NSDictionary *response);

@interface CBNewsfeed : NSObject

/**
 * Set the CBNewsfeed delegate to be able to receive notification
 * of various events.
 */
@property (nonatomic, weak) id<CBNewsfeedDelegate> delegate;

/**
 * Override how often the CBNewsfeed should attempt to get
 * new data from the Chartboost API server.
 *
 * Default is 60 seconds; set to 0 to disable background fetch.
 *
 * Cannot be set to less than 60 seconds unless disabling.  If set to 
 * less than 60 seconds will use default fetch time of 60 seconds.
 */
@property (nonatomic, assign) NSUInteger fetchTime;

/**
 * Set a custom UI that implements the CBNewsfeedUIProtocol
 * to replace the default Newsfeed UI.
 */
@property (nonatomic, strong) Class uiClass;

/**
 * Get the CBNewsfeed shared singleton object.
 */
+ (CBNewsfeed *)shared;

/**
 * Call this in application:didFinishLaunchingWithOptions: to start getting
 * Newsfeed data from the Chartboost API servers.
 */
- (void)startNewsfeed;

/**
 * CBNewsfeed CoreData Methods
 */

/**
 * Get CBStory objects currently stored on the device.
 *
 * @return NSArray of CBStory objects.
 */
- (NSArray *)getMessages;

/**
 * Get CBStory object currently stored on the device with the given message ID.
 *
 * @param NSString for the messageID of the CBStory
 *
 * @return CBStory.
 */
- (CBStory *)getMessage:(NSString *)messageId;

/**
 * Delete CBStory objects currently stored on the device.
 */
- (void)deleteMessages;

/**
 * Delete CBStory object currently stored on the device with the given message ID.
 *
 * @param CBStory to delete
 */
- (void)deleteMessage:(CBStory *)message;

/**
 * Get the total number of messages currently on the device.
 *
 * @return NSUInteger
 */
- (NSUInteger)messageCount;

/**
 * Get the number of unread messages currently on the device.
 *
 * @return NSUInteger
 */
- (NSUInteger)unreadMessageCount;

/**
 * CBNewsfeed HTTP Methods
 */

/**
 * Retrieve CBStory data from the Chartboost API server.
 *
 * Sends an HTTP request to the Chartboost API server to fetch active CBStory
 * object data.  New CBStory data is returned in the successBlock() and all
 * objects can be accessed using the getMessages() call above.
 *
 * If the CBNewsfeedDelegate protocol is implemented this method will
 * call didGetNewMessages() on the delegate upon a successful HTTP request that returns
 * new CBStory objects.
 *
 * @param CBStoryRetrieveMessagesSuccessBlock successBlock is executed if HTTP request returns successfully.
 * @param CBStoryRetrieveMessagesFailureBlock failureBlock is executed for all HTTP failures.
 */
- (void)retrieveMessages:(CBStoryRetrieveMessagesSuccessBlock)successBlock
            failureBlock:(CBStoryRetrieveMessagesFailureBlock)failureBlock;

/**
 * Retrieve CBStory data from the Chartboost API server.
 *
 * Calls the [CBNewsfeed retrieveMessages:failureBlock:] with nil set for the successBlock()
 * and the failureBlock().
 */
- (void)retrieveMessages;

/**
 * CBNewsfeed UI Methods
 */

/**
 * Check if the NewsfeedUI is visible.
 *
 * Calls [CBNewsfeedUIProtocol isNewsfeedUIVisible] for the UI class.
 *
 * @return BOOL
 */
- (BOOL)isNewsfeedUIVisible;

/**
 * Display the Newsfeed UI.
 *
 * Calls [CBNewsfeedUIProtocol displayNewsfeed] for the UI class.
 */
- (void)showNewsfeedUI;

/**
 * Close the Newsfeed UI.
 *
 * Calls [CBNewsfeedUIProtocol dismissNewsfeed] for the UI class.
 */
- (void)closeNewsfeedUI;

/**
 * Check if the NotificationUI is visible.
 *
 * Calls [CBNewsfeedUIProtocol isNofiticationUIVisible] for the UI class.
 *
 * @return BOOL
 */
- (BOOL)isNotificationUIVisible;

/**
 * Display the Notification UI for the most recent CBStory.
 *
 * Calls [CBNewsfeedUIProtocol displayNotification] for the UI class.
 */
- (void)showNotificationUI;

/**
 * Display the Notification UI for a specific CBStory.
 *
 * Calls [CBNewsfeedUIProtocol displayNotification:] for the UI class.
 *
 * @param CBStory object to display Notification UI for.
 */
- (void)showNotificationUIForStory:(CBStory *)story;

/**
 * Close the Notification UI.
 *
 * Calls [CBNewsfeedUIProtocol dismissNotification] for the UI class.
 */
- (void)closeNotificationUI;

/**
 * Confirm if an age gate passed or failed.
 */
- (void)didPassAgeGate:(BOOL)pass;

@end

/**
 * CBNewsfeedDelegate
 *
 * Implement to receive notification of various CBNewsfeed events.
 */
@protocol CBNewsfeedDelegate <NSObject>

@optional

/**
 * Called when a user clicks a message in the newsfeed UI.
 *
 * @param CBStory that was clicked
 */
- (void)didClickMessage:(CBStory *)message;

/**
 * Called when a message expires due to a timer.
 *
 * @param CBStory that was expired
 */
- (void)didExpireMessage:(CBStory *)message;

/**
 * Called when a user views a message in the newsfeed UI.
 *
 * @param CBStory that was viewed
 */
- (void)didViewMessage:(CBStory *)message;

/**
 * Called when a user clicks a notification.
 *
 * @param CBStory that was clicked
 */
- (void)didClickNotification:(CBStory *)message;

/**
 * Called when a user viewes a notification.
 *
 * @param CBStory that was viewed
 */
- (void)didViewNotification:(CBStory *)message;

/**
 * Called when new messages were retrieved from the server.
 *
 * @param NSArray of CBStory objects
 */
- (void)didGetNewMessages:(NSArray *)messages;

/**
 * Implement to decide if the CBstory object should
 * automatically display a notification UI.
 *
 * @param CBStory 
 */
- (BOOL)shouldAutomaticallyDisplayNotificationUI:(CBStory *)message;

/**
 * Implement this method to control the blocking for an age gate.
 *
 * If the method returns NO, the callback should not be used
 */
- (BOOL)shouldPauseStoryClickForConfirmation;

@end
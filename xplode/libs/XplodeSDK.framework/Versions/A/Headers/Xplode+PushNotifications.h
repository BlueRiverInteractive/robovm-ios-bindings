//  Copyright (c) 2014 Iddiction, Inc. All rights reserved.

#import "Xplode.h"

///---------------------
/// @name Push Notifications
///---------------------

@interface Xplode (PushNotifications)

/*!
 * @name Push Notifications
 */

/// Registers the unparsed push token received from Apple with Xplode.
///
/// @deprecated Since version 2.4.1.
/// @param deviceToken			The unparsed device token that is returned by the UIApplication push registration delegate method as NSData.
/// @param completionHandler	The completion handler.
+ (void)registerDeviceTokenWithData:(NSData *)deviceToken
					   onCompletion:(void(^)(NSError *error))completionHandler  __attribute__((deprecated(" Since Xplode SDK v2.4.1. Use registerDeviceTokenWithData:withCompletionHandler: instead.")));

/// Registers the parsed push token received from Apple with Xplode.
///
/// @deprecated Since version 2.4.1.
/// @param deviceToken			The parsed device token string that is returned by the UIApplication push registration delegate method.
/// @param completionHandler	The completion handler.
+ (void)registerDeviceTokenWithString:(NSString *)deviceToken
						 onCompletion:(void(^)(NSError *error))completionHandler __attribute__((deprecated(" Since Xplode SDK v2.4.1. Use registerDeviceTokenWithString:withCompletionHandler: instead.")));

/// Registers the unparsed push token received from Apple with Xplode.
///
/// @param deviceToken			The unparsed device token that is returned by the UIApplication push registration delegate method as NSData.
/// @param completionHandler	The completion handler.
+ (void)registerDeviceTokenWithData:(NSData *)deviceToken
			  withCompletionHandler:(void(^)(NSError *error))completionHandler;

/// Registers the parsed push token received from Apple with Xplode.
///
/// @param deviceToken			The parsed device token string that is returned by the UIApplication push registration delegate method.
/// @param completionHandler	The completion handler.
+ (void)registerDeviceTokenWithString:(NSString *)deviceToken
				withCompletionHandler:(void(^)(NSError *error))completionHandler;

/// Handles the received push payload content.
///
/// @param userInfo				The received push payload that is returned by application:didReceiveRemoteNotification: as an NSDictionary.
+ (void)handlePushNotificationPayload:(NSDictionary *)userInfo
           withFetchCompletionHandler:(void(^)(UIBackgroundFetchResult result))completionHandler;


@end

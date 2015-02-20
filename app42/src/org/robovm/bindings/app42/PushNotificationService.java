package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSDate;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.ByVal;
import org.robovm.rt.bro.annotation.GlobalValue;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class PushNotificationService extends App42Service
{
	@GlobalValue(symbol = "PRODUCTION", optional=true)
	public static native @ByVal String PRODUCTION();
	
	@GlobalValue(symbol = "DEVELOPMENT", optional=true)
	public static native @ByVal String DEVELOPMENT();
	
	public PushNotificationService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);

	/**Upload certificate file to server
	 * 
	 * @param password the password you have used while exporting the certificate
	 * @param filePath path of certificate file
	 * @param environment environment for the certificate whether it would be development or production
	 * @return PushNotification Object
	 */
	@Method(selector = "uploadFile:filePath:environment:completionBlock:")
	public native void uploadFile(String password, String filePath, String environment, @Block App42ResponseBlock completionBlock);
	
	/** Stores your device token on server with particular username
	 * 
	 * @param Username username with which you want your device to be registered
	 * @param deviceToken device id for android phones
	 * @return PushNotification Object
	 */
	@Method(selector = "registerDeviceToken:withUser:completionBlock:")
	public native void registerDeviceToken(String deviceToken, String userName, String environment, @Block App42ResponseBlock completionBlock);
	
	/** Create Channel for app on which user can subscribe and get the notification for that 
	 * channel
	 * @param channel - channel name which you want to create
	 * @param description = description for that channel
	 * @return PushNotification Object
	 */
	@Method(selector = "createChannelForApp:description:completionBlock:")
	public native void createChannelForApp(String channel, String description, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Subscribe to the channel
	 *
	 * @param channel
	 *            the channel name which you want to subscribe
	 * @param userName
	 *            username which want to subscribe
	 * @return PushNotification Object
	 * @throws App42Exception
	 */
	@Method(selector = "subscribeToChannel:userName:completionBlock:")
	public native void subscribeToChannel(String channel, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Unsubscribe from particular channel
	 *
	 * @param channel
	 *            channel name which you want to unsubscribe
	 * @param userName
	 *            username which want to unsubscribe
	 * @return PushNotification Object
	 * @throws App42Exception
	 */
	@Method(selector = "unsubscribeFromChannel:userName:completionBlock:")
	public native void unsubscribeFromChannel(String channel, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Subscribe to the channel
	 * @param channel the channel name which you want to subscribe
	 * @param userName username which want to subscribe
	 * @param deviceToken deviceToken for which you want to subscribe
	 * @return PushNotification Object
	 */
	@Method(selector = "subscribeToChannel:userName:deviceToken:completionBlock:")
	public native void subscribeToChannel(String channel, String userName, String deviceToken, @Block App42ResponseBlock completionBlock);
	
	/**
	 * This API is Deprecated from Version 2.2
	 */
	@Method(selector = "subscribeToChannel:userName:deviceToken:deviceType:completionBlock:")
	public native void subscribeToChannel(String channel, String userName, String deviceToken, String deviceType, @Block App42ResponseBlock completionBlock);
	
	/**Unsubscribe from particular channel
	 * 
	 * @param channel channel name which you want to unsubscribe
	 * @param userName username which want to unsubscribe
	 * @return PushNotification Object
	 */
	@Method(selector = "unsubscribeDeviceToChannel:userName:deviceToken:completionBlock:")
	public native void unsubscribeDeviceToChannel(String channel, String userName, String deviceToken, @Block App42ResponseBlock completionBlock);
	
	/** send push message to channel containing string
	 * 
	 * @param channel channel name which you want to send the message
	 * @param message push message in string format
	 * @return PushNotification Object
	 */
	@Method(selector = "sendPushMessageToChannel:withMessage:completionBlock:")
	public native void sendPushMessageToChannel(String channel, String message, @Block App42ResponseBlock completionBlock);
	
	/** Send Push Message to particular channel containing Json
	 * 
	 * @param channel channel name which you want to send your json message
	 * @param message push message in Dictionary format
	 * @return PushNotification Object
	 */
	@Method(selector = "sendPushMessageToChannel:withMessageDictionary:completionBlock:")
	public native void sendPushMessageToChannel(String channel, NSDictionary<?, ?> message, @Block App42ResponseBlock completionBlock);
	
	/** Send push message to all your users 
	 *
	 * @param message push message
	 * @return PushNotification Object
	 */
	@Method(selector = "sendPushMessageToAll:completionBlock:")
	public native void sendPushMessageToAll(String message, @Block App42ResponseBlock completionBlock);
	
	/** Send push message to all iOS users
	 *
	 * @param message push message
	 * @return PushNotification Object
	 */
	@Method(selector = "sendPushMessageToiOS:completionBlock:")
	public native void sendPushMessageToiOS(String message, @Block App42ResponseBlock completionBlock);
	
	/** Send push message to all android users
	 *
	 * @param message push message
	 * @return PushNotification Object
	 */
	@Method(selector = "sendPushMessageToAndroid:completionBlock:")
	public native void sendPushMessageToAndroid(String message, @Block App42ResponseBlock completionBlock);
	
	/** Send Push Message To paticular user in string format
	 * 
	 * @param username username which you want to send the message
	 * @param message push message
	 * @return PushNotification Object
	 */
	@Method(selector = "sendPushMessageToUser:completionBlock:")
	public native void sendPushMessageToUser(String userName, String message, @Block App42ResponseBlock completionBlock);
	
	/**Send Push Message to particular user
	 * 
	 * @param username username which you want to send message
	 * @param message push Message in json
	 * @return PushNotification Object
	 */
	@Method(selector = "sendPushMessageToUser:withMessageDictionary:completionBlock:")
	public native void sendPushMessageToUser(String userName, NSDictionary<?, ?> message, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Send Push Message To target user using storage query.
	 * This method fetches userName from target dbName and collectionName using passed query and sends push notification to them.
	 *
	 * @param message - Message that you want to send
	 * @param dbName - dbName
	 * @param collectionName - collectionName
	 * @param query - query to fetch target users.
	 * @return PushNotification Object
	 * @throws App42Exception
	 */
	@Method(selector = "sendPushMessageToUser:dbName:completionBlock:collectionName:query:completionBlock:")
	public native void sendPushMessageToUser(String message, String dbName, String collectionName, Query query, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Send push message to list of specific users.
	 *
	 * @param message
	 *            - Message which you have to send.
	 * @param userList
	 *            - List of the users for which message has to be send.
	 * @return PushNotification Object
	 * @throws App42Exception
	 */
	@Method(selector = "sendPushMessageToGroup:message:completionBlock:")
	public native void sendPushMessageToGroup(NSArray<?> userList, String message, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param startDate
	 * @param endDate
	 * @param message
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "sendMessageToInActiveUsersFromDate:toDate:message:completionBlock:")
	public native void sendMessageToInActiveUsersFromDate(NSDate startDate, NSDate endDate, String message, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Send Push Message To user in async mode
	 *
	 * @param username
	 *            - Name of the user which you want to send the message
	 * @param message
	 *            - Message which you want to send.
	 * @param expiryDate
	 *            - date on which message is to schedule.
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "scheduleMessageToUser:expiryDate:message:completionBlock:")
	public native void scheduleMessageToUser(String userName, NSDate expiryDate, String message, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Delete your device from push-notification service.
	 *
	 * @param userName
	 *            - Name of user whose device token has to delete.
	 * @param deviceToken
	 *            - device token which has to be deleted
	 * @return App42Response Object
	 * @throws App42Exception
	 */
	@Method(selector = "deleteDeviceToken:deviceToken:completionBlock:")
	public native void deleteDeviceToken(String userName, String deviceToken, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Delete all devices registered for single user in push-notification service.
	 *
	 * @param userName
	 *            - Name of user whose devices has to delete.
	 * @return App42Response Object
	 * @throws App42Exception
	 */
	@Method(selector = "deleteAllDevices:completionBlock:")
	public native void deleteAllDevices(String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Unsubscribe your device from push-notification service.
	 * @param userName
	 * @param deviceToken
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "unsubscribeDeviceForUser:deviceToken:completionBlock:")
	public native void unsubscribeDeviceForUser(String userName, String deviceToken, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Resubscribe your device for push-notification service.
	 * @param userName
	 * @param deviceToken
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "resubscribeDeviceForUser:deviceToken:completionBlock:")
	public native void resubscribeDeviceForUser(String userName, String deviceToken, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Send push to device with matching deviceToken and userName.
	 * @param userName
	 * @param deviceToken
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "sendPushMessageToDevice:userName:message:completionBlock:")
	public native void sendPushMessageToDevice(String deviceToken, String userName, String message, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param userName
	 * @param deviceToken
	 * @param increment
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "updatePushBadgeforDevice:userName:badges:completionBlock:")
	public native void updatePushBadgeforDevice(String deviceToken, String userName, int badges, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param userName
	 * @param increment
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "updatePushBadgeforUser:badges:completionBlock:")
	public native void updatePushBadgeforUser(String userName, int badges, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param channelName
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "deleteChannel:completionBlock:")
	public native void deleteChannel(String channelName, @Block App42ResponseBlock completionBlock);
}

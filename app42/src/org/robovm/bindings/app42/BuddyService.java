package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSArray;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class BuddyService extends App42Service
{
	public BuddyService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);

	/**
	 * Send friend request allow you to send the buddy request to the user.
	 *
	 * @param userName
	 *            - Name of the user who wanted to send the request to the
	 *            buddy.
	 * @param buddyName
	 *            - Name of buddy for whom you sending the request.
	 * @param message
	 *            - Message to the user.
	 * @return - Buddy Object
	 * @throws App42Exception
	 */
	@Method(selector = "sendFriendRequestFromUser:toBuddy:withMessage:completionBlock:")
	public native void sendFriendRequest(String userName, String buddyName, String message, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch all the friend request for the user.
	 *
	 * @param userName
	 *            - Name of user for which request has to be fetched.
	 * @return Buddy Object
	 * @throws App42Exception
	 */
	@Method(selector = "getFriendRequest:completionBlock:")
	public native void getFriendRequest(String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Accept the friend request of the user.
	 *
	 * @param userName
	 *            - Name of the user who is going to accept the request.
	 * @param buddyName
	 *            - Name of the buddy whose request has to be accepted.
	 * @return - Buddy Object
	 * @throws App42Exception
	 */
	@Method(selector = "acceptFriendRequestFromBuddy:toUser:completionBlock:")
	public native void acceptFriendRequest(String buddyName, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Reject the friend request of the user
	 *
	 * @param userName
	 *            - Name of user who is rejecting friend request.
	 * @param buddyName
	 *            - Name of user whose friend request has to reject.
	 * @return Buddy Object
	 * @throws App42Exception
	 */
	@Method(selector = "rejectFriendRequestFromBuddy:toUser:completionBlock:")
	public native void rejectFriendRequest(String buddyName, String userName, @Block App42ResponseBlock completionBlock);

	/**
	 *
	 * @param userName
	 *            - Name of the user who want to create the group
	 * @param groupName
	 *            - Name of the group which is to be create
	 * @return Buddy object
	 * @throws App42Exception
	 */
	@Method(selector = "createGroup:byUser:completionBlock:")
	public native void createGroup(String groupName, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param userName
	 *            - Name of the user who want to fetch the friend request
	 * @return buddy object
	 * @throws App42Exception
	 */
	@Method(selector = "getAllFriends:completionBlock:")
	public native void getAllFriends(String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param userName
	 *            - Name of the user who want to add friend in group
	 * @param groupName
	 *            - Name of the group in which friend had to be added
	 * @param friends
	 *            - List of friend which has to be added in group
	 * @return Buddy object
	 * @throws App42Exception
	 */
	@Method(selector = "addFriends:ofUser:toGroup:completionBlock:")
	public native void addFriends(NSArray<?> friends, String userName, String groupName, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param userName
	 *            - Name of the user who want to checkedIn the geo location
	 * @param geoPoint
	 *            - geo points of user which is to chechedIn
	 * @return buddy object
	 * @throws App42Exception
	 */
	@Method(selector = "checkedInWithUser:geoLocation:completionBlock:")
	public native void checkedInGeoLocation(String userName, GeoPoint point, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param userName
	 * @param latitude
	 * @param longitude
	 * @param maxDistance
	 * @param max
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "getFriendsOfUser:withLatitude:andLongitude:inRadius:max:completionBlock:")
	public native void getFriendsByLocation(String userName, double latitude, double longitude, double maxDistance, int max, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Get All groups created by user
	 *
	 * @param userName
	 *            - Name of the user for which group has to be fetched.
	 * @return Buddy object
	 * @throws App42Exception
	 */
	@Method(selector = "getAllGroups:completionBlock:")
	public native void getAllGroups(String userName, @Block App42ResponseBlock completionBlock);

	/**
	 * Get All friends in specific group
	 *
	 * @param userName
	 *            : name of user who is frtching the friends in group
	 * @param ownerName
	 *            : name of group owner
	 * @param groupName
	 *            : name of group
	 * @return Buddy object
	 * @throws App42Exception
	 */
	@Method(selector = "getAllFriendsOfUser:inGroup:ofOwner:completionBlock:")
	public native void getAllFriends(String userName, String groupName, String ownerName, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param userName
	 *            : name of user who is frtching the friends in group
	 * @param ownerName
	 *            : name of group owner
	 * @param groupName
	 *            : name of group
	 * @param callBack
	 *            : Callback object for success/exception result
	 * @throws App42Exception
	 *
	 *             public void getAllFriendsInGroup(final String userName, final
	 *             String ownerName, final String groupName, final App42CallBack
	 *             callBack) throws App42Exception {
	 *             Util.throwExceptionIfNullOrBlank(callBack, "callBack"); new
	 *             Thread() {
	 * @Override public void run() { try { final ArrayList<Buddy> buddy =
	 *           getAllFriendsInGroup( userName, ownerName, groupName);
	 *           callBack.onSuccess(buddy); } catch (App42Exception ex) {
	 *           App42Log.error(" Exception :" + ex); callBack.onException(ex);
	 *           } } }.start(); }
	 *
	 *           //Block the friend request of the user forever
	 *
	 * @param userName
	 *            - Name of the user who is blocking the friend request.
	 * @param buddyName
	 *            - Name of user whose friend request has to block.
	 * @return Buddy object
	 * @throws App42Exception
	 */
	@Method(selector = "blockFriendRequestFromBuddy:userName:completionBlock:")
	public native void blockFriendRequest(String buddyName, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Never get any request by this user
	 *
	 * @param userName
	 *            : name of the user who is blocking.
	 * @param buddyName
	 *            : name of the user to whom to block.
	 * @return Buddy object
	 * @throws App42Exception
	 */
	@Method(selector = "blockBuddy:byUser:completionBlock:")
	public native void blockBuddy(String buddyName, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Unblock User
	 *
	 * @param userName
	 *            : name of user who is unblocking the specific buddy
	 * @param buddyName
	 *            : name of user to be unblocked
	 * @return Buddy object
	 * @throws App42Exception
	 */
	@Method(selector = "unblockBuddy:byUser:completionBlock:")
	public native void unblockBuddy(String buddyName, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Send the message to the group.
	 *
	 * @param userName
	 *            - Name of the user who wan't to send the message.
	 * @param ownerName
	 *            - Name of the user who created the group for which are going
	 *            to send the message
	 * @param groupName
	 *            - Name of the group which is created by the ownerUser.
	 * @param message
	 *            - Message for the receiver.
	 * @return - Buddy Object
	 * @throws App42Exception
	 */
	@Method(selector = "sendMessage:fromUser:toGroup:ofGroupOwner:completionBlock:")
	public native void sendMessage(String message, String userName, String groupName, String ownerName, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param userName
	 * @param buddyName
	 * @param message
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "sendMessage:toFriend:fromUser:completionBlock:")
	public native void sendMessage(String message, String buddyName, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param userName
	 * @param message
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "sendMessageToFriends:fromUser:completionBlock:")
	public native void sendMessageToFriends(String message, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param userName
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "getAllMessages:completionBlock:")
	public native void getAllMessages(String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param userName
	 *            - Name of the user who want to fetch the message from buddy
	 * @param buddyName
	 *            - Name of Buddy for which message has to fetch.
	 * @return Buddy object
	 * @throws App42Exception
	 */
	@Method(selector = "getAllMessagesFromBuddy:toUser:completionBlock:")
	public native void getAllMessagesFromBuddy(String buddyName, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param userName
	 *            - Name of the user who want to fetch the message from the
	 *            group
	 * @param groupOwner
	 *            - Name of owner of the group
	 * @param groupName
	 *            - Name of the group from which message has to fetch
	 * @return Buddy object
	 * @throws App42Exception
	 */
	@Method(selector = "getAllMessagesFromGroup:ofGroupOwner:toUser:completionBlock:")
	public native void getAllMessagesFromGroup(String groupName, String groupOwner, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param userName
	 * @param buddyName
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "unFriend:buddyName:completionBlock:")
	public native void unFriend(String userName, String buddyName, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param userName
	 * @param messageId
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "deleteMessageById:userName:completionBlock:")
	public native void deleteMessageById(String messageId, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param userName
	 * @param messageIds
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "deleteMessageByIds:")
	public native void deleteMessageByIds(NSArray<?> messageIds, String userName, @Block App42ResponseBlock completionBlock);
}

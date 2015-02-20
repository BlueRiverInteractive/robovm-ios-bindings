//
//  BuddyService.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 02/07/13.
//  Copyright (c) 2013 ShephertzTechnology PVT LTD. All rights reserved.
//

#import "App42Service.h"
#import "Buddy.h"


@class App42Response;
@class GeoPoint;
@interface BuddyService : App42Service

- (id) init __attribute__((unavailable));
/**
 * This is a constructor that takes
 *
 * @param apiKey
 * @param secretKey
 * @param baseURL
 *
 */
-(id)initWithAPIKey:(NSString *)apiKey  secretKey:(NSString *)secretKey;


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
-(void)sendFriendRequestFromUser:(NSString*)userName toBuddy:(NSString*) buddyName withMessage:(NSString*)message completionBlock:(App42ResponseBlock)completionBlock;

/**
 * Fetch all the friend request for the user.
 *
 * @param userName
 *            - Name of user for which request has to be fetched.
 * @return Buddy Object
 * @throws App42Exception
 */

-(void)getFriendRequest:(NSString *)userName completionBlock:(App42ResponseBlock)completionBlock;

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

-(void)acceptFriendRequestFromBuddy:(NSString*)buddyName toUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

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
-(void)rejectFriendRequestFromBuddy:(NSString*)buddyName toUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

/**
 *
 * @param userName
 *            - Name of the user who want to create the group
 * @param groupName
 *            - Name of the group which is to be create
 * @return Buddy object
 * @throws App42Exception
 */
-(void)createGroup:(NSString*)groupName byUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

/**
 *
 * @param userName
 *            - Name of the user who want to fetch the friend request
 * @return buddy object
 * @throws App42Exception
 */

-(void)getAllFriends:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

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

-(void)addFriends:(NSArray*)friends ofUser:(NSString*)userName toGroup:(NSString*)groupName completionBlock:(App42ResponseBlock)completionBlock;

/**
 *
 * @param userName
 *            - Name of the user who want to checkedIn the geo location
 * @param geoPoint
 *            - geo points of user which is to chechedIn
 * @return buddy object
 * @throws App42Exception
 */
-(void)checkedInWithUser:(NSString*)userName geoLocation:(GeoPoint*)point completionBlock:(App42ResponseBlock)completionBlock;

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
-(void)getFriendsOfUser:(NSString *)userName withLatitude:(double)latitude andLongitude:(double)longitude inRadius:(double)maxDistance max:(int) max completionBlock:(App42ResponseBlock)completionBlock;

/**
 * Get All groups created by user
 *
 * @param userName
 *            - Name of the user for which group has to be fetched.
 * @return Buddy object
 * @throws App42Exception
 */

-(void)getAllGroups:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

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
-(void)getAllFriendsOfUser:(NSString*)userName inGroup:(NSString*)groupName ofOwner:(NSString*)ownerName completionBlock:(App42ResponseBlock)completionBlock;

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

-(void)blockFriendRequestFromBuddy:(NSString*)buddyName toUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

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

-(void)blockBuddy:(NSString*)buddyName byUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

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
-(void)unblockBuddy:(NSString*)buddyName byUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

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
-(void)sendMessage:(NSString*)message fromUser:(NSString*)userName toGroup:(NSString*)groupName ofGroupOwner:(NSString*)ownerName completionBlock:(App42ResponseBlock)completionBlock;

/**
 *
 * @param userName
 * @param buddyName
 * @param message
 * @return
 * @throws App42Exception
 */
-(void)sendMessage:(NSString*)message toFriend:(NSString*)buddyName fromUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

/**
 *
 * @param userName
 * @param message
 * @return
 * @throws App42Exception
 */
-(void)sendMessageToFriends:(NSString*)message fromUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

/**
 *
 * @param userName
 * @return
 * @throws App42Exception
 */
-(void)getAllMessages:(NSString*) userName completionBlock:(App42ResponseBlock)completionBlock;

/**
 *
 * @param userName
 *            - Name of the user who want to fetch the message from buddy
 * @param buddyName
 *            - Name of Buddy for which message has to fetch.
 * @return Buddy object
 * @throws App42Exception
 */
-(void)getAllMessagesFromBuddy:(NSString*)buddyName toUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

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
-(void)getAllMessagesFromGroup:(NSString*)groupName ofGroupOwner:(NSString*)groupOwner toUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;
/**
 *
 * @param userName
 * @param buddyName
 * @return
 * @throws App42Exception
 */

-(void)unFriend:(NSString*)userName buddyName:(NSString*)buddyName completionBlock:(App42ResponseBlock)completionBlock;

/**
 *
 * @param userName
 * @param messageId
 * @return
 * @throws App42Exception
 */
-(void)deleteMessageById:(NSString*)messageId userName:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

/**
 *
 * @param userName
 * @param messageIds
 * @return
 * @throws App42Exception
 */
-(void)deleteMessageByIds:(NSArray*)messageIds userName:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;
@end

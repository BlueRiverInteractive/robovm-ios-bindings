package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSArray;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class GiftService extends App42Service
{
	public GiftService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);

	/**
	 * Create a gift.
	 *
	 * @param giftName
	 *            - Name of gift to be created.
	 * @param giftIconPath
	 *            - File path of the gift icon
	 * @param displayName
	 *            - An alternate name of the gift that can be used to display
	 * @param tag
	 *            - tag for the Gift
	 * @param description
	 *            - Description of the Gift to be created
	 * @return Gift Object
	 * @throws App42Exception
	 */
	@Method(selector = "createGiftWithName:giftIconPath:displayName:giftTag:description:completionBlock:")
	public native void createGift(String giftName, String giftIconPath, String displayName, String tag, String description, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Get all gifts available.
	 *
	 * @return NSArray of gift Object
	 * @throws App42Exception
	 */
	@Method(selector = "getAllGifts:")
	public native void getAllGifts(@Block App42ResponseBlock completionBlock);

	/**
	 * Get gift with its name.
	 *
	 * @param giftName
	 *            - Name of gift to be fetched.
	 * @return Gift Object
	 * @throws App42Exception
	 */
	@Method(selector = "getGiftByName:completionBlock:")
	public native void getGiftByName(String giftName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Get all gifts having same tag.
	 *
	 * @param tag
	 *            - tag for the Gift
	 * @return NSArray of gift Objects
	 * @throws App42Exception
	 */
	@Method(selector = "getGiftsByTag:completionBlock:")
	public native void getGiftsByTag(String tag, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Delete a gift with name.
	 *
	 * @param giftName
	 *            - Name of gift to be created.
	 * @return App42Response
	 * @throws App42Exception
	 */
	@Method(selector = "deleteGiftByName:completionBlock:")
	public native void deleteGiftByName(String giftName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Send a gift with name to other users.
	 *
	 * @param giftName
	 *            - Name of gift to be created.
	 * @param sender
	 *            - Name of the user who is sending the gift.
	 * @param recipients
	 *            - Array of the user who will receive the gift.
	 * @param message
	 *            - message that you want to send with gift.
	 * @return Gift Object
	 * @throws App42Exception
	 */
	@Method(selector = "sendGiftWithName:from:to:withMessage:completionBlock:")
	public native void sendGift(String giftName, String sender, NSArray<?> recipients, String message, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Request a gift with name from other users.
	 *
	 * @param giftName
	 *            - Name of gift to be created.
	 * @param sender
	 *            - Name of the user who is requesting for the gift.
	 * @param recipients
	 *            - Array of the user who will receive the request.
	 * @param message
	 *            - message that you want to send with request.
	 * @return Gift Object
	 * @throws App42Exception
	 */
	@Method(selector = "requestGiftWithName:from:to:withMessage:completionBlock:")
	public native void requestGift(String giftName, String sender, NSArray<?> recipients, String message, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Get a gift request from a user.
	 *
	 * @param giftName
	 *            - Name of gift to be created.
	 * @param userName
	 *            - Name of the user who is requesting for the gift.
	 * @return Gift Object
	 * @throws App42Exception
	 */
	@Method(selector = "getGiftRequestWithName:fromUser:completionBlock:")
	public native void getGiftRequest(String giftName, String userName, @Block App42ResponseBlock completionBlock);

	@Method(selector = "distributeGiftsWithName:to:recipients:count:completionBlock:")
	public native void distributeGifts(String giftName, NSArray<?> recipients, int count, @Block App42ResponseBlock completionBlock);
	
	@Method(selector = "getGiftCountWithName:forUser:completionBlock:")
	public native void getGiftCount(String giftName, String userName, @Block App42ResponseBlock completionBlock);

	@Method(selector = "acceptGiftRequestWithId:by:completionBlock:")
	public native void acceptGiftRequest(String requestId, String recipient, @Block App42ResponseBlock completionBlock);
	
	@Method(selector = "rejectGiftRequestWithId:by:completionBlock:")
	public native void rejectGiftRequest(String requestId, String recipient, @Block App42ResponseBlock completionBlock);
	
	@Method(selector = "removeGiftWithRequestId:by:completionBlock:")
	public native void removeGift(String requestId, String recipient, @Block App42ResponseBlock completionBlock);
}

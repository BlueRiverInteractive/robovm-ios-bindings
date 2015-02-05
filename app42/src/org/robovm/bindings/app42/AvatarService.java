package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSData;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class AvatarService extends App42Service
{
	/**
	 * This is a constructor that takes
	 *
	 * @param apiKey
	 * @param secretKey
	 * @param baseURL
	 *
	 */
	public AvatarService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);

	/**
	 * Upload your own avatar from binary.
	 *
	 * @param name
	 *            - Name of avatar to be created.
	 * @param userName
	 *            - Name of the user who is creating avatar
	 * @param filePath
	 *            - The local path for the file
	 * @param description
	 *            - Description of the avatar
	 * @return Avatar Object
	 * @throws App42Exception
	 */
	@Method(selector = "createAvatarWithName:userName:filePath:description:completionBlock:")
	public native void createAvatar(String name, String userName, String filePath, String description, @Block App42ResponseBlock completionBlock);

	/**
	 * Import your avatar from Facebook based of given access token.
	 *
	 * @param avatarName
	 *            - Name of avatar to be created.
	 * @param userName
	 *            - Name of the user who is creating avatar
	 * @param accessToken
	 *            - Facebook Access Token that has been received after
	 *            authorization
	 * @param description
	 *            - Description of the avatar
	 * @return Avatar Object
	 * @throws App42Exception
	 */
	@Method(selector = "createAvatarFromFacebookWithName:userName:accessToken:description:completionBlock:")
	public native void createAvatarFromFacebook(String avatarName, String userName, String accessToken, String description, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Create avatar from any web media using URL
	 *
	 * @param avatarName
	 *            - Name of avatar to be created
	 * @param userName
	 *            - Name of the user who is creating avatar
	 * @param webUrl
	 *            - WebURL of photo which you want to create
	 * @param description
	 *            - Description of the avatar
	 * @return Avatar Object
	 * @throws App42Exception
	 */
	@Method(selector = "createAvatarFromWebURLWithName:userName:webUrl:description:completionBlock:")
	public native void createAvatarFromWebURL(String avatarName, String userName, String webUrl, String description, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Get detail description of avatar
	 *
	 * @param userName
	 *            - Name of the user for which avatar is to fetched
	 * @param avatarName
	 *            - Name of the avatar is to be fetched
	 * @return Avatar Object
	 * @throws App42Exception
	 */
	@Method(selector = "getAvatarByName:userName:completionBlock:")
	public native void getAvatarByName(String avatarName, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * View all avatars.
	 *
	 * @param userName
	 *            - Name of the user for which avatar is to fetched
	 * @return Array of Avatar Objects
	 * @throws App42Exception
	 */
	@Method(selector = "getAllAvatarsForUser:completionBlock:")
	public native void getAllAvatarsForUser(String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * View the latest avatar uploaded by user.
	 *
	 *
	 * @param userName
	 *            - Name of the user for which current avatar is to fetch
	 * @return Avatar Object
	 * @throws App42Exception
	 */
	@Method(selector = "getCurrentAvatar:completionBlock:")
	public native void getCurrentAvatar(String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Change your current avatar from existing avatars in app.
	 *
	 * @param userName
	 *            - Name of the user for which avatar is to updated.
	 * @param avatarName
	 *            - Name of the avatar to be updated.
	 * @return Avatar Object
	 * @throws App42Exception
	 */
	@Method(selector = "changeCurrentAvatarWithName:forUser:completionBlock:")
	public native void changeCurrentAvatar(String avatarName, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param avatarName
	 * @param userName
	 * @param fileData
	 * @param description
	 * @param extension
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "createAvatarFromFileDataWithName:userName:fileData:description:extension:completionBlock:")
	public native void createAvatarFromFileDataWithName(String avatarName, String userName, NSData fileData, String description, String extension, @Block App42ResponseBlock completionBlock);
}

package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSArray;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class SocialService extends App42Service
{
	public SocialService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
	/**
	 * Links the User Facebook access credentials to the App User account.
	 *
	 * @param userName
	 *            - Name of the user whose Facebook account to be linked
	 * @param accessToken
	 *            - Facebook Access Token that has been received after
	 *            authorization
	 * @param appId
	 *            - Facebook App Id
	 * @param appSecret
	 *            - Facebook App Secret
	 *
	 * @returns The Social object
	 *
	 */
	@Method(selector = "linkUserFacebookAccount:appId:appSecret:accessToken:completionBlock:")
	public native void linkUserFacebookAccount(String userName, String appId, String appSecret, String accessToken, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Links the User Facebook access credentials to the App User account.
	 *
	 * @param userName
	 *            - Name of the user whose Facebook account to be linked
	 * @param accessToken
	 *            - Facebook Access Token that has been received after
	 *            authorization
	 *
	 * @returns The Social object
	 *
	 */
	@Method(selector = "linkUserFacebookAccount:accessToken:completionBlock:")
	public native void linkUserFacebookAccount(String userName, String accessToken, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Updates the Facebook status of the specified user.
	 *
	 * @param userName
	 *            - Name of the user for whom the status needs to be updated
	 * @param status
	 *            - status that has to be updated
	 *
	 * @returns The Social object
	 *
	 *
	 */
	@Method(selector = "updateFacebookStatus:status:completionBlock:")
	public native void updateFacebookStatus(String userName, String status, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Links the User Twitter access credentials to the App User account.
	 *
	 * @param userName
	 *            - Name of the user whose Twitter account to be linked
	 * @param consumerKey
	 *            - Twitter App Consumer Key
	 * @param consumerSecret
	 *            - Twitter App Consumer Secret
	 * @param accessToken
	 *            - Twitter Access Token that has been received after
	 *            authorization
	 * @param accessTokenSecret
	 *            - Twitter Access Token Secret that has been received after
	 *            authorization
	 *
	 * @returns The Social object
	 *
	 *
	 */
	@Method(selector = "linkUserTwitterAccount:consumerKey:consumerSecret:accessToken:accessTokenSecret:completionBlock:")
	public native void linkUserTwitterAccount(String userName, String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Links the User Twitter access credentials to the App User account.
	 *
	 * @param userName
	 *            - Name of the user whose Twitter account to be linked
	 * @param accessToken
	 *            - Twitter Access Token that has been received after
	 *            authorization
	 * @param accessTokenSecret
	 *            - Twitter Access Token Secret that has been received after
	 *            authorization
	 *
	 * @returns The Social object
	 *
	 */
	@Method(selector = "linkUserTwitterAccount:accessToken:accessTokenSecret:completionBlock:")
	public native void linkUserTwitterAccount(String userName, String accessToken, String accessTokenSecret, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Updates the Twitter status of the specified user.
	 *
	 * @param userName
	 *            - Name of the user for whom the status needs to be updated
	 * @param status
	 *            - status that has to be updated
	 *
	 * @returns The Social object
	 *
	 *
	 */
	@Method(selector = "updateTwitterStatus:status:completionBlock:")
	public native void updateTwitterStatus(String userName, String status, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Links the User LinkedIn access credentials to the App User account.
	 *
	 * @param userName
	 *            - Name of the user whose LinkedIn account to be linked
	 * @param apiKey
	 *            - LinkedIn App API Key
	 * @param secretKey
	 *            - LinkedIn App Secret Key
	 * @param accessToken
	 *            - LinkedIn Access Token that has been received after
	 *            authorization
	 * @param accessTokenSecret
	 *            - LinkedIn Access Token Secret that has been received after
	 *            authorization
	 *
	 * @returns The Social object
	 *
	 */
	@Method(selector = "linkUserLinkedInAccount:apiKey:secretKey:accessToken:accessTokenSecret:completionBlock:")
	public native void linkUserLinkedInAccount(String userName, String linkedInApiKey, String linkedInSecretKey, String accessToken, String accessTokenSecret, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Links the User LinkedIn access credentials to the App User account.
	 *
	 * @param userName
	 *            - Name of the user whose LinkedIn account to be linked
	 * @param accessToken
	 *            - LinkedIn Access Token that has been received after
	 *            authorization
	 * @param accessTokenSecret
	 *            - LinkedIn Access Token Secret that has been received after
	 *            authorization
	 *
	 * @returns The Social object
	 *
	 */
	@Method(selector = "linkUserLinkedInAccount:accessToken:accessTokenSecret:completionBlock:")
	public native void linkUserLinkedInAccount(String userName, String accessToken, String accessTokenSecret, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Updates the LinkedIn status of the specified user.
	 *
	 * @param userName
	 *            - Name of the user for whom the status needs to be updated
	 * @param status
	 *            - status that has to be updated
	 *
	 * @returns The Social object
	 *
	 */
	@Method(selector = "updateLinkedInStatus:status:completionBlock:")
	public native void updateLinkedInStatus(String userName, String status, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Updates the status for all linked social accounts of the specified user.
	 *
	 * @param userName
	 *            - Name of the user for whom the status needs to be updated
	 * @param status
	 *            - status that has to be updated
	 *
	 * @returns The Social object
	 *
	 */
	@Method(selector = "updateSocialStatusForAll:status:completionBlock:")
	public native void updateSocialStatusForAll(String userName, String status, @Block App42ResponseBlock completionBlock);

	/**
	 * This function returns a list of facebook friends of the specified user by
	 * accessing the facebook account.
	 *
	 * @param userName
	 *            - Name of the user whose Facebook friends account has to be
	 *            retrieve
	 * @return Social Object
	 * @throws App42Exception
	 */
	@Method(selector = "getFacebookFriendsFromLinkUser:completionBlock:")
	public native void getFacebookFriendsFromLinkUser(String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * This function returns a list of facebook friends of the specified user
	 * using a given authorization token. To get the friend list here, user
	 * needs not to log into the facebook account.
	 *
	 * @param accessToken
	 *            - Facebook Access Token that has been received after authorization
	 * @return Social Object
	 * @throws App42Exception
	 */
	@Method(selector = "getFacebookFriendsFromAccessToken:completionBlock:")
	public native void getFacebookFriendsFromAccessToken(String accessToken, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * Share binary files on your facebook wall with custom message.
	 *
	 * @param accessToken
	 *            - Facebook Access Token that has been received after
	 *            authorization
	 * @param name
	 *            - name of the file which has to be share.
	 * @param filePath
	 *            - file path of your local machiene
	 * @param message
	 *            - Message which has to be post with Link.
	 * @return App42Response Object
	 * @throws App42Exception
	 */
	@Method(selector = "facebookPublishStream:fileName:filePath:message:completionBlock:")
	public native void facebookPublishStream(String accessToken, String fileName, String filePath, String message, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * Share your link on facebook based on access token.
	 *
	 * @param accessToken
	 *            - Facebook Access Token that has been received after
	 *            authorization.
	 * @param link
	 *            - Link which has to be post on facebook wall.
	 * @param message
	 *            - Message which has to be post with Link.
	 * @return App42Response Object
	 * @throws App42Exception
	 */
	@Method(selector = "facebookLinkPost:link:message:completionBlock:")
	public native void facebookLinkPost(String accessToken, String link, String message, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * Share your link on facebook based on custom image and message.
	 *
	 *
	 * @param accessToken
	 *            -Facebook Access Token that has been received after
	 *            authorization
	 * @param link
	 *            - Link which has to be share on facebook.
	 * @param message
	 *            - Message which has to be share with Link.
	 * @param pictureUrl
	 *            - Your Thumbnail image url which you want to share on
	 *            facebook.
	 * @param name
	 *            - Name of your File.
	 * @param description
	 *            - Description about your link.
	 * @return App42Response Object
	 * @throws App42Exception
	 */
  	@Method(selector = "facebookLinkPostWithCustomThumbnail:link:message:pictureUrl:fileName:description:completionBlock:")
	public native void facebookLinkPostWithCustomThumbnail(String accessToken, String link, String message, String pictureUrl, String fileName, String description, @Block App42ResponseBlock completionBlock);
	/**
	 * Fetch the profile info like profile pic ,facebookID and user name based
	 * on facebook access token.
	 *
	 * @param accessToken
	 *            -Facebook Access Token for which Profile Info has to be
	 *            fetched.
	 * @return App42Response Object
	 * @throws App42Exception
	 */
  	@Method(selector = "getFacebookProfile:completionBlock:")
	public native void getFacebookProfile(String accessToken, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Get the facebook profile info for the gives IDs
	 *
	 * @param facebookIds
	 *            - facebook id(s) of the user(s) for which facebook profile
	 *            info is to fetch.
	 * @return Social object
	 * @throws App42Exception
	 */
  	@Method(selector = "getFacebookProfilesFromIds:completionBlock:")
	public native void getFacebookProfilesFromIds(NSArray<?> facebookIds, @Block App42ResponseBlock completionBlock);
}

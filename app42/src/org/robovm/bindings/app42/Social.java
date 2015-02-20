package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Social extends App42Response
{
	@Property(selector = "userName")
	public native String getUserName();

	@Property(selector = "setUserName:", strongRef = true)
	public native void setUserName(String userName);
	
	@Property(selector = "status")
	public native String getStatus();

	@Property(selector = "setStatus:", strongRef = true)
	public native void setStatus(String status);

	@Property(selector = "facebookAppId")
	public native String getFacebookAppId();

	@Property(selector = "setFacebookAppId:", strongRef = true)
	public native void setFacebookAppId(String facebookAppId);
	
	@Property(selector = "facebookAppSecret")
	public native String getFacebookAppSecret();

	@Property(selector = "setfacebookAppSecret:", strongRef = true)
	public native void setfacebookAppSecret(String facebookAppSecret);
	
	@Property(selector = "facebookAccessToken")
	public native String getFacebookAccessToken();

	@Property(selector = "setFacebookAccessToken:", strongRef = true)
	public native void setFacebookAccessToken(String facebookAccessToken);

	@Property(selector = "twitterConsumerKey")
	public native String getTwitterConsumerKey();

	@Property(selector = "setTwitterConsumerKey:", strongRef = true)
	public native void setTwitterConsumerKey(String twitterConsumerKey);
	
	@Property(selector = "twitterConsumerSecret")
	public native String getTwitterConsumerSecret();

	@Property(selector = "setTwitterConsumerSecret:", strongRef = true)
	public native void setTwitterConsumerSecret(String twitterConsumerSecret);

	@Property(selector = "twitterAccessToken")
	public native String getTwitterAccessToken();

	@Property(selector = "setTwitterAccessToken:", strongRef = true)
	public native void setTwitterAccessToken(String twitterAccessToken);

	@Property(selector = "twitterAccessTokenSecret")
	public native String getTwitterAccessTokenSecret();

	@Property(selector = "setTwitterAccessTokenSecret:", strongRef = true)
	public native void setTwitterAccessTokenSecret(String twitterAccessTokenSecret);

	@Property(selector = "linkedinApiKey")
	public native String getLinkedinApiKey();

	@Property(selector = "setLinkedinApiKey:", strongRef = true)
	public native void setLinkedinApiKey(String linkedinApiKey);

	@Property(selector = "linkedinSecretKey")
	public native String getLinkedinSecretKey();

	@Property(selector = "setLinkedinSecretKey:", strongRef = true)
	public native void setLinkedinSecretKey(String linkedinSecretKey);

	@Property(selector = "linkedinAccessToken")
	public native String getLinkedinAccessToken();

	@Property(selector = "setLinkedinAccessToken:", strongRef = true)
	public native void setLinkedinAccessToken(String linkedinAccessToken);

	@Property(selector = "linkedinAccessTokenSecret")
	public native String getLinkedinAccessTokenSecret();

	@Property(selector = "setLinkedinAccessTokenSecret:", strongRef = true)
	public native void setLinkedinAccessTokenSecret(String linkedinAccessTokenSecret);

	@Property(selector = "friendsList")
	public native NSMutableArray<?> getFriendsList();

	@Property(selector = "setFriendsList:", strongRef = true)
	public native void setFriendsList(NSMutableArray<?> friendsList);

	@Property(selector = "facebookProfile")
	public native FacebookProfile getFacebookProfile();

	@Property(selector = "setFacebookProfile:", strongRef = true)
	public native void setFacebookProfile(FacebookProfile facebookProfile);

	@Property(selector = "publicProfile")
	public native NSMutableArray<?> getPublicProfile();

	@Property(selector = "setPublicProfile:", strongRef = true)
	public native void setPublicProfile(NSMutableArray<?> publicProfile);
}

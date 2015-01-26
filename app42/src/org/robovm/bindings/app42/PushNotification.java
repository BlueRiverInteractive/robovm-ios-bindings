package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class PushNotification extends App42Response
{
	@Property(selector = "channelList")
	public native NSMutableArray<?> getChannelList();

	@Property(selector = "setChannelList:", strongRef = true)
	public native void setChannelList(NSMutableArray<?> channelList);

	@Property(selector = "message")
	public native String getMessage();

	@Property(selector = "setMessage:", strongRef = true)
	public native void setMessage(String message);

	@Property(selector = "userName")
	public native String getUserName();

	@Property(selector = "setUserName:", strongRef = true)
	public native void setUserName(String userName);

	@Property(selector = "expiry")
	public native String getExpiry();

	@Property(selector = "setExpiry:", strongRef = true)
	public native void setExpiry(String expiry);
	
	@Property(selector = "type")
	public native String getType();

	@Property(selector = "setType:", strongRef = true)
	public native void setType(String type);
	
	@Property(selector = "deviceToken")
	public native String getDeviceToken();

	@Property(selector = "setDeviceToken:", strongRef = true)
	public native void setDeviceToken(String deviceToken);
}

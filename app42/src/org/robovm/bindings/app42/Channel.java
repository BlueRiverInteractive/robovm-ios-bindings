package org.robovm.bindings.app42;

import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class Channel extends App42Response
{
	@Property(selector = "channelName")
	public native String getName();

	@Property(selector = "setChannelName:", strongRef = true)
	public native void setChannelName(String channelName);
	
	@Property(selector = "description")
	public native String getDescription();

	@Property(selector = "setDescription:", strongRef = true)
	public native void setDescription(String description);
	
	@Property(selector = "pushNotificationObject")
	public native PushNotification getPushNotification();

	@Property(selector = "setPushNotificationObject:", strongRef = true)
	public native void setPushNotificationObject(PushNotification pushNotification);

	public Channel(PushNotification pushNotificationObject) {
		super((SkipInit) null);
	    initObject(init(pushNotificationObject));
	}
	
	@Method(selector = "initWithPush:")
	private native @Pointer long init(PushNotification pushNotificationObject);
}

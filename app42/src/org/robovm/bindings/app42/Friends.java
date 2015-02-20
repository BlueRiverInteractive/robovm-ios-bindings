package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Friends extends NSObject
{
	@Property(selector = "name")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);
	
	@Property(selector = "picture")
	public native String getPicture();

	@Property(selector = "setPicture:", strongRef = true)
	public native void setPicture(String picture);
	
	@Property(selector = "friendId")
	public native String getFriendId();

	@Property(selector = "setFriendId:", strongRef = true)
	public native void setFriendId(String friendId);
	
	@Property(selector = "installed")
	public native boolean isInstalled();

	@Property(selector = "setInstalled:", strongRef = true)
	public native void setInstalled(boolean isInstalled);
}

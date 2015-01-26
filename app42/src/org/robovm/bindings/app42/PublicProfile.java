package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class PublicProfile extends NSObject
{
	@Property(selector = "name")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);

	@Property(selector = "fbId")
	public native String getFbId();

	@Property(selector = "setFbId:", strongRef = true)
	public native void setFbId(String fbId);

	@Property(selector = "picture")
	public native String getPicture();

	@Property(selector = "setPicture:", strongRef = true)
	public native void setPicture(String picture);
}

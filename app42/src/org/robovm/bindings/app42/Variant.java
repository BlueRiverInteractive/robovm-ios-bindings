package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Variant extends NSObject
{
	@Property(selector = "name")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);
	
	@Property(selector = "profile")
	public native String getProfile();

	@Property(selector = "setProfile:", strongRef = true)
	public native void setProfile(String profile);
}

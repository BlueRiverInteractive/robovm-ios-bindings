package org.robovm.bindings.app42;

import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class PreferenceData extends App42Response
{
	@Property(selector = "userId")
	public native String getUserId();

	@Property(selector = "setUserId:", strongRef = true)
	public native void setUserId(String userId);

	@Property(selector = "itemId")
	public native String getItemId();

	@Property(selector = "setItemId:", strongRef = true)
	public native void setItemId(String itemId);

	@Property(selector = "preference")
	public native String getPreference();

	@Property(selector = "setPreference:", strongRef = true)
	public native void setPreference(String preference);
}

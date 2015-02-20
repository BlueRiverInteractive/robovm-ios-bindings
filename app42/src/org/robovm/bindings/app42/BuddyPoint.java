package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDate;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class BuddyPoint extends NSObject
{
	@Property(selector = "latitude")
	public native double getLatitude();

	@Property(selector = "setLatitude:", strongRef = true)
	public native void setLatitude(double latitude);
	
	@Property(selector = "longitude")
	public native double getLongitude();

	@Property(selector = "setLongitude:", strongRef = true)
	public native void setLongitude(double longitude);
	
	@Property(selector = "buddyName")
	public native String getBuddyName();

	@Property(selector = "setBuddyName:", strongRef = true)
	public native void setBuddyName(String buddyName);
	
	@Property(selector = "markerName")
	public native String getMarkerName();

	@Property(selector = "setMarkerName:", strongRef = true)
	public native void setMarkerName(String markerName);
	
	@Property(selector = "createdOn")
	public native NSDate getCreatedOn();

	@Property(selector = "setCreatedOn:", strongRef = true)
	public native void setCreatedOn(NSDate createdOn);

	@Method(selector = "getBuddyPointDict:")
	public native NSDictionary<?, ?> getBuddyPointDict();
}

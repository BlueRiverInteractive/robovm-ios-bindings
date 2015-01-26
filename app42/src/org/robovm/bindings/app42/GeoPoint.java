package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class GeoPoint extends NSObject
{
	@Property(selector = "latitude")
	public native double getLatitude();

	@Property(selector = "setLatitude:", strongRef = true)
	public native void setLatitude(double latitude);

	@Property(selector = "longitude")
	public native double getLongitude();

	@Property(selector = "setLongitude:", strongRef = true)
	public native void setLongitude(double longitude);
	
	@Property(selector = "marker")
	public native String getMarker();

	@Property(selector = "setMarker:", strongRef = true)
	public native void setMarker(String marker);

	@Method(selector = "getGeoPointValues")
	public native NSMutableDictionary<?, ?> getGeoPointValues();
}

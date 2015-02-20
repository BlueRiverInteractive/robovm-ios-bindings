package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class GeoTag extends NSObject
{
	@Property(selector = "lat")
	public native double getLat();

	@Property(selector = "setLat:", strongRef = true)
	public native void setLat(double lat);

	@Property(selector = "lng")
	public native double getLng();

	@Property(selector = "setLng:", strongRef = true)
	public native void setLng(double lng);

	public GeoTag(double latitude, double longitude) {
		super((SkipInit) null);
	    initObject(init(latitude, longitude));
	}
	
	@Method(selector = "initWithLatitude:andLongitude:")
	private native @Pointer long init(double latitude, double longitude);
	
	/**
	 * Values coming from response are converted NSDictionary.
	 *
	 * @return NSDictionary
	 */
	@Method(selector = "getGeoTag")
	public native NSDictionary<?, ?> getGeoTag();
	
	@Method(selector = "toString")
	public native String toString();
}

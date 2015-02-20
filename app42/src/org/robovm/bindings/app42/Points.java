package org.robovm.bindings.app42;

import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class Points extends App42Response
{
	@Property(selector = "lat")
	public native double getLat();

	@Property(selector = "setLatitude:", strongRef = true)
	public native void setLat(double lat);

	@Property(selector = "lng")
	public native double getLng();

	@Property(selector = "setLng:", strongRef = true)
	public native void setLng(double lng);
	
	@Property(selector = "marker")
	public native String getMarker();

	@Property(selector = "setMarker:", strongRef = true)
	public native void setMarker(String marker);
	
	public Points(Geo geo) {
		super((SkipInit) null);
	    initObject(init(geo));
	}
	
	@Method(selector = "initWithGeo:")
	private native @Pointer long init(Geo geo);
}

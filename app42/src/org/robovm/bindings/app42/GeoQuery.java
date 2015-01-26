package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class GeoQuery extends NSObject
{
	public static final String APP42_OP_NEAR = "$near";
	public static final String APP42_OP_WITHIN = "$within";
	
	@Property(selector = "geoQueryObject")
	public native NSMutableDictionary<?, ?> getGeoQuery();

	@Property(selector = "setGeoQueryObject:", strongRef = true)
	public native void setGeoQuery(NSMutableDictionary<?, ?> geoQuery);
	
	@Property(selector = "geoQueryObjectArray")
	public native NSMutableArray<?> getGeoQueryArray();

	@Property(selector = "setGeoQueryObjectArray:", strongRef = true)
	public native void setGeoQueryArray(NSMutableArray<?> geoQueryArray);

	public GeoQuery(GeoQuery geoQuery) {
		super((SkipInit) null);
	    initObject(init(geoQuery));
	}
	
	@Method(selector = "initWithGeoQuery:")
	private native @Pointer long init(GeoQuery geoQuery);

	@Method(selector = "getStr")
	public native String getStr();
}

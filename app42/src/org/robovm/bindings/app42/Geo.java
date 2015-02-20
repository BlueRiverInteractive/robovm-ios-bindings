package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDate;
import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.Property;

public class Geo extends App42Response
{
	@Property(selector = "storageName")
	public native String getStorageName();

	@Property(selector = "setStorageName:", strongRef = true)
	public native void setStorageName(String storageName);
	
	@Property(selector = "sourceLat")
	public native String getSourceLat();

	@Property(selector = "setSourceLat:", strongRef = true)
	public native void setSourceLat(String sourceLat);
	
	@Property(selector = "sourceLng")
	public native String getSourceLng();

	@Property(selector = "setSourceLng:", strongRef = true)
	public native void setSourceLng(String sourceLng);
	
	@Property(selector = "distanceInKM")
	public native String getDistanceInKM();

	@Property(selector = "setDistanceInKM:", strongRef = true)
	public native void setDistanceInKM(String distanceInKM);
	
	@Property(selector = "createdOn")
	public native NSDate getCreatedOn();

	@Property(selector = "setCreatedOn:", strongRef = true)
	public native void setCreatedOn(NSDate createdOn);

	@Property(selector = "pointList")
	public native NSMutableArray<?> getPointList();

	@Property(selector = "setPointList:", strongRef = true)
	public native void setPointList(NSMutableArray<?> pointList);
}

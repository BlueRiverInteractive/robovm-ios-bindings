package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDate;
import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Gift extends App42Response
{
	@Property(selector = "name")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);

	@Property(selector = "displayName")
	public native String getDisplayName();

	@Property(selector = "setDisplayName:", strongRef = true)
	public native void setDisplayName(String displayName);
	
	@Property(selector = "icon")
	public native String getIcon();

	@Property(selector = "setIcon:", strongRef = true)
	public native void setIcon(String icon);

	@Property(selector = "description")
	public native String getDescription();

	@Property(selector = "setDescription:", strongRef = true)
	public native void setDescription(String description);
	
	@Property(selector = "tag")
	public native String getTag();

	@Property(selector = "setTag:", strongRef = true)
	public native void setTag(String tag);
	
	@Property(selector = "createdOn")
	public native NSDate getCreatedOn();

	@Property(selector = "setCreatedOn:", strongRef = true)
	public native void setCreatedOn(NSDate tag);

	@Property(selector = "requests")
	public native NSMutableArray<?> getRequests();

	@Property(selector = "setRequests:", strongRef = true)
	public native void setRequests(NSMutableArray<?> requests);
}

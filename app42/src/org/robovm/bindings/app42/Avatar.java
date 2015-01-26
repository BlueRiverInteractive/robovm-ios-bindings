package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDate;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Avatar extends App42Response
{
	@Property(selector = "getUserName")
	public native String getUserName();

	@Property(selector = "setUserName:", strongRef = true)
	public native void setUserName(String userName);
	
	@Property(selector = "getName")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);
	
	@Property(selector = "url")
	public native String getUrl();

	@Property(selector = "setUrl:", strongRef = true)
	public native void setUrl(String url);
	
	@Property(selector = "tinyUrl")
	public native String getTinyUrl();

	@Property(selector = "setTinyUrl:", strongRef = true)
	public native void setTinyUrl(String tinyUrl);
	
	@Property(selector = "description")
	public native String getDescription();

	@Property(selector = "setDescription:", strongRef = true)
	public native void setDescription(String description);
	
	@Property(selector = "createdOn")
	public native NSDate getCreatedOn();

	@Property(selector = "setCreatedOn:", strongRef = true)
	public native void setCreatedOn(NSDate createdOn);
	
	@Property(selector = "isCurrent")
	public native boolean isCurrent();

	@Property(selector = "setCurrent:", strongRef = true)
	public native void setCurrent(boolean isCurrent);
}

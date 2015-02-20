package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDate;
import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Session extends App42Response
{
	@Property(selector = "userName")
	public native String getUserName();

	@Property(selector = "setUserName:", strongRef = true)
	public native void setUserName(String userName);

	@Property(selector = "sessionId")
	public native String getSessionId();

	@Property(selector = "setSessionId:", strongRef = true)
	public native void setSessionId(String sessionId);

	@Property(selector = "invalidatedOn")
	public native NSDate getInvalidatedOn();

	@Property(selector = "setInvalidatedOn:", strongRef = true)
	public native void setInvalidatedOn(NSDate invalidatedOn);

	@Property(selector = "createdOn")
	public native NSDate getCreatedOn();

	@Property(selector = "setCreatedOn:", strongRef = true)
	public native void setCreatedOn(NSDate createdOn);

	@Property(selector = "attributeArray")
	public native NSMutableArray<?> getAttributeArray();

	@Property(selector = "setAttributeArray:", strongRef = true)
	public native void setAttributeArray(NSMutableArray<?> attributeArray);
}

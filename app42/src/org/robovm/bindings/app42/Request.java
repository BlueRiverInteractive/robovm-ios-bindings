package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDate;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Request extends NSObject
{
	@Property(selector = "sender")
	public native String getSender();

	@Property(selector = "setSender:", strongRef = true)
	public native void setSender(String sender);
	
	@Property(selector = "recipient")
	public native String getRecipient();

	@Property(selector = "setRecipient:", strongRef = true)
	public native void setRecipient(String recipient);

	@Property(selector = "message")
	public native String getMessage();

	@Property(selector = "setMessage:", strongRef = true)
	public native void setMessage(String message);

	@Property(selector = "requestId")
	public native String getRequestId();

	@Property(selector = "setRequestId:", strongRef = true)
	public native void setRequestId(String requestId);

	@Property(selector = "type")
	public native String getType();

	@Property(selector = "setType:", strongRef = true)
	public native void setType(String type);

	@Property(selector = "expiration")
	public native NSDate getExpiration();

	@Property(selector = "setExpiration:", strongRef = true)
	public native void setExpiration(NSDate expiration);

	@Property(selector = "sentOn")
	public native NSDate getSentOn();

	@Property(selector = "setSentOn:", strongRef = true)
	public native void setSentOn(NSDate sentOn);

	@Property(selector = "receivedOn")
	public native NSDate getReceivedOn();

	@Property(selector = "setReceivedOn:", strongRef = true)
	public native void setReceivedOn(NSDate receivedOn);
}

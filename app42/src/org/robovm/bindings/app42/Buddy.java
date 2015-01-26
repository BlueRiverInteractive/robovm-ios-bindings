package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDate;
import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Buddy extends App42Response
{
	@Property(selector = "userName")
	public native String getUserName();

	@Property(selector = "setUserName:", strongRef = true)
	public native void setUserName(String userName);
	
	@Property(selector = "buddyName")
	public native String getBuddyName();

	@Property(selector = "setBuddyName:", strongRef = true)
	public native void setBuddyName(String buddyName);
	
	@Property(selector = "groupName")
	public native String getGroupName();

	@Property(selector = "setGroupName:", strongRef = true)
	public native void setGroupName(String groupName);
	
	@Property(selector = "ownerName")
	public native String getOwnerName();

	@Property(selector = "setOwnerName:", strongRef = true)
	public native void setOwnerName(String ownerName);
	
	@Property(selector = "message")
	public native String getMessage();

	@Property(selector = "setMessage:", strongRef = true)
	public native void setMessage(String message);
	
	@Property(selector = "messageId")
	public native String getMessageId();

	@Property(selector = "setMessageId:", strongRef = true)
	public native void setMessageId(String messageId);
	
	@Property(selector = "sendedOn")
	public native NSDate getSentOn();

	@Property(selector = "setSentOn:", strongRef = true)
	public native void setSentOn(NSDate sendedOn);
	
	@Property(selector = "acceptedOn")
	public native NSDate getAcceptedOn();

	@Property(selector = "setAcceptedOn:", strongRef = true)
	public native void setAcceptedOn(NSDate acceptedOn);
	
	@Property(selector = "buddyList")
	public native NSMutableArray<?> getBuddyList();

	@Property(selector = "setBuddyList:", strongRef = true)
	public native void setBuddyList(NSMutableArray<?> buddyList);
	
	@Property(selector = "pointList")
	public native NSMutableArray<?> getPointList();

	@Property(selector = "setPointList:", strongRef = true)
	public native void setPointList(NSMutableArray<?> pointList);
}

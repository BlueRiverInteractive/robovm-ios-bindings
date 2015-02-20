package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Queue extends App42Response
{
	@Property(selector = "queueType")
	public native String getQueueType();

	@Property(selector = "setQueueType:", strongRef = true)
	public native void setQueueType(String queueType);
	
	@Property(selector = "queueName")
	public native String getQueueName();

	@Property(selector = "setQueueName:", strongRef = true)
	public native void setQueueName(String queueName);
	
	@Property(selector = "description")
	public native String getDescription();

	@Property(selector = "setDescription:", strongRef = true)
	public native void setDescription(String description);
	
	@Property(selector = "messageArray")
	public native NSMutableArray<?> getMessageArray();

	@Property(selector = "setMessageArray:", strongRef = true)
	public native void setMessageArray(NSMutableArray<?> messageArray);
}

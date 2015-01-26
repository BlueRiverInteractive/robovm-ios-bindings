package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class Message extends NSObject
{
	@Property(selector = "queueObject")
	public native Queue getQueue();

	@Property(selector = "setQueueObject:", strongRef = true)
	public native void setQueue(Queue queue);

	@Property(selector = "correlationId")
	public native String getCorrelationId();

	@Property(selector = "setCorrelationId:", strongRef = true)
	public native void setCorrelationId(String correlationId);

	@Property(selector = "payLoad")
	public native String getPayLoad();

	@Property(selector = "setPayLoad:", strongRef = true)
	public native void setPayLoad(String payLoad);

	@Property(selector = "messageId")
	public native String getMessageId();

	@Property(selector = "setMessageId:", strongRef = true)
	public native void setMessageId(String messageId);

	public Message(Queue queue) {
		super((SkipInit) null);
	    initObject(init(queue));
	}
	
	@Method(selector = "initWithQueue:")
	private native @Pointer long init(Queue queue);
}

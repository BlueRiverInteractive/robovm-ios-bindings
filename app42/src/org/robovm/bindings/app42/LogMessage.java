package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDate;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class LogMessage extends App42Response
{
	@Property(selector = "logObject")
	public native Log getLog();

	@Property(selector = "setLogObject:", strongRef = true)
	public native void setLog(Log log);

	@Property(selector = "message")
	public native String getMessage();

	@Property(selector = "setMessage:", strongRef = true)
	public native void setMessage(String message);

	@Property(selector = "type")
	public native String getType();

	@Property(selector = "setType:", strongRef = true)
	public native void setType(String type);

	@Property(selector = "logTime")
	public native NSDate getLogTime();

	@Property(selector = "setLogTime:", strongRef = true)
	public native void setLogTime(NSDate logTime);

	@Property(selector = "module")
	public native String getModule();

	@Property(selector = "setModule:", strongRef = true)
	public native void setModule(String module);
	
	public LogMessage(Log log) {
		super((SkipInit) null);
	    initObject(init(log));
	}
	
	@Method(selector = "initWithLog:")
	private native @Pointer long init(Log log);
}

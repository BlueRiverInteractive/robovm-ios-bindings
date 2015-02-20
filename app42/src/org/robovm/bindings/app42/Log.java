package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Log extends App42Response
{
	@Property(selector = "logMessageArray")
	public native NSMutableArray<?> getLogMessageArray();

	@Property(selector = "setLogMessageArray:", strongRef = true)
	public native void setLogMessageArray(NSMutableArray<?> logMessageArray);
}

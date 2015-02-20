package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Email extends App42Response
{
	@Property(selector = "from")
	public native String getFrom();

	@Property(selector = "setFrom:", strongRef = true)
	public native void setFrom(String from);
	
	@Property(selector = "to")
	public native String getTo();

	@Property(selector = "setTo:", strongRef = true)
	public native void setTo(String to);
	
	@Property(selector = "subject")
	public native String getSubject();

	@Property(selector = "setSubject:", strongRef = true)
	public native void setSubject(String subject);
	
	@Property(selector = "body")
	public native String getBody();

	@Property(selector = "setBody:", strongRef = true)
	public native void setBody(String body);
	
	@Property(selector = "configurationArray")
	public native NSMutableArray<?> getConfigurationArray();

	@Property(selector = "setConfigurationArray:", strongRef = true)
	public native void setConfigurationArray(NSMutableArray<?> configurationArray);
}

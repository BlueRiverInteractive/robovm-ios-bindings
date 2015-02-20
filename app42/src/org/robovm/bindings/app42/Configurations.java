package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class Configurations extends NSObject
{
	@Property(selector = "emailObj")
	public native Email getEmail();

	@Property(selector = "setEmailObj:", strongRef = true)
	public native void setEmailObj(Email email);
	
	@Property(selector = "emailId")
	public native String getEmailId();

	@Property(selector = "setEmailId:", strongRef = true)
	public native void setEmailId(String emailId);
	
	@Property(selector = "host")
	public native String getHost();

	@Property(selector = "setHost:", strongRef = true)
	public native void setHost(String host);
	
	@Property(selector = "port")
	public native int getPort();

	@Property(selector = "setPort:", strongRef = true)
	public native void setPort(int port);
	
	@Property(selector = "ssl")
	public native boolean getSsl();

	@Property(selector = "setSsl:", strongRef = true)
	public native void setSsl(boolean ssl);
	
	public Configurations(Email email) {
		super((SkipInit) null);
	    initObject(init(email));
	}
	
	@Method(selector = "initWithEmail:")
	private native @Pointer long init(Email email);
}

package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class App42NotFoundException extends App42Exception
{
	public App42NotFoundException(String aName, String aReason, NSDictionary<?, ?> aUserInfo) 
	{
		super(aName, aReason, aUserInfo);
		init(aReason, aUserInfo);
	}
	
	@Method(selector = "initWithreason:userInfo:")
	private native @Pointer long init(String aReason, NSDictionary<?, ?> aUserInfo);
}

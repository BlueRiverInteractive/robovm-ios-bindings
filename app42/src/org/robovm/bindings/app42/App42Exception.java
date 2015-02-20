package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSException;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class App42Exception extends NSException
{	
	public App42Exception(String aName, String aReason, NSDictionary<?, ?> aUserInfo) 
	{
		super(aName, aReason, aUserInfo);
		init(aReason, aUserInfo);
	}

	@Method(selector = "initWithreason:userInfo:")
	private native @Pointer long init(String aReason, NSDictionary<?, ?> aUserInfo);
	
	@Property(selector = "httpErrorCode")
	public native int getHttpErrorCode();

	@Property(selector = "setHttpErrorCode:", strongRef = true)
	public native void setHttpErrorCode(int httpErrorCode);
	
	@Property(selector = "appErrorCode")
	public native int getAppErrorCode();

	@Property(selector = "setAppErrorCode:", strongRef = true)
	public native void setAppErrorCode(int appErrorCode);
	
	@Method(selector = "exceptionWithReason:userInfo:httpStatusCode:appErrorCode:")
	public static native App42Exception exceptionWithReason(String aReason, NSDictionary<?, ?> aUserInfo, int httpCode, int appCode);
}

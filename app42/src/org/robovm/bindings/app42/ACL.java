package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class ACL extends NSObject 
{
	public static final String APP42_READ = "R";
	public static final String APP42_WRITE = "W";
	
	@Property(selector = "_userName")
	public native String getUserName();

	@Property(selector = "setUserName:", strongRef = true)
	public native void setUserName(String userName);
	
	@Property(selector = "_permission")
	public native String getPermission();

	@Property(selector = "setPermission:", strongRef = true)
	public native void setPermission(String permission);
	
	public ACL(String userName, String permission) {
	    initObject(init(userName, permission));
	}
	
	@Method(selector = "initWithUserName:andPermission:")
	private native @Pointer long init(String userName, String permission);
	
	@Method(selector = "toString")
	public native String toString();
	
	@Method(selector = "getACLParamsDict")
	public native NSDictionary<?, ?> getACLParamsDict();
	
	@Method(selector = "equals")
	public native boolean equals(NSObject object);
}

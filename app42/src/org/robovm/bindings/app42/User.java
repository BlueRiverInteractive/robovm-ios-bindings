package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSDate;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class User extends App42Response
{
	@Property(selector = "userName")
	public native String getUserName();

	@Property(selector = "setUserName:", strongRef = true)
	public native void setUserName(String userName);
	
	@Property(selector = "sessionId")
	public native String getSessionId();

	@Property(selector = "setSessionId:", strongRef = true)
	public native void setSessionId(String sessionId);
	
	@Property(selector = "email")
	public native String getEmail();

	@Property(selector = "setEmail:", strongRef = true)
	public native void setEmail(String email);

	@Property(selector = "password")
	public native String getPassword();

	@Property(selector = "setPassword:", strongRef = true)
	public native void setPassword(String password);

	@Property(selector = "profile")
	public native Profile getProfile();

	@Property(selector = "setProfile:", strongRef = true)
	public native void setProfile(Profile profile);
	
	@Property(selector = "isAccountLocked")
	public native boolean isAccountLocked();

	@Property(selector = "setAccountLocked:", strongRef = true)
	public native void setAccountLocked(boolean accountLocked);

	@Property(selector = "roleList")
	public native NSArray<?> getRoleList();

	@Property(selector = "setRoleList:", strongRef = true)
	public native void setRoleList(NSArray<?> roleList);

	@Property(selector = "createdOn")
	public native NSDate getCreatedOn();

	@Property(selector = "setCreatedOn:", strongRef = true)
	public native void setCreatedOn(NSDate createdOn);

	@Property(selector = "jsonDocArray")
	public native NSArray<?> getJsonDocArray();

	@Property(selector = "setJsonDocArray:", strongRef = true)
	public native void setJsonDocArray(NSArray<?> jsonDocArray);

	@Method(selector = "toString")
	public native String toString();
}

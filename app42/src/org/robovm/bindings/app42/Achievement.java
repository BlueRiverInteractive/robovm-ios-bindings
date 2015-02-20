package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDate;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Achievement extends App42Response
{
	@Property(selector = "userName")
	public native String getUserName();

	@Property(selector = "setUserName:", strongRef = true)
	public native void setUserName(String userName);
	
	@Property(selector = "description")
	public native String getDescription();

	@Property(selector = "setDescription:", strongRef = true)
	public native void setDescription(String description);
	
	@Property(selector = "name")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);
	
	@Property(selector = "gameName")
	public native String getGameName();

	@Property(selector = "setGameName:", strongRef = true)
	public native void setGameName(String gameName);
	
	@Property(selector = "achievedOn")
	public native NSDate getAchievedOn();

	@Property(selector = "setAchievedOn:", strongRef = true)
	public native void setAchievedOn(NSDate achievedOn);
}

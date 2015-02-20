package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDate;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Timer extends App42Response
{
	@Property(selector = "name")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);

	@Property(selector = "userName")
	public native String getUserName();

	@Property(selector = "setUserName:", strongRef = true)
	public native void setUserName(String userName);
	
	@Property(selector = "currentTime")
	public native NSDate getCurrentTime();

	@Property(selector = "setCurrentTime:", strongRef = true)
	public native void setCurrentTime(NSDate currentTime);

	@Property(selector = "startTime")
	public native NSDate getStartTime();

	@Property(selector = "setStartTime:", strongRef = true)
	public native void setStartTime(NSDate startTime);
	
	@Property(selector = "endTime")
	public native NSDate getEndTime();

	@Property(selector = "setEndTime:", strongRef = true)
	public native void setEndTime(NSDate endTime);

	@Property(selector = "timeInSeconds")
	public native long getTimeInSeconds();

	@Property(selector = "setTimeInSeconds:", strongRef = true)
	public native void setTimeInSeconds(long timeInSeconds);

	@Property(selector = "isTimerActive")
	public native boolean isTimerActive();

	@Property(selector = "setTimerActive:", strongRef = true)
	public native void setTimerActive(boolean isTimerActive);
}

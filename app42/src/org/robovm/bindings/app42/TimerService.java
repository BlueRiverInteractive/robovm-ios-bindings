package org.robovm.bindings.app42;

import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class TimerService extends App42Service
{
	public TimerService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
	@Method(selector = "createOrUpdateTimerWithName:timeInSeconds:completionBlock:")
	public native void createOrUpdateTimerWithName(String timerName, long timeInSeconds, @Block App42ResponseBlock completionBlock);

	@Method(selector = "startTimerWithName:forUser:completionBlock:")
	public native void startTimerWithName(String timerName, String userName, @Block App42ResponseBlock completionBlock);
	
	@Method(selector = "isTimerActive:forUser:completionBlock:")
	public native void isTimerActive(String timerName, String userName, @Block App42ResponseBlock completionBlock);
	
	@Method(selector = "cancelTimerWithName:forUser:completionBlock:")
	public native void cancelTimerWithName(String timerName, String userName, @Block App42ResponseBlock completionBlock);
	
	@Method(selector = "deleteTimerWithName:completionBlock:")
	public native void deleteTimerWithName(String timerName, @Block App42ResponseBlock completionBlock);

	@Method(selector = "getCurrentTime:")
	public native void getCurrentTime(@Block App42ResponseBlock completionBlock);
}

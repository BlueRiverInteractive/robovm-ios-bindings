package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class EventService extends App42Service
{
	public EventService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
	@Method(selector = "trackEventWithName:andProperties:completionBlock:")
	public native void trackEvent(String eventName, NSDictionary<?, ?> properties, @Block App42ResponseBlock completionBlock);
	
	@Method(selector = "startActivityWithName:andProperties:completionBlock:")
	public native void startActivity(String eventName, NSDictionary<?, ?> properties, @Block App42ResponseBlock completionBlock);
	
	@Method(selector = "endActivityWithName:andProperties:completionBlock:")
	public native void endActivity(String eventName, NSDictionary<?, ?> properties, @Block App42ResponseBlock completionBlock);
	
	@Method(selector = "setLoggedInUserProperties:completionBlock:")
	public native void setLoggedInUserProperties(NSDictionary<?, ?> properties, @Block App42ResponseBlock completionBlock);

	@Method(selector = "updateLoggedInUserProperties:completionBlock:")
	public native void updateLoggedInUserProperties(NSDictionary<?, ?> properties, @Block App42ResponseBlock completionBlock);
}


package org.robovm.bindings.thinkgaming;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class ThinkGamingEvent extends NSObject {
	public ThinkGamingEvent (String eventName) {
		super((SkipInit)null);
		initObject(init(eventName));
	}

	@Method(selector = "initWithEventName:")
	private native @Pointer
	long init (String eventName);

	@Property
	public native String getEventName ();

	@Property
	public native void setEventName (String name);

	@Method(selector = "endTimedEvent")
	public native ThinkGamingEvent endTimedEvent ();

	@Method(selector = "endTimedEventWithParameters:")
	public native ThinkGamingEvent endTimedEvent (NSDictionary<?, ?> parameters);

	@Method(selector = "endViewProductWithPurchaseWithParameters:")
	public native ThinkGamingEvent endViewProductWithPurchase (NSDictionary<?, ?> parameters);

	@Method(selector = "endViewProductWithOutPurchaseWithParameters:")
	public native ThinkGamingEvent endViewProductWithoutPurchase (NSDictionary<?, ?> parameters);
}

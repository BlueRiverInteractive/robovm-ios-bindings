package org.robovm.bindings.gpgs;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSURL;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class GPGEvent extends NSObject {

	@Property(selector = "count")
	public native long getCount();
	
	@Property(selector = "eventDescription")
	public native String getEventDescription();
	
	@Property(selector = "eventId")
	public native String getEventId();
	
	@Property(selector = "imageUrl")
	public native NSURL getImageUrl();
	
	@Property(selector = "name")
	public native String getName();
	
	@Property(selector = "visible")
	public native boolean getVisible();
	
	@Method(selector = "allEventsWithCompletionHandler:")
	public static native void allEventsWithCompletionHandler(@Block GPGEventListBlock completionHandler);
	
	@Method(selector = "eventForId:completionHandler:")
	public static native void eventForId(String eventId, @Block GPGEventOperationBlock completionHandler);
	
	@Method(selector = "increment")
	public native void increment();
	
	@Method(selector = "incrementBy:")
	public native void incrementBy(long steps);
	
	@Method(selector = "incrementWithCompletionHandler:")
	public native void incrementWithCompletionHandler(@Block GPGEventOperationBlock completionHandler);

	@Method(selector = "incrementBy:completionHandler:")
	public native void incrementBy(long steps, @Block GPGEventOperationBlock completionHandler);
}

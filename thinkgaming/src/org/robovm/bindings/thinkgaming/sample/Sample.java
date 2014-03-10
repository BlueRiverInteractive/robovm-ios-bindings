
package org.robovm.bindings.thinkgaming.sample;

import org.robovm.bindings.thinkgaming.ThinkGamingEvent;
import org.robovm.bindings.thinkgaming.ThinkGamingLogger;
import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;

/** Basic usage of the ThinkGaming SDK. */
public class Sample extends UIApplicationDelegate.Adapter {

	@Override
	public void didFinishLaunching (UIApplication application) {
		ThinkGamingLogger.startSession("xyz");
		ThinkGamingLogger.logEvent("Test Event");
		ThinkGamingEvent timedEvent = ThinkGamingLogger.startTimedEvent("Timed Event");
		System.out.println(timedEvent.getEventName());
		timedEvent.endTimedEvent();

		ThinkGamingEvent event2 = new ThinkGamingEvent("test_name");
		System.out.println(event2.getEventName());
	}

	public static void main (String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
	}
}

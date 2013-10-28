
package org.robovm.bindings.flurry;

import java.util.HashMap;

import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;

/** Basic usage of the Flurry Analytics SDK. */
public class Sample extends UIApplicationDelegate.Adapter {
	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public boolean didFinishLaunching (UIApplication application, NSDictionary launchOptions) {
		// First start the Flurry session.
		Flurry.startSession("YOUR_API_KEY", launchOptions);

		// Track events with parameters.
		HashMap<String, String> parameters = new HashMap<String, String>();
		parameters.put("Param_1", "Value_1");
		Flurry.logEvent("My_special_event", new NSDictionary(parameters));

		return true;
	}

	public static void main (String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
	}
}

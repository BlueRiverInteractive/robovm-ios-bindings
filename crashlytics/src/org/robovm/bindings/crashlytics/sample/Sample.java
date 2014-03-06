
package org.robovm.bindings.crashlytics.sample;

import org.robovm.bindings.crashlytics.Crashlytics;
import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;

/** Sample usage of the Crashlytics SDK. */
public class Sample extends UIApplicationDelegate.Adapter {

	@Override
	public void didFinishLaunching (UIApplication application) {
		Crashlytics crashlytics = Crashlytics.start("91ee0278ac843000496cde6a0d9f7e036b73d0ee");
	}

	public static void main (String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
	}
}

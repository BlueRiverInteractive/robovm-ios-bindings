
package org.robovm.bindings.crashlytics.sample;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.bindings.crashlytics.Crashlytics;

/** Sample usage of the Crashlytics SDK. */
public class Sample extends UIApplicationDelegateAdapter {

	@Override
	public void didFinishLaunching (UIApplication application) {
		Crashlytics crashlytics = Crashlytics.start("91ee0278ac843000496cde6a0d9f7e036b73d0ee");
	}

	public static void main (String[] argv) {
		try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
			UIApplication.main(argv, null, Sample.class);
		}
	}
}


package org.robovm.bindings.googleanalytics.sample;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;

/** Sample usage of the Google Analytics SDK. */
public class Sample extends UIApplicationDelegateAdapter {
	@Override
	public void didFinishLaunching (UIApplication application) {

	}

	public static void main (String[] argv) {
		try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
			UIApplication.main(argv, null, Sample.class);
		}
	}
}

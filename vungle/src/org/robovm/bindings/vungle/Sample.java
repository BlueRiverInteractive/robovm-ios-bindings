package org.robovm.bindings.vungle;

import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;

/**
 * Sample usage of the Vungle SDK.
 */
public class Sample extends UIApplicationDelegate.Adapter {
	@Override
	public void didFinishLaunching(UIApplication application) {

	}

	public static void main(String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
	}
}
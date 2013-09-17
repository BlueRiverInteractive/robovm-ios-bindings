package org.robovm.bindings.flurry;

import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;

/**
 * This class is only used for testing purposes.
 */
public class Main extends UIApplicationDelegate.Adapter {
	@Override
	public boolean didFinishLaunching(UIApplication application, NSDictionary launchOptions) {
		return true;
	}

	public static void main(String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Main.class);
		pool.drain();
	}
}
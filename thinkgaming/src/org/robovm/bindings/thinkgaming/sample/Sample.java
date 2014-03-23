
package org.robovm.bindings.thinkgaming.sample;

import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;

/** Basic usage of the ThinkGaming SDK. */
public class Sample extends UIApplicationDelegate.Adapter {

	@Override
	public void didFinishLaunching (UIApplication application) {
	}

	public static void main (String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
	}
}

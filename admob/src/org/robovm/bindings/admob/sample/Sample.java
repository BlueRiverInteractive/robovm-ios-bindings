
package org.robovm.bindings.admob.sample;

import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;

public class Sample extends UIApplicationDelegate.Adapter {

	@Override
	public void didFinishLaunching (org.robovm.cocoatouch.uikit.UIApplication application) {

	}

	public static void main (String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
	}
}

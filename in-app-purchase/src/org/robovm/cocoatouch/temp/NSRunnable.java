
package org.robovm.cocoatouch.temp;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Library;

@Library("Foundation")
public class NSRunnable extends NSObject implements NSObjectProtocol {

	static {
		ObjCRuntime.bind(NSRunnable.class);
	}

	private final Runnable runnable;

	public NSRunnable (Runnable runnable) {
		this.runnable = runnable;
	}

	public void run () {
		try {
			runnable.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final Selector run = Selector.register("run");
	private static final Selector performSelectorOnMainThread$withObject$waitUntilDone$ = Selector
		.register("performSelectorOnMainThread:withObject:waitUntilDone:");

	@Bridge
	private native static void objc_performSelectorOnMainThread (NSRunnable __self__, Selector __cmd__, Selector selector,
		NSObject data, boolean wait);

	public void performOnMainThread (boolean wait) {
		objc_performSelectorOnMainThread(this, performSelectorOnMainThread$withObject$waitUntilDone$, run, null, wait);
	}

	static class Callbacks {
		@Callback
		@BindSelector("run")
		public static void run (NSRunnable __self__, Selector __cmd__) {
			__self__.run();
		}
	}
}

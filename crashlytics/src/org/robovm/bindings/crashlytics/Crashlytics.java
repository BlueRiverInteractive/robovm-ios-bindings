
package org.robovm.bindings.crashlytics;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class Crashlytics extends NSObject {
	private Crashlytics () {
	}

	@Method(selector = "startWithAPIKey:")
	public static native Crashlytics start (String apiKey);

	@Method(selector = "crash")
	public native void crash ();
}

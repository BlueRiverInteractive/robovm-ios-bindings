
package org.robovm.bindings.crashlytics;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class Crashlytics extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(Crashlytics.class);

	static {
		ObjCRuntime.bind(Crashlytics.class);
	}

	private Crashlytics () {
	}

	// + (Crashlytics *)startWithAPIKey:(NSString *)apiKey;
	private static final Selector startWithAPIKey$ = Selector.register("startWithAPIKey:");

	@Bridge
	private native static Crashlytics objc_startWithAPIKey$ (ObjCClass __self__, Selector __cmd__, String apiKey);

	public static Crashlytics start (String apiKey) {
		return objc_startWithAPIKey$(objCClass, startWithAPIKey$, apiKey);
	}

// - (void)crash;
	private static final Selector crash = Selector.register("crash");

	@Bridge
	private native static void objc_crash (Crashlytics __self__, Selector __cmd__);

	public void crash () {
		objc_crash(this, crash);
	}
}

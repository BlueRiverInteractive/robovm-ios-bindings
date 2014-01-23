
package org.robovm.bindings.openkit;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class OKManager extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(OKManager.class);

	static {
		ObjCRuntime.bind(OKManager.class);
	}

	public static void configure (String appKey, String secretKey) {
		objc_configureWithAppKey$secretKey$(objCClass, configureWithAppKey$secretKey$, appKey, secretKey);
	}

	private static final Selector configureWithAppKey$secretKey$ = Selector.register("configureWithAppKey:secretKey:");

	@Bridge
	private native static void objc_configureWithAppKey$secretKey$ (ObjCClass __self__, Selector __cmd__, String appKey,
		String secretKey);

	public static boolean handleOpenURL (NSURL url) {
		return objc_handleOpenURL$(objCClass, handleOpenURL$, url);
	}

	private static final Selector handleOpenURL$ = Selector.register("handleOpenURL:");

	@Bridge
	private native static boolean objc_handleOpenURL$ (ObjCClass __self__, Selector __cmd__, NSURL url);

	public static void handleDidBecomeActive () {
		objc_handleDidBecomeActive(objCClass, handleDidBecomeActive);
	}

	private static final Selector handleDidBecomeActive = Selector.register("handleDidBecomeActive");

	@Bridge
	private native static void objc_handleDidBecomeActive (ObjCClass __self__, Selector __cmd__);

	public static void handleWillTerminate () {
		objc_handleDidBecomeActive(objCClass, handleWillTerminate);
	}

	private static final Selector handleWillTerminate = Selector.register("handleWillTerminate");

	@Bridge
	private native static void objc_handleWillTerminate (ObjCClass __self__, Selector __cmd__);
}

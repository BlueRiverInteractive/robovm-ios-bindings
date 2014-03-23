
package org.robovm.bindings.openkit;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class OKManager extends NSObject {
	@Method(selector = "configureWithAppKey:secretKey:")
	public static native void configure (String appKey, String secretKey);

	@Method(selector = "handleOpenURL:")
	public static native boolean handleOpenURL (NSURL url);

	@Method(selector = "handleDidBecomeActive")
	public static native void handleDidBecomeActive ();

	@Method(selector = "handleWillTerminate")
	public static native void handleWillTerminate ();
}

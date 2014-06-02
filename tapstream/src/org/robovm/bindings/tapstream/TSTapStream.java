
package org.robovm.bindings.tapstream;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class TSTapStream extends NSObject implements TSApi {

	@Method(selector = "createWithAccountName:developerSecret:config:")
	public static native void create (String accountName, String developerSecret, TSConfig config);

	@Method(selector = "instance")
	public static native TSTapStream getInstance ();

	@Override
	@Method(selector = "fireEvent:")
	public native void fireEvent (TSEvent event);

// - (void)fireHit:(TSHit *)hit completion:(void(^)(TSResponse *))completion;
// - (void)getConversionData:(void(^)(NSData *))completion;
}

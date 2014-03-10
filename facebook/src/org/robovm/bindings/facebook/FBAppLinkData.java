
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class FBAppLinkData extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(FBAppLinkData.class);

	static {
		ObjCRuntime.bind(FBAppLinkData.class);
	}

	/** Full set of query parameters for this app link. */
	public NSDictionary<NSString, NSString> getOriginalQueryParameters () {
		return objc_originalQueryParameters(this, originalQueryParameters);
	}

	private static final Selector originalQueryParameters = Selector.register("originalQueryParameters");

	@Bridge
	private native static NSDictionary<NSString, NSString> objc_originalQueryParameters (FBAppLinkData __self__, Selector __cmd__);
}

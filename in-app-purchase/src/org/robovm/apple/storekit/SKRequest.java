
package org.robovm.apple.storekit;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.ObjCSuper;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("StoreKit")
@NativeClass
public class SKRequest extends NSObject {

	static {
		ObjCRuntime.bind(/* <name> */SKRequest /* </name> */.class);
	}

	// - (void)cancel __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);

	// - (void)start __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector start$ = Selector.register("start");

	@Bridge
	private native static void objc_start (SKRequest __self__, Selector __cmd__);

	@Bridge
	private native static void objc_startSuper (ObjCSuper __super__, Selector __cmd__);

	public void start () {
		if (customClass) {
			objc_startSuper(getSuper(), start$);
		} else {
			objc_start(this, start$);
		}
	}
}

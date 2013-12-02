
package org.robovm.cocoatouch.storekit;

import org.robovm.cocoatouch.foundation.NSSet;
import org.robovm.objc.ObjCObject;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.ObjCSuper;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("StoreKit")
@NativeClass
public class SKProductsRequest extends SKRequest {

	static {
		ObjCRuntime.bind(/* <name> */SKProductsRequest /* </name> */.class);
	}

	private static final Selector delegate = Selector.register("delegate");

	@Bridge
	private native static SKProductsRequestDelegate objc_getDelegate (SKProductsRequest __self__, Selector __cmd__);

	@Bridge
	private native static SKProductsRequestDelegate objc_getDelegateSuper (ObjCSuper __super__, Selector __cmd__);

	public SKProductsRequestDelegate getDelegate () {
		if (customClass) {
			return objc_getDelegateSuper(getSuper(), delegate);
		} else {
			return objc_getDelegate(this, delegate);
		}
	}

	private static final Selector setDelegate$ = Selector.register("setDelegate:");

	@Bridge
	private native static void objc_setDelegate (SKProductsRequest __self__, Selector __cmd__, SKProductsRequestDelegate delegate);

	@Bridge
	private native static void objc_setDelegateSuper (ObjCSuper __super__, Selector __cmd__, SKProductsRequestDelegate delegate);

	public void setDelegate (SKProductsRequestDelegate delegate) {
		addStrongRef((ObjCObject)delegate);
		if (customClass) {
			objc_setDelegateSuper(getSuper(), setDelegate$, delegate);
		} else {
			objc_setDelegate(this, setDelegate$, delegate);
		}
	}

	// - (id)initWithProductIdentifiers:(NSSet *)productIdentifiers __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);

	private static final Selector initWithProductIdentifiers$ = Selector.register("initWithProductIdentifiers:");

	@Bridge
	private native static void objc_initWithProductIdentifiers (SKProductsRequest __self__, Selector __cmd__,
		NSSet productIdentifiers);

	@Bridge
	private native static void objc_initWithProductIdentifiersSuper (ObjCSuper __super__, Selector __cmd__,
		NSSet productIdentifiers);

	public SKProductsRequest (NSSet productIdentifiers) {
		if (customClass) {
			objc_initWithProductIdentifiersSuper(getSuper(), initWithProductIdentifiers$, productIdentifiers);
		} else {
			objc_initWithProductIdentifiers(this, initWithProductIdentifiers$, productIdentifiers);
		}
	}
}

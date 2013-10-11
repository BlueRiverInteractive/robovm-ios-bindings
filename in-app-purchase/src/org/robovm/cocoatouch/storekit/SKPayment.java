package org.robovm.cocoatouch.storekit;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.ObjCSuper;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("StoreKit")
@NativeClass
public class SKPayment extends NSObject {

	static {
		ObjCRuntime.bind(/* <name> */SKPayment /* </name> */.class);
	}

	private static final ObjCClass objCClass = ObjCClass.getByType(/* <name> */SKPayment /* </name> */.class);

	// + (id)paymentWithProductIdentifier:(NSString *)identifier __OSX_AVAILABLE_BUT_DEPRECATED(__MAC_NA,__MAC_NA,__IPHONE_3_0,__IPHONE_5_0);
	private static final Selector paymentWithProductIdentifier$ = Selector.register("paymentWithProductIdentifier:");

	@Bridge
	private native static SKPayment objc_paymentWithProductIdentifier(ObjCClass __self__, Selector __cmd__, NSString identifier);

	public static SKPayment fromProductIdentifier(NSString identifier) {
		return objc_paymentWithProductIdentifier(objCClass, paymentWithProductIdentifier$, identifier);
	}

	// @property(nonatomic, readonly) NSInteger quantity __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector setQuantity$ = Selector.register("setQuantity:");

	@Bridge
	private native static void objc_setQuantity(SKPayment __self__, Selector __cmd__, int quantity);

	@Bridge
	private native static void objc_setQuantitySuper(ObjCSuper __super__, Selector __cmd__, int quantity);

	public void setQuantity(int quantity) {
		if (customClass) {
			objc_setQuantitySuper(getSuper(), setQuantity$, quantity);
		} else {
			objc_setQuantity(this, setQuantity$, quantity);
		}
	}

	// @property(nonatomic, copy, readonly) NSString *applicationUsername __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_7_0);
	private static final Selector setApplicationUsername$ = Selector.register("setApplicationUsername:");

	@Bridge
	private native static void objc_setApplicationUsername(SKPayment __self__, Selector __cmd__, NSString applicationUsername);

	@Bridge
	private native static void objc_setApplicationUsernameSuper(ObjCSuper __super__, Selector __cmd__, NSString applicationUsername);

	public void setQuantity(NSString applicationUsername) {
		if (customClass) {
			objc_setApplicationUsernameSuper(getSuper(), setApplicationUsername$, applicationUsername);
		} else {
			objc_setApplicationUsername(this, setApplicationUsername$, applicationUsername);
		}
	}

	// @property(nonatomic, copy, readonly) NSString *productIdentifier __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector productIdentifier = Selector.register("productIdentifier");

	@Bridge
	private native static NSString objc_getProductIdentifier(SKPayment __self__, Selector __cmd__);

	@Bridge
	private native static NSString objc_getProductIdentifierSuper(ObjCSuper __super__, Selector __cmd__);

	public NSString getProductIdentifier() {
		return (customClass) ? objc_getProductIdentifierSuper(getSuper(), productIdentifier) : objc_getProductIdentifier(this, productIdentifier);
	}
}

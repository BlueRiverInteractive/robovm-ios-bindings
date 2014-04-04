
package org.robovm.apple.storekit;

import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.ObjCSuper;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("StoreKit")
@NativeClass
public class SKPaymentTransaction extends NSObject {

	static {
		ObjCRuntime.bind(/* <name> */SKPaymentTransaction /* </name> */.class);
	}

	// @property(nonatomic, readonly) NSError *error __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector error = Selector.register("error");

	@Bridge
	private native static NSError objc_getError (SKPaymentTransaction __self__, Selector __cmd__);

	@Bridge
	private native static NSError objc_getErrorSuper (ObjCSuper __super__, Selector __cmd__);

	public NSError getError () {
		return (customClass) ? objc_getErrorSuper(getSuper(), error) : objc_getError(this, error);
	}

	// @property(nonatomic, readonly) SKPaymentTransactionState transactionState __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector transactionState = Selector.register("transactionState");

	@Bridge
	private native static SKPaymentTransactionState objc_getTransactionState (SKPaymentTransaction __self__, Selector __cmd__);

	@Bridge
	private native static SKPaymentTransactionState objc_getTransactionStateSuper (ObjCSuper __super__, Selector __cmd__);

	public SKPaymentTransactionState getTransactionState () {
		return (customClass) ? objc_getTransactionStateSuper(getSuper(), transactionState) : objc_getTransactionState(this,
			transactionState);
	}

	// @property(nonatomic, readonly) NSString *transactionIdentifier __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector transactionIdentifier = Selector.register("transactionIdentifier");

	@Bridge
	private native static String objc_getTransactionIdentifier (SKPaymentTransaction __self__, Selector __cmd__);

	@Bridge
	private native static String objc_getTransactionIdentifierSuper (ObjCSuper __super__, Selector __cmd__);

	public String getTransactionIdentifier () {
		return (customClass) ? objc_getTransactionIdentifierSuper(getSuper(), transactionIdentifier)
			: objc_getTransactionIdentifier(this, transactionIdentifier);
	}

	// @property(nonatomic, readonly) SKPayment *payment __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector payment = Selector.register("payment");

	@Bridge
	private native static SKPayment objc_getPayment (SKPaymentTransaction __self__, Selector __cmd__);

	@Bridge
	private native static SKPayment objc_getPaymentSuper (ObjCSuper __super__, Selector __cmd__);

	public SKPayment getPayment () {
		return (customClass) ? objc_getPaymentSuper(getSuper(), payment) : objc_getPayment(this, payment);
	}

}

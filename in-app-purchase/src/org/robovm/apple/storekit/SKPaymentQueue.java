
package org.robovm.apple.storekit;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.ObjCSuper;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("StoreKit")
@NativeClass
public class SKPaymentQueue extends NSObject {
	static {
		ObjCRuntime.bind(SKPaymentQueue.class);
	}

	private static final ObjCClass objCClass = ObjCClass.getByType(SKPaymentQueue.class);

	// + (SKPaymentQueue *)defaultQueue __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector defaultQueue = Selector.register("defaultQueue");

	@Bridge
	private native static SKPaymentQueue objc_defaultQueue (ObjCClass __self__, Selector __cmd__);

	public static SKPaymentQueue getDefaultQueue () {
		return objc_defaultQueue(objCClass, defaultQueue);
	}

	// - (void)addPayment:(SKPayment *)payment __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector addPayment$ = Selector.register("addPayment:");

	@Bridge
	private native static void objc_addPayment (SKPaymentQueue __self__, Selector __cmd__, SKPayment payment);

	@Bridge
	private native static void objc_addPaymentSuper (ObjCSuper __super__, Selector __cmd__, SKPayment payment);

	public void addPayment (SKPayment payment) {
		if (customClass) {
			objc_addPaymentSuper(getSuper(), addPayment$, payment);
		} else {
			objc_addPayment(this, addPayment$, payment);
		}
	}

	// - (void)finishTransaction:(SKPaymentTransaction *)transaction __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector finishTransaction$ = Selector.register("finishTransaction:");

	@Bridge
	private native static void objc_finishTransaction (SKPaymentQueue __self__, Selector __cmd__, SKPaymentTransaction transaction);

	@Bridge
	private native static void objc_finishTransactionSuper (ObjCSuper __super__, Selector __cmd__, SKPaymentTransaction transaction);

	public void finishTransaction (SKPaymentTransaction transaction) {
		if (customClass) {
			objc_finishTransactionSuper(getSuper(), finishTransaction$, transaction);
		} else {
			objc_finishTransaction(this, finishTransaction$, transaction);
		}
	}

	// - (void)addTransactionObserver:(id <SKPaymentTransactionObserver>)observer __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector addTransactionObserver$ = Selector.register("addTransactionObserver:");

	@Bridge
	private native static void objc_addTransactionObserver (SKPaymentQueue __self__, Selector __cmd__,
		SKPaymentTransactionObserver observer);

	@Bridge
	private native static void objc_addTransactionObserverSuper (ObjCSuper __super__, Selector __cmd__,
		SKPaymentTransactionObserver observer);

	public void addTransactionObserver (SKPaymentTransactionObserver observer) {
		if (customClass) {
			objc_addTransactionObserverSuper(getSuper(), addTransactionObserver$, observer);
		} else {
			objc_addTransactionObserver(this, addTransactionObserver$, observer);
		}
	}

	// - (void)removeTransactionObserver:(id <SKPaymentTransactionObserver>)observer
// __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector removeTransactionObserver$ = Selector.register("removeTransactionObserver:");

	@Bridge
	private native static void objc_removeTransactionObserver (SKPaymentQueue __self__, Selector __cmd__,
		SKPaymentTransactionObserver observer);

	@Bridge
	private native static void objc_removeTransactionObserverSuper (ObjCSuper __super__, Selector __cmd__,
		SKPaymentTransactionObserver observer);

	public void removeTransactionObserver (SKPaymentTransactionObserver observer) {
		if (customClass) {
			objc_removeTransactionObserverSuper(getSuper(), removeTransactionObserver$, observer);
		} else {
			objc_removeTransactionObserver(this, removeTransactionObserver$, observer);
		}
	}

	// - (void)restoreCompletedTransactions __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector restoreCompletedTransactions = Selector.register("restoreCompletedTransactions");

	@Bridge
	private native static void objc_restoreCompletedTransactions (SKPaymentQueue __self__, Selector __cmd__);

	@Bridge
	private native static void objc_restoreCompletedTransactionsSuper (ObjCSuper __super__, Selector __cmd__);

	public void restoreCompletedTransactions () {
		if (customClass) {
			objc_restoreCompletedTransactionsSuper(getSuper(), restoreCompletedTransactions);
		} else {
			objc_restoreCompletedTransactions(this, restoreCompletedTransactions);
		}
	}

	// + (BOOL)canMakePayments __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector canMakePayments$ = Selector.register("canMakePayments");

	@Bridge
	private native static boolean objc_canMakePayments (ObjCClass __self__, Selector __cmd__);

	public static boolean canMakePayments () {
		return objc_canMakePayments(objCClass, canMakePayments$);
	}
}

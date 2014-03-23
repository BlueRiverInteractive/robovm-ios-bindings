
package org.robovm.cocoatouch.storekit;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.objc.annotation.NotImplemented;
import org.robovm.rt.bro.annotation.Callback;

public interface SKPaymentTransactionObserver extends NSObjectProtocol {

	// Sent when the transaction array has changed (additions or state changes). Client should check state of transactions and
// finish as appropriate.
	// - (void)paymentQueue:(SKPaymentQueue *)queue updatedTransactions:(NSArray *)transactions
// __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	void updatedTransactions (SKPaymentQueue queue, NSArray<SKPaymentTransaction> transactions);

	public static class Adapter extends NSObject implements SKPaymentTransactionObserver {
		@Override
		@NotImplemented("paymentQueue:updatedTransactions:")
		public void updatedTransactions (SKPaymentQueue queue, NSArray<SKPaymentTransaction> transactions) {
			throw new UnsupportedOperationException();
		}
	}

	static class Callbacks {
		@Callback
		@BindSelector("paymentQueue:updatedTransactions:")
		public static void updatedTransactions (SKPaymentTransactionObserver __self__, Selector __cmd__, SKPaymentQueue queue,
			NSArray<SKPaymentTransaction> transactions) {
			__self__.updatedTransactions(queue, transactions);
		}
	}
}

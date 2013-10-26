
package org.robovm.bindings.inapppurchase;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.storekit.SKPaymentQueue;
import org.robovm.cocoatouch.storekit.SKPaymentTransaction;
import org.robovm.cocoatouch.storekit.SKPaymentTransactionObserver;

public class CustomTransactionObserver extends SKPaymentTransactionObserver.Adapter {
	private final InAppPurchaseManager manager;

	public CustomTransactionObserver (InAppPurchaseManager manager) {
		this.manager = manager;
	}

	@Override
	public void updatedTransactions (SKPaymentQueue queue, NSArray<SKPaymentTransaction> transactions) {
		for (SKPaymentTransaction transaction : transactions) {
			switch (transaction.getTransactionState()) {
			case Purchased:
				manager.transactionCompleted(transaction);
				break;
			case Failed:
				manager.transactionFailed(transaction);
				break;
			case Restored:
				manager.transactionRestored(transaction);
				break;
			default:
				break;
			}
		}
	}
}


package org.robovm.bindings.inapppurchase;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.storekit.SKPaymentQueue;
import org.robovm.apple.storekit.SKPaymentTransaction;
import org.robovm.apple.storekit.SKPaymentTransactionObserver;

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

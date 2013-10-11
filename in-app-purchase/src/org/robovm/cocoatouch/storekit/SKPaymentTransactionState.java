package org.robovm.cocoatouch.storekit;

import org.robovm.rt.bro.ValuedEnum;

public enum SKPaymentTransactionState implements ValuedEnum {
	Purchasing(0), // Transaction is being added to the server queue.
	Purchased(1), // Transaction is in queue, user has been charged. Client should complete the transaction.
	Failed(2), // Transaction was cancelled or failed before being added to the server queue.
	Restored(3); // Transaction was restored from user's purchase history. Client should complete the transaction.

	private final int n;

	private SKPaymentTransactionState(int n) {
		this.n = n;
	}

	@Override
	public int value() {
		return n;
	}
}

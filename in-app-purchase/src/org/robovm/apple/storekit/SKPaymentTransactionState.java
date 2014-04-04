
package org.robovm.apple.storekit;

import org.robovm.rt.bro.ValuedEnum;

public enum SKPaymentTransactionState implements ValuedEnum {
	Purchasing(0), // Transaction is being added to the server queue.
	Purchased(1), // Transaction is in queue, user has been charged. Client should complete the transaction.
	Failed(2), // Transaction was cancelled or failed before being added to the server queue.
	Restored(3); // Transaction was restored from user's purchase history. Client should complete the transaction.

	private final long n;

	private SKPaymentTransactionState (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}


package org.robovm.bindings.thinkgaming;

import org.robovm.apple.storekit.SKPaymentTransaction;

public interface DidPurchaseProductBlock {
	public void invoke (boolean success, SKPaymentTransaction transaction);
}

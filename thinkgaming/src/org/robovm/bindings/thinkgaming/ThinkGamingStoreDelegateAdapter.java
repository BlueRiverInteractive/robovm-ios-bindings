
package org.robovm.bindings.thinkgaming;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.storekit.SKPaymentTransaction;

public class ThinkGamingStoreDelegateAdapter extends NSObject implements ThinkGamingStoreDelegate {
	@Override
	public void didPurchaseProduct (ThinkGamingStoreSDK thinkGamingStore, String productIdentifier,
		SKPaymentTransaction transaction) {
	}

	@Override
	public void didRestoreProduct (ThinkGamingStoreSDK thinkGamingStore, String productIdentifier, String iTunesReference,
		SKPaymentTransaction transaction) {
	}

	@Override
	public void didFinishRestoringProducts (ThinkGamingStoreSDK thinkGamingStore, boolean success) {
	}

	@Override
	public void didFailPurchasingProduct (ThinkGamingStoreSDK thinkGamingStore, String productIdentifier,
		SKPaymentTransaction transaction) {
	}
}

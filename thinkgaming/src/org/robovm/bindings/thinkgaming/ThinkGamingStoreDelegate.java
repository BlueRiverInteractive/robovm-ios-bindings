
package org.robovm.bindings.thinkgaming;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

public interface ThinkGamingStoreDelegate extends NSObjectProtocol {
	@Method(selector = "thinkGamingStore:didPurchaseProduct:withTransaction:")
	void didPurchaseProduct (ThinkGamingStoreSDK thinkGamingStore, String productIdentifier, SKPaymentTransaction transaction);

	@Method(selector = "thinkGamingStore:didRestoreProduct:withITunesReference:andTransaction:")
	void didRestoreProduct (ThinkGamingStoreSDK thinkGamingStore, String productIdentifier, String iTunesReference,
		SKPaymentTransaction transaction);

	@Method(selector = "thinkGamingStore:didFinishRestoringProducts:")
	void didFinishRestoringProducts (ThinkGamingStoreSDK thinkGamingStore, boolean success);

	@Method(selector = "thinkGamingStore:didFailPurchasingProduct:withTransaction:")
	void didFailPurchasingProduct (ThinkGamingStoreSDK thinkGamingStore, String productIdentifier, SKPaymentTransaction transaction);
}

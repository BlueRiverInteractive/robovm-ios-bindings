package org.robovm.bindings.inapppurchase;

import java.util.HashMap;
import java.util.Map;

import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.storekit.SKPaymentTransaction;
import org.robovm.cocoatouch.storekit.SKProduct;
import org.robovm.cocoatouch.storekit.SKRequest;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;

/**
 * Sample usage of the InAppPurchaseManager class.
 */
public class Sample extends UIApplicationDelegate.Adapter {
	private InAppPurchaseManager iapManager;
	private Map<String, SKProduct> appStoreProducts;

	@Override
	public void didFinishLaunching(UIApplication application) {
		iapManager = new InAppPurchaseManager(new InAppPurchaseListener() {
			@Override
			public void productsReceived(SKProduct[] products) {
				// Store the products.
				appStoreProducts = new HashMap<String, SKProduct>();

				for (int i = 0; i < products.length; i++) {
					appStoreProducts.put(products[i].getProductIdentifier().toString(), products[i]);
				}

				// Fill your shop UI with products here.
			}

			@Override
			public void productsRequestFailed(SKRequest request, NSError error) {
				// Something went wrong. Possibly no Internet connection.
			}

			@Override
			public void transactionCompleted(SKPaymentTransaction transaction) {
				// Purchase successfully completed.
				// Get the product identifier and award the product to the user.
				String productId = transaction.getPayment().getProductIdentifier().toString();
				if (productId.equals("com.business.game.consumable")) {
					// awardProduct1();
				} else if (productId.equals("com.business.game.nonconsumable")) {
					// awardProduct2();
				}
			}

			@Override
			public void transactionFailed(SKPaymentTransaction transaction) {
				// Something went wrong. Possibly no Internet connection.
			}

			@Override
			public void transcationRestored(SKPaymentTransaction transaction) {
				// Purchase successfully restored.
				// Get the product identifier and award the product to the user. This is only useful for non-consumable products.
				String productId = transaction.getPayment().getProductIdentifier().toString();
				if (productId.equals("com.business.game.nonconsumable")) {
					// awardProduct2();
				}
			}

		});

		// First request the available products from the app store.
		iapManager.requestProducts("com.business.game.consumable", "com.business.game.nonconsumable");

		// At any time you want to purchase a product.
		if (iapManager.canMakePayments())
			iapManager.purchaseProduct(appStoreProducts.get("com.business.game.consumable"));

		// When you want to restore products like Ad-free.
		iapManager.restoreTransactions();
	}

	public static void main(String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
	}
}
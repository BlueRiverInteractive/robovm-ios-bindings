package org.robovm.bindings.inapppurchase.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.storekit.SKPaymentTransaction;
import org.robovm.apple.storekit.SKProduct;
import org.robovm.apple.storekit.SKRequest;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.bindings.inapppurchase.AppStoreListener;
import org.robovm.bindings.inapppurchase.AppStoreManager;

/** Sample usage of the InAppPurchaseManager class. */
public class Sample extends UIApplicationDelegateAdapter {
    private AppStoreManager iapManager;
    private Map<String, SKProduct> appStoreProducts;

    @Override
    public void didFinishLaunching(UIApplication application) {
        iapManager = new AppStoreManager(new AppStoreListener() {
            @Override
            public void productsReceived(List<SKProduct> products) {
                // Store the products.
                appStoreProducts = new HashMap<String, SKProduct>();

                for (SKProduct product : products) {
                    appStoreProducts.put(product.getProductIdentifier().toString(), product);
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
            public void transactionFailed(SKPaymentTransaction transaction, NSError error) {
                // Something went wrong. Possibly no Internet connection or user
                // cancelled.
            }

            @Override
            public void transactionRestored(SKPaymentTransaction transaction) {

            }

            @Override
            public void transactionRestoreFailed(List<SKPaymentTransaction> transactions, NSError error) {
                if (error != null && error.getCode() == 2) {
                    // User cancelled
                } else {
                    // Some other error
                }
            }

            @Override
            public void transactionDeferred(SKPaymentTransaction transaction) {
                // User needs to ask for permission to finish the transaction.
            }

            @Override
            public void transactionRestoreCompleted(List<SKPaymentTransaction> transactions) {
                // Purchases successfully restored.
                for (SKPaymentTransaction transaction : transactions) {
                    // Get the product identifier and award the product to the
                    // user. This is only useful for non-consumable products.
                    String productId = transaction.getPayment().getProductIdentifier().toString();
                    if (productId.equals("com.business.game.nonconsumable")) {
                        // awardProduct2();
                    }
                }
            }

        });
        // First request the available products from the app store.
        iapManager.requestProducts("com.business.game.consumable", "com.business.game.nonconsumable");
        // At any time you want to purchase a product.
        if (iapManager.canMakePayments() && appStoreProducts != null) {
            iapManager.purchaseProduct(appStoreProducts.get("com.business.game.consumable"));
        }
        // When you want to restore non-consumable products.
        iapManager.restoreTransactions();
    }

    public static void main(String[] argv) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(argv, null, Sample.class);
        }
    }
}


package org.robovm.bindings.thinkgaming;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class ThinkGamingStoreSDK extends NSObject implements SKProductsRequestDelegate, SKPaymentTransactionObserver {
	@Property(strongRef = true)
	public native ThinkGamingStoreDelegate getDelegate ();

	@Method(selector = "getListOfStoresThenCall:")
	public native void getListOfStores (@Block DidDownloadStoresBlock block);

	@Method(selector = "getListOfProductsForStoreIdentifier:thenCall:")
	public native void getListOfProducts (String storeIdentifier, @Block DidDownloadProductsBlock block);

	@Method(selector = "purchaseProduct:thenCall:")
	public native void purchaseProduct (ThinkGamingProduct product, @Block DidPurchaseProductBlock block);

	@Method(selector = "hasPreviouslyPurchasedProductWithIdentifider:")
	public native boolean hasPurchasedProduct (String iTunesProductIdentifier);

	@Method(selector = "restorePreviouslyPurchasedProducts")
	public native void restorePurchasedProducts ();

	@Method(selector = "getListOfPreviouslyPurchasedProductIdentifiers")
	public native NSArray<?> getListOfPurchasedProductIdentifiers ();

	@Override
	public void updatedTransactions (SKPaymentQueue queue, org.robovm.apple.foundation.NSArray<SKPaymentTransaction> transactions) {
	}

	@Override
	public void receivedResponse (SKProductsRequest request, SKProductsResponse response) {
	}
}

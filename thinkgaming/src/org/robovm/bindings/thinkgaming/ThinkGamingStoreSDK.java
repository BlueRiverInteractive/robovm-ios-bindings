
package org.robovm.bindings.thinkgaming;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.storekit.SKDownload;
import org.robovm.apple.storekit.SKPaymentQueue;
import org.robovm.apple.storekit.SKPaymentTransaction;
import org.robovm.apple.storekit.SKPaymentTransactionObserver;
import org.robovm.apple.storekit.SKProductsRequest;
import org.robovm.apple.storekit.SKProductsRequestDelegate;
import org.robovm.apple.storekit.SKProductsResponse;
import org.robovm.apple.storekit.SKRequest;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class ThinkGamingStoreSDK extends NSObject implements SKProductsRequestDelegate, SKPaymentTransactionObserver {
	@Property
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
	public void updatedTransactions (SKPaymentQueue queue, NSArray<SKPaymentTransaction> transactions) {
	}

	@Override
	public void didFinish (SKRequest request) {
	}

	@Override
	public void didFail (SKRequest request, NSError error) {
	}

	@Override
	public void removedTransactions (SKPaymentQueue queue, NSArray<SKPaymentTransaction> transactions) {
	}

	@Override
	public void restoreCompletedTransactionsFailed (SKPaymentQueue queue, NSError error) {
	}

	@Override
	public void restoreCompletedTransactionsFinished (SKPaymentQueue queue) {
	}

	@Override
	public void updatedDownloads (SKPaymentQueue queue, NSArray<SKDownload> downloads) {
	}

	@Override
	public void didReceiveResponse (SKProductsRequest request, SKProductsResponse response) {
	}
}

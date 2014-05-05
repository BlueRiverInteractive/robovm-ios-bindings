
package org.robovm.bindings.inapppurchase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSSet;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.storekit.SKPayment;
import org.robovm.apple.storekit.SKPaymentQueue;
import org.robovm.apple.storekit.SKPaymentTransaction;
import org.robovm.apple.storekit.SKProduct;
import org.robovm.apple.storekit.SKProductsRequest;
import org.robovm.apple.storekit.SKProductsRequestDelegateAdapter;
import org.robovm.apple.storekit.SKProductsResponse;
import org.robovm.apple.storekit.SKRequest;

/** An easy to use in-app purchase system for iOS. */
public class InAppPurchaseManager {
	public static String TAG = "[InAppPurchaseManager] ";

	private final InAppPurchaseListener listener;
	private SKProductsRequest productsRequest;
	private final CustomTransactionObserver paymentObserver;
	private boolean requestingProducts;
	private boolean purchasingProduct;

	/** Create a new instance of the InAppPurchaseManager.
	 * 
	 * @param listener The listener interface for common callbacks. */
	public InAppPurchaseManager (InAppPurchaseListener listener) {
		paymentObserver = new CustomTransactionObserver(this);
		this.listener = listener;

		SKPaymentQueue.getDefaultQueue().addTransactionObserver(paymentObserver);
	}

	/** Verify that the iTunes account can make purchases for this application. */
	public boolean canMakePayments () {
		return SKPaymentQueue.canMakePayments();
	}

	/** Call this when you no longer want to use the InAppPurchaseManager. */
	public void unregisterObserver () {
		SKPaymentQueue.getDefaultQueue().removeTransactionObserver(paymentObserver);
	}

	/** Request the product information for the specified product identifiers. Calls
	 * {@link InAppPurchaseListener#productsReceived(SKProduct[])} on success or
	 * {@link InAppPurchaseListener#productsRequestFailed(SKRequest, NSError)} on fail.
	 * 
	 * @param productIds The identifiers of the products you want to query. */
	public void requestProducts (String... productIds) {
		requestProducts(Arrays.asList(productIds));
	}

	/** Request the product information for the specified product identifiers. Calls
	 * {@link InAppPurchaseListener#productsReceived(SKProduct[])} on success or
	 * {@link InAppPurchaseListener#productsRequestFailed(SKRequest, NSError)} on fail.
	 * 
	 * @param productIds The identifiers of the products you want to query as a java List. */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void requestProducts (List<String> productIds) {
		if (requestingProducts) {
			System.out.println(TAG + "Already requesting products!");
			return;
		}

		List<NSString> products = new ArrayList<NSString>();
		for (int i = 0; i < productIds.size(); i++) {
			products.add(new NSString(productIds.get(i)));
		}

		System.out.println(TAG + "Requesting product data...");

		productsRequest = new SKProductsRequest(new NSSet(products));
		productsRequest.setDelegate(new RequestDelegate());
		productsRequest.start();
		requestingProducts = true;
	}

	/** Purchase the specified product. Should be preceded by a call to {@link #canMakePayments()} to check if the user can buy.
	 * 
	 * @param product The product to buy. */
	public void purchaseProduct (SKProduct product) {
		if (purchasingProduct) {
			System.out.println(TAG + "Already purchasing a product!");
			return;
		}

		System.out.println(TAG + "Purchasing product '" + product.getLocalizedTitle() + "'...");
		SKPayment payment = SKPayment.fromProduct(product);
		SKPaymentQueue.getDefaultQueue().addPayment(payment);
		purchasingProduct = true;
	}

	/** Restore any transactions that occurred for this Apple ID. */
	public void restoreTransactions () {
		if (purchasingProduct) {
			System.out.println(TAG + "Already purchasing a product!");
			return;
		}

		System.out.println(TAG + "Restoring products...");
		SKPaymentQueue.getDefaultQueue().restoreCompletedTransactions();
		purchasingProduct = true;
	}

	/** Returns {@code true} if a product is already being purchased, else {@code false}. **/
	public boolean isPurchasingProduct () {
		return purchasingProduct;
	}

	/** Returns {@code true} if products are already being requested, else {@code false}. **/
	public boolean isRequestingProducts () {
		return requestingProducts;
	}

	private class RequestDelegate extends SKProductsRequestDelegateAdapter {
		@Override
		public void didReceiveResponse (SKProductsRequest request, SKProductsResponse response) {
			System.out.println(TAG + "Products successfully received!");
			requestingProducts = false;

			NSArray<SKProduct> products = response.getProducts();

			listener.productsReceived(products.toArray(new SKProduct[products.size()]));
		}

		@Override
		public void didFail (SKRequest request, NSError error) {
			System.out.println(TAG + "Products request failed! Error: " + (error != null ? error.toString() : "unknown"));
			requestingProducts = false;

			listener.productsRequestFailed(request, error);
		}
	}

	protected void transactionCompleted (SKPaymentTransaction transaction) {
		System.out.println(TAG + "Completed transaction '" + transaction.getTransactionIdentifier() + "' successfully!");
		SKPaymentQueue.getDefaultQueue().finishTransaction(transaction);
		purchasingProduct = false;

		listener.transactionCompleted(transaction);
	}

	protected void transactionRestored (SKPaymentTransaction transaction) {
		System.out.println(TAG + "Restored transaction '" + transaction.getTransactionIdentifier() + "' successfully!");
		SKPaymentQueue.getDefaultQueue().finishTransaction(transaction);
		purchasingProduct = false;

		listener.transactionRestored(transaction);
	}

	protected void transactionFailed (SKPaymentTransaction transaction) {
		System.out.println(TAG + "Transaction '" + transaction.getTransactionIdentifier() + "' failed! Error: "
			+ (transaction.getError() != null ? transaction.getError().toString() : "unknown"));
		SKPaymentQueue.getDefaultQueue().finishTransaction(transaction);
		purchasingProduct = false;

		listener.transactionFailed(transaction, transaction.getError());
	}

	protected void restoreCompleted (SKPaymentQueue queue) {
		System.out.println(TAG + "Transactions successfully restored!");
		purchasingProduct = false;
	}

	protected void restoreFailed (SKPaymentQueue queue, NSError error) {
		System.out.println(TAG + "Restoring transactions failed with error " + error.description());
		purchasingProduct = false;

		listener.transactionRestoreFailed(queue.getTransactions(), error);
	}
}

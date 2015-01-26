package org.robovm.bindings.app42;

import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.ByVal;
import org.robovm.rt.bro.annotation.GlobalValue;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class CartService extends App42Service 
{
	@GlobalValue(symbol = "DECLINED", optional=true)
	public static native @ByVal String DECLINED();
	
	@GlobalValue(symbol = "AUTHORIZED", optional=true)
	public static native @ByVal String AUTHORIZED();
	
	@GlobalValue(symbol = "PENDING", optional=true)
	public static native @ByVal String PENDING();
	
	public CartService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
	/**
	 * Creates a Cart Session for the specified User
	 *
	 * @param user
	 *            - User for whom Cart Session has to be created
	 *
	 * @returns Cart Object containing Cart Id with Creation Time. The id has to
	 *          be used in subsequent calls for adding and checking out
	 *
	 */
	@Method(selector = "createCart:completionBlock:")
	public native void createCart(String user, @Block App42ResponseBlock completionBlock);
	/**
	 * Fetch Cart details. Can be used by the App developer to display Cart
	 * Details i.e. Items in a Cart.
	 *
	 * @param cartId
	 *            - The Cart Id that has to be fetched
	 *
	 * @returns Cart object containing cart details with all the items which are
	 *          in it. It also tells the state of the Cart
	 *
	 */
	@Method(selector = "getCartDetails:completionBlock:")
	public native void getCartDetails(String cartId, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Adds an Item in the Cart with quantity and price. This method does not
	 * take currency. Its the bonus of the App developer to maitain the
	 * currency. It takes only the price.
	 *
	 * @param cartID
	 *            - The Cart Id into which item has to be added
	 * @param itemID
	 *            - The Item id which has to be added in the cart. If the
	 *            Catalogue Service is used along with the Cart Service then the
	 *            Item ids should be same.
	 * @param itemQuantity
	 *            - Quantity of the Item to be purchased
	 * @param price
	 *            - Price of the item
	 *
	 * @returns Cart object containing added item.
	 *
	 */
	@Method(selector = "addItem:itemID:itemQuantity:price:completionBlock:")
	public native void addItem(String cartId, String itemID, int itemQuantity, double price, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches the Items from the specified Cart
	 *
	 * @param cartId
	 *            - The cart id from which items have to be fetched
	 *
	 * @returns Cart object which contains all items in the cart
	 *
	 */
	@Method(selector = "getItems:completionBlock:")
	public native void getItems(String cartId, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches the specified Item from the specified Cart
	 *
	 * @param cartId
	 *            - The cart id from which item has to be fetched
	 * @param itemId
	 *            - The item for which the information has to be fetched
	 *
	 * @returns Cart Object
	 *
	 */
	@Method(selector = "getItem:itemId:completionBlock:")
	public native void getItems(String cartId, String itemId, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Removes the specified item from the specified Cart
	 *
	 * @param cartId
	 *            - The cart id from which the item has to be removed
	 * @param itemId
	 *            - Id of the Item which has to be removed
	 *
	 * @returns App42Response if removed successfully
	 *
	 */
	@Method(selector = "removeItem:itemId:completionBlock:")
	public native void removeItem(String cartId, String itemId, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Removes all Items from the specified Cart
	 *
	 * @param cartId
	 *            - The cart id from which items have to be removed
	 *
	 * @returns App42Response if removed successfully
	 *
	 */
	@Method(selector = "removeAllItems:completionBlock:")
	public native void removeAllItems(String cartId, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Checks whether the Cart is Empty or not
	 *
	 * @param cartId
	 *            - The cart id to check for empty
	 *
	 * @returns Cart object (isEmpty method on Cart object can be used to check
	 *          status)
	 *
	 */
	@Method(selector = "isEmpty:completionBlock:")
	public native void isEmpty(String cartId, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Checks out the Cart and put it in CheckOut Stage and returns the
	 * Transaction Id The transaction id has to be used in future to update the
	 * Payment Status.
	 *
	 * @param cartID
	 *            - The cart id that has to be checkedOut.
	 *
	 * @returns Cart object containing Checked Out Cart Information with the
	 *          Transaction Id
	 *
	 */
	@Method(selector = "checkOut:completionBlock:")
	public native void checkOut(String cartId, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Update Payment Status of the Cart. When a Cart is checkout, it is in
	 * Checkout state. The payment status has to be updated based on the Payment
	 * Gateway interaction
	 *
	 * @param cartID
	 *            - The cart id for which the payment status has to be updated
	 * @param transactionID
	 *            - Transaction id for which the payment status has to be
	 *            updated
	 * @param paymentStatus
	 *            - Payment Status to be updated. The probable values are
	 *            PaymentStatus.DECLINED, PaymentStatus.AUTHORIZED,
	 *            PaymentStatus.PENDING
	 *
	 * @returns Cart object which contains Payment Status
	 *
	 */
	@Method(selector = "payment:transactionID:paymentStatus:completionBlock:")
	public native void payment(String cartId, String transactionID, String paymentStatus, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches Payment information for a User. This can be used to display Order
	 * and Payment History
	 *
	 * @param userId
	 *            - User Id for whom payment information has to be fetched
	 *
	 * @returns List containing Cart objects. Payment history can be retrieved
	 *          from individual Cart object.
	 *
	 */
	@Method(selector = "getPaymentsByUser:completionBlock:")
	public native void getPaymentsByUser(String userId, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches Payment information for the specified Cart Id
	 *
	 * @param cartID
	 *            - Cart Id for which the payment information has to be fetched
	 *
	 * @returns Cart object which contains Payment History for the specified
	 *          Cart
	 *
	 */
	@Method(selector = "getPaymentByCart:completionBlock:")
	public native void getPaymentByCart(String cartID, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches Payment information based on User Id and Status
	 *
	 * @param userId
	 *            - User Id for whom payment information has to be fetched
	 *@param paymentStatus
	 *            - Status of type which payment information has to be fetched
	 *
	 * @returns List containing Cart objects. Payment history can be retrieved
	 *          from individual Cart object.
	 *
	 * @returns Payment History
	 *
	 */
	@Method(selector = "getPaymentsByUserAndStatus:status:completionBlock:")
	public native void getPaymentsByUserAndStatus(String userId, String paymentStatus, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * Fetches Payment information based on Status
	 *
	 * @param paymentStatus
	 *            - Status of type which payment information has to be fetched
	 *
	 * @returns List containing Cart objects. Payment history can be retrieved
	 *          from individual Cart object.
	 *
	 */
	@Method(selector = "getPaymentsByStatus:completionBlock:")
	public native void getPaymentsByStatus(String paymentStatus, @Block App42ResponseBlock completionBlock);

	/**
	 * History of Carts and Payments for a User. It gives all the carts which
	 * are in AUTHORIZED, DECLINED, PENDING state.
	 *
	 * @param userId
	 *            - User Id for whom payment history has to be fetched
	 *
	 * @returns List containing Cart objects. Payment history can be retrieved
	 *          from individual Cart object.
	 *
	 */
	@Method(selector = "getPaymentHistoryByUser:completionBlock:")
	public native void getPaymentHistoryByUser(String userId, @Block App42ResponseBlock completionBlock);
	
	/**
	 * History of all carts. It gives all the carts which are in AUTHORIZED,
	 * DECLINED, PENDING state.
	 *
	 * @returns List containing Cart objects. Payment history can be retrieved
	 *          from individual Cart object.
	 *
	 */
	@Method(selector = "getPaymentHistoryAll:")
	public native void getPaymentHistoryAll(@Block App42ResponseBlock completionBlock);
	
	/**
	 * To increase quantity of existing item in the cart.
	 *
	 * @param cartID
	 *            - The Cart Id into which item has to be added
	 * @param itemID
	 *            - The Item id which has to be added in the cart. If the
	 *            Catalogue Service is used along with the Cart Service then the
	 *            Item ids should be same.
	 * @param itemQuantity
	 *            - Quantity of the Item to be purchased
	 *
	 * @returns Cart object containing updated item.
	 *
	 */
	@Method(selector = "increaseQuantity:itemID:itemQuantity:completionBlock:")
	public native void increaseQuantity(String cartId, String itemId, int itemQuantity, @Block App42ResponseBlock completionBlock);
	
	/**
	 * To decrease quantity of existing item in the cart..
	 *
	 * @param cartID
	 *            - The Cart Id from where item quantity has to be reduced
	 * @param itemID
	 *            - The Item id from where item quantity has to be reduced. If
	 *            the Catalogue Service is used along with the Cart Service then
	 *            the Item ids should be same.
	 * @param itemQuantity
	 *            - Quantity of the Item has to be reduced
	 *
	 * @returns Cart object containing updated item.
	 *
	 */
	@Method(selector = "decreaseQuantity:itemID:itemQuantity:completionBlock:")
	public native void decreaseQuantity(String cartId, String itemId, int itemQuantity, @Block App42ResponseBlock completionBlock);
}

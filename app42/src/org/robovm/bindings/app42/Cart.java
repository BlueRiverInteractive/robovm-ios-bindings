package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDate;
import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Cart extends App42Response
{
	/*!
	 *set and get the user name for the User.
	 */
	@Property(selector = "userName")
	public native String getUserName();

	@Property(selector = "setUserName:", strongRef = true)
	public native void setUserName(String userName);
	
	/*!
	 *set and get the cartId for the User. 
	 */
	@Property(selector = "cartId")
	public native String getCartId();

	@Property(selector = "setCartId:", strongRef = true)
	public native void setCartId(String cartId);
	
	/*!
	 *set and get the creation time of the cart.
	 */
	@Property(selector = "creationTime")
	public native NSDate getCreationTime();

	@Property(selector = "setCreationTime:", strongRef = true)
	public native void setCreationTime(NSDate creationTime);
	
	/*!
	 *set and get the check out time of cart. 
	 */
	@Property(selector = "checkOutTime")
	public native NSDate getCheckOutTime();

	@Property(selector = "setCheckOutTime:", strongRef = true)
	public native void setCheckOutTime(NSDate checkOutTime);
	
	/*!
	 *set and get the state of the cart. 
	 */
	@Property(selector = "state")
	public native String getState();

	@Property(selector = "setState:", strongRef = true)
	public native void setState(String state);
	
	/*!
	 *set and get true or false as per the cart information whether it's empty or
	 * not.
	 *
	 * @return true if cart is empty, false if cart is not empty.
	 */
	@Property(selector = "isEmpty")
	public native boolean isEmpty();

	@Property(selector = "setEmpty:", strongRef = true)
	public native void setEmpty(boolean isEmpty);
	
	/*!
	 *set and get the cartSession for the Cart. 
	 */
	@Property(selector = "cartSession")
	public native String getCartSession();

	@Property(selector = "setCartSession:", strongRef = true)
	public native void setCartSession(String cartSession);
	
	/*!
	 *set and get the total amount of cart. 
	 */
	@Property(selector = "totalAmount")
	public native double getTotalAmount();

	@Property(selector = "setTotalAmount:", strongRef = true)
	public native void setTotalAmount(double totalAmount);
	
	/*!
	 *set and get the list of all the items in the cart.
	 */
	@Property(selector = "itemListArray")
	public native NSMutableArray<?> getItemListArray();

	@Property(selector = "setItemListArray:", strongRef = true)
	public native void setItemListArray(NSMutableArray<?> itemListArray);
	
	/*!
	 *set and get the payment of the Cart.
	 *
	 */
	@Property(selector = "paymentObj")
	public native Payment getPayment();

	@Property(selector = "setPaymentObj:", strongRef = true)
	public native void setPayment(Payment payment);
}

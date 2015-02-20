package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDate;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class Payment extends NSObject
{
	@Property(selector = "transactionId")
	public native String getTransactionId();

	@Property(selector = "setTransactionId:", strongRef = true)
	public native void setTransactionId(String transactionId);
	
	@Property(selector = "status")
	public native String getStatus();

	@Property(selector = "setStatus:", strongRef = true)
	public native void setStatus(String status);

	@Property(selector = "date")
	public native NSDate getDate();

	@Property(selector = "setDate:", strongRef = true)
	public native void setDate(NSDate date);

	@Property(selector = "totalAmount")
	public native double getTotalAmount();

	@Property(selector = "setTotalAmount:", strongRef = true)
	public native void setTotalAmount(double totalAmount);

	@Property(selector = "cartObject")
	public native Cart getCart();

	@Property(selector = "setCartObject:", strongRef = true)
	public native void setCart(Cart cart);

	public Payment(Cart cart) {
		super((SkipInit) null);
	    initObject(init(cart));
	}
	
	@Method(selector = "initWithCart:")
	private native @Pointer long init(Cart cart);
}

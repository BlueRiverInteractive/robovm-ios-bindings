package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDecimalNumber;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class Item extends App42Response
{
	@Property(selector = "itemId")
	public native String getItemId();

	@Property(selector = "setItemId:", strongRef = true)
	public native void setItemId(String itemId);
	
	@Property(selector = "name")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);

	@Property(selector = "image")
	public native String getImage();

	@Property(selector = "setImage:", strongRef = true)
	public native void setImage(String image);

	@Property(selector = "quantity")
	public native int getQuantity();

	@Property(selector = "setQuantity:", strongRef = true)
	public native void setQuantity(int quantity);

	@Property(selector = "price")
	public native NSDecimalNumber getPrice();

	@Property(selector = "setPrice:", strongRef = true)
	public native void setPrice(NSDecimalNumber price);

	@Property(selector = "totalAmount")
	public native double getTotalAmount();

	@Property(selector = "setTotalAmount:", strongRef = true)
	public native void setTotalAmount(double totalAmount);

	@Property(selector = "cartObject")
	public native Cart getCart();

	@Property(selector = "setCartObject:", strongRef = true)
	public native void setCart(Cart cart);

	public Item(Cart cart) {
		super((SkipInit) null);
	    initObject(init(cart));
	}
	
	@Method(selector = "initWithCart:")
	private native @Pointer long init(Cart cart);
}

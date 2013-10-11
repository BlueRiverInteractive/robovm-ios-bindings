package org.robovm.cocoatouch.storekit;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.ObjCSuper;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("StoreKit")
@NativeClass
public class SKProductsResponse extends NSObject {

	static {
		ObjCRuntime.bind(SKProductsResponse.class);
	}

	// @property(nonatomic, readonly) NSArray *products __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);

	private static final Selector products = Selector.register("products");

	@Bridge
	private native static NSArray<SKProduct> objc_getProducts(SKProductsResponse __self__, Selector __cmd__);

	@Bridge
	private native static NSArray<SKProduct> objc_getProductsSuper(ObjCSuper __super__, Selector __cmd__);

	public NSArray<SKProduct> getProducts() {
		return (customClass) ? objc_getProductsSuper(getSuper(), products) : objc_getProducts(this, products);
	}
}

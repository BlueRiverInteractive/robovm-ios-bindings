
package org.robovm.cocoatouch.storekit;

import org.robovm.apple.foundation.NSLocale;
import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.ObjCSuper;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("StoreKit")
@NativeClass
public class SKProduct extends NSObject {

	static {
		ObjCRuntime.bind(SKProduct.class);
	}

	// @property(nonatomic, readonly) NSString *localizedDescription __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector localizedDescription = Selector.register("localizedDescription");

	@Bridge
	private native static String objc_localizedDescription (SKProduct __self__, Selector __cmd__);

	@Bridge
	private native static String objc_localizedDescriptionSuper (ObjCSuper __super__, Selector __cmd__);

	public String getLocalizedDescription () {
		if (customClass) {
			return objc_localizedDescriptionSuper(getSuper(), localizedDescription);
		} else {
			return objc_localizedDescription(this, localizedDescription);
		}
	}

	// @property(nonatomic, readonly) NSString *localizedTitle __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector localizedTitle = Selector.register("localizedTitle");

	@Bridge
	private native static String objc_localizedTitle (SKProduct __self__, Selector __cmd__);

	@Bridge
	private native static String objc_localizedTitleSuper (ObjCSuper __super__, Selector __cmd__);

	public String getLocalizedTitle () {
		if (customClass) {
			return objc_localizedTitleSuper(getSuper(), localizedTitle);
		} else {
			return objc_localizedTitle(this, localizedTitle);
		}
	}

	// @property(nonatomic, readonly) NSDecimalNumber *price __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector price = Selector.register("price");

	@Bridge
	private native static NSNumber objc_getPrice (SKProduct __self__, Selector __cmd__);

	@Bridge
	private native static NSNumber objc_getPriceSuper (ObjCSuper __super__, Selector __cmd__);

	public NSNumber getPrice () {
		return (customClass) ? objc_getPriceSuper(getSuper(), price) : objc_getPrice(this, price);
	}

	// @property(nonatomic, readonly) NSLocale *priceLocale __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector priceLocale = Selector.register("priceLocale");

	@Bridge
	private native static NSLocale objc_getPriceLocale (SKProduct __self__, Selector __cmd__);

	@Bridge
	private native static NSLocale objc_getPriceLocaleSuper (ObjCSuper __super__, Selector __cmd__);

	public NSLocale getPriceLocale () {
		return (customClass) ? objc_getPriceLocaleSuper(getSuper(), priceLocale) : objc_getPriceLocale(this, priceLocale);
	}

	// @property(nonatomic, readonly) NSString *productIdentifier __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector productIdentifier = Selector.register("productIdentifier");

	@Bridge
	private native static String objc_getProductIdentifier (SKProduct __self__, Selector __cmd__);

	@Bridge
	private native static String objc_getProductIdentifierSuper (ObjCSuper __super__, Selector __cmd__);

	public String getProductIdentifier () {
		return (customClass) ? objc_getProductIdentifierSuper(getSuper(), productIdentifier) : objc_getProductIdentifier(this,
			productIdentifier);
	}
}

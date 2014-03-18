
package org.robovm.bindings.thinkgaming;

import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.foundation.NSLocale;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass()
public class ThinkGamingProduct extends NSObject {

	public ThinkGamingProduct (NSDictionary<?, ?> response) {
		super((SkipInit)null);
		initObject(init(response));
	}

	@Method(selector = "initWithResponse:")
	private native @Pointer
	long init (NSDictionary<?, ?> response);

	@Property()
	public native String getProductIdentifier ();

	@Property()
	public native void setProductIdentifier (String identifier);

	@Property()
	public native String getDisplayName ();

	@Property()
	public native void setDisplayName (String name);

	@Property()
	public native String getDisplayDescription ();

	@Property()
	public native void setDisplayDescription (String description);

	@Property()
	public native double getThinkGamingPrice ();

	@Property()
	public native void setThinkGamingPrice (double price);

	@Method(selector = "price")
	public native double getPrice ();

	@Method(selector = "priceLocale")
	public native NSLocale getPriceLocale ();

	@Method(selector = "formattedPrice")
	public native String getFormattedPrice ();

	@Property()
	public native String getOfferText ();

	@Property()
	public native void setOfferText (String text);

	@Property()
	public native double getBuyPercentage ();

	@Property()
	public native void setBuyPercentage (double percentage);

	@Property()
	public native String getITunesProductIdentifier ();

	@Property()
	public native void setITunesProductIdentifier (String identifier);

// @Property() TODO
// public native SKProduct getITunesProduct ();

// @Property()
// public native void setITunesProduct (SKProduct product);

	@Property()
	public native int getPriceId ();

	@Property()
	public native void setPriceId (int id);

	@Property()
	public native int getMessageId ();

	@Property()
	public native void setMessageId (int id);

	@Property()
	public native String getItunesReference ();

	@Property()
	public native void setItunesReference (String reference);
}

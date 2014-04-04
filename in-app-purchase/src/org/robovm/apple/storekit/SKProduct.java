
package org.robovm.apple.storekit;

import org.robovm.apple.foundation.NSLocale;
import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Library;

@Library("StoreKit")
@NativeClass
public class SKProduct extends NSObject {
	@Property
	public native String getLocalizedDescription ();

	@Property
	public native String getLocalizedTitle ();

	@Property
	public native NSNumber getPrice ();

	@Property
	public native NSLocale getPriceLocale ();

	@Property
	public native String getProductIdentifier ();
}

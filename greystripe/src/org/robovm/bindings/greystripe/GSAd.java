
package org.robovm.bindings.greystripe;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class GSAd extends NSObject {

	public GSAd () {
		super((SkipInit)null);
	}

	/** A boolean indicating whether an ad has been fetched and is ready to be displayed.
	 * 
	 * @return a boolean indicating whether or not the ad is ready to be displayed */
	@Method
	public native boolean isAdReady ();

	/** Attempts to fetch a new ad. This should only be called if there is not already a valid ad ready to be displayed. */
	@Method
	public native void fetch ();

	@Method(selector = "adID")
	public native String getAdID ();
}

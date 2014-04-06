
package org.robovm.bindings.admob;

import org.robovm.apple.foundation.NSError;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.GlobalValue;

/** This class represents the error generated due to invalid request parameters. */
@NativeClass
public class GADRequestError extends NSError {
	/** Google AdMob Ads error domain. */
	@GlobalValue(symbol = "kGADErrorDomain")
	public static native String errorDomain ();

	private GADRequestError () {
	}
}

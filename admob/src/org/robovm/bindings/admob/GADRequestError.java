
package org.robovm.bindings.admob;

import org.robovm.apple.foundation.NSError;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.GlobalValue;
import org.robovm.rt.bro.annotation.Library;

/** This class represents the error generated due to invalid request parameters. */
@Library(Library.INTERNAL)
@NativeClass
public class GADRequestError extends NSError {
	/** Google AdMob Ads error domain. */
	@GlobalValue(symbol = "kGADErrorDomain")
	public static native String errorDomain ();

	private GADRequestError () {
	}
}

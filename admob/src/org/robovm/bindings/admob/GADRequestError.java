
package org.robovm.bindings.admob;

import org.robovm.apple.foundation.NSError;
import org.robovm.objc.annotation.NativeClass;

/** This class represents the error generated due to invalid request parameters. */
@NativeClass
public class GADRequestError extends NSError {
	/** Google AdMob Ads error domain. */
	public static String errorDomain () {
		return GADRequestErrorConstants.errorDomain();
	}

	private GADRequestError () {
	}

	public GADErrorCode getErrorCode () {
		long code = code();
		if (code >= 0 && code < GADErrorCode.values().length) {
			return GADErrorCode.values()[(int)code];
		}
		return null;
	}
}

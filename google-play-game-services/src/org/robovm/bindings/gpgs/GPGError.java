
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSString;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGError extends NSError {
	public GPGError(String domain, long code, NSDictionary<NSString, ?> dict) {
		super(domain, code, dict);
	}

	private static final ObjCClass objCClass = ObjCClass.getByType(GPGError.class);

	static {
		ObjCRuntime.bind(GPGError.class);
	}

	/*
	 * enum { GPGInvalidAuthenticationError = 1, // No valid authentication found. You must authenticate the user before executing
	 * the action that returned this error.
	 * 
	 * GPGNetworkUnavailableError = 2, // The network is offline, a network operation cannot be completed.
	 * 
	 * GPGServiceMethodFailedError = 3, // A method from the games service failed.
	 * 
	 * GPGRevisionStaleError = 4, // Current SDK version is either deprecated or invalid. };
	 */
}


package org.robovm.bindings.playhaven;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class PHAPIRequest extends NSObject {
	/** Returns a new PHAPIRequest instance with the given token and secret
	 * 
	 * @param token The token
	 * 
	 * @param secret The secret
	 * 
	 * @return The PHAPIRequest instance **/
	@Method(selector = "requestForApp:secret:")
	public static native PHAPIRequest request (String token, String secret);

	/** Start the request if it has not already started **/
	@Method
	public native void send ();
}

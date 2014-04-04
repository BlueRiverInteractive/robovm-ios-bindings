
package org.robovm.bindings.tapjoy;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIView;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class Tapjoy extends NSObject {
	/** This method is called to initialize the Tapjoy system and notify the server that this device is running your application.
	 * 
	 * This method should be called upon app delegate initialization in the applicationDidFinishLaunching method.
	 * 
	 * @param appID The application ID. Retrieved from the app dashboard in your Tapjoy account.
	 * @param secretKey The application secret key. Retrieved from the app dashboard in your Tapjoy account. */
	@Method(selector = "requestTapjoyConnect:secretKey:")
	public static native void requestConnect (String appID, String secretKey);

	/** Allocates and initializes a TJCOffersWebView.
	 * 
	 * @return The TJCOffersWebView UIView object. */
	@Method
	public static native UIView showOffers ();

	/** Requests for Tap Points (Virtual Currency) notify via TJC_TAP_POINTS_RESPONSE_NOTIFICATION notification. */
	@Method(selector = "getTapPoints")
	public static native void getTapPoints ();

	/** Updates the virtual currency for the user with the given spent amount of currency.
	 * 
	 * If the spent amount exceeds the current amount of currency the user has, nothing will happen.
	 * @param points The amount of currency to subtract from the current total amount of currency the user has. */
	@Method(selector = "spendTapPoints:")
	public static native void spendTapPoints (int points);
}

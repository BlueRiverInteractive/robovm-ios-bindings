
package org.robovm.bindings.appirater;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class Appirater extends NSObject {

	/** @return the singleton. */
	@Method
	public static native Appirater sharedInstance ();

	/** Tells Appirater that the app has launched, and on devices that do NOT support multitasking, the 'uses' count will be
	 * incremented. You should call this method at the end of your application delegate's
	 * application:didFinishLaunchingWithOptions: method.
	 * 
	 * If the app has been used enough to be rated (and enough significant events), you can suppress the rating alert by passing NO
	 * for canPromptForRating. The rating alert will simply be postponed until it is called again with YES for canPromptForRating.
	 * The rating alert can also be triggered by appEnteredForeground: and userDidSignificantEvent: (as long as you pass YES for
	 * canPromptForRating in those methods). */
	@Method(selector = "appLaunched:")
	public static native void appLaunched (boolean canPromptForRating);

	/** Tells Appirater to show the prompt (a rating alert). The prompt will be showed if there is connection available, the user
	 * hasn't declined to rate or hasn't rated current version.
	 * 
	 * You could call to show the prompt regardless Appirater settings, e.g., in case of some special event in your app. */
	@Method(selector = "showPrompt")
	public static native void showPrompt ();

	/** Set your Apple generated software id here. */
	@Method(selector = "setAppId:")
	public static native void setAppId (String appId);

	/** Users will need to have the same version of your app installed for this many days before they will be prompted to rate it. */
	@Method(selector = "setDaysUntilPrompt:")
	public static native void setDaysUntilPrompt (double days);

	/** An example of a 'use' would be if the user launched the app. Bringing the app into the foreground (on devices that support
	 * it) would also be considered a 'use'. You tell Appirater about these events using the two methods: [Appirater appLaunched:]
	 * [Appirater appEnteredForeground:]
	 * 
	 * Users need to 'use' the same version of the app this many times before before they will be prompted to rate it. */
	@Method(selector = "setUsesUntilPrompt:")
	public static native void setUsesUntilPrompt (int uses);

	/** 'YES' will show the Appirater alert everytime. Useful for testing how your message looks and making sure the link to your
	 * app's review page works. */
	@Method(selector = "setDebug:")
	public static native void setDebug (boolean debug);

	/** Set the delegate if you want to know when Appirater does something */
	@Method(selector = "setDelegate:")
	public static native void setDelegate (AppiraterDelegate delegate);
}

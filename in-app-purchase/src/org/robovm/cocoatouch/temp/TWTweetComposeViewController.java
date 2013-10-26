
package org.robovm.cocoatouch.temp;

import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("Twitter")
@NativeClass
public class TWTweetComposeViewController extends UIViewController {
	static {
		ObjCRuntime.bind(TWTweetComposeViewController.class);
	}

	private static final ObjCClass objCClass = ObjCClass.getByType(TWTweetComposeViewController.class);

	private static final Selector canSendTweet = Selector.register("canSendTweet");

	@Bridge
	private native static boolean objc_canSendTweet (ObjCClass __self__, Selector __cmd__);

	public static boolean canSendTweet () {
		return objc_canSendTweet(objCClass, canSendTweet);
	}

	private static final Selector setCompletionHandler$ = Selector.register("setCompletionHandler:");

	@Bridge
	private native static void objc_setCompletionHandler (TWTweetComposeViewController __self__, Selector __cmd__,
		SLComposeViewControllerResultHandler completionHandler);

	public void setCompletionHandler (SLComposeViewControllerResultHandler completionHandler) {
		objc_setCompletionHandler(this, setCompletionHandler$, completionHandler);
	}

	private static final Selector setInitialText$ = Selector.register("setInitialText:");

	@Bridge
	private native static boolean objc_setInitialText (TWTweetComposeViewController __self__, Selector __cmd__, String text);

	public boolean setInitialText (String text) {
		return objc_setInitialText(this, setInitialText$, text);
	}
}

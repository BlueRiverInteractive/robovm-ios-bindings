
package org.robovm.apple.temp;

import org.robovm.apple.social.SLComposeViewControllerResult;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.objc.block.VoidBlock1;
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

	@Property(selector = "setCompletionHandler:")
	public native void setCompletionHandler (@Block VoidBlock1<SLComposeViewControllerResult> completionHandler);

	private static final Selector setInitialText$ = Selector.register("setInitialText:");

	@Bridge
	private native static boolean objc_setInitialText (TWTweetComposeViewController __self__, Selector __cmd__, String text);

	public boolean setInitialText (String text) {
		return objc_setInitialText(this, setInitialText$, text);
	}
}


package org.robovm.bindings.facebook.manager;

import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("Social")
@NativeClass
public class SLComposeViewController extends UIViewController {
	static {
		ObjCRuntime.bind(SLComposeViewController.class);
	}

	private SLComposeViewController () {
	}

	private static final ObjCClass objCClass = ObjCClass.getByType(SLComposeViewController.class);

	// + (BOOL)isAvailableForServiceType:(NSString *)serviceType;
	private static final Selector isAvailableForServiceType$ = Selector.register("isAvailableForServiceType:");

	@Bridge
	private native static boolean objc_isAvailableForServiceType (ObjCClass __self__, Selector __cmd__, NSString serviceType);

	public static boolean isAvailable (NSString serviceType) {
		return objc_isAvailableForServiceType(objCClass, isAvailableForServiceType$, serviceType);
	}

	public static final NSString ServiceTypeTwitter = new NSString("com.apple.social.twitter");
	public static final NSString ServiceTypeFacebook = new NSString("com.apple.social.facebook");
	public static final NSString ServiceTypeSinaWeibo = new NSString("com.apple.social.sinaweibo");

// // + (SLComposeViewController *)composeViewControllerForServiceType:(NSString *)serviceType;
// private static final Selector composeViewControllerForServiceType$ = Selector.register("composeViewControllerForServiceType:");
//
// @Bridge
// private native static SLComposeViewController objc_composeViewControllerForServiceType (ObjCClass __self__, Selector __cmd__,
// NSString serviceType);
//
// public static SLComposeViewController fromService (NSString serviceType) {
// return objc_composeViewControllerForServiceType(objCClass, composeViewControllerForServiceType$, serviceType);
// }
//
// // @property (nonatomic, copy) SLComposeViewControllerCompletionHandler completionHandler;
// private static final Selector setCompletionHandler$ = Selector.register("setCompletionHandler:");
//
// @Bridge
// private native static void objc_setCompletionHandler (SLComposeViewController __self__, Selector __cmd__,
// SLComposeViewControllerResultHandler completionHandler);
//
// public void setCompletionHandler (SLComposeViewControllerResultHandler completionHandler) {
// objc_setCompletionHandler(this, setCompletionHandler$, completionHandler);
// }
//
// // - (BOOL)setInitialText:(NSString *)text;
// private static final Selector setInitialText$ = Selector.register("setInitialText:");
//
// @Bridge
// private native static boolean objc_setInitialText (SLComposeViewController __self__, Selector __cmd__, String text);
//
// public boolean setInitialText (String text) {
// return objc_setInitialText(this, setInitialText$, text);
// }
}

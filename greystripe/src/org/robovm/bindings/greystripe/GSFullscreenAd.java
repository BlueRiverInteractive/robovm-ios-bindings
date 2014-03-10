
package org.robovm.bindings.greystripe;

import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;

@NativeClass
public class GSFullscreenAd extends GSAd {

	/** Initialize a GSFullscreenAd with a delegate. If this init is used, the host app must implement the GUID method.
	 * 
	 * @param a_delegate The delegate that will receive all ad notification messages. */
	public GSFullscreenAd initWithDelegate (GSAdDelegate delegate) {
		return objc_initWithDelegate(this, init$WithDelegate, delegate);
	}

	// - (id)initWithDelegate:(id<GSAdDelegate>)a_delegate;
	private static final Selector init$WithDelegate = Selector.register("initWithDelegate:");

	@Bridge
	private native static final GSFullscreenAd objc_initWithDelegate (GSFullscreenAd __self__, Selector __cmd__,
		GSAdDelegate a_delegate);

	/** Initialize a GSFullscreenAd with a delegate and a GUID. If the host app does not implement the GUID method, this is the init
	 * method that needs to be called. Otherwise an exception will be raised.
	 * 
	 * @param a_delegate The delegate that will receive all ad notification messages.
	 * @param a_GUID The global unique identifier for the application. */
	public GSFullscreenAd initWithDelegate (GSAdDelegate delegate, String guid) {
		return objc_initWithDelegate(this, init$WithDelegate$GUID, delegate, new NSString(guid));
	}

	// - (id)initWithDelegate:(id<GSAdDelegate>)a_delegate GUID:(NSString *)a_GUID;
	private static final Selector init$WithDelegate$GUID = Selector.register("initWithDelegate:GUID:");

	@Bridge
	private native static final GSFullscreenAd objc_initWithDelegate (GSFullscreenAd __self__, Selector __cmd__,
		GSAdDelegate a_delegate, NSString a_GUID);

	/** Tells the shared GSFullscreenAdViewController to display the ad from the given view controller. This should be the view
	 * controller that is currently displaying.
	 * 
	 * @param a_viewController the view controller that the ad should be displayed from. */
	public boolean displayFromViewController (UIViewController controller) {
		return objc_displayFromViewController(this, display$FromViewController, controller);
	}

	// - (BOOL)displayFromViewController:(UIViewController *)a_viewController;
	private static final Selector display$FromViewController = Selector.register("displayFromViewController:");

	@Bridge
	private native static boolean objc_displayFromViewController (GSFullscreenAd __self__, Selector __cmd__,
		UIViewController a_viewController);

}

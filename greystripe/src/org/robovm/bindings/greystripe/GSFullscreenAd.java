
package org.robovm.bindings.greystripe;

import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class GSFullscreenAd extends GSAd {
	/** Initialize a GSFullscreenAd with a delegate. If this init is used, the host app must implement the GUID method.
	 * 
	 * @param a_delegate The delegate that will receive all ad notification messages. */
	public GSFullscreenAd (GSAdDelegate delegate) {
		initObject(init(delegate));
	}

	@Method(selector = "initWithDelegate:")
	private native @Pointer
	long init (GSAdDelegate delegate);

	/** Initialize a GSFullscreenAd with a delegate and a GUID. If the host app does not implement the GUID method, this is the init
	 * method that needs to be called. Otherwise an exception will be raised.
	 * 
	 * @param a_delegate The delegate that will receive all ad notification messages.
	 * @param a_GUID The global unique identifier for the application. */
	public GSFullscreenAd (GSAdDelegate delegate, String guid) {
		init(delegate, guid);
	}

	@Method(selector = "initWithDelegate:GUID:")
	private native @Pointer
	long init (GSAdDelegate delegate, String guid);

	/** Tells the shared GSFullscreenAdViewController to display the ad from the given view controller. This should be the view
	 * controller that is currently displaying.
	 * 
	 * @param a_viewController the view controller that the ad should be displayed from. */
	@Method(selector = "displayFromViewController:")
	public native boolean display (UIViewController controller);
}

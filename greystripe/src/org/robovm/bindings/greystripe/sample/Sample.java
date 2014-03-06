package org.robovm.bindings.greystripe.sample;

import org.robovm.bindings.greystripe.GSAd;
import org.robovm.bindings.greystripe.GSAdDelegate;
import org.robovm.bindings.greystripe.GSAdError;
import org.robovm.bindings.greystripe.GSFullscreenAd;
import org.robovm.bindings.greystripe.GSAdDelegate.Adapter;
import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;
import org.robovm.cocoatouch.uikit.UIScreen;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.cocoatouch.uikit.UIWindow;

/** Sample usage of the Greystrike SDK. */
public class Sample extends UIApplicationDelegate.Adapter {
	
	private static final String guid = "51d7ee3c-95fd-48d5-b648-c915209a00a5";
	
	private UIViewController localViewController; 

	private GSFullscreenAd fullScreenAd;
	
	@Override
	public void didFinishLaunching (UIApplication application) {
		localViewController = new UIViewController();
		
		fullScreenAd = new GSFullscreenAd();
		fullScreenAd.initWithDelegate(new GSAdDelegate.Adapter() {
			
			@Override
			public UIViewController greystripeBannerDisplayViewController() {
				return localViewController;
			}

			@Override
			public NSString greystripeGUID() {
				return new NSString(guid);
			}

			@Override
			public void greystripeAdFetchSucceeded(GSAd a_ad) {
				System.err.println("Fetch succeeded");
				if (a_ad == fullScreenAd && fullScreenAd != null) {
					fullScreenAd.displayFromViewController(greystripeBannerDisplayViewController());
				}
			}

			@Override
			public void greystripeAdFetchFailed(GSAd a_ad, GSAdError a_error) {
				System.err.println("Fetch failed for ad");
				if (fullScreenAd != null) {
					fullScreenAd.fetch();
				}
			}

			@Override
			public void greystripeDidDismissModalViewController() {
				if (fullScreenAd != null) {
					fullScreenAd.fetch();
				}
			}
		});

		UIWindow window = new UIWindow(UIScreen.getMainScreen().getBounds());
		window.setRootViewController(localViewController);
		window.makeKeyAndVisible();
		
		System.err.println("Fetching...");
		fullScreenAd.fetch();
	}

	public static void main (String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
	}
}
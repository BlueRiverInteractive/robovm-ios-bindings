package org.robovm.bindings.mopub;

import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;
import org.robovm.cocoatouch.uikit.UIScreen;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.cocoatouch.uikit.UIWindow;

/**
 * Basic usage of the MoPub advertising SDK.
 */
public class Sample extends UIApplicationDelegate.Adapter {
	private UIViewController mainViewController;

	@Override
	public void didFinishLaunching(UIApplication application) {
		MPInterstitialAdController interstitial = MPInterstitialAdController.getAdController("YOUR_AD_UNIT_ID");
		MPInterstitialAdControllerDelegate delegate = new MPInterstitialAdControllerDelegate.Adapter() {
			@Override
			public void didExpire(MPInterstitialAdController interstitial) {
				// If the ad did expire, load a new ad.
				interstitial.loadAd();
			}

			@Override
			public void didLoadAd(MPInterstitialAdController interstitial) {
				// If the ad is ready, show it.
				if (interstitial.isReady())
					interstitial.show(mainViewController);
			}

			@Override
			public void didFailToLoadAd(MPInterstitialAdController interstitial) {
				// If the ad did fail to load, load a new ad. Check the debug log to see why it didn't load.
				interstitial.loadAd();
			}
		};

		interstitial.setDelegate(delegate);
		interstitial.loadAd();

		mainViewController = new UIViewController();
		UIWindow window = new UIWindow(UIScreen.getMainScreen().getBounds());
		window.setRootViewController(mainViewController);
		window.makeKeyAndVisible();
	}

	public static void main(String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
	}
}
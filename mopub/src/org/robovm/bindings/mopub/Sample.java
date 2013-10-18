package org.robovm.bindings.mopub;

import org.robovm.cocoatouch.coregraphics.CGRect;
import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;
import org.robovm.cocoatouch.uikit.UIColor;
import org.robovm.cocoatouch.uikit.UIScreen;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.cocoatouch.uikit.UIWindow;

/**
 * Basic usage of banners and interstitials.
 */
public class Sample extends UIApplicationDelegate.Adapter {
	private UIViewController interstitialViewController;

	@Override
	public void didFinishLaunching(UIApplication application) {
		// We need a view controller to see ads.
		interstitialViewController = new UIViewController();

		// Create an interstitial.
		MPInterstitialAdController interstitial = MPInterstitialAdController.getAdController("YOUR_AD_UNIT_ID");
		// The delegate for an interstitial is optional.
		MPInterstitialAdControllerDelegate delegate = new MPInterstitialAdControllerDelegate.Adapter() {
			@Override
			public void didExpire(MPInterstitialAdController interstitial) {
				// If the ad did expire, load a new ad.
				interstitial.loadAd();
			}

			@Override
			public void didLoadAd(MPInterstitialAdController interstitial) {
				// If the ad is ready, show it.
				// It's best to call these methods manually and not in didLoadAd().
				if (interstitial.isReady())
					interstitial.show(interstitialViewController);
			}

			@Override
			public void didFailToLoadAd(MPInterstitialAdController interstitial) {
				// If the ad did fail to load, load a new ad. Check the debug log to see why it didn't load.
				interstitial.loadAd();
			}
		};
		interstitial.setDelegate(delegate);
		// Load an interstitial ad.
		interstitial.loadAd();

		// Create a MoPub ad. In this case a banner, but you can make it any size you want.
		MPAdView banner = new MPAdView("YOUR_AD_UNIT_ID", MPConstants.MOPUB_BANNER_SIZE);

		// Let's calculate our banner size. We need to do this because the resolution of a retina and normal device is different.
		float bannerWidth = UIScreen.getMainScreen().getApplicationFrame().size().width();
		float bannerHeight = bannerWidth / MPConstants.MOPUB_BANNER_SIZE.width() * MPConstants.MOPUB_BANNER_SIZE.height();

		// Let's set the frame (boundings) of our banner view. Remember on iOS view coordinates have their origin top-left.
		// Position banner on the top.
		// banner.setFrame(new CGRect(0, 0, bannerWidth, bannerHeight));
		// Position banner on the bottom.
		banner.setFrame(new CGRect(0, UIScreen.getMainScreen().getApplicationFrame().size().height() - bannerHeight, bannerWidth, bannerHeight));
		// Let's color the background for testing, so we can see if it is positioned correctly, even if no ad is loaded yet.
		banner.setBackgroundColor(new UIColor(1, 0, 0, 1)); // Remove this after testing.

		// The delegate for the banner. It is required to override getViewController() to get ads.
		MPAdViewDelegate bannerDelegate = new MPAdViewDelegate.Adapter() {
			@Override
			public UIViewController getViewController() {
				return interstitialViewController;
			}
		};
		banner.setDelegate(bannerDelegate);
		// Add banner to our view controller.
		interstitialViewController.getView().addSubview(banner);
		// Finally load a banner ad. This ad gets refreshed automatically, although you can refresh it at any time via refreshAd().
		banner.loadAd();

		// Create a standard UIWindow at screen size, add the view controller and show it.
		UIWindow window = new UIWindow(UIScreen.getMainScreen().getBounds());
		window.setRootViewController(interstitialViewController);
		window.makeKeyAndVisible();

		// If you are already using a UIWindow, you can do the following (f.e. LibGDX):
		// UIView interstitialView = new UIView(UIScreen.getMainScreen().getBounds());
		// interstitialView.setUserInteractionEnabled(false);
		// interstitialViewController.setView(interstitialView);
		// application.getKeyWindow().addSubview(interstitialViewController.getView());
	}

	public static void main(String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
	}
}
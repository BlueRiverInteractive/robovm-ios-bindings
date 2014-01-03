
package org.robovm.bindings.mopub.sample;

import org.robovm.bindings.mopub.MPAdView;
import org.robovm.bindings.mopub.MPAdViewDelegate;
import org.robovm.bindings.mopub.MPConstants;
import org.robovm.bindings.mopub.MPInterstitialAdController;
import org.robovm.bindings.mopub.MPInterstitialAdControllerDelegate;
import org.robovm.cocoatouch.coregraphics.CGRect;
import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;
import org.robovm.cocoatouch.uikit.UIColor;
import org.robovm.cocoatouch.uikit.UIScreen;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.cocoatouch.uikit.UIWindow;

/** Basic usage of banners and interstitials. */
public class Sample extends UIApplicationDelegate.Adapter {
	private static final String INTERSTITIAL_AD_UNIT_ID = "80abbe6aa484431cbf5d2cb01e915c6a";
	private static final String BANNER_AD_UNIT_ID = "YOUR_AD_UNIT_ID";
	private UIViewController rootViewController;
	private MPAdViewController adViewController;

	@Override
	public void didFinishLaunching (UIApplication application) {
		// We need a view controller to see ads.
		rootViewController = new UIViewController();
		// If you are already using a UIWindow with a root view controller, get the root view controller (f.e. LibGDX):
		// rootViewController = UIApplication.getSharedApplication().getKeyWindow().getRootViewController();

		// Create an interstitial.
		final MPInterstitialAdController interstitial = MPInterstitialAdController.getAdController(INTERSTITIAL_AD_UNIT_ID);
		// The delegate for an interstitial is optional.
		MPInterstitialAdControllerDelegate delegate = new MPInterstitialAdControllerDelegate.Adapter() {
			@Override
			public void didDisappear (MPInterstitialAdController interstitial) {
				// If the ad disappears, load a new ad, so we can show it immediately the next time.
				interstitial.loadAd();
			}

			@Override
			public void didExpire (MPInterstitialAdController interstitial) {
				// If the ad did expire, load a new ad, so we can show it immediately the next time.
				interstitial.loadAd();
			}

			@Override
			public void didLoadAd (MPInterstitialAdController interstitial) {
				// If the ad is ready, show it.
				// It's best to call these methods manually and not in didLoadAd(). Use this only for testing purposes!
				if (interstitial.isReady()) interstitial.show(rootViewController);
			}

			@Override
			public void didFailToLoadAd (MPInterstitialAdController interstitial) {
				// If the ad did fail to load, load a new ad. Check the debug log to see why it didn't load.
				interstitial.loadAd();
			}
		};
		interstitial.setDelegate(delegate);

		// Create a MoPub ad. In this case a banner, but you can make it any size you want.
		final MPAdView banner = new MPAdView(BANNER_AD_UNIT_ID, MPConstants.MOPUB_BANNER_SIZE);

		// Let's calculate our banner size. We need to do this because the resolution of a retina and normal device is different.
		float bannerWidth = UIScreen.getMainScreen().getBounds().size().width();
		float bannerHeight = bannerWidth / MPConstants.MOPUB_BANNER_SIZE.width() * MPConstants.MOPUB_BANNER_SIZE.height();

		// Let's set the frame (bounds) of our banner view. Remember on iOS view coordinates have their origin top-left.
		// Position banner on the top.
		// banner.setFrame(new CGRect(0, 0, bannerWidth, bannerHeight));
		// Position banner on the bottom.
		banner.setFrame(new CGRect(0, UIScreen.getMainScreen().getBounds().size().height() - bannerHeight, bannerWidth,
			bannerHeight));
		// Let's color the background for testing, so we can see if it is positioned correctly, even if no ad is loaded yet.
		banner.setBackgroundColor(new UIColor(1, 0, 0, 1)); // Remove this after testing.

		// We use our custom ad view controller to notify for orientation changes.
		adViewController = new MPAdViewController(banner);

		// The delegate for the banner. It is required to override getViewController() to get ads.
		MPAdViewDelegate bannerDelegate = new MPAdViewDelegate.Adapter() {
			@Override
			public UIViewController getViewController () {
				return adViewController;
			}
		};
		banner.setDelegate(bannerDelegate);
		// Add banner to our view controller.
		adViewController.getView().addSubview(banner);

		// We add the ad view controller to our root view controller.
		rootViewController.addChildViewController(adViewController);
		rootViewController.getView().addSubview(adViewController.getView());

		// Create a standard UIWindow at screen size, add the view controller and show it.
		UIWindow window = new UIWindow(UIScreen.getMainScreen().getBounds());
		window.setRootViewController(rootViewController);
		window.addSubview(rootViewController.getView());
		window.makeKeyAndVisible();

		// Load an interstitial ad.
		interstitial.loadAd();
		// Load a banner ad. This ad gets refreshed automatically, although you can refresh it at any time via refreshAd().
		banner.loadAd();
	}

	public static void main (String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
	}
}

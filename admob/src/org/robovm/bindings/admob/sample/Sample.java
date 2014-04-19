
package org.robovm.bindings.admob.sample;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.apple.uikit.UIWindow;
import org.robovm.bindings.admob.GADInterstitial;
import org.robovm.bindings.admob.GADInterstitialDelegateAdapter;
import org.robovm.bindings.admob.GADRequest;
import org.robovm.bindings.admob.GADRequestError;

public class Sample extends UIApplicationDelegateAdapter {
	private static final String AD_UNIT_ID = "YOUR_AD_UNIT_ID";

	private UIWindow window;
	private UIViewController rootViewController;

	@Override
	public void didFinishLaunching (UIApplication application) {
		rootViewController = new UIViewController();

		GADInterstitial interstitial = new GADInterstitial();
		interstitial.setAdUnitID(AD_UNIT_ID);

		interstitial.setDelegate(new GADInterstitialDelegateAdapter() {
			@Override
			public void didReceiveAd (GADInterstitial ad) {
				System.out.println("Did receive ad.");
			}

			@Override
			public void didFailToReceiveAd (GADInterstitial ad, GADRequestError error) {
				System.out.println(error.description());
				System.out.println(error.getErrorCode());
			}
		});

		window = new UIWindow(UIScreen.getMainScreen().getBounds());
		window.setRootViewController(rootViewController);
		window.addSubview(rootViewController.getView());
		window.makeKeyAndVisible();

		interstitial.loadRequest(GADRequest.request());
		interstitial.present(rootViewController);
	}

	public static void main (String[] argv) {
		try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
			UIApplication.main(argv, null, Sample.class);
		}
	}
}

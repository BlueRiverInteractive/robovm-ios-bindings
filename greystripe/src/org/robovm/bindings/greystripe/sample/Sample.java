
package org.robovm.bindings.greystripe.sample;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.apple.uikit.UIWindow;
import org.robovm.bindings.greystripe.GSAd;
import org.robovm.bindings.greystripe.GSAdDelegateAdapter;
import org.robovm.bindings.greystripe.GSAdError;
import org.robovm.bindings.greystripe.GSFullscreenAd;

/** Sample usage of the Greystrike SDK. */
public class Sample extends UIApplicationDelegateAdapter {
	private static final String guid = "51d7ee3c-95fd-48d5-b648-c915209a00a5";

	private UIWindow window;
	private UIViewController localViewController;
	private GSFullscreenAd fullScreenAd;

	@Override
	public void didFinishLaunching (UIApplication application) {
		localViewController = new UIViewController();

		fullScreenAd = new GSFullscreenAd(new GSAdDelegateAdapter() {
			@Override
			public UIViewController getBannerDisplayViewController () {
				return localViewController;
			}

			@Override
			public String getGUID () {
				return guid;
			}

			@Override
			public void adFetchSucceeded (GSAd a_ad) {
				System.err.println("Fetch succeeded");
				if (a_ad == fullScreenAd && fullScreenAd != null) {
					fullScreenAd.display(getBannerDisplayViewController());
				}
			}

			@Override
			public void adFetchFailed (GSAd a_ad, GSAdError a_error) {
				System.err.println("Fetch failed for ad");
				if (fullScreenAd != null) {
					fullScreenAd.fetch();
				}
			}

			@Override
			public void didDismissModalViewController () {
				if (fullScreenAd != null) {
					fullScreenAd.fetch();
				}
			}
		});

		window = new UIWindow(UIScreen.getMainScreen().getBounds());
		window.setRootViewController(localViewController);
		window.makeKeyAndVisible();

		System.err.println("Fetching...");
		fullScreenAd.fetch();
	}

	public static void main (String[] argv) {
		try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
			UIApplication.main(argv, null, Sample.class);
		}
	}
}

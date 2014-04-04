
package org.robovm.bindings.vungle.sample;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.apple.uikit.UIWindow;
import org.robovm.bindings.vungle.VGPlayData;
import org.robovm.bindings.vungle.VGStatusData;
import org.robovm.bindings.vungle.VGVunglePub;
import org.robovm.bindings.vungle.VGVunglePubDelegateAdapter;

/** Sample usage of the Vungle SDK. */
public class Sample extends UIApplicationDelegateAdapter {
	private UIWindow window;
	private UIViewController viewController;

	@Override
	public void didFinishLaunching (UIApplication application) {
		viewController = new UIViewController();

		// Setup Vungle.
		VGVunglePub.start("YOUR_VUNGLE_APP_ID");
		VGVunglePub.setDelegate(new VGVunglePubDelegateAdapter() {
			@Override
			public void moviePlayed (VGPlayData playData) {
				if (playData.isPlayedFully()) {
					System.out.println("Played the whole movie");
					// Here is a good place to award the user for watching the video.
				}
			}

			@Override
			public void statusUpdate (VGStatusData statusData) {
				// Show a video ad. You would normally do this in a button tap event.
				if (VGVunglePub.isAdAvailable()) {
					VGVunglePub.playIncentivizedAd(viewController, true, false, "");
				}
			}

			@Override
			public void viewWillAppear (UIViewController viewController) {
			}

			@Override
			public void viewDidDisappear (UIViewController viewController) {
			}

			@Override
			public void appStoreViewDidDisappear () {
			}
		});

		window = new UIWindow(UIScreen.getMainScreen().getBounds());
		window.setRootViewController(viewController);
		window.makeKeyAndVisible();
	}

	public static void main (String[] argv) {
		try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
			UIApplication.main(argv, null, Sample.class);
		}
	}
}

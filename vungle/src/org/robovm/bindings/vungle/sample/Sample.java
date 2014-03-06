
package org.robovm.bindings.vungle.sample;

import org.robovm.bindings.vungle.VGPlayData;
import org.robovm.bindings.vungle.VGStatusData;
import org.robovm.bindings.vungle.VGVunglePub;
import org.robovm.bindings.vungle.VGVunglePubDelegate;
import org.robovm.bindings.vungle.VGVunglePubDelegate.Adapter;
import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;
import org.robovm.cocoatouch.uikit.UIScreen;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.cocoatouch.uikit.UIWindow;

/** Sample usage of the Vungle SDK. */
public class Sample extends UIApplicationDelegate.Adapter {
	UIViewController viewController;

	@Override
	public void didFinishLaunching (UIApplication application) {
		viewController = new UIViewController();

		// Setup Vungle.
		VGVunglePub.start("YOUR_VUNGLE_APP_ID");
		VGVunglePub.setDelegate(new VGVunglePubDelegate.Adapter() {
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
		});

		UIWindow window = new UIWindow(UIScreen.getMainScreen().getBounds());
		window.setRootViewController(viewController);
		window.makeKeyAndVisible();
	}

	public static void main (String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
	}
}

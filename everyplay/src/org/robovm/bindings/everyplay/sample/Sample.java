package org.robovm.bindings.everyplay.sample;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.apple.uikit.UIWindow;
import org.robovm.bindings.everyplay.Everyplay;
import org.robovm.bindings.everyplay.EveryplayDelegate;
import org.robovm.bindings.everyplay.EveryplayDelegateAdapter;

/** Basic usage of the Everyplay SDK. */
public class Sample extends UIApplicationDelegateAdapter {

	private UIWindow window;
	private UIViewController rootViewController;
	EveryplayDelegate everyplayDelegate;

	@Override
	public boolean didFinishLaunching(UIApplication application,
			UIApplicationLaunchOptions launchOptions) {
		rootViewController = new UIViewController();

		window = new UIWindow(UIScreen.getMainScreen().getBounds());
		window.setRootViewController(rootViewController);
		window.makeKeyAndVisible();

		// Initialize Everyplay
		System.out.println("Initializing Everyplay");
		String CLIENT_ID = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
		String SECRET = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
		Everyplay.configure(CLIENT_ID, SECRET, "https://m.everyplay.com/auth");
		everyplayDelegate = new EveryplayDelegateAdapter() {

			@Override
			public void shown() {
				System.out.println("Everyplay Shown");
			}

			@Override
			public void hidden() {
				System.out.println("Everyplay hidden");
			}

			@Override
			public void readyForRecording(NSNumber enabled) {
				System.out.println("Everyplay Ready for recording");
			}

		};
		Everyplay everyplay = Everyplay.init(everyplayDelegate,
				rootViewController);

		everyplay.showEveryplay();

		return true;
	}

	public static void main(String[] argv) {
		try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
			UIApplication.main(argv, null, Sample.class);
		}
	}
}

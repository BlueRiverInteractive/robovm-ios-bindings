
package org.robovm.bindings.adcolony.sample;

import java.util.ArrayList;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.apple.uikit.UIWindow;
import org.robovm.bindings.adcolony.AdColony;
import org.robovm.bindings.adcolony.AdColonyDelegateAdapter;

/** Sample usage of the AdColony SDK. */
public class Sample extends UIApplicationDelegateAdapter {
	private static final String APP_ID = "YOUR_APP_ID";
	private static final String ZONE_ID = "YOUR_ZONE_ID";
	private UIViewController viewController;
	private UIWindow window;

	@Override
	public void didFinishLaunching (UIApplication application) {
		viewController = new UIViewController();

		// Setup AdColony
		ArrayList<NSString> aZones = new ArrayList<NSString>();
		aZones.add(new NSString(ZONE_ID));
		NSArray<NSString> zones = new NSArray<NSString>(aZones);
		AdColony.configure(APP_ID, zones, new AdColonyDelegateAdapter() {

		}, true);

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

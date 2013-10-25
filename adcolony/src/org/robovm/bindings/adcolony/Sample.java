
package org.robovm.bindings.adcolony;

import java.util.ArrayList;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;
import org.robovm.cocoatouch.uikit.UIScreen;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.cocoatouch.uikit.UIWindow;

/** Sample usage of the AdColony SDK. */
public class Sample extends UIApplicationDelegate.Adapter implements AdColonyDelegate, AdColonyAdDelegate {
	private static final String APP_ID = "YOUR_APP_ID";
	private static final String ZONE_ID = "YOUR_ZONE_ID";
	UIViewController viewController;

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public void didFinishLaunching (UIApplication application) {
		viewController = new UIViewController();

		// Setup AdColony
		ArrayList<NSString> aZones = new ArrayList<NSString>();
		aZones.add(new NSString(ZONE_ID));
		NSArray zones = new NSArray(aZones);
		AdColony.configure(APP_ID, zones, this, true);

		UIWindow window = new UIWindow(UIScreen.getMainScreen().getBounds());
		window.setRootViewController(viewController);
		window.makeKeyAndVisible();
	}

	public static void main (String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
	}

	@Override
	public void onAdColonyAdAvailabilityChange (boolean available, String zoneID) {
		// If Zone is Active show the video
		if (AdColony.getZoneStatus(zoneID) == AdColonyStatus.ADCOLONY_ZONE_STATUS_ACTIVE) AdColony.playVideoAd(ZONE_ID, this);
	}

	@Override
	public void onAdColonyV4VCReward (boolean success, String currencyName, int amount, String zoneID) {

	}

	@Override
	public void onAdColonyAdStartedInZone (String zoneID) {

	}

	@Override
	public void onAdColonyAdAttemptFinished (boolean shown, String zoneID) {

	}
}

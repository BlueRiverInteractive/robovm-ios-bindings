
package org.robovm.bindings.mobileapptracking.sample;

import org.robovm.apple.adsupport.ASIdentifierManager;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSPropertyList;
import org.robovm.apple.foundation.NSURL;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;
import org.robovm.bindings.mobileapptracking.MobileAppTracker;

public class Sample extends UIApplicationDelegateAdapter {
    public static final String ADVERTISER_ID = "YOUR_ADVERTISER_ID";
    public static final String CONVERSION_KEY = "YOUR_CONVERSION_KEY";

    @Override
    public boolean didFinishLaunching (UIApplication application, UIApplicationLaunchOptions launchOptions) {
        // Account Configuration info - must be set
        MobileAppTracker.start(ADVERTISER_ID, CONVERSION_KEY);

        // Pass the Apple Identifier for Advertisers (IFA) to MAT; enables accurate 1-to-1 attribution.
        // REQUIRED for attribution on iOS devices.
        MobileAppTracker.setAppleAdvertisingIdentifier(ASIdentifierManager.getSharedManager().getAdvertisingIdentifier(),
            ASIdentifierManager.getSharedManager().isAdvertisingTrackingEnabled());

        /** If your app already has a pre-existing user base before you implement the MAT SDK, then identify the pre-existing users
         * with this code snippet. Otherwise, MAT counts your pre-existing users as new installs the first time they run your app.
         * Omit this section if you're upgrading to a newer version of the MAT SDK. This section only applies to NEW
         * implementations of the MAT SDK.
         * 
         * <pre>
         *          boolean isExistingUser = ...
         *          if (isExistingUser) {
         *             MobileAppTracker.setExistingUser(true);
         *          }
         * </pre> */

        return true;
    }

    @Override
    public void didBecomeActive (UIApplication application) {
        // MAT will not function without the measureSession() call included
        MobileAppTracker.measureSession();
    }

    @Override
    public boolean openURL (UIApplication application, NSURL url, String sourceApplication, NSPropertyList annotation) {
        MobileAppTracker.didOpenURL(url.getAbsoluteString(), sourceApplication);
        return true;
    }

    public static void main (String[] argv) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(argv, null, Sample.class);
        }
    }
}

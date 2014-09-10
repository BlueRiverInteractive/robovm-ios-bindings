
package org.robovm.bindings.flurry.sample;

import java.util.HashMap;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;
import org.robovm.bindings.flurry.analytics.Flurry;

/** Basic usage of the Flurry Analytics SDK. */
public class Sample extends UIApplicationDelegateAdapter {

    @Override
    public boolean didFinishLaunching (UIApplication application, UIApplicationLaunchOptions launchOptions) {
        // First start the Flurry session.
        Flurry.startSession("YOUR_API_KEY", launchOptions);

        // Track events with parameters.
        HashMap<String, String> parameters = new HashMap<String, String>();
        parameters.put("Param_1", "Value_1");
        Flurry.logEvent("My_special_event", parameters);

        return true;
    }

    public static void main (String[] argv) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(argv, null, Sample.class);
        }
    }
}


package org.robovm.bindings.testfairy.sample;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;
import org.robovm.bindings.testfairy.TestFairy;
import org.robovm.rt.Signals;

/** Basic usage of the TestFairy SDK. */
public class Sample extends UIApplicationDelegateAdapter {

    @Override
    public boolean didFinishLaunching (UIApplication application, UIApplicationLaunchOptions launchOptions) {
        Signals.installSignals(new Signals.InstallSignalsCallback() {
            @Override
            public void install () {
                TestFairy.begin("YOUR_API_KEY");
            }
        });

        return true;
    }

    public static void main (String[] argv) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(argv, null, Sample.class);
        }
    }
}


package org.robovm.bindings.apsalar.sample;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;

public class Sample extends UIApplicationDelegateAdapter {

    @Override
    public boolean didFinishLaunching (UIApplication application, UIApplicationLaunchOptions launchOptions) {

        return true;
    }

    public static void main (String[] argv) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(argv, null, Sample.class);
        }
    }
}

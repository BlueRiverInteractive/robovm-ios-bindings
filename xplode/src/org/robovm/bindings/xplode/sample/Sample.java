package org.robovm.bindings.xplode.sample;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.bindings.xplode.Xplode;

public class Sample extends UIApplicationDelegateAdapter {
    private static final String APP_HANDLE = "APP_HANDLE";
    private static final String APP_SECRET = "APP_SECRET";


    @Override
    public void didFinishLaunching(UIApplication application) {
        Xplode.initialize(APP_HANDLE, APP_SECRET);
    }

    public static void main(String[] argv) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(argv, null, Sample.class);
        }
    }
}

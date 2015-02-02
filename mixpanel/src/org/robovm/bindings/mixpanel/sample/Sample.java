package org.robovm.bindings.mixpanel.sample;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.*;
import org.robovm.bindings.mixpanel.Mixpanel;

public class Sample extends UIApplicationDelegateAdapter {
    private static final String API_TOKEN = "";
    private UIWindow window;


    @Override
    public boolean didFinishLaunching(UIApplication application, UIApplicationLaunchOptions launchOptions) {
        window = new UIWindow(UIScreen.getMainScreen().getBounds());
        window.makeKeyAndVisible();
        Mixpanel.getSharedInstance(API_TOKEN);
        return true;
    }

    public static void main(String[] argv) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(argv, null, Sample.class);
        }
    }
}

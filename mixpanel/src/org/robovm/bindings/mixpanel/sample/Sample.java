package org.robovm.bindings.mixpanel.sample;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.*;
import org.robovm.bindings.mixpanel.Mixpanel;

public class Sample extends UIApplicationDelegateAdapter {
    private UIWindow window;
    private Mixpanel mixpanel;


    @Override
    public boolean didFinishLaunching(UIApplication application, UIApplicationLaunchOptions launchOptions) {
        window = new UIWindow(UIScreen.getMainScreen().getBounds());
        window.makeKeyAndVisible();
        mixpanel = Mixpanel.getSharedInstance("353cc0a49e1060ce3e1bb57dcfa33970");
        mixpanel.track("From IOS");
        return true;
    }

    public static void main(String[] argv) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(argv, null, Sample.class);
        }
    }
}

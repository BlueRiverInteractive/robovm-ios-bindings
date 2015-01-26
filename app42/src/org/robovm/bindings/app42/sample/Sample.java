package org.robovm.bindings.app42.sample;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.bindings.app42.App42API;
import org.robovm.bindings.app42.App42Exception;
import org.robovm.bindings.app42.App42ResponseBlock;
import org.robovm.bindings.app42.UserService;

public class Sample extends UIApplicationDelegateAdapter
{
    @Override
    public void didFinishLaunching (UIApplication application) {

    }

    public static void main (String[] argv)
    {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(argv, null, Sample.class);
        }
    }
}

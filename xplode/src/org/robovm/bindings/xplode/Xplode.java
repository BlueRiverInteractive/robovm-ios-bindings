package org.robovm.bindings.xplode;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

/**
 * Created by sargis on 11/17/14.
 */

@NativeClass
public class Xplode extends NSObject {
    @Method(selector = "initializeWithAppHandle:appSecret:")
    public static native void initialize(String appHandle, String appSecret);

    @Method(selector = "presentPromotionForBreakpoint:")
    public static native void presentPromotionForBreakpoint(String breakpoint);
}

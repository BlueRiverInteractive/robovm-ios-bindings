package org.robovm.bindings.mixpanel;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

/**
 * Created by sargis on 1/25/15.
 */
@NativeClass
public class Mixpanel extends NSObject {
    @Method(selector = "sharedInstanceWithToken")
    public static native Mixpanel initialize(String apiToken);
}

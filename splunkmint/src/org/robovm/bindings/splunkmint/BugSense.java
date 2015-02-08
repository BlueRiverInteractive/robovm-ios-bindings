
package org.robovm.bindings.splunkmint;

import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class BugSense extends BugSenseBase {
    @Method(selector = "sharedInstance")
    public static native BugSense getSharedInstance ();
}


package org.robovm.bindings.splunkmint;

import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

/** The Mint class is the main class for all appropriate requests. */
@NativeClass
public class Mint extends MintBase {

    /** Returns the singleton Mint reference to use in your application. You should not initialize the Mint class yourself because
     * unexpected results may occur.
     *
     * @return The Mint singleton instance reference. */
    @Method(selector = "sharedInstance")
    public static native Mint getSharedInstance ();
}

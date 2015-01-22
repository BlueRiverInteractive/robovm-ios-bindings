
package org.robovm.bindings.facebook.dialogs;

import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

/** This object is used as a base class for parameters passed to native dialogs that open in the Facebook app. */
@NativeClass
public abstract class FBDialogsParams extends NSObject {

    protected FBDialogsParams (SkipInit skipInit) {
        super(skipInit);
    }

    /** Validates the receiver to ensure that it is configured properly. */
    @Method(selector = "validate")
    public native NSError validate ();
}


package org.robovm.bindings.splunkmint;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class LoggedRequestEventArgs extends NSObject {

    @Property
    public native MintResponseResult getResponseResult ();

}

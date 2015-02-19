
package org.robovm.bindings.splunkmint;

import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** The MintLogResult class provides information about the logged request. */
@NativeClass
public class MintLogResult extends MintResult {

    /** The log type of the request. */
    @Property
    public native MintLogType getLogType ();
}

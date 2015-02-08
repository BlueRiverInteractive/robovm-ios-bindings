
package org.robovm.bindings.splunkmint;

import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class MintPerformance extends SPLJSONModel {

    @Property
    public native String getAppMemAvail ();

    @Property
    public native String getAppMemMax ();

    @Property
    public native String getAppMemTotal ();

    @Property
    public native String getSysMemAvail ();

    @Property
    public native String getSysMemLow ();

    @Property
    public native String getSysMemThreshold ();
}

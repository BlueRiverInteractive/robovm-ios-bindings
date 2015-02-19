
package org.robovm.bindings.splunkmint;

import org.robovm.apple.foundation.NSNumber;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class MintResponseResult extends MintResult {
    @Property
    public native NSNumber getErrorId ();

    @Property
    public native String getServerResponse ();

    @Property
    public native String getUrl ();

    @Property
    public native String getContentText ();

    @Property
    public native String getTickerText ();

    @Property
    public native String getContentTitle ();

    @Property(selector = "isResolved")
    public native boolean isResolved ();
}

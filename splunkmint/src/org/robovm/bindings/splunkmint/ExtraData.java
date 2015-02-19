
package org.robovm.bindings.splunkmint;

import org.robovm.apple.foundation.NSNumber;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

/** The ExtraData class contains extra data as a key-value pair to attach to error requests. */
@NativeClass
public class ExtraData extends SPLJSONModel {

    /** A string that contains the key. */
    @Property
    public native String getKey ();

    @Property
    public native void setKey (String key);

    /** A string that contains the value. */
    @Property
    public native String getValue ();

    @Property
    public native void setValue (String value);

    /** Returns the allowed length of the value. */
    @Property
    public native NSNumber getMaxValueLength ();

    @Property
    public native void setMaxValueLength (NSNumber maxValueLength);

    /** Initializes an ExtraData instance with a key-value pair.
     *
     * @param key The key.
     * @param value The value.
     *
     * @return The ExtraData instance. */
    public ExtraData (String key, String value) {
        initObject(init(key, value));
    }

    @Method(selector = "initWithKey:andValue:")
    private native @Pointer long init (String key, String value);

    /** Determines whether two ExtraData instances are equal according to internal IDs.
     *
     * @param aExtraData The ExtraData instance to test equality.
     *
     * @return A Boolean that indicates whether the instances are equal. */
    @Method(selector = "isEqualToExtraData:")
    public native boolean equalsTo (ExtraData extraData);
}

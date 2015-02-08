
package org.robovm.bindings.splunkmint;

import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.MachineSizedSInt;
import org.robovm.rt.bro.annotation.MachineSizedUInt;

/** The LimitedExtraDataList class contains a list of extra crash data (from ExtraData instances) to attach to error requests. */
@NativeClass
public class LimitedExtraDataList extends SPLJSONModel {

    /** The maximum number of ExtraData instances that can be included in the list of extra crash data. */
    @Property
    public native @MachineSizedUInt long getMaxCount ();

    /** Returns the count of ExtraData instances in the list. */
    @Property
    public native @MachineSizedUInt long getCount ();

    /** A modifiable array that contains the ExtraData instances. */
    @Property
    public native NSMutableArray<ExtraData> getExtraDataArray ();

    @Method(selector = "addExtraDataToDataFixture:")
    public static native void addExtraDataToDataFixture (DataFixture dataFixture);

    /** A singleton instance for the global extra data attached to the crash.
     *
     * @return A reference to the LimitedExtraDataList singleton instance. */
    @Method(selector = "sharedInstance")
    public static native LimitedExtraDataList getSharedInstance ();

    /** Adds an ExtraData instance to the list.
     *
     * @param extraData The ExtraData instance. */
    @Method(selector = "add:")
    public native void add (ExtraData extraData);

    /** Removes an ExtraData instance from the list.
     *
     * @param extraData The ExtraData instance. */
    @Method(selector = "remove:")
    public native void remove (ExtraData extraData);

    /** Adds an ExtraData instance to the list as a key-value pair.
     *
     * @param key The key.
     * @param value The value. */
    @Method(selector = "addWithKey:andValue:")
    public native void add (String key, String value);

    /** Removes an ExtraData instance from the list.
     *
     * @param key The key of the ExtraData instance. */
    @Method(selector = "removeWithKey:")
    public native void remove (String key);

    /** Gets the index of an ExtraData instance in the list.
     *
     * @param extraData An ExtraData instance.
     *
     * @return The index of the ExtraData in the list. */
    @Method(selector = "indexOf:")
    public native @MachineSizedSInt long indexOf (ExtraData extraData);

    /** Inserts an ExtraData instance at a specific index in the list.
     *
     * @param index The index.
     * @param extraData An ExtraData instance. */
    @Method(selector = "insertAtIndex:extraData:")
    public native void insert (@MachineSizedUInt long index, ExtraData extraData);

    /** Removes an ExtraData instance from a specific index in the list.
     *
     * @param index The index. */
    @Method(selector = "removeAtIndex:")
    public native void remove (@MachineSizedUInt long index);

    /** Clears the internal ExtraData list. */
    @Method
    public native void clear ();

    /** Determines whether an ExtraData instance is in the list.
     *
     * @param extraData An ExtraData instance.
     *
     * @return A Boolean that indicates whether the ExtraData instance exists. */
    @Method(selector = "contains:")
    public native boolean contains (ExtraData extraData);
}

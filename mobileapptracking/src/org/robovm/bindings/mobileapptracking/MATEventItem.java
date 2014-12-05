
package org.robovm.bindings.mobileapptracking;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** MATEventItem represents event items for use with MAT events. */
@NativeClass
public class MATEventItem extends NSObject {

    @Property(selector = "item")
    public native String getName ();

    @Property(selector = "setItem:")
    public native void setName (String name);

    @Property
    public native float getUnitPrice ();

    @Property
    public native void setUnitPrice (float unitPrice);

    @Property
    public native int getQuantity ();

    @Property
    public native void setQuantity (int quantity);

    @Property
    public native float getRevenue ();

    @Property
    public native void setRevenue (float revenue);

    @Property
    public native String getAttribute1 ();

    @Property
    public native void setAttribute1 (String attribute);

    @Property
    public native String getAttribute2 ();

    @Property
    public native void setAttribute2 (String attribute);

    @Property
    public native String getAttribute3 ();

    @Property
    public native void setAttribute3 (String attribute);

    @Property
    public native String getAttribute4 ();

    @Property
    public native void setAttribute4 (String attribute);

    @Property
    public native String getAttribute5 ();

    @Property
    public native void setAttribute5 (String attribute);

    /** Method to create an event item. Revenue will be calculated using (quantity * unitPrice).
     * @param name name of the event item
     * @param unitPrice unit price of the event item
     * @param quantity quantity of the event item */
    @Method(selector = "eventItemWithName:unitPrice:quantity:")
    public static native MATEventItem create (String name, float unitPrice, int quantity);

    /** Method to create an event item.
     * @param name name of the event item
     * @param unitPrice unit price of the event item
     * @param quantity quantity of the event item
     * @param revenue revenue of the event item, to be used instead of (quantity * unitPrice) */
    @Method(selector = "eventItemWithName:unitPrice:quantity:")
    public static native MATEventItem create (String name, float unitPrice, int quantity, float revenue);

    /** Method to create an event item.
     * @param name name of the event item
     * @param attribute1 an extra parameter that corresponds to attribute_sub1 property of the event item
     * @param attribute2 an extra parameter that corresponds to attribute_sub2 property of the event item
     * @param attribute3 an extra parameter that corresponds to attribute_sub3 property of the event item
     * @param attribute4 an extra parameter that corresponds to attribute_sub4 property of the event item
     * @param attribute5 an extra parameter that corresponds to attribute_sub5 property of the event item */
    @Method(selector = "eventItemWithName:attribute1:attribute2:attribute3:attribute4:attribute5:")
    public static native MATEventItem create (String name, String attribute1, String attribute2, String attribute3,
        String attribute4, String attribute5);

    /** Method to create an event item.
     * @param name name of the event item
     * @param unitPrice unit price of the event item
     * @param quantity quantity of the event item
     * @param revenue revenue of the event item, to be used instead of (quantity * unitPrice)
     * @param attribute1 an extra parameter that corresponds to attribute_sub1 property of the event item
     * @param attribute2 an extra parameter that corresponds to attribute_sub2 property of the event item
     * @param attribute3 an extra parameter that corresponds to attribute_sub3 property of the event item
     * @param attribute4 an extra parameter that corresponds to attribute_sub4 property of the event item
     * @param attribute5 an extra parameter that corresponds to attribute_sub5 property of the event item */
    @Method(selector = "eventItemWithName:unitPrice:quantity:revenue:attribute1:attribute2:attribute3:attribute4:attribute5:")
    public static native MATEventItem create (String name, float unitPrice, int quantity, float revenue, String attribute1,
        String attribute2, String attribute3, String attribute4, String attribute5);
}

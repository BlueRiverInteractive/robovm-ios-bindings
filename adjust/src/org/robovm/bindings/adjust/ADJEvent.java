
package org.robovm.bindings.adjust;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class ADJEvent extends NSObject {
    @Property
    public native String getEventToken ();

    @Property
    public native NSNumber getRevenue ();

    @Property
    public native NSDictionary<NSString, NSObject> getCallbackParameters ();

    @Property
    public native NSDictionary<NSString, NSObject> getPartnerParameters ();

    @Property
    public native String getTransactionId ();

    @Property
    public native String getCurrency ();

    /** Create Event object with Event Token.
     *
     * @param event Event token that is created in the dashboard at http://adjust.com and should be six characters long. */
    @Method(selector = "eventWithEventToken:")
    public static native ADJEvent create (String eventToken);

    /** Add a key-pair to a callback URL.
     *
     * In your dashboard at http://adjust.com you can assign a callback URL to each event type. That URL will get called every
     * time the event is triggered. On top of that you can add callback parameters to the following method that will be forwarded
     * to these callbacks.
     *
     * @param key String key in the callback URL.
     * @param value String value of the key in the Callback URL. */
    @Method(selector = "addCallbackParameter:value:")
    public native void addCallbackParameter (String key, String value);

    /** Add a key-pair to be fowarded to a partner.
     *
     * @param key String key to be fowarded to the partner
     * @param value String value of the key to be fowarded to the partner */
    @Method(selector = "addPartnerParameter:")
    public native void addPartnerParameter (String key, String value);

    /** Set the revenue and associated currency of the event.
     *
     * The event can contain some revenue. The amount revenue is measured in units. It must include a currency in the ISO 4217
     * format.
     *
     * @param amount The amount in units (example: for 1.50 EUR is 1.5)
     * @param currency String of the currency with ISO 4217 format. It should be 3 characters long (example: for 1.50 EUR is
     * @"EUR") */
    @Method(selector = "setRevenue:curreny:")
    public native void setRevenue (double amount, String currency);

    /** Set the transaction ID of a In-App Purchases to avoid revenue duplications.
     *
     * A transaction ID can be used to avoid duplicate revenue events. The last ten transaction identifiers are remembered.
     *
     * @param The identifier used to avoid duplicate revenue events */
    @Method(selector = "setTransactionId:")
    public native void setTransactionId (String transactionId);

    @Method(selector = "isValid")
    public native boolean isValid ();
}

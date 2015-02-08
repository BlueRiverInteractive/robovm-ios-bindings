
package org.robovm.bindings.splunkmint;

import org.robovm.apple.foundation.NSNumber;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class TrStop extends SPLTransaction {

    @Method(selector = "isJSONTrStop:")
    public static native boolean isJSONTrStop (String json);

    /** The duration of the transaction, in milliseconds. */
    @Property
    public native NSNumber getDuration ();

    /** The status of the transaction. */
    @Property
    public native String getStatus ();

    /** The reason the transaction stopped, was cancelled, or failed. */
    @Property
    public native String getReason ();

    /** Creates a new TrStop instance.
     *
     * @param transactionId The transaction ID of the TrStart instance, auto-generated when the TrStart instance is created.
     * @param transactionName The unique transaction name of the TrStart instance.
     * @param anAppEnvironment A MintAppEnvironment instance.
     * @param aDuration The duration of the transaction, in seconds.
     * @param aReason The reason the transaction stopped, was cancelled, or failed.
     * @param aCompletedStatus The completion status of the transaction.
     *
     * @return A TrStop instance reference */
    @Method(selector = "getInstanceWithTransactionId:transactionName:appEnvironment:duration:reason:andCompletedStatus:")
    public static native TrStop getInstance (String transactionId, String transactionName, MintAppEnvironment anAppEnvironment,
        NSNumber aDuration, String aReason, String aCompletedStatus);
}

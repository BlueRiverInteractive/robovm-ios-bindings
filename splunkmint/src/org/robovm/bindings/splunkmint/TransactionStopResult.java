
package org.robovm.bindings.splunkmint;

import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** The TransactionStopResult class stops a transaction. */
@NativeClass
public class TransactionStopResult extends TransactionResult {

    /** The reason the transaction stopped, was cancelled, or failed. */
    @Property
    public native String getReason ();

    /** The transaction stop model. */
    @Property
    public native TrStop getTransactionStop ();
}

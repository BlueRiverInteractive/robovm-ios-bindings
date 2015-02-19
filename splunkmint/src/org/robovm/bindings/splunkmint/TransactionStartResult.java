
package org.robovm.bindings.splunkmint;

import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** The TransactionStartResult class provides information when a transaction starts. */
@NativeClass
public class TransactionStartResult extends TransactionResult {

    /** The unique name of the transaction. */
    @Property
    public native String getTransactionName ();

    /** The transaction model that started. */
    @Property
    public native TrStart getTransactionStart ();
}

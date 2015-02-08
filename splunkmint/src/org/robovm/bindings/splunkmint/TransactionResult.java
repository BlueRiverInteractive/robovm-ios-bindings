
package org.robovm.bindings.splunkmint;

import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** The TransactionResult base transaction model class contains information about creating, stopping, and cancelling a transaction. */
@NativeClass
public class TransactionResult extends SPLJSONModel {

    /** The status of the transaction request. */
    @Property
    public native TransactionStatus getTransactionStatus ();

    /** Additional information about the transaction. */
    @Property
    public native String getDescriptionResult ();

}


package org.robovm.bindings.splunkmint;

import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** The Transaction base model class is used for a transaction requests. */
@NativeClass
public class SPLTransaction extends DataFixture {

    /** A string that contains the name of the transaction. */
    @Property
    public native String getName ();

    @Property
    public native void setName (String name);

    /** An auto-generated string that contains the ID of the transaction. */
    @Property
    public native String getTransactionId ();

    @Property
    public native void setTransactionId (String transactionId);

}


package org.robovm.bindings.splunkmint;

import org.robovm.rt.bro.ValuedEnum;

/** Enumeration values that indicate the transaction status. */
public enum TransactionStatus implements ValuedEnum {
    /** The transaction started successfully. */
    SuccessfullyStarted(0),

    /** The transaction was cancelled by the user. */
    UserCancelled(1),

    /** The transaction was stopped successfully by the user. */
    UserSuccessfullyStopped(2),

    /** The transaction request failed. */
    Failed(3),

    /** The specified transaction you are trying to start exists. */
    Exists(4),

    /** The specified transaction you are trying to stop or cancel does not exist. */
    NotFound(5);

    private long n;

    TransactionStatus (long n) {
        this.n = n;
    }

    @Override
    public long value () {
        return n;
    }
}

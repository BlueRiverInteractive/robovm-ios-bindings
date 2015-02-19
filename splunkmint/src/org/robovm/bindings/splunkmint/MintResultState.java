
package org.robovm.bindings.splunkmint;

import org.robovm.rt.bro.ValuedEnum;

/** Enumeration values that indicate the state of a request upon completion. */
public enum MintResultState implements ValuedEnum {
    /** The request succeeded. */
    OK(0),

    /** The request threw an error. */
    Error(1),

    /** The request state is undefined */
    Undefined(2);

    private long n;

    MintResultState (long n) {
        this.n = n;
    }

    @Override
    public long value () {
        return n;
    }
}

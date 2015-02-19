
package org.robovm.bindings.splunkmint;

import org.robovm.rt.bro.ValuedEnum;

/** Enumeration values that indicate the type of logged request. */
public enum MintLogType implements ValuedEnum {
    /** The logged request is an exception. */
    Exception(0),

    /** The logged request is an event. */
    Event(1);

    private final long n;

    MintLogType (long n) {
        this.n = n;
    }

    @Override
    public long value () {
        return n;
    }
}


package org.robovm.bindings.splunkmint;

import org.robovm.rt.bro.ValuedEnum;

/** Enumeration values that indicate the request type. */
public enum MintRequestType implements ValuedEnum {
    /** The request is an error. */
    Error(0),

    /** The request is an event. */
    Event(1),

    /** The request contains a batch of multiple types. */
    Both(2);

    private long n;

    MintRequestType (long n) {
        this.n = n;
    }

    @Override
    public long value () {
        return n;
    }
}

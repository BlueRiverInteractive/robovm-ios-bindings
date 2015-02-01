
package org.robovm.bindings.adjust;

import org.robovm.rt.bro.ValuedEnum;

public enum ADJLogLevel implements ValuedEnum {
    Verbose(1L), Debug(2L), Info(3L), Warn(4L), Error(5L), Assert(6L);

    private final long n;

    private ADJLogLevel (long n) {
        this.n = n;
    }

    @Override
    public long value () {
        return n;
    }

    public static ADJLogLevel valueOf (long n) {
        for (ADJLogLevel v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " + ADJLogLevel.class.getName());
    }
}

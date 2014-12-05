
package org.robovm.bindings.adjust;

import org.robovm.rt.bro.ValuedEnum;

public enum AILogLevel implements ValuedEnum {
    Verbose(1L), Debug(2L), Info(3L), Warn(4L), Error(5L), Assert(6L);

    private final long n;

    private AILogLevel (long n) {
        this.n = n;
    }

    @Override
    public long value () {
        return n;
    }

    public static AILogLevel valueOf (long n) {
        for (AILogLevel v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " + AILogLevel.class.getName());
    }
}

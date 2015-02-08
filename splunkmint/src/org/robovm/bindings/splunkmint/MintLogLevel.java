
package org.robovm.bindings.splunkmint;

import org.robovm.rt.bro.ValuedEnum;

/** Enumeration values that indicate the log level of the log event. */
public enum MintLogLevel implements ValuedEnum {
    /** The lowest priority, and normally not logged except for messages from the kernel. */
    Debug(20),

    /** The lowest priority that you would normally log, and purely informational in nature. */
    Info(30),

    /** Things of moderate interest to the user or administrator. */
    Notice(40),

    /** Something is amiss and might fail if not corrected. */
    Warning(50),

    /** Something has failed. */
    Error(60),

    /** A failure in a key system. */
    Critical(70),

    /** A serious failure in a key system. */
    Alert(80),

    /** The highest priority, usually reserved for catastrophic failures and reboot notices. */
    Emergency(90);

    private long n;

    MintLogLevel (long n) {
        this.n = n;
    }

    @Override
    public long value () {
        return n;
    }
}

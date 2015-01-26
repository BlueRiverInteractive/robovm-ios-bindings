
package org.robovm.bindings.ythelper;

import org.robovm.rt.bro.ValuedEnum;

/** These enums represent error codes thrown by the player. */

public enum YTPlayerError implements ValuedEnum {
    kYTPlayerErrorInvalidParam(0), kYTPlayerErrorHTML5Error(1), kYTPlayerErrorVideoNotFound(2), kYTPlayerErrorNotEmbeddable(3), kYTPlayerErrorUnknown(
        4);

    private final long n;

    private YTPlayerError (long n) {
        this.n = n;
    }

    @Override
    public long value () {
        return n;
    }
}

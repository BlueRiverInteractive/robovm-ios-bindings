
package org.robovm.bindings.ythelper;

import org.robovm.rt.bro.ValuedEnum;

/** These enums represent the state of the current video in the player. */

public enum YTPlayerState implements ValuedEnum {
    kYTPlayerStateUnstarted(0), kYTPlayerStateEnded(1), kYTPlayerStatePlaying(2), kYTPlayerStatePaused(3), kYTPlayerStateBuffering(
        4), kYTPlayerStateQueued(5), kYTPlayerStateUnknown(6);

    private final long n;

    private YTPlayerState (long n) {
        this.n = n;
    }

    @Override
    public long value () {
        return n;
    }
}

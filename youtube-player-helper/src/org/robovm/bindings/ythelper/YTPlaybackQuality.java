
package org.robovm.bindings.ythelper;

import org.robovm.rt.bro.ValuedEnum;

/** These enums represent the resolution of the currently loaded video. */

public enum YTPlaybackQuality implements ValuedEnum {
    kYTPlaybackQualitySmall(0), kYTPlaybackQualityMedium(1), kYTPlaybackQualityLarge(2), kYTPlaybackQualityHD720(3), kYTPlaybackQualityHD1080(
        4), kYTPlaybackQualityHighRes(5),
    /** Addition for YouTube Live Events. */
    kYTPlaybackQualityAuto(6), kYTPlaybackQualityDefault(7),
    /** This should never be returned. It is here for future proofing. */
    kYTPlaybackQualityUnknown(8);

    private final long n;

    private YTPlaybackQuality (long n) {
        this.n = n;
    }

    @Override
    public long value () {
        return n;
    }
}

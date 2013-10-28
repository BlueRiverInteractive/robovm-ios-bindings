package org.robovm.bindings.cocoatouch.gamekit;

import org.robovm.rt.bro.ValuedEnum;

public enum GKLeaderboardTimeScope implements ValuedEnum{
	GKLeaderboardTimeScopeToday(0),
	GKLeaderboardTimeScopeWeek(1),
	GKLeaderboardTimeScopeAllTime(2);

    private final int n;

    private GKLeaderboardTimeScope(int n) {
        this.n = n;
    }

    public int value() {
        return n;
    }

}

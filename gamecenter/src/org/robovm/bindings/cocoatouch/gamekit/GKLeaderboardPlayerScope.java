package org.robovm.bindings.cocoatouch.gamekit;

import org.robovm.rt.bro.ValuedEnum;

public enum GKLeaderboardPlayerScope implements ValuedEnum{
	GKLeaderboardPlayerScopeGlobal(0),
	GKLeaderboardPlayerScopeFriendsOnly(1);

    private final int n;

    private GKLeaderboardPlayerScope(int n) {
        this.n = n;
    }

    public int value() {
        return n;
    }

}

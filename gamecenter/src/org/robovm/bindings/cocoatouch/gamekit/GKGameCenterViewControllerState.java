package org.robovm.bindings.cocoatouch.gamekit;

import org.robovm.rt.bro.ValuedEnum;

public enum GKGameCenterViewControllerState implements ValuedEnum{
	GKGameCenterViewControllerStateDefault(0),
	GKGameCenterViewControllerStateLeaderboards(1),
	GKGameCenterViewControllerStateAchievements(2),
	GKGameCenterViewControllerStateChallenges(3);

    private final int n;

    private GKGameCenterViewControllerState(int n) {
        this.n = n;
    }

    public int value() {
        return n;
    }

}

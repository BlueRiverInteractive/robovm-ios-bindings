
package org.robovm.bindings.apple.gamekit;

import org.robovm.rt.bro.ValuedEnum;

public enum GKGameCenterViewControllerState implements ValuedEnum {
	GKGameCenterViewControllerStateDefault(-1), GKGameCenterViewControllerStateLeaderboards(0), GKGameCenterViewControllerStateAchievements(
		1), GKGameCenterViewControllerStateChallenges(2);

	private final long n;

	private GKGameCenterViewControllerState (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}

}

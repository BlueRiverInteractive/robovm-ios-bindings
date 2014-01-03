
package org.robovm.bindings.cocoatouch.gamekit;

import org.robovm.rt.bro.ValuedEnum;

public enum GKGameCenterViewControllerState implements ValuedEnum {
	GKGameCenterViewControllerStateDefault(0), GKGameCenterViewControllerStateLeaderboards(1), GKGameCenterViewControllerStateAchievements(
		2), GKGameCenterViewControllerStateChallenges(3);

	private final long n;

	private GKGameCenterViewControllerState (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}

}

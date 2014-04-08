
package org.robovm.bindings.apple.gamekit;

import org.robovm.rt.bro.ValuedEnum;

public enum GKLeaderboardTimeScope implements ValuedEnum {
	GKLeaderboardTimeScopeToday(0), GKLeaderboardTimeScopeWeek(1), GKLeaderboardTimeScopeAllTime(2);

	private final long n;

	private GKLeaderboardTimeScope (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}

}

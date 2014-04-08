
package org.robovm.bindings.apple.gamekit;

import org.robovm.rt.bro.ValuedEnum;

public enum GKLeaderboardPlayerScope implements ValuedEnum {
	GKLeaderboardPlayerScopeGlobal(0), GKLeaderboardPlayerScopeFriendsOnly(1);

	private final long n;

	private GKLeaderboardPlayerScope (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}

}

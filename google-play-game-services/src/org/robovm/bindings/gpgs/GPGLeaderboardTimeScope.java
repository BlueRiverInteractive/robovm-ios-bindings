
package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

/** @author Michael Hadash */

public enum GPGLeaderboardTimeScope implements ValuedEnum {
	GPGLeaderboardTimeScopeUnknown(-1), GPGLeaderboardTimeScopeToday(1), GPGLeaderboardTimeScopeThisWeek(2), GPGLeaderboardTimeScopeAllTime(
		3);

	private final long n;

	private GPGLeaderboardTimeScope (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}

}

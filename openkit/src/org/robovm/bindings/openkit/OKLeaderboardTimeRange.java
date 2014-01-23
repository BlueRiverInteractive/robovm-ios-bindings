
package org.robovm.bindings.openkit;

import org.robovm.rt.bro.ValuedEnum;

public enum OKLeaderboardTimeRange implements ValuedEnum {
	OKLeaderboardTimeRangeOneDay(0), OKLeaderboardTimeRangeOneWeek(1), OKLeaderboardTimeRangeAllTime(2);

	private final long n;

	private OKLeaderboardTimeRange (int n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}

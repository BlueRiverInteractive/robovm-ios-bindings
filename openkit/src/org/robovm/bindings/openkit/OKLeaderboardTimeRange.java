
package org.robovm.bindings.openkit;

import org.robovm.rt.bro.ValuedEnum;

public enum OKLeaderboardTimeRange implements ValuedEnum {
	OneDay, OneWeek, AllTime;

	@Override
	public long value () {
		return ordinal();
	}
}

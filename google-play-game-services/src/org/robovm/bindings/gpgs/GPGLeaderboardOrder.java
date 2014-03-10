
package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

/** @author Michael Hadash */

public enum GPGLeaderboardOrder implements ValuedEnum {
	GPGLeaderboardOrderUnknown(-1), GPGLeaderboardOrderLargerIsBetter(0), GPGLeaderboardOrderSmallerIsBetter(1);

	private final long n;

	private GPGLeaderboardOrder (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}

}

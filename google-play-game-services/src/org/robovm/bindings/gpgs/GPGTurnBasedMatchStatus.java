package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

public enum GPGTurnBasedMatchStatus implements ValuedEnum {
	GPGTurnBasedMatchStatusAutoMatching(0),
	GPGTurnBasedMatchStatusActive(1),
	GPGTurnBasedMatchStatusComplete(2),
	GPGTurnBasedMatchStatusCanceled(3),
	GPGTurnBasedMatchStatusExpired(4),
	GPGTurnBasedMatchStatusDeleted(5);

	private final long n;

	private GPGTurnBasedMatchStatus (long n) {
	  this.n = n;
	}

	@Override
	public long value () {
	  return n;
	}
}

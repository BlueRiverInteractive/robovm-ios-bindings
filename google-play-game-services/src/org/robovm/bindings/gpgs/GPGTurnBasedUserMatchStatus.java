package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

public enum GPGTurnBasedUserMatchStatus implements ValuedEnum {
	GPGTurnBasedUserMatchStatusInvited(0),
	GPGTurnBasedUserMatchStatusAwaitingTurn(1),
	GPGTurnBasedUserMatchStatusTurn(2),
	GPGTurnBasedUserMatchStatusMatchCompleted(3);

	private final long n;

	private GPGTurnBasedUserMatchStatus (long n) {
	  this.n = n;
	}

	@Override
	public long value () {
	  return n;
	}
}

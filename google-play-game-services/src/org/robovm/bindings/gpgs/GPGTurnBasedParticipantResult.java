package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

public enum GPGTurnBasedParticipantResult implements ValuedEnum {
	GPGTurnBasedParticipantResultStatusUninitialized(-1), 
	GPGTurnBasedParticipantResultStatusWin(0), 
	GPGTurnBasedParticipantResultStatusLoss(1), 
	GPGTurnBasedParticipantResultStatusTie(2),
	GPGTurnBasedParticipantResultStatusNone(3), 
	GPGTurnBasedParticipantResultStatusDisconnect(4), 
	GPGTurnBasedParticipantResultStatusDisagreed(5);

	private final long n;

	private GPGTurnBasedParticipantResult (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}

}

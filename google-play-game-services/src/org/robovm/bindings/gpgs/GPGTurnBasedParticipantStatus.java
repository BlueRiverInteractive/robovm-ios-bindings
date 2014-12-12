package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

public enum GPGTurnBasedParticipantStatus implements ValuedEnum {
	GPGTurnBasedParticipantStatusUnknown(-1),
	GPGTurnBasedParticipantStatusNotInvited(0),
	GPGTurnBasedParticipantStatusInvited(1),
	GPGTurnBasedParticipantStatusJoined(2),
	GPGTurnBasedParticipantStatusDeclined(3),
	GPGTurnBasedParticipantStatusLeft(4),
	GPGTurnBasedParticipantStatusFinished(5),
	GPGTurnBasedParticipantStatusUnresponsive(6);

	private final long n;

	private GPGTurnBasedParticipantStatus (long n) {
	  this.n = n;
	}

	@Override
	public long value () {
	  return n;
	}
}

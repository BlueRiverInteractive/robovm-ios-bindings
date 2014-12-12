package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

public enum GPGRealTimeParticipantStatus implements ValuedEnum {
	GPGRealTimeParticipantStatusInvited(0),
	GPGRealTimeParticipantStatusJoined(1),
	GPGRealTimeParticipantStatusDeclined(2),
	GPGRealTimeParticipantStatusLeft(3),
	GPGRealTimeParticipantStatusConnectionEstablished(4);

	private final long n;

	private GPGRealTimeParticipantStatus (long n) {
	  this.n = n;
	}

	@Override
	public long value () {
	  return n;
	}
}

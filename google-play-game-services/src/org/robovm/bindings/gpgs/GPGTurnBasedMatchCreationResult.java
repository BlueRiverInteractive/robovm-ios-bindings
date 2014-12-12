package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

public enum GPGTurnBasedMatchCreationResult implements ValuedEnum {
	GPGTurnBasedMatchCreationSuccess(0),
	GPGTurnBasedMatchCreationFailedMissingCreationData(1),
	GPGTurnBasedMatchCreationFailedInvalidVariant(2),
	GPGTurnBasedMatchCreationFailedInvalidAutoMatchCount(3),
	GPGTurnBasedMatchCreationFailedInvalidPlayerCount(4),
	GPGTurnBasedMatchCreationFailedRoomNotInviting(5),
	GPGTurnBasedMatchCreationFailedMultiplayerNotEnabled(6),
	GPGTurnBasedMatchCreationFailedNotSignedIn(7),
	GPGTurnBasedMatchCreationFailedNotOnline(8),
	GPGTurnBasedMatchCreationFailedUnknown(9);

	private final long n;

	private GPGTurnBasedMatchCreationResult (long n) {
	  this.n = n;
	}

	@Override
	public long value () {
	  return n;
	}
}

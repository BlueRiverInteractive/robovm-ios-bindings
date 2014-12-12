package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

public enum GPGRealTimeRoomCreationResult implements ValuedEnum {
	GPGRealTimeRoomCreationSuccess(0),
	GPGRealTimeRoomCreationFailedMissingCreationData(1),
	GPGRealTimeRoomCreationFailedMissingDelegate(2),
	GPGRealTimeRoomCreationFailedInvalidVariant(3),
	GPGRealTimeRoomCreationFailedInvalidAutoMatchCount(4),
	GPGRealTimeRoomCreationFailedInvalidPlayerCount(5),
	GPGRealTimeRoomCreationFailedRoomNotInviting(6),
	GPGRealTimeRoomCreationFailedMultiplayerNotEnabled(7),
	GPGRealTimeRoomCreationFailedNotSignedIn(8),
	GPGRealTimeRoomCreationFailedNotOnline(9),
	GPGRealTimeRoomCreationFailedUnknown(10);

	private final long n;

	private GPGRealTimeRoomCreationResult (long n) {
	  this.n = n;
	}

	@Override
	public long value () {
	  return n;
	}
}

package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

public enum GPGRealTimeRoomStatus implements ValuedEnum {
	GPGRealTimeRoomStatusInviting(0),
	GPGRealTimeRoomStatusConnecting(1),
	GPGRealTimeRoomStatusAutoMatching(2),
	GPGRealTimeRoomStatusActive(3),
	GPGRealTimeRoomStatusDeleted(4);

	private final long n;

	private GPGRealTimeRoomStatus (long n) {
	  this.n = n;
	}

	@Override
	public long value () {
	  return n;
	}
}

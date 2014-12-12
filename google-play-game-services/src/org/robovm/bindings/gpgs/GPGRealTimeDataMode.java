package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

public enum GPGRealTimeDataMode implements ValuedEnum {
	GPGRealTimeDataModeUnreliable(0),
	GPGRealTimeDataModeReliable(1);

	private final long n;

	private GPGRealTimeDataMode (long n) {
	  this.n = n;
	}

	@Override
	public long value () {
	  return n;
	}
}


package org.robovm.apple.temp;

import org.robovm.rt.bro.ValuedEnum;

public enum MFMessageComposeResult implements ValuedEnum {
	Cancelled(0), Sent(1), Failed(2);

	private final long n;

	private MFMessageComposeResult (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}

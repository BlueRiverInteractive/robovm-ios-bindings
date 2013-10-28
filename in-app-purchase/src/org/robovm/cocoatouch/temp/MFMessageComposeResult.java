
package org.robovm.cocoatouch.temp;

import org.robovm.rt.bro.ValuedEnum;

public enum MFMessageComposeResult implements ValuedEnum {
	Cancelled(0), Sent(1), Failed(2);

	private final int n;

	private MFMessageComposeResult (int n) {
		this.n = n;
	}

	@Override
	public int value () {
		return n;
	}
}

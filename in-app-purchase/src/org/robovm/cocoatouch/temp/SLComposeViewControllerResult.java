
package org.robovm.cocoatouch.temp;

import org.robovm.rt.bro.ValuedEnum;

public enum SLComposeViewControllerResult implements ValuedEnum {
	Cancelled(0), Done(1);

	private final long n;

	private SLComposeViewControllerResult (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}

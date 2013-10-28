
package org.robovm.cocoatouch.temp;

import org.robovm.rt.bro.ValuedEnum;

public enum SLComposeViewControllerResult implements ValuedEnum {
	Cancelled(0), Done(1);

	private final int n;

	private SLComposeViewControllerResult (int n) {
		this.n = n;
	}

	@Override
	public int value () {
		return n;
	}
}

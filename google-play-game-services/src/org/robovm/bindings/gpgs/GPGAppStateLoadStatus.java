
package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

public enum GPGAppStateLoadStatus implements ValuedEnum {
	GPGAppStateLoadStatusUnknownError(-1), GPGAppStateLoadStatusSuccess(0), GPGAppStateLoadStatusNotFound(1);

	private final long n;

	private GPGAppStateLoadStatus (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}

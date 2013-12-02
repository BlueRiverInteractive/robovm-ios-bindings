
package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

//TODO: test this
public enum GPGAppStateLoadStatus implements ValuedEnum {
	GPGAppStateLoadStatusUnknownError(-1), GPGAppStateLoadStatusSuccess(0), GPGAppStateLoadStatusNotFound(1);

	private final int n;

	private GPGAppStateLoadStatus (int n) {
		this.n = n;
	}

	@Override
	public int value () {
		return n;
	}
}

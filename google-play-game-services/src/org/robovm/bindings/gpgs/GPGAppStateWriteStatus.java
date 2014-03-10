
package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

public enum GPGAppStateWriteStatus implements ValuedEnum {
	GPGAppStateWriteStatusUnknownError(-1), GPGAppStateWriteStatusSuccess(0), GPGAppStateWriteStatusBadKeyDataOrVersion(1), GPGAppStateWriteStatusKeysQuotaExceeded(
		2), GPGAppStateWriteStatusNotFound(3), GPGAppStateWriteStatusConflict(4), GPGAppStateWriteStatusSizeExceeded(5);

	private final long n;

	private GPGAppStateWriteStatus (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}

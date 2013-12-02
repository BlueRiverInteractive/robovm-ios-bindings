package com.michingo.robovmbindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

public enum GPGAppStateWriteStatus implements ValuedEnum {
	GPGAppStateWriteStatusUnknownError(-1),
	GPGAppStateWriteStatusSuccess(0),
	GPGAppStateWriteStatusBadKeyDataOrVersion(1),
	GPGAppStateWriteStatusKeysQuotaExceeded(2),
	GPGAppStateWriteStatusNotFound(3),
	GPGAppStateWriteStatusConflict(4),
	GPGAppStateWriteStatusSizeExceeded(5);
	
	private final int n;
	
	private GPGAppStateWriteStatus(int n) { this.n = n; }
    public int value() { return n; }
}

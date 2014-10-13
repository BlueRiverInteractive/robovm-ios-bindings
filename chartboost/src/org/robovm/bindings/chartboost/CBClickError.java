package org.robovm.bindings.chartboost;

import org.robovm.rt.bro.ValuedEnum;

public enum CBClickError
		implements
		ValuedEnum {
	CBClickErrorUriInvalid,
	CBClickErrorUriUnrecognized,
	CBClickErrorAgeGateFailure,
	CBClickErrorInternal;

	@Override
	public long value() {
		return ordinal();
	}

}

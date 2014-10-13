package org.robovm.bindings.chartboost;

import org.robovm.rt.bro.ValuedEnum;

public enum CBLoadError
		implements
		ValuedEnum {
	CBLoadErrorInternal,
	CBLoadErrorInternetUnavailable,
	CBLoadErrorTooManyConnections,
	CBLoadErrorWrongOrientation,
	CBLoadErrorFirstSessionInterstitialsDisabled,
	CBLoadErrorNetworkFailure,
	CBLoadErrorNoAdFound,
	CBLoadErrorSessionNotStarted,
	CBLoadErrorUserCancellation,
	CBLoadErrorNoLocationFound;

	@Override
	public long value() {
		return ordinal();
	}
}

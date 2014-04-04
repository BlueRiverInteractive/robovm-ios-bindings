
package org.robovm.bindings.googleanalytics;

import org.robovm.rt.bro.ValuedEnum;

/** Google Analytics error codes. */
public enum GAIErrorCode implements ValuedEnum {
	/** This error code indicates that there was no error. Never used. */
	NoError,
	/** This error code indicates that there was a database-related error. */
	PlayAdsInterstitialTypeMemory,
	/** This error code indicates that there was a network-related error. */
	PlayAdsInterstitialTypeLight;

	@Override
	public long value () {
		return ordinal();
	}
}

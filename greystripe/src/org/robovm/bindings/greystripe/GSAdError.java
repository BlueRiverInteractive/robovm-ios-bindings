
package org.robovm.bindings.greystripe;

import org.robovm.rt.bro.ValuedEnum;

public enum GSAdError implements ValuedEnum {
	NoError,
	/** This error is dispatched when there is no available network connection. */
	NoNetwork,
	/** This error is dispatched when a blank ad is returned by the server. */
	NoAd,
	/** This error is dispatched when the request took too long to complete. */
	Timeout,
	/** This error is dispatched when a server error occurs. */
	ServerError,
	/** This error is dispatched when the GUID provided by the application is not a valid Greystripe GUID. */
	InvalidApplicationIdentifier,
	/** This error is dispatched when the ad that is fetched is expired and cannot be displayed. */
	AdExpired,
	/** This error is dispatched after the SDK prevents a fetch from occurring when it is highly unlikely that an ad would be
	 * returned. This error can occur in high volume, low fill situations or when too many ad requests are made in a short period
	 * of time. This error will resolve itself after a short timeout. If you frequently receive this message you should reduce the
	 * frequency of your requests or use an alternate fallback method when no ad is available. */
	FetchLimitExceeded,
	/** This error is dispatched when the cause of the error is unknown. */
	Unknown;

	@Override
	public long value () {
		return ordinal();
	}
}

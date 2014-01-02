
package org.robovm.bindings.adcolony;

import org.robovm.rt.bro.ValuedEnum;

/** Enum for zone status */
public enum AdColonyStatus implements ValuedEnum {
	/** AdColony has not been configured with that zone ID. */
	ADCOLONY_ZONE_STATUS_NO_ZONE(0),
	/** The zone has been turned off on the www.adcolony.com control panel. */
	ADCOLONY_ZONE_STATUS_OFF(1),
	/** The zone is preparing ads for display. */
	ADCOLONY_ZONE_STATUS_LOADING(2),
	/** The zone has completed preparing ads for display. */
	ADCOLONY_ZONE_STATUS_ACTIVE(3),
	/** AdColony has not yet received the zone's configuration from the server. */
	ADCOLONY_ZONE_STATUS_UNKNOWN(4);

	private final long n;

	private AdColonyStatus (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}

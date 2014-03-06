
package org.robovm.bindings.adcolony;

import org.robovm.rt.bro.ValuedEnum;

/** Enum for zone status */
public enum AdColonyStatus implements ValuedEnum {
	/** AdColony has not been configured with that zone ID. */
	ADCOLONY_ZONE_STATUS_NO_ZONE,
	/** The zone has been turned off on the www.adcolony.com control panel. */
	ADCOLONY_ZONE_STATUS_OFF,
	/** The zone is preparing ads for display. */
	ADCOLONY_ZONE_STATUS_LOADING,
	/** The zone has completed preparing ads for display. */
	ADCOLONY_ZONE_STATUS_ACTIVE,
	/** AdColony has not yet received the zone's configuration from the server. */
	ADCOLONY_ZONE_STATUS_UNKNOWN;

	@Override
	public long value () {
		return ordinal();
	}
}

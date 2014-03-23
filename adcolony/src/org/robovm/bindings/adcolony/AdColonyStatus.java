
package org.robovm.bindings.adcolony;

import org.robovm.rt.bro.ValuedEnum;

/** Enum for zone status */
public enum AdColonyStatus implements ValuedEnum {
	/** AdColony has not been configured with that zone ID. */
	NoZone,
	/** The zone has been turned off on the www.adcolony.com control panel. */
	Off,
	/** The zone is preparing ads for display. */
	Loading,
	/** The zone has completed preparing ads for display. */
	Active,
	/** AdColony has not yet received the zone's configuration from the server. */
	Unknown;

	@Override
	public long value () {
		return ordinal();
	}
}

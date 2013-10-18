package org.robovm.bindings.adcolony;

import org.robovm.rt.bro.ValuedEnum;

/**
 * Enum for zone status
 */
public enum AdColonyStatus implements ValuedEnum{
	ADCOLONY_ZONE_STATUS_NO_ZONE(0),  /**< AdColony has not been configured with that zone ID. */
	ADCOLONY_ZONE_STATUS_OFF(1),      /**< The zone has been turned off on the www.adcolony.com control panel */
	ADCOLONY_ZONE_STATUS_LOADING(2),  /**< The zone is preparing ads for display */
	ADCOLONY_ZONE_STATUS_ACTIVE(3),   /**< The zone has completed preparing ads for display */
	ADCOLONY_ZONE_STATUS_UNKNOWN(4);  /**< AdColony has not yet received the zone's configuration from the server */
	
	private final int n;
	
	private AdColonyStatus(int n){
		this.n = n;
	}
	
	@Override
	public int value(){
		return n;
	}

}

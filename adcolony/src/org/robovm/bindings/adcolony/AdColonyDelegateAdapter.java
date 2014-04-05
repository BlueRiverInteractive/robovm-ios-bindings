
package org.robovm.bindings.adcolony;

import org.robovm.apple.foundation.NSObject;

public class AdColonyDelegateAdapter extends NSObject implements AdColonyDelegate {
	@Override
	public void onAdAvailabilityChange (boolean available, String zoneID) {
	}

	@Override
	public void onV4VCReward (boolean success, String currencyName, int amount, String zoneID) {
	}
}

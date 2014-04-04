
package org.robovm.bindings.adcolony;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

public interface AdColonyDelegate extends NSObjectProtocol {
	/** Provides your app with real-time updates about ad availability changes. This method is called when a zone's ad availability
	 * state changes (when ads become available, or become unavailable). Listening to these callbacks allows your app to update its
	 * user interface immediately. For example, when ads become available in a zone you could immediately show an ad for that zone.
	 * @param available Whether ads became available or unavailable
	 * @param zoneID The affected zone */
	@Method(selector = "onAdColonyAdAvailabilityChange:inZone:")
	void onAdAvailabilityChange (boolean available, String zoneID);

	/** Notifies your app after an ad is displayed when a virtual currency transaction has completed. In your implementation, check
	 * for success and implement any app-specific code that should be run when AdColony has successfully rewarded. Client-side V4VC
	 * implementations should increment the user's currency balance in this method. Server-side V4VC implementations should contact
	 * the game server to determine the current total balance for the virtual currency.
	 * @param success Whether the transaction succeeded or failed
	 * @param currencyName The name of currency to reward
	 * @param amount The amount of currency to reward
	 * @param zoneID The affected zone */
	@Method(selector = "onAdColonyV4VCReward:currencyName:currencyAmount:inZone:")
	void onV4VCReward (boolean success, String currencyName, int amount, String zoneID);
}

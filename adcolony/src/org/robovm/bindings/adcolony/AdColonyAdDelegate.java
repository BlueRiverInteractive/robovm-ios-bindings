
package org.robovm.bindings.adcolony;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

public interface AdColonyAdDelegate extends NSObjectProtocol {
	/** Notifies your app that an ad will actually play in response to the app's request to play an ad. This method is called when
	 * AdColony has taken control of the device screen and is about to begin showing an ad. Apps should implement app-specific code
	 * such as pausing a game and turning off app music.
	 * @param zoneID The affected zone */
	@Method(selector = "onAdColonyAdStartedInZone:")
	void onAdStartedInZone (String zoneID);

	/** Notifies your app that an ad completed playing (or never played) and control has been returned to the app. This method is
	 * called when AdColony has finished trying to show an ad, either successfully or unsuccessfully. If an ad was shown, apps
	 * should implement app-specific code such as unpausing a game and restarting app music.
	 * @param shown Whether an ad was actually shown
	 * @param zoneID The affected zone */
	@Method(selector = "onAdColonyAdAttemptFinished:inZone:")
	void onAdAttemptFinished (boolean shown, String zoneID);
}

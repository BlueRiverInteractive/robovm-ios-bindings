
package org.robovm.bindings.adcolony;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class AdColony extends NSObject {
	private AdColony () {
	}

	/** Configures AdColony specifically for your app; required for usage of the rest of the API. This method returns immediately;
	 * any long-running work such as network connections are performed in the background. AdColony does not begin preparing ads for
	 * display or performing reporting until after it is configured by your app.
	 * 
	 * @param appID The AdColony app ID for your app. This can be created and retrieved at the [Control
	 *           Panel](http://clients.adcolony.com)
	 * @param zoneIDs An array of at least one AdColony zone ID string. AdColony zone IDs can be created and retrieved at the
	 *           [Control Panel](http://clients.adcolony.com). If `nil`, app will be unable to play ads and AdColony will only
	 *           provide limited reporting and install tracking functionality.
	 * @param del The delegate to receive V4VC and ad availability events. Can be {@code null} for apps that do not need these
	 *           events.
	 * @param log A boolean controlling AdColony verbose logging. */
	@Method(selector = "configureWithAppID:zoneIDs:delegate:logging:")
	public static native void configure (String appID, NSArray<NSString> zoneIDs, AdColonyDelegate delegate, boolean log);

	/** Plays an AdColony ad. This method returns immediately, before the ad completes. If ads are not available, an ad may not play
	 * as a result of this method call. If you need more detailed information about when the ad completes or whether an ad played,
	 * pass in a delegate.
	 * @param zoneID The zone from which the ad should play.
	 * @param del The delegate to receive ad events. Can be {@code null} for apps that do not need these events. */
	@Method(selector = "playVideoAdForZone:withDelegate:")
	public static native void playVideoAd (String zoneID, AdColonyAdDelegate del);

	/** Plays an AdColony ad and allows specifying display of the default V4VC instructional popups. This method returns
	 * immediately, before the ad completes. If ads are not available, an ad may not play as a result of this method call. If you
	 * need more detailed information about when the ad completes or whether an ad played, pass in a delegate.
	 * @param zoneID The zone from which the ad should play.
	 * @param del The delegate to receive ad events. Can be {@code null} for apps that do not need these events.
	 * @param showPrePopup Whether AdColony should display an instructional popup before the ad.
	 * @param showPostPopup Whether AdColony should display an instructional popup after the ad. */
	@Method(selector = "playVideoAdForZone:withDelegate:withV4VCPrePopup:andV4VCPostPopup:")
	public static native void playVideoAd (String zoneID, AdColonyAdDelegate del, boolean showPrePopup, boolean showPostPopup);

	/** Returns the zone status for the specified zone.
	 * @param zoneID The zone in question
	 * @return An ADCOLONY_ZONE_STATUS enum value indicating the zone status */
	@Method(selector = "zoneStatusForZone:")
	public static native AdColonyStatus getZoneStatus (String zoneID);
}


package org.robovm.bindings.flurry.ads;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIView;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.bindings.flurry.analytics.Flurry;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.ByVal;

/** Provides all available methods for displaying ads.
 * 
 * Set of methods that allow publishers to configure, target, and deliver ads to their customers.
 * 
 * For information on how to use Flurry's Ads SDK to attract high-quality users and monetize your user base see <a
 * href="http://support.flurry.com/index.php?title=Publishers">Support Center - Publishers</a>.
 * 
 * @version SDK 4.4.0 */
@NativeClass
public class FlurryAds extends NSObject {

	private FlurryAds () {
	}

	/** Retrieves an ad for the given space.
	 * 
	 * This method will attempt to retrieve ads for the given space from the Flurry server.
	 * 
	 * The space simply represents the placement of the ad in your app and should be unique for each placement. For example, if you
	 * are displaying a full screen ad on your splash screen and after level completion, you may have the following spaces
	 * "SPLASH_AD" and "LEVEL_AD".
	 * 
	 * @since 4.1.0
	 * @see #removeAd(String)
	 * @see FlurryAdDelegate#shouldDisplay(String, boolean)
	 * @see FlurryAdDelegate#didFailToRender(String, NSError)
	 * @see #displayAd(String, UIView)
	 * @param space The placement of an ad in your app, where placement may be splash screen for SPLASH_AD.
	 * @param frame The frame of the view that will be used for the ad container.
	 * @param size The default size of an ad space. This can be overriden on the server. See FlurryAdSize in the FlurryAds.h file
	 *           for allowable values. */
	@Method(selector = "fetchAdForSpace:frame:size:")
	public static native void fetchAd (String space, @ByVal CGRect frame, FlurryAdSize size);

	/** Returns if an ad is currently ready to display for a given space.
	 * 
	 * This method will verify if there is an ad is currently available for this user. If an ad is not available, you may call to
	 * {@link #fetchAd(String, CGRect, FlurryAdSize)} load a new ad.
	 * 
	 * If this method returns {@code true}, an ad will be available when you attempt to display an ad. However, it is still
	 * advisable to listen to the delegate {@link FlurryAdDelegate#didFailToRender(String, NSError)}. The space simply represents
	 * the placement of the ad in your app and should be unique for each placement. For example, if you are displaying a full
	 * screen ad on your splash screen and after level completion, you may have the following spaces
	 * 
	 * "SPLASH_AD" and "LEVEL_AD".
	 * 
	 * @since 4.1.0
	 * @see #fetchAd(String, CGRect, FlurryAdSize)
	 * @see #displayAd(String, UIView)
	 * @param space The placement of an ad in your app, where placement may be splash screen for SPLASH_AD.
	 * 
	 * @return {@code true}/{@code false} to indicate if an ad is ready to be displayed. */
	@Method(selector = "adReadyForSpace:")
	public static native boolean isAdReady (String space);

	/** Display an ad for the given space.
	 * 
	 * This method will display an ad if one is ready for display on the device.
	 * 
	 * The space simply represents the placement of the ad in your app and should be unique for each placement. Only one ad will
	 * show at a time for any given ad space. For example, if you are displaying a full screen ad on your splash screen and after
	 * level completion, you may have the following spaces
	 * 
	 * "SPLASH_AD" and "LEVEL_AD".
	 * 
	 * @since 4.1.0
	 * @see #fetchAd(String, CGRect, FlurryAdSize)
	 * @see #isAdReady(String)
	 * @see #removeAd(String)
	 * @see FlurryAdDelegate#shouldDisplay(String, boolean)
	 * @see FlurryAdDelegate#didFailToRender(String, NSError)
	 * @param space The placement of an ad in your app, where placement may
	 * @param view The view to place the ad. The view frame should be identical to the view frame passed in
	 *           {@link #fetchAd(String, CGRect, FlurryAdSize)} Note view is not used for interstitials. be splash screen for
	 *           SPLASH_AD. */
	@Method(selector = "displayAdForSpace:onView:")
	public static native void displayAd (String space, UIView view);

	/** Display an ad for the given interstitial space.
	 * 
	 * This method will display an interstitial ad if one is ready for display on the device for specified UIViewController
	 * instance
	 * 
	 * The space simply represents the placement of the ad in your app and should be unique for each placement. Only one ad will
	 * show at a time for any given ad space. For example, if you are displaying a full screen ad on your splash screen and after
	 * level completeion, you may have the following spaces
	 * 
	 * "SPLASH_AD" and "LEVEL_AD".
	 * 
	 * @see #fetchAd(String, CGRect, FlurryAdSize)
	 * @see #isAdReady(String)
	 * @see #removeAd(String)
	 * @see FlurryAdDelegate#shouldDisplay(String, boolean)
	 * @see FlurryAdDelegate#didFailToRender(String, NSError)
	 * 
	 * @since 4.2.2
	 * @param space The placement of an ad in your app, where placement may
	 * @param viewController The viewController to show the fullscreen ad modally. Note this method should not be used for banners. */
	@Method(selector = "displayAdForSpace:modallyForViewController:")
	public static native void displayAd (String space, UIViewController viewController);

	/** Fetch and Display an ad for the given space.
	 * 
	 * This method will display an ad if one is available from the Flurry server for this user.
	 * 
	 * This is a blocking method that allows you to change the user experience based on availability of an ad. If you would like to
	 * display an ad asynchronously, just set timeout to 0. This is useful in the case of banners for instance where the user
	 * should not wait for its display. If you are loading async with timeout set to 0, ignore the return value of this method and
	 * rely exclusively on the relevant delegate methods listed below. The space simply represents the placement of the ad in your
	 * app and should be unique for each placement. Only one ad will show at a time for any given ad space. For example, if you are
	 * displaying a full screen ad on your splash screen and after level completeion, you may have the following spaces
	 * 
	 * "SPLASH_AD" and "LEVEL_AD".
	 * 
	 * being received. {@link FlurryAdDelegate#didFailToReceiveAd(String, NSError)} for details on notification of failure to
	 * receive ads
	 * 
	 * @see #isAdReady(String)
	 * @see #removeAd(String)
	 * @see FlurryAdDelegate#shouldDisplay(String, boolean)
	 * @see FlurryAdDelegate#didFailToRender(String, NSError)
	 * @see FlurryAdDelegate#didFailToReceiveAd(String, NSError)
	 * 
	 * @since 4.0.0
	 * @param space The placement of an ad in your app, where placement may be splash screen for SPLASH_AD.
	 * @param view The UIView in your app that the ad will be placed as a subview. Note: for fullscreen ads, this view is not used
	 *           as a container, but the size of the view may still be used for determining what types of ads will fit in this
	 *           space.
	 * @param size The default size of an ad space. This can be overriden on the server. See FlurryAdSize in the FlurryAds.h file
	 *           for allowable values. */
	@Method(selector = "fetchAndDisplayAdForSpace:view:size:")
	public static native void fetchAndDisplayAd (String space, UIView view, FlurryAdSize size);

	/** Removes an ad for the given space.
	 * 
	 * This method will remove an ad if one is currently displaying.
	 * 
	 * The space simply represents the placement of the ad in your app and should be unique for each placement. Only one ad will
	 * show at a time for any given ad space.
	 * 
	 * @since 4.0.0
	 * @see #removeAd(String)
	 * @see FlurryAdDelegate#shouldDisplay(String, boolean)
	 * @param space The placement of an ad in your app, where placement may be splash screen for SPLASH_AD. */
	@Method(selector = "removeAdFromSpace:")
	public static native void removeAd (String space);

	/** Initializes the ad serving system.
	 * 
	 * This method initializes the ad serving system and can be used to pre-cache ads from the server (this is done when ad spaces
	 * are configured on the server).
	 * 
	 * This method must be called sometime after {@link Flurry#startSession(String)}.
	 * 
	 * @since 4.0
	 * @param rootViewController The primary root view controller of your app. */
	@Method(selector = "initialize:")
	public static native void initialize (UIViewController rootViewController);

	/** Sets the object to receive various delegate methods.
	 * 
	 * This method allows you to register an object that will receive notifications at different phases of ad serving.
	 * 
	 * @since 4.0
	 * @see FlurryAdDelegate
	 * @param delegate The object to receive notifications of various ad actions. */
	@Method(selector = "setAdDelegate:")
	private static native void setAdDelegate (FlurryAdDelegate delegate);

	/** Informs server to send test ads.
	 * 
	 * This method allows you to request test ads from the server. These ads do not generate revenue so it is CRITICAL this call is
	 * removed prior to app submission.
	 * 
	 * @since 4.0
	 * @param enable {@code true} to receive test ads to the device. Not including this method is equivalent to passing
	 *           {@code false}. */
	@Method
	public static native void enableTestAds (boolean enable);

	/** Sets a dictionary of key/value pairs, which will be transmitted to Flurry servers when a user clicks on an ad.
	 * 
	 * UserCookies allow the developer to specify information on a user executing an ad action. There is one UserCookie object, and
	 * on each ad click that UserCookie is transmitted to the Flurry servers. The UserCookie key/value pairs will be transmitted
	 * back to the developer via the app callback if one is set. This is useful for rewarded inventory, to identify which of your
	 * users should be rewarded when a reward callback is sent.
	 * 
	 * Calling this method with a nil or empty dictionary has no effect. Calling this method a second time with a valid dictionary
	 * will replace the previous entries. To clear previously set userCookies, you must call #clearUserCookies.
	 * 
	 * @since 4.0.0
	 * @see #clearUserCookies()
	 * @param userCookies The information about the user executing ad actions. Note: do not transmit personally identifiable
	 *           information in the user cookies. */
	@Method(selector = "setUserCookies:")
	public static native void setUserCookies (NSDictionary<?, ?> userCookies);

	/** Removes a previously set dictionary of key/value pairs.
	 * 
	 * This method removes information from the one UserCookie object.
	 * 
	 * @since 4.0.0
	 * @see #setUserCookies(NSDictionary) */
	@Method
	public static native void clearUserCookies ();

	/** Sets a dictionary of key/value pairs, which will be transmitted to Flurry servers when an ad is requested.
	 * 
	 * Keywords allow the developer to specify information on a user executing an ad action for the purposes of targeting. There is
	 * one keywords object that is transmitted to the Flurry servers on each ad request. If corresponding keywords are matched on
	 * the ad server, a subset of targeted ads will be delivered. This allows partners to supply information they track internally,
	 * which is not available to Flurry's targeting system.
	 * 
	 * Calling this method with a nil or empty dictionary has no effect. Calling this method a second time with a valid dictionary
	 * will replace the previous entries. To clear previously set keywords, you must call #clearKeywords.
	 * 
	 * @since 4.0.0
	 * @see #clearKeywords()
	 * @param keywords The information about the user to be used in targeting an ad. Note: do not transmit personally identifiable
	 *           information in keywords. */
	@Method(selector = "setKeywordsForTargeting:")
	public static native void setKeywords (NSDictionary<?, ?> keywords);

	/** Removes a previously set dictionary of key/value pairs.
	 * 
	 * This method removes information from the one keywords object.
	 * @since 4.0.0
	 * @see #setKeywords(NSDictionary) */
	@Method
	public static native void clearKeywords ();

	/** Method to add a custom ad network to be served through the standard Flurry ad system.
	 * 
	 * This method adds a network with the necessary publisher supplied properties to the Flurry sdk.
	 * @since 4.0.0
	 * @see FlurryCustomAdNetwork
	 * @see FlurryCustomAdNetworkProperties */
	@Method(selector = "addCustomAdNetwork:")
	public static native void addCustomAdNetwork (ObjCClass adNetworkClass, FlurryCustomAdNetworkProperties adNetworkProperties);
}

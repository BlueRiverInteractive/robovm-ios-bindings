
package org.robovm.bindings.greystripe;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.Method;

public interface GSAdDelegate extends NSObjectProtocol {
	/** The view controller that the banner ad's browser should be displayed from.
	 * @warning This must be implemented for banner ads. This view controller cannot be popped or removed from the view heiarchy
	 *          while the browser is being displayed. */
	@Method(selector = "greystripeBannerDisplayViewController")
	UIViewController getBannerDisplayViewController ();

	/** The global unique identifier for the application.
	 * 
	 * This must be set if it is not passed in on ad initialization.
	 * @warning This can only be set once by the application. All subsquent setting of the GUID will be ignored. */
	@Method(selector = "greystripeGUID")
	String getGUID ();

	/** A boolean indicating whether the first banner ad should be fetched automatically.
	 * 
	 * The default value is {@code true}.
	 * @warning If this method is implemented, all subsequent setting of this property will be ignored. */
	@Method(selector = "greystripeBannerAutoload")
	boolean bannerAutoload ();

	/** Sent when an ad has successfully been fetched and is ready to be displayed.
	 * 
	 * @param a_ad The ad that succeeded. */
	@Method(selector = "greystripeAdFetchSucceeded:")
	void adFetchSucceeded (GSAd ad);

	/** Sent if the ad fetch request failed.
	 * 
	 * The possible errors that may occur are:
	 * 
	 ** kGSNoNetwork:** This error is dispatched when there is no available network connection.
	 * 
	 ** kGSNoAd:** This error is dispatched when a blank ad is returned by the server.
	 * 
	 ** kGSTimeout:** This error is dispatched when the request took too long to complete.
	 * 
	 ** kGSServerError:** This error is dispatched when a server error occurs.
	 * 
	 ** kGSInvalidApplicationIdentifier:** This error is dispatched when the GUID provided by the application is not a valid
	 * Greystripe GUID.
	 * 
	 ** kGSAdExpired:** This error is dispatched when the ad that is fetched is expired and cannot be displayed.
	 * 
	 ** kGSFetchLimitExceeded:** This error is dispatched after the SDK prevents a fetch from occurring when it is highly unlikely
	 * that an ad would be returned. This error can occur in high volume, low fill situations or when too many ad requests are made
	 * in a short period of time. This error will resolve itself after a short timeout. If you frequently receive this message you
	 * should reduce the frequency of your requests or use an alternate fallback method when no ad is available.
	 * 
	 ** kGSUnknown:** This error is dispatched when the cause of the error is unknown.
	 * @param a_ad The ad that failed.
	 * @param a_error The GSAdError that occured during fetching. */
	@Method(selector = "greystripeAdFetchFailed:withError:")
	void adFetchFailed (GSAd ad, GSAdError error);

	/** Sent when the ad is clicked through to the browser or to an external app.
	 * 
	 * @param a_ad The ad that clicked through. */
	@Method(selector = "greystripeAdClickedThrough:")
	void greystripeAdClickedThrough (GSAd ad);

	/** Sent when a fullscreen ad is about to take over the screen, or when the browser is about to present modally for banner ads. */
	@Method(selector = "greystripeWillPresentModalViewController")
	void willPresentModalViewController ();

	/** Sent when the fullscreen ad's view controller or the browser view controller is about to animate off screen. If a view
	 * controller needs to be pushed or popped when the ad is dismissed, it should be done here. */
	@Method(selector = "greystripeWillDismissModalViewController")
	void willDismissModalViewController ();

	/** Sent after the fullscreen ad's view controller or the browser view controller has fully animated off screen. If the app
	 * wants to present a modal view controller after an ad has been dismissed, it must be done in this method. Modal presentation
	 * will not work from the {@link #willDismissModalViewController()} method. */
	@Method(selector = "greystripeDidDismissModalViewController")
	void didDismissModalViewController ();

	/** Sent when a banner ad's view is about to expand to take over the full screen. */
	@Method(selector = "greystripeBannerWillExpand")
	void bannerWillExpand ();

	/** Sent after an expanded banner ad has collapsed back to it's normal size. */
	@Method(selector = "greystripeBannerDidCollapse")
	void bannerDidCollapse ();

	/** Return {@code true} in this method in order to log out the ID for each ad. This defaults to {@code false}. */
	@Method(selector = "greystripeShouldLogAdID")
	boolean shouldLogAdID ();
}

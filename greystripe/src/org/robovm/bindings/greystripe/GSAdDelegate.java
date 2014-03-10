package org.robovm.bindings.greystripe;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
public interface GSAdDelegate extends NSObjectProtocol {

	/**
	 * The view controller that the banner ad's browser should be displayed from.
	 * @warning This must be implemented for banner ads. This view controller cannot
	 * be popped or removed from the view heiarchy while the browser is being displayed.
	 */
	//- (UIViewController *)greystripeBannerDisplayViewController;
	UIViewController greystripeBannerDisplayViewController();

	/**
	 * The global unique identifier for the application.
	 *
	 * This must be set if it is not passed in on ad initialization.
	 * @warning This can only be set once by the application. All subsquent setting of
	 * the GUID will be ignored.
	 */
	//- (NSString *)greystripeGUID;
	NSString greystripeGUID();

	/**
	 * A BOOL indicating whether the first banner ad should be fetched automatically.
	 * 
	 * The default value is YES.
	 * @warning If this method is implemented, all subsequent setting of this property
	 * will be ignored.
	 */
	//- (BOOL)greystripeBannerAutoload;
	boolean greystripeBannerAutoload();

	/**
	 * Sent when an ad has successfully been fetched and is ready to be displayed.
	 *
	 * @param a_ad The ad that succeeded.
	 */
	//- (void)greystripeAdFetchSucceeded:(id<GSAd>)a_ad;
	void greystripeAdFetchSucceeded(GSAd a_ad);

	/**
	  Sent if the ad fetch request failed. 
	 
	  The possible errors that may occur are:
	 
	   **kGSNoNetwork:** This error is dispatched when there is no available network connection.
	 
	   **kGSNoAd:** This error is dispatched when a blank ad is returned by the server.
	 
	   **kGSTimeout:** This error is dispatched when the request took too long to complete.
	 
	   **kGSServerError:** This error is dispatched when a server error occurs.
	 
	   **kGSInvalidApplicationIdentifier:** This error is dispatched when the GUID provided by the application is not a valid Greystripe GUID.
	 
	   **kGSAdExpired:** This error is dispatched when the ad that is fetched is expired and cannot be displayed.
	 
	   **kGSFetchLimitExceeded:** This error is dispatched after the SDK prevents a fetch from occurring when it is highly unlikely
	  that an ad would be returned. This error can occur in high volume, low fill situations or when too
	  many ad requests are made in a short period of time. This error will resolve itself after a short
	  timeout. If you frequently receive this message you should reduce the frequency of your requests
	  or use an alternate fallback method when no ad is available.
	 
	   **kGSUnknown:** This error is dispatched when the cause of the error is unknown.
	 
	  @param a_ad The ad that failed.
	  @param a_error The GSAdError that occured during fetching.
	 */
	//- (void)greystripeAdFetchFailed:(id<GSAd>)a_ad withError:(GSAdError)a_error;
	void greystripeAdFetchFailed(GSAd a_ad, GSAdError a_error);

	/**
	 * Sent when the ad is clicked through to the browser or to an external app.
	 *
	 * @param a_ad The ad that clicked through.
	 */
	//- (void)greystripeAdClickedThrough:(id<GSAd>)a_ad;
	void greystripeAdClickedThrough(GSAd a_ad);

	/**
	 * Sent when a fullscreen ad is about to take over the screen, or when the browser
	 * is about to present modally for banner ads.
	 */
	//- (void)greystripeWillPresentModalViewController;
	void greystripeWillPresentModalViewController();

	/**
	 * Sent when the fullscreen ad's view controller or the browser view controller
	 * is about to animate off screen. If a view controller needs to be pushed or 
	 * popped when the ad is dismissed, it should be done here.
	 */
	//- (void)greystripeWillDismissModalViewController;
	void greystripeWillDismissModalViewController();

	/**
	 * Sent after the fullscreen ad's view controller or the browser view controller
	 * has fully animated off screen. If the app wants to present a modal view controller after
	 * an ad has been dismissed, it must be done in this method. Modal presentation will not work
	 * from the greystripeWillDismissModalViewController method.
	 */
	//- (void)greystripeDidDismissModalViewController;
	void greystripeDidDismissModalViewController();

	/**
	 * Sent when a banner ad's view is about to expand to take over the
	 * full screen.
	 */
	//- (void)greystripeBannerWillExpand;
	void greystripeBannerWillExpand();

	/**
	 * Sent after an expanded banner ad has collapsed back to it's normal
	 * size.
	 */
	//- (void)greystripeBannerDidCollapse;
	void greystripeBannerDidCollapse();

	/**
	 * Return YES in this method in order to log out the ID for each ad. This
	 * defaults to NO.
	 */
	//- (BOOL)greystripeShouldLogAdID;
	boolean greystripeShouldLogAdID();
	
	public static abstract class Adapter extends NSObject implements GSAdDelegate {

		@Override
		public NSString greystripeGUID() {
			return null;
		}

		@Override
		public boolean greystripeBannerAutoload() {
			return false;
		}

		@Override
		public void greystripeAdFetchSucceeded(GSAd a_ad) {			
		}

		@Override
		public void greystripeAdFetchFailed(GSAd a_ad, GSAdError a_error) {			
		}

		@Override
		public void greystripeAdClickedThrough(GSAd a_ad) {			
		}

		@Override
		public void greystripeWillPresentModalViewController() {			
		}

		@Override
		public void greystripeWillDismissModalViewController() {			
		}

		@Override
		public void greystripeDidDismissModalViewController() {			
		}

		@Override
		public void greystripeBannerWillExpand() {			
		}

		@Override
		public void greystripeBannerDidCollapse() {			
		}

		@Override
		public boolean greystripeShouldLogAdID() {
			return false;
		}
		
	}

	static class Callbacks {
		
		@Callback
		@BindSelector("greystripeBannerDisplayViewController")
		public static UIViewController greystripeBannerDisplayViewController (GSAdDelegate __self__, Selector __cmd__) {
			return __self__.greystripeBannerDisplayViewController();
		}
		
		@Callback
		@BindSelector("greystripeGUID")
		public static NSString greystripeGUID (GSAdDelegate __self__, Selector __cmd__) {
			return __self__.greystripeGUID();
		}
		
		@Callback
		@BindSelector("greystripeBannerAutoload")
		public static boolean greystripeBannerAutoload (GSAdDelegate __self__, Selector __cmd__) {
			return __self__.greystripeBannerAutoload();
		}
		
		@Callback
		@BindSelector("greystripeAdFetchSucceeded:")
		public static void greystripeAdFetchSucceeded (GSAdDelegate __self__, Selector __cmd__, GSAd a_ad) {
			__self__.greystripeAdFetchSucceeded(a_ad);
		}
		
		@Callback
		@BindSelector("greystripeAdFetchFailed:")
		public static void greystripeAdFetchFailed (GSAdDelegate __self__, Selector __cmd__, GSAd a_ad, GSAdError a_error) {
			__self__.greystripeAdFetchFailed(a_ad, a_error);
		}
		
		@Callback
		@BindSelector("greystripeAdClickedThrough:")
		public static void greystripeAdClickedThrough (GSAdDelegate __self__, Selector __cmd__, GSAd a_ad) {
			__self__.greystripeAdClickedThrough(a_ad);
		}
		
		@Callback
		@BindSelector("greystripeWillPresentModalViewController")
		public static void greystripeWillPresentModalViewController (GSAdDelegate __self__, Selector __cmd__) {
			__self__.greystripeWillPresentModalViewController();
		}
		
		@Callback
		@BindSelector("greystripeWillDismissModalViewController")
		public static void greystripeWillDismissModalViewController (GSAdDelegate __self__, Selector __cmd__) {
			__self__.greystripeWillDismissModalViewController();
		}

		@Callback
		@BindSelector("greystripeDidDismissModalViewController")
		public static void greystripeDidDismissModalViewController (GSAdDelegate __self__, Selector __cmd__) {
			__self__.greystripeDidDismissModalViewController();
		}

		@Callback
		@BindSelector("greystripeBannerWillExpand")
		public static void greystripeBannerWillExpand (GSAdDelegate __self__, Selector __cmd__) {
			__self__.greystripeBannerWillExpand();
		}

		@Callback
		@BindSelector("greystripeBannerDidCollapse")
		public static void greystripeBannerDidCollapse (GSAdDelegate __self__, Selector __cmd__) {
			__self__.greystripeBannerDidCollapse();
		}

		@Callback
		@BindSelector("greystripeShouldLogAdID")
		public static boolean greystripeShouldLogAdID (GSAdDelegate __self__, Selector __cmd__) {
			return __self__.greystripeShouldLogAdID();
		}		
	}	
}


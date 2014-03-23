
package org.robovm.bindings.admob;

import org.robovm.apple.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;

/** Delegate for receiving state change messages from a GADBannerView such as ad requests succeeding/failing or when an ad has been
 * clicked. */
public interface GADBannerViewDelegate extends NSObjectProtocol {
	/** Sent when an ad request loaded an ad. This is a good opportunity to add this view to the hierarchy if it has not yet been
	 * added. If the ad was received as a part of the server-side auto refreshing, you can examine the hasAutoRefreshed property of
	 * the view.
	 * @param view */
	void didReceiveAd (GADBannerView view);

	/** Sent when an ad request failed. Normally this is because no network connection was available or no ads were available (i.e.
	 * no fill). If the error was received as a part of the server-side auto refreshing, you can examine the hasAutoRefreshed
	 * property of the view.
	 * @param error */
	void didFailToReceiveAd (GADBannerView view, GADRequestError error);

	/** Sent just before presenting the user a full screen view, such as a browser, in response to clicking on an ad. Use this
	 * opportunity to stop animations, time sensitive interactions, etc.
	 * 
	 * Normally the user looks at the ad, dismisses it, and control returns to your application by calling adViewDidDismissScreen:.
	 * However if the user hits the Home button or clicks on an App Store link your application will end. On iOS 4.0+ the next
	 * method called will be applicationWillResignActive: of your UIViewController (UIApplicationWillResignActiveNotification).
	 * Immediately after that adViewWillLeaveApplication: is called.
	 * @param view */
	void willPresentScreen (GADBannerView view);

	/** Sent just before dismissing a full screen view.
	 * @param view */
	void willDismissScreen (GADBannerView view);

	/** Sent just after dismissing a full screen view. Use this opportunity to restart anything you may have stopped as part of
	 * adViewWillPresentScreen:.
	 * @param view */
	void didDismissScreen (GADBannerView view);

	/** Sent just before the application will background or terminate because the user clicked on an ad that will launch another
	 * application (such as the App Store). The normal UIApplicationDelegate methods, like applicationDidEnterBackground:, will be
	 * called immediately before this.
	 * @param view */
	void willLeaveApplication (GADBannerView view);

	public static class Adapter extends NSObject implements GADBannerViewDelegate {
		@Override
		public void didReceiveAd (GADBannerView view) {
		}

		@Override
		public void didFailToReceiveAd (GADBannerView view, GADRequestError error) {
		}

		@Override
		public void willPresentScreen (GADBannerView view) {
		}

		@Override
		public void willDismissScreen (GADBannerView view) {
		}

		@Override
		public void didDismissScreen (GADBannerView view) {
		}

		@Override
		public void willLeaveApplication (GADBannerView view) {
		}
	}

	static class Callbacks {
		@Callback
		@BindSelector("adViewDidReceiveAd:")
		public static void didReceiveAd (GADBannerViewDelegate __self__, Selector __cmd__, GADBannerView view) {
			__self__.didReceiveAd(view);
		}

		@Callback
		@BindSelector("adView:didFailToReceiveAdWithError:")
		public static void didFailToReceiveAd (GADBannerViewDelegate __self__, Selector __cmd__, GADBannerView view,
			GADRequestError error) {
			__self__.didFailToReceiveAd(view, error);
		}

		@Callback
		@BindSelector("adViewWillPresentScreen:")
		public static void willPresentScreen (GADBannerViewDelegate __self__, Selector __cmd__, GADBannerView view) {
			__self__.willPresentScreen(view);
		}

		@Callback
		@BindSelector("adViewWillDismissScreen:")
		public static void willDismissScreen (GADBannerViewDelegate __self__, Selector __cmd__, GADBannerView view) {
			__self__.willDismissScreen(view);
		}

		@Callback
		@BindSelector("adViewDidDismissScreen:")
		public static void didDismissScreen (GADBannerViewDelegate __self__, Selector __cmd__, GADBannerView view) {
			__self__.didDismissScreen(view);
		}

		@Callback
		@BindSelector("adViewWillLeaveApplication:")
		public static void willLeaveApplication (GADBannerViewDelegate __self__, Selector __cmd__, GADBannerView view) {
			__self__.willLeaveApplication(view);
		}
	}
}

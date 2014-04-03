
package org.robovm.bindings.admob;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;

/** Delegate for receiving state change messages from a GADInterstitial such as interstitial ad requests succeeding/failing. */
public interface GADInterstitialDelegate extends NSObjectProtocol {
	/** Sent when an interstitial ad request succeeded. Show it at the next transition point in your application such as when
	 * transitioning between view controllers. */
	void didReceiveAd (GADInterstitial ad);

	/** Sent when an interstitial ad request completed without an interstitial to show. This is common since interstitials are shown
	 * sparingly to users. */
	void didFailToReceiveAd (GADInterstitial ad, GADErrorCode error);

	/** Sent just before presenting an interstitial. After this method finishes the interstitial will animate onto the screen. Use
	 * this opportunity to stop animations and save the state of your application in case the user leaves while the interstitial is
	 * on screen (e.g. to visit the App Store from a link on the interstitial). */
	void willPresentScreen (GADInterstitial ad);

	/** Sent before the interstitial is to be animated off the screen. */
	void willDismissScreen (GADInterstitial ad);

	/** Sent just after dismissing an interstitial and it has animated off the screen. */
	void didDismissScreen (GADInterstitial ad);

	/** Sent just before the application will background or terminate because the user clicked on an ad that will launch another
	 * application (such as the App Store). The normal UIApplicationDelegate methods, like applicationDidEnterBackground:, will be
	 * called immediately before this. */
	void willLeaveApplication (GADInterstitial ad);

	public static class Adapter extends NSObject implements GADInterstitialDelegate {
		@Override
		public void didReceiveAd (GADInterstitial ad) {
		}

		@Override
		public void didFailToReceiveAd (GADInterstitial ad, GADErrorCode error) {
		}

		@Override
		public void willPresentScreen (GADInterstitial ad) {
		}

		@Override
		public void willDismissScreen (GADInterstitial ad) {
		}

		@Override
		public void didDismissScreen (GADInterstitial ad) {
		}

		@Override
		public void willLeaveApplication (GADInterstitial ad) {
		}
	}

	static class Callbacks {
		@Callback
		@BindSelector("interstitialDidReceiveAd:")
		public static void didReceiveAd (GADInterstitialDelegate __self__, Selector __cmd__, GADInterstitial ad) {
			__self__.didReceiveAd(ad);
		}

		@BindSelector("interstitial:didFailToReceiveAdWithError:")
		public static void didFailToReceiveAdWithError (GADInterstitialDelegate __self__, Selector __cmd__, GADInterstitial ad,
			GADErrorCode error) {
			__self__.didFailToReceiveAd(ad, error);
		}

		@Callback
		@BindSelector("interstitialWillPresentScreen:")
		public static void willPresentScreen (GADInterstitialDelegate __self__, Selector __cmd__, GADInterstitial ad) {
			__self__.willPresentScreen(ad);
		}

		@Callback
		@BindSelector("interstitialWillDismissScreen:")
		public static void willDismissScreen (GADInterstitialDelegate __self__, Selector __cmd__, GADInterstitial ad) {
			__self__.willDismissScreen(ad);
		}

		@Callback
		@BindSelector("interstitialDidDismissScreen:")
		public static void didDismissScreen (GADInterstitialDelegate __self__, Selector __cmd__, GADInterstitial ad) {
			__self__.didDismissScreen(ad);
		}

		@Callback
		@BindSelector("interstitialWillLeaveApplication:")
		public static void willLeaveApplication (GADInterstitialDelegate __self__, Selector __cmd__, GADInterstitial ad) {
			__self__.willLeaveApplication(ad);
		}
	}

}

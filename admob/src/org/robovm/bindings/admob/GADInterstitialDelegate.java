package org.robovm.bindings.admob;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
public interface GADInterstitialDelegate extends NSObjectProtocol {

	// - (void)interstitialDidReceiveAd:(GADInterstitial *)ad;
	/**
	 * Sent when an interstitial ad request succeeded. Show it at the next transition point in your application such as when transitioning between view controllers.
	 */
	void interstitialDidReceiveAd(GADInterstitial ad);

	// - (void)interstitial:(GADInterstitial *)ad didFailToReceiveAdWithError:(GADRequestError *)error;
	/**
	 * Sent when an interstitial ad request completed without an interstitial to show. This is common since interstitials are shown sparingly to users.
	 */
	void interstitialDidFailToReceiveAdWithError(GADInterstitial ad, GADRequestError error);

	// - (void)interstitialWillPresentScreen:(GADInterstitial *)ad;
	/**
	 * Sent just before presenting an interstitial. After this method finishes the interstitial will animate onto the screen. Use this opportunity to stop animations and save the state of your
	 * application in case the user leaves while the interstitial is on screen (e.g. to visit the App Store from a link on the interstitial).
	 */
	void interstitialWillPresentScreen(GADInterstitial ad);

	// - (void)interstitialWillDismissScreen:(GADInterstitial *)ad;
	/**
	 * Sent before the interstitial is to be animated off the screen.
	 */
	void interstitialWillDismissScreen(GADInterstitial ad);

	// - (void)interstitialDidDismissScreen:(GADInterstitial *)ad;
	/**
	 * Sent just after dismissing an interstitial and it has animated off the screen.
	 */
	void interstitialDidDismissScreen(GADInterstitial ad);

	// - (void)interstitialWillLeaveApplication:(GADInterstitial *)ad;
	/**
	 * Sent just before the application will background or terminate because the user clicked on an ad that will launch another application (such as the App Store). The normal UIApplicationDelegate
	 * methods, like applicationDidEnterBackground:, will be called immediately before this.
	 */
	void interstitialWillLeaveApplication(GADInterstitial ad);

	public static class Adapter extends NSObject implements GADInterstitialDelegate {
		@Override
		public void interstitialDidReceiveAd(GADInterstitial ad){
		}

		@Override
		public void interstitialDidFailToReceiveAdWithError(GADInterstitial ad, GADRequestError error){
		}

		@Override
		public void interstitialWillPresentScreen(GADInterstitial ad){
		}

		@Override
		public void interstitialWillDismissScreen(GADInterstitial ad){
		}

		@Override
		public void interstitialDidDismissScreen(GADInterstitial ad){
		}

		@Override
		public void interstitialWillLeaveApplication(GADInterstitial ad){
		}
	}

	static class Callbacks {
		@Callback
		@BindSelector("interstitialDidReceiveAd:")
		public static void interstitialDidReceiveAd(GADInterstitialDelegate __self__, Selector __cmd__, GADInterstitial ad){
			__self__.interstitialDidReceiveAd(ad);
		}

		@BindSelector("interstitial:didFailToReceiveAdWithError:")
		public static void interstitialDidFailToReceiveAdWithError(GADInterstitialDelegate __self__, Selector __cmd__, GADInterstitial ad, GADRequestError error){
			__self__.interstitialDidFailToReceiveAdWithError(ad, error);
		}
		
		@Callback
		@BindSelector("interstitialWillPresentScreen:")
		public static void interstitialWillPresentScreen(GADInterstitialDelegate __self__, Selector __cmd__, GADInterstitial ad){
			__self__.interstitialWillPresentScreen(ad);
		}
		
		@Callback
		@BindSelector("interstitialWillDismissScreen:")
		public static void interstitialWillDismissScreen(GADInterstitialDelegate __self__, Selector __cmd__, GADInterstitial ad){
			__self__.interstitialWillDismissScreen(ad);
		}
		
		@Callback
		@BindSelector("interstitialDidDismissScreen:")
		public static void interstitialDidDismissScreen(GADInterstitialDelegate __self__, Selector __cmd__, GADInterstitial ad){
			__self__.interstitialDidDismissScreen(ad);
		}
		
		@Callback
		@BindSelector("interstitialWillLeaveApplication:")
		public static void interstitialWillLeaveApplication(GADInterstitialDelegate __self__, Selector __cmd__, GADInterstitial ad){
			__self__.interstitialWillLeaveApplication(ad);
		}
	}

}

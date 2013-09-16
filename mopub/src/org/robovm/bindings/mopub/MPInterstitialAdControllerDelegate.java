package org.robovm.bindings.mopub;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Library;

/**
 * The delegate of an {@link MPInterstitialAdController} object must adopt the MPInterstitialAdControllerDelegate protocol.
 * 
 * The methods of this protocol allow the delegate to be notified of interstitial state changes, such as when an ad has loaded, when an ad has been
 * presented or dismissed from the screen, and when an ad has expired.
 * 
 * Don't implement this interface, instead extend the provided {@link Adapter} class.
 */
@Library(Library.INTERNAL)
public interface MPInterstitialAdControllerDelegate extends NSObjectProtocol {

	/**
	 * Sent when an interstitial ad object successfully loads an ad.
	 * 
	 * @param interstitial
	 *            The interstitial ad object sending the message.
	 */
	void didLoadAd(MPInterstitialAdController interstitial);

	/**
	 * Sent when an interstitial ad object fails to load an ad.
	 * 
	 * @param interstitial
	 *            The interstitial ad object sending the message.
	 */
	void didFailToLoadAd(MPInterstitialAdController interstitial);

	/**
	 * Sent immediately before an interstitial ad object is presented on the screen.
	 * 
	 * Your implementation of this method should pause any application activity that requires user interaction.
	 * 
	 * @param interstitial
	 *            The interstitial ad object sending the message.
	 */
	void willAppear(MPInterstitialAdController interstitial);

	/**
	 * Sent after an interstitial ad object has been presented on the screen.
	 * 
	 * @param interstitial
	 *            The interstitial ad object sending the message.
	 */
	void didAppear(MPInterstitialAdController interstitial);

	/**
	 * Sent immediately before an interstitial ad object will be dismissed from the screen.
	 * 
	 * @param interstitial
	 *            The interstitial ad object sending the message.
	 */
	void willDisappear(MPInterstitialAdController interstitial);

	/**
	 * Sent after an interstitial ad object has been dismissed from the screen, returning control to your application.
	 * 
	 * Your implementation of this method should resume any application activity that was paused prior to the interstitial being presented on-screen.
	 * 
	 * @param interstitial
	 *            The interstitial ad object sending the message.
	 */
	void didDisappear(MPInterstitialAdController interstitial);

	/**
	 * Sent when a loaded interstitial ad is no longer eligible to be displayed.
	 * 
	 * Interstitial ads from certain networks (such as iAd) may expire their content at any time, even if the content is currently on-screen. This
	 * method notifies you when the currently- loaded interstitial has expired and is no longer eligible for display.
	 * 
	 * If the ad was on-screen when it expired, you can expect that the ad will already have been dismissed by the time this message is sent.
	 * 
	 * Your implementation may include a call to `loadAd` to fetch a new ad, if desired.
	 * 
	 * @param interstitial
	 *            The interstitial ad object sending the message.
	 */
	void didExpire(MPInterstitialAdController interstitial);

	/**
	 * Extend this adapter to listen for events triggered by a {@link MPInterstitialAdController}.
	 */
	public static class Adapter extends NSObject implements MPInterstitialAdControllerDelegate {
		@Override
		public void didLoadAd(MPInterstitialAdController interstitial) {
		}

		@Override
		public void didFailToLoadAd(MPInterstitialAdController interstitial) {
		}

		@Override
		public void willAppear(MPInterstitialAdController interstitial) {
		}

		@Override
		public void didAppear(MPInterstitialAdController interstitial) {
		}

		@Override
		public void willDisappear(MPInterstitialAdController interstitial) {
		}

		@Override
		public void didDisappear(MPInterstitialAdController interstitial) {
		}

		@Override
		public void didExpire(MPInterstitialAdController interstitial) {
		}
	}

	static class Callbacks {
		@Callback
		@BindSelector("interstitialDidLoadAd:")
		public static void didLoadAd(MPInterstitialAdControllerDelegate __self__, Selector __cmd__, MPInterstitialAdController interstitial) {
			__self__.didLoadAd(interstitial);
		}

		@Callback
		@BindSelector("interstitialDidFailToLoadAd:")
		public static void didFailToLoadAd(MPInterstitialAdControllerDelegate __self__, Selector __cmd__, MPInterstitialAdController interstitial) {
			__self__.didFailToLoadAd(interstitial);
		}

		@Callback
		@BindSelector("interstitialWillAppear:")
		public static void willPresentView(MPInterstitialAdControllerDelegate __self__, Selector __cmd__, MPInterstitialAdController interstitial) {
			__self__.willAppear(interstitial);
		}

		@Callback
		@BindSelector("interstitialDidAppear:")
		public static void didDismissView(MPInterstitialAdControllerDelegate __self__, Selector __cmd__, MPInterstitialAdController interstitial) {
			__self__.didAppear(interstitial);
		}

		@Callback
		@BindSelector("interstitialWillDisappear:")
		public static void willLeaveApplication(MPInterstitialAdControllerDelegate __self__, Selector __cmd__, MPInterstitialAdController interstitial) {
			__self__.willDisappear(interstitial);
		}

		@Callback
		@BindSelector("interstitialDidDisappear:")
		public static void didDisappear(MPInterstitialAdControllerDelegate __self__, Selector __cmd__, MPInterstitialAdController interstitial) {
			__self__.didDisappear(interstitial);
		}

		@Callback
		@BindSelector("interstitialDidExpire:")
		public static void didExpire(MPInterstitialAdControllerDelegate __self__, Selector __cmd__, MPInterstitialAdController interstitial) {
			__self__.didExpire(interstitial);
		}
	}
}
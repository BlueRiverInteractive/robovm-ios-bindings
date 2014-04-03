
package org.robovm.bindings.admob.mediation;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;

public interface GADCustomEventInterstitial extends NSObjectProtocol {

	// - (void)requestInterstitialAdWithParameter:(NSString *)serverParameter label:(NSString *)serverLabel
// request:(GADCustomEventRequest *)request;
	/** This method is called by Mediation when your Custom Event is scheduled to be executed. Your implementation should begin
	 * retrieval of the interstitial ad, usually from a backend server, or from an ad network SDK. Results of the execution should
	 * be reported back via the delegate. Note that you should wait until -presentFromRootViewController is called before
	 * displaying the interstitial ad. Do not automatically display the ad when you receive the ad. Instead, retain the ad and
	 * display it when presentFromRootViewController is called. |serverParameter| and |serverLabel| are the parameter and label
	 * configured in the AdMob Mediation UI for the Custom Event. |request| contains information about the ad request, some of
	 * those are from GADRequest.
	 * @param serverParameter
	 * @param serverLabel
	 * @param request */
	void requestInterstitial (NSString serverParameter, NSString serverLabel, GADCustomEventRequest request);

	// - (void)presentFromRootViewController:(UIViewController *)rootViewController;
	/** Present the interstitial ad as a modal view using the provided view controller. This is called only after your Custom Event
	 * calls back to the delegate with the message -customEvent:didReceiveAd: .
	 * @param rootViewController */
	void present (UIViewController rootViewController);

	// @property (nonatomic, assign) id<GADCustomEventInterstitialDelegate> delegate;
	/** Setter for delegate You should call back to the |delegate| with the results of the execution to ensure Mediation behaves
	 * correctly. The delegate is assigned, not retained, to prevent memory leak caused by circular retention.
	 * 
	 * You can create accessor methods either by doing
	 * 
	 * @synthesize delegate;
	 * 
	 *             in your class implementation, or define the methods -delegate and -setDelegate: yourself.
	 * 
	 *             In your object's -dealloc method, remember to nil out the delegate.
	 * @param delegate */
	void setDelegate (GADCustomEventInterstitialDelegate delegate);

	// @property (nonatomic, assign) id<GADCustomEventInterstitialDelegate> delegate;
	/** Getter for Delegate You should call back to the |delegate| with the results of the execution to ensure Mediation behaves
	 * correctly. The delegate is assigned, not retained, to prevent memory leak caused by circular retention.
	 * 
	 * You can create accessor methods either by doing
	 * 
	 * @synthesize delegate;
	 * 
	 *             in your class implementation, or define the methods -delegate and -setDelegate: yourself.
	 * 
	 *             In your object's -dealloc method, remember to nil out the delegate.
	 * @return */
	GADCustomEventInterstitialDelegate getDelegate ();

	public static class Adapter extends NSObject implements GADCustomEventInterstitial {
		@Override
		public void requestInterstitial (NSString serverParameter, NSString serverLabel, GADCustomEventRequest request) {
		}

		@Override
		public void present (UIViewController rootViewController) {
		}

		@Override
		public void setDelegate (GADCustomEventInterstitialDelegate delegate) {
		}

		@Override
		public GADCustomEventInterstitialDelegate getDelegate () {
			return null;
		}
	}

	static class Callbacks {
		@Callback
		@BindSelector("requestInterstitialAdWithParameter:label:request:")
		public static void requestInterstitial (GADCustomEventInterstitial __self__, Selector __cmd__, NSString serverParameter,
			NSString serverLabel, GADCustomEventRequest request) {
			__self__.requestInterstitial(serverParameter, serverLabel, request);
		}

		@Callback
		@BindSelector("presentFromRootViewController:")
		public static void present (GADCustomEventInterstitial __self__, Selector __cmd__, UIViewController rootViewController) {
			__self__.present(rootViewController);
		}

		@Callback
		@BindSelector("delegate")
		public static GADCustomEventInterstitialDelegate getDelegate (GADCustomEventInterstitial __self__, Selector __cmd__) {
			return __self__.getDelegate();
		}

		@Callback
		@BindSelector("setDelegate:")
		public static void setDelegate (GADCustomEventInterstitial __self__, Selector __cmd__,
			GADCustomEventInterstitialDelegate delegate) {
			__self__.setDelegate(delegate);
		}
	}

}

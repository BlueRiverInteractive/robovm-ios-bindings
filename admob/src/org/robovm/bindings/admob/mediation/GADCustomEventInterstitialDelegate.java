package org.robovm.bindings.admob.mediation;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Library;

/**
 * Call back to this delegate in your custom event. You must call
 * customEventInterstitial:didReceiveAd: when there is an ad to show, or
 * customEventInterstitial:didFailAd: when there is no ad to show. Otherwise, if
 * enough time passed (several seconds) after the SDK called the
 * requestInterstitialAdWithParameter: method of your custom event, the
 * mediation SDK will consider the request timed out, and move on to the next ad
 * network.
 */
@Library(Library.INTERNAL)
public interface GADCustomEventInterstitialDelegate extends NSObjectProtocol{
	
	//- (void)customEventInterstitial:(id<GADCustomEventInterstitial>)customEvent didReceiveAd:(NSObject *)ad;
	/**
	 * Your Custom Event object must call this when it receives or creates an
	 * interstitial ad. If there is an ad object, pass it in the method call.
	 * Pass nil if the ad object is not available.
	 * @param customEvent
	 * @param ad
	 */
	void customEventDidReceiveAd(GADCustomEventInterstitial customEvent, NSObject ad);
	
	//- (void)customEventInterstitial:(id<GADCustomEventInterstitial>)customEvent didFailAd:(NSError *)error;
	/**
	 * Your Custom Event object must call this when it fails to receive or
	 * create the ad. Pass along any error object sent from the ad network's
	 * SDK, or an NSError describing the error. Pass nil if not available.
	 * @param customEvent
	 * @param error
	 */
	void customEventDidFailAd(GADCustomEventInterstitial customEvent, NSError error);
	
	//- (void)customEventInterstitialWillPresent: (id<GADCustomEventInterstitial>)customEvent;
	/**
	 * Your Custom Event should call this when the interstitial is being displayed.
	 * @param customEvent
	 */
	void customEventWillPresent(GADCustomEventInterstitial customEvent);
	
	//- (void)customEventInterstitialWillDismiss: (id<GADCustomEventInterstitial>)customEvent;
	/**
	 * Your Custom Event should call this when the interstitial is about to be dismissed.
	 * @param customEvent
	 */
	void customEventWillDismiss(GADCustomEventInterstitial customEvent);
	
	//- (void)customEventInterstitialDidDismiss: (id<GADCustomEventInterstitial>)customEvent;
	/**
	 * Your Custom Event should call this when the interstitial has been dismissed.
	 * @param customEvent
	 */
	void customEventDidDismiss(GADCustomEventInterstitial customEvent);
	
	//- (void)customEventInterstitialWillLeaveApplication: (id<GADCustomEventInterstitial>)customEvent;
	/**
	 * Your Custom Event should call this method when a user action will result in App switching.
	 * @param customEvent
	 */
	void customEventWillLeaveApplication(GADCustomEventInterstitial customEvent);
	
	public static class Adapter extends NSObject implements GADCustomEventInterstitialDelegate {
		@Override
		public void customEventDidReceiveAd(GADCustomEventInterstitial customEvent, NSObject ad){
		}

		@Override
		public void customEventDidFailAd(GADCustomEventInterstitial customEvent, NSError error){
		}

		@Override
		public void customEventWillPresent(GADCustomEventInterstitial customEvent){
		}

		@Override
		public void customEventWillDismiss(GADCustomEventInterstitial customEvent){
		}

		@Override
		public void customEventDidDismiss(GADCustomEventInterstitial customEvent){
		}

		@Override
		public void customEventWillLeaveApplication(GADCustomEventInterstitial customEvent){
		}
	}
	
	static class Callbacks {
		@Callback
		@BindSelector("customEventInterstitial:didReceiveAd:")
		public static void customEventDidReceiveAd(GADCustomEventInterstitialDelegate __self__, Selector __cmd__, GADCustomEventInterstitial customEvent, NSObject ad){
			__self__.customEventDidReceiveAd(customEvent, ad);
		}
		
		@Callback
		@BindSelector("customEventInterstitial:didFailAd:")
		public static void customEventDidFailAd(GADCustomEventInterstitialDelegate __self__, Selector __cmd__, GADCustomEventInterstitial customEvent, NSError error){
			__self__.customEventDidFailAd(customEvent, error);
		}
		
		@Callback
		@BindSelector("customEventInterstitialWillPresent:")
		public static void customEventWillPresent(GADCustomEventInterstitialDelegate __self__, Selector __cmd__, GADCustomEventInterstitial customEvent){
			__self__.customEventWillPresent(customEvent);
		}
		
		@Callback
		@BindSelector("customEventInterstitialWillDismiss:")
		public static void customEventWillDismiss(GADCustomEventInterstitialDelegate __self__, Selector __cmd__, GADCustomEventInterstitial customEvent){
			__self__.customEventWillDismiss(customEvent);
		}
		
		@Callback
		@BindSelector("customEventInterstitialDidDismiss:")
		public static void customEventDidDismiss(GADCustomEventInterstitialDelegate __self__, Selector __cmd__, GADCustomEventInterstitial customEvent){
			__self__.customEventDidDismiss(customEvent);
		}
		
		@Callback
		@BindSelector("customEventInterstitialWillLeaveApplication:")
		public static void customEventWillLeaveApplication(GADCustomEventInterstitialDelegate __self__, Selector __cmd__, GADCustomEventInterstitial customEvent){
			__self__.customEventWillLeaveApplication(customEvent);
		}
	}

}

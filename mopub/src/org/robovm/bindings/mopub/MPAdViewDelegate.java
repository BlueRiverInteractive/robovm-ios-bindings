
package org.robovm.bindings.mopub;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.objc.annotation.NotImplemented;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Library;

/** The delegate of an {@link MPAdView} object must adopt the MPAdViewDelegate protocol. It must implement
 * {@link #getViewController()} to provide a root view controller from which the ad view should present modal content.
 * 
 * Optional methods of this protocol allow the delegate to be notified of banner success or failure, as well as other lifecycle
 * events.
 * 
 * Don't implement this interface, instead extend the provided {@link Adapter} class. */
@Library(Library.INTERNAL)
public interface MPAdViewDelegate extends NSObjectProtocol {

	/** Asks the delegate for a view controller to use for presenting modal content, such as the in-app browser that can appear when
	 * an ad is tapped.
	 * 
	 * @return A view controller that should be used for presenting modal content. */
	UIViewController getViewController ();

	/** Sent when an ad view successfully loads an ad.
	 * 
	 * Your implementation of this method should insert the ad view into the view hierarchy, if you have not already done so.
	 * 
	 * @param view The ad view sending the message. */
	void didLoadAd (MPAdView view);

	/** Sent when an ad view fails to load an ad.
	 * 
	 * To avoid displaying blank ads, you should hide the ad view in response to this message.
	 * 
	 * @param view The ad view sending the message. */
	void didFailToLoadAd (MPAdView view);

	/** Sent when an ad view is about to present modal content.
	 * 
	 * This method is called when the user taps on the ad view. Your implementation of this method should pause any application
	 * activity that requires user interaction.
	 * 
	 * @param view The ad view sending the message.
	 * @see #didDismissView */
	void willPresentView (MPAdView view);

	/** Sent when an ad view has dismissed its modal content, returning control to your application.
	 * 
	 * Your implementation of this method should resume any application activity that was paused in response to
	 * `willPresentModalViewForAd:`.
	 * 
	 * @param view The ad view sending the message.
	 * @see #willPresentView */
	void didDismissView (MPAdView view);

	/** Sent when a user is about to leave your application as a result of tapping on an ad.
	 * 
	 * Your application will be moved to the background shortly after this method is called.
	 * 
	 * @param view The ad view sending the message. */
	void willLeaveApplication (MPAdView view);

	/** Extend this adapter to listen for events triggered by a {@link MPAdView}. */
	public static class Adapter extends NSObject implements MPAdViewDelegate {
		@NotImplemented("viewControllerForPresentingModalView")
		@Override
		public UIViewController getViewController () {
			throw new UnsupportedOperationException();
		}

		@Override
		public void didLoadAd (MPAdView view) {
		}

		@Override
		public void didFailToLoadAd (MPAdView view) {
		}

		@Override
		public void willPresentView (MPAdView view) {
		}

		@Override
		public void didDismissView (MPAdView view) {
		}

		@Override
		public void willLeaveApplication (MPAdView view) {
		}
	}

	static class Callbacks {
		@Callback
		@BindSelector("viewControllerForPresentingModalView")
		public static UIViewController getViewController (MPAdViewDelegate __self__, Selector __cmd__) {
			return __self__.getViewController();
		}

		@Callback
		@BindSelector("adViewDidLoadAd:")
		public static void didLoadAd (MPAdViewDelegate __self__, Selector __cmd__, MPAdView view) {
			__self__.didLoadAd(view);
		}

		@Callback
		@BindSelector("adViewDidFailToLoadAd:")
		public static void didFailToLoadAd (MPAdViewDelegate __self__, Selector __cmd__, MPAdView view) {
			__self__.didFailToLoadAd(view);
		}

		@Callback
		@BindSelector("willPresentModalViewForAd:")
		public static void willPresentView (MPAdViewDelegate __self__, Selector __cmd__, MPAdView view) {
			__self__.willPresentView(view);
		}

		@Callback
		@BindSelector("didDismissModalViewForAd:")
		public static void didDismissView (MPAdViewDelegate __self__, Selector __cmd__, MPAdView view) {
			__self__.didDismissView(view);
		}

		@Callback
		@BindSelector("willLeaveApplicationFromAd:")
		public static void willLeaveApplication (MPAdViewDelegate __self__, Selector __cmd__, MPAdView view) {
			__self__.willLeaveApplication(view);
		}
	}
}

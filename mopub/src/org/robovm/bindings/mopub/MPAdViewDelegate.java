
package org.robovm.bindings.mopub;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.Method;

/** The delegate of an {@link MPAdView} object must adopt the MPAdViewDelegate protocol. It must implement
 * {@link #getViewController()} to provide a root view controller from which the ad view should present modal content.
 * 
 * Optional methods of this protocol allow the delegate to be notified of banner success or failure, as well as other lifecycle
 * events.
 * 
 * Don't implement this interface, instead extend the provided {@link Adapter} class. */
public interface MPAdViewDelegate extends NSObjectProtocol {

	/** Asks the delegate for a view controller to use for presenting modal content, such as the in-app browser that can appear when
	 * an ad is tapped.
	 * 
	 * @return A view controller that should be used for presenting modal content. */
	@Method(selector = "viewControllerForPresentingModalView")
	UIViewController getViewController ();

	/** Sent when an ad view successfully loads an ad.
	 * 
	 * Your implementation of this method should insert the ad view into the view hierarchy, if you have not already done so.
	 * 
	 * @param view The ad view sending the message. */
	@Method(selector = "adViewDidLoadAd:")
	void didLoadAd (MPAdView view);

	/** Sent when an ad view fails to load an ad.
	 * 
	 * To avoid displaying blank ads, you should hide the ad view in response to this message.
	 * 
	 * @param view The ad view sending the message. */
	@Method(selector = "adViewDidFailToLoadAd:")
	void didFailToLoadAd (MPAdView view);

	/** Sent when an ad view is about to present modal content.
	 * 
	 * This method is called when the user taps on the ad view. Your implementation of this method should pause any application
	 * activity that requires user interaction.
	 * 
	 * @param view The ad view sending the message.
	 * @see #didDismissView */
	@Method(selector = "willPresentModalViewForAd:")
	void willPresentView (MPAdView view);

	/** Sent when an ad view has dismissed its modal content, returning control to your application.
	 * 
	 * Your implementation of this method should resume any application activity that was paused in response to
	 * `willPresentModalViewForAd:`.
	 * 
	 * @param view The ad view sending the message.
	 * @see #willPresentView */
	@Method(selector = "didDismissModalViewForAd:")
	void didDismissView (MPAdView view);

	/** Sent when a user is about to leave your application as a result of tapping on an ad.
	 * 
	 * Your application will be moved to the background shortly after this method is called.
	 * 
	 * @param view The ad view sending the message. */
	@Method(selector = "willLeaveApplicationFromAd:")
	void willLeaveApplication (MPAdView view);
}

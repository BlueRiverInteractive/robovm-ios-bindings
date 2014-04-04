
package org.robovm.bindings.mopub;

import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.NotImplemented;

public class MPAdViewDelegateAdapter implements MPAdViewDelegate {
	@Override
	@NotImplemented("viewControllerForPresentingModalView")
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

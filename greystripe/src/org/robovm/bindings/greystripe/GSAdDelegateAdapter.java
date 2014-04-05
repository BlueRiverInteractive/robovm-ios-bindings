
package org.robovm.bindings.greystripe;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIViewController;

public class GSAdDelegateAdapter extends NSObject implements GSAdDelegate {
	@Override
	public UIViewController getBannerDisplayViewController () {
		return null;
	}

	@Override
	public String getGUID () {
		return null;
	}

	@Override
	public boolean bannerAutoload () {
		return false;
	}

	@Override
	public void adFetchSucceeded (GSAd ad) {
	}

	@Override
	public void adFetchFailed (GSAd ad, GSAdError error) {
	}

	@Override
	public void greystripeAdClickedThrough (GSAd ad) {
	}

	@Override
	public void willPresentModalViewController () {
	}

	@Override
	public void willDismissModalViewController () {
	}

	@Override
	public void didDismissModalViewController () {
	}

	@Override
	public void bannerWillExpand () {
	}

	@Override
	public void bannerDidCollapse () {
	}

	@Override
	public boolean shouldLogAdID () {
		return false;
	}
}

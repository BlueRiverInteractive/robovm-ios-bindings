
package org.robovm.bindings.chartboost;

import org.robovm.apple.foundation.NSObject;

public class ChartboostDelegateAdapter extends NSObject implements ChartboostDelegate {
	@Override
	public boolean shouldRequestInterstitial (String location) {
		return false;
	}

	@Override
	public boolean shouldDisplayInterstitial (String location) {
		return false;
	}

	@Override
	public void didCacheInterstitial (String location) {
	}

	@Override
	public void didFailToLoadInterstitial (String location) {
	}

	@Override
	public void didDismissInterstitial (String location) {
	}

	@Override
	public void didCloseInterstitial (String location) {
	}

	@Override
	public void didClickInterstitial (String location) {
	}

	@Override
	public boolean shouldDisplayLoadingViewForMoreApps () {
		return false;
	}

	@Override
	public boolean shouldDisplayMoreApps () {
		return false;
	}

	@Override
	public void didCacheMoreApps () {
	}

	@Override
	public void didFailToLoadMoreApps () {
	}

	@Override
	public void didDismissMoreApps () {
	}

	@Override
	public void didCloseMoreApps () {
	}

	@Override
	public void didClickMoreApps () {
	}

	@Override
	public boolean shouldRequestInterstitialsInFirstSession () {
		return false;
	}
}

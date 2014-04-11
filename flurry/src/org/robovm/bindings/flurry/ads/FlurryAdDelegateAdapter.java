
package org.robovm.bindings.flurry.ads;

import org.robovm.apple.foundation.NSError;

public class FlurryAdDelegateAdapter implements FlurryAdDelegate {
	@Override
	public void didReceiveAd (String adSpace) {
	}

	@Override
	public void didFailToReceiveAd (String adSpace, NSError error) {
	}

	@Override
	public boolean shouldDisplay (String adSpace, boolean interstitial) {
		return false;
	}

	@Override
	public void didFailToRender (String adSpace, NSError error) {
	}

	@Override
	public void willDismiss (String adSpace, boolean interstitial) {
	}

	@Override
	public void didDismiss (String adSpace, boolean interstitial) {
	}

	@Override
	public void willLeaveApplication (String adSpace) {
	}

	@Override
	public void willExpand (String adSpace) {
	}

	@Override
	public void willCollapse (String adSpace) {
	}

	@Override
	public void didCollapse (String adSpace) {
	}

	@Override
	public void didReceiveClick (String adSpace) {
	}

	@Override
	public void videoDidFinish (String adSpace) {
	}

	@Override
	public String getMillennialAppKey () {
		return null;
	}

	@Override
	public String getMillennialInterstitialAppKey () {
		return null;
	}

	@Override
	public String getInMobiAppKey () {
		return null;
	}

	@Override
	public String getAdMobPublisherID () {
		return null;
	}

	@Override
	public String getMobclixApplicationID () {
		return null;
	}

	@Override
	public String getJumptapPublisherID () {
		return null;
	}

	@Override
	public String getJumptapSiteID () {
		return null;
	}

	@Override
	public String getJumptapBannerAdSpotID () {
		return null;
	}

	@Override
	public String getJumptapLeaderboardAdSpotID () {
		return null;
	}

	@Override
	public String getJumptapMediumRectangleAdSpotID () {
		return null;
	}

	@Override
	public String getGreystripeApplicationID () {
		return null;
	}

	@Override
	public boolean isAccelerometerEnabled () {
		return false;
	}
}

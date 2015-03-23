package org.robovm.bindings.chartboost;

import org.robovm.apple.foundation.NSObject;

public class ChartboostDelegateAdapter extends NSObject implements
        ChartboostDelegate {
    @Override
    public boolean shouldRequestInterstitial(String location) {
        return true;
    }

    @Override
    public boolean shouldDisplayInterstitial(String location) {
        return true;
    }

    @Override
    public void didDisplayInterstitial(String location) {
    }

    @Override
    public void didFailToLoadInterstitial(String location, CBLoadError loadError) {
    }

    @Override
    public void didCacheInterstitial(String location) {
    }

    @Override
    public void didDismissInterstitial(String location) {
    }

    @Override
    public void didCloseInterstitial(String location) {
    }

    @Override
    public void didClickInterstitial(String location) {
    }

    @Override
    public void didFailToRecordClick(String location, CBClickError clickError) {
    }

    @Override
    public boolean shouldDisplayMoreApps(String location) {
        return true;
    }

    @Override
    public void didCacheMoreApps(String location) {
    }

    @Override
    public void didDismissMoreApps(String location) {
    }

    @Override
    public void didCloseMoreApps(String location) {
    }

    @Override
    public void didClickMoreApps(String location) {
    }

    @Override
    public void didFailToLoadMoreApps(String location, CBLoadError loadError) {
    }

    @Override
    public boolean shouldDisplayRewardedVideo(String location) {
        return true;
    }

    @Override
    public void didCacheRewardedVideo(String location) {
    }

    @Override
    public void didDismissRewardedVideo(String location) {
    }

    @Override
    public void didCloseRewardedVideo(String location) {
    }

    @Override
    public void didClickRewardedVideo(String location) {
    }

    @Override
    public void didFailToLoadRewardedVideo(String location, CBLoadError loadError) {
    }

    @Override
    public void didCompleteRewardedVideo(String location, int reward) {
    }
}

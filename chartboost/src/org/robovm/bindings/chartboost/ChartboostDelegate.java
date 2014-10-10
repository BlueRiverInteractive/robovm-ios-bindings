package org.robovm.bindings.chartboost;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

public interface ChartboostDelegate extends NSObjectProtocol {

	@Method(selector = "shouldRequestInterstitial:")
	boolean shouldRequestInterstitial(String location);

	@Method(selector = "shouldDisplayInterstitial:")
	boolean shouldDisplayInterstitial(String location);

	@Method(selector = "didDisplayInterstitial:")
	void didDisplayInterstitial(String location);

	@Method(selector = "didCacheInterstitial:")
	void didCacheInterstitial(String location);

	@Method(selector = "didFailToLoadInterstitial:withError:")
	void didFailToLoadInterstitial(String location, CBLoadError loadError);

	@Method(selector = "didFailToRecordClick:withError:")
	void didFailToRecordClick(String location, CBClickError clickError);

	@Method(selector = "didDismissInterstitial:")
	void didDismissInterstitial(String location);

	@Method(selector = "didCloseInterstitial:")
	void didCloseInterstitial(String location);

	@Method(selector = "didClickInterstitial:")
	void didClickInterstitial(String location);

	@Method(selector = "shouldDisplayMoreApps:")
	boolean shouldDisplayMoreApps(String location);

	@Method(selector = "didCacheMoreApps:")
	void didCacheMoreApps(String location);

	@Method(selector = "didDismissMoreApps:")
	void didDismissMoreApps(String location);

	@Method(selector = "didCloseMoreApps:")
	void didCloseMoreApps(String location);

	@Method(selector = "didClickMoreApps:")
	void didClickMoreApps(String location);

	@Method(selector = "didFailToLoadMoreApps:withError:")
	void didFailToLoadMoreApps(String location, CBLoadError loadError);

}

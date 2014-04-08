
package org.robovm.bindings.chartboost;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

public interface ChartboostDelegate extends NSObjectProtocol {
	@Method(selector = "shouldRequestInterstitial:")
	boolean shouldRequestInterstitial (String location);

	@Method(selector = "shouldDisplayInterstitial:")
	boolean shouldDisplayInterstitial (String location);

	@Method(selector = "didCacheInterstitial:")
	void didCacheInterstitial (String location);

	@Method(selector = "didFailToLoadInterstitial:")
	void didFailToLoadInterstitial (String location);

	@Method(selector = "didDismissInterstitial:")
	void didDismissInterstitial (String location);

	@Method(selector = "didCloseInterstitial:")
	void didCloseInterstitial (String location);

	@Method(selector = "didClickInterstitial:")
	void didClickInterstitial (String location);

	@Method(selector = "shouldDisplayLoadingViewForMoreApps")
	boolean shouldDisplayLoadingViewForMoreApps ();

	@Method(selector = "shouldDisplayMoreApps")
	boolean shouldDisplayMoreApps ();

	@Method(selector = "didCacheMoreApps")
	void didCacheMoreApps ();

	@Method(selector = "didFailToLoadMoreApps")
	void didFailToLoadMoreApps ();

	@Method(selector = "didDismissMoreApps")
	void didDismissMoreApps ();

	@Method(selector = "didCloseMoreApps")
	void didCloseMoreApps ();

	@Method(selector = "didClickMoreApps")
	void didClickMoreApps ();

	@Method(selector = "shouldRequestInterstitialsInFirstSession")
	boolean shouldRequestInterstitialsInFirstSession ();
}

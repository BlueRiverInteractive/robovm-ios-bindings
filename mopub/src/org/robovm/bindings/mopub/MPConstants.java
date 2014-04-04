
package org.robovm.bindings.mopub;

import org.robovm.apple.coregraphics.CGSize;

public class MPConstants {
	// Sizing constants.
	public static final CGSize MOPUB_BANNER_SIZE = new CGSize(320, 50);
	public static final CGSize MOPUB_MEDIUM_RECT_SIZE = new CGSize(300, 250);
	public static final CGSize MOPUB_LEADERBOARD_SIZE = new CGSize(728, 90);
	public static final CGSize MOPUB_WIDE_SKYSCRAPER_SIZE = new CGSize(160, 600);

	// Timeout constants.
	public static final float MINIMUM_REFRESH_INTERVAL = 5;
	public static final float DEFAULT_BANNER_REFRESH_INTERVAL = 60;
	public static final float BANNER_TIMEOUT_INTERVAL = 10;
	public static final float INTERSTITIAL_TIMEOUT_INTERVAL = 30;
}

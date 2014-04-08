
package org.robovm.bindings.apple.gamekit;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;

@Deprecated
public interface GKLeaderboardViewControllerDelegate extends NSObjectProtocol {

	// - (void)leaderboardViewControllerDidFinish:(GKLeaderboardViewController *)viewController;
	/** The leaderboard view has finished
	 * @param viewController */
	void leaderboardViewControllerDidFinish (GKLeaderboardViewController viewController);

	public static class Adapter extends NSObject implements GKLeaderboardViewControllerDelegate {
		@Override
		public void leaderboardViewControllerDidFinish (GKLeaderboardViewController viewController) {
		}
	}

	static class Callbacks {
		@Callback
		@BindSelector("leaderboardViewControllerDidFinish:")
		public static void leaderboardViewControllerDidFinish (GKLeaderboardViewControllerDelegate __self__, Selector __cmd__,
			GKLeaderboardViewController viewController) {
			__self__.leaderboardViewControllerDidFinish(viewController);
		}
	}

}

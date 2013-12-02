
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;

public interface GPGLeaderboardsControllerDelegate extends NSObjectProtocol {

	// - (void)leaderboardsViewControllerDidFinish:(GPGLeaderboardsController *)viewController;
	void leaderboardsViewControllerDidFinish (GPGLeaderboardsController viewController);

	public static class Adapter extends NSObject implements GPGLeaderboardsControllerDelegate {
		@Override
		public void leaderboardsViewControllerDidFinish (GPGLeaderboardsController viewController) {
		}
	}

	static class Callbacks {
		@Callback
		@BindSelector("leaderboardsViewControllerDidFinish:")
		public static void leaderboardsViewControllerDidFinish (GPGLeaderboardsControllerDelegate __self__, Selector __cmd__,
			GPGLeaderboardsController viewController) {
			__self__.leaderboardsViewControllerDidFinish(viewController);
		}
	}
}

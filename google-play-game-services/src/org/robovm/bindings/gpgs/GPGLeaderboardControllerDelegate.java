
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;

public interface GPGLeaderboardControllerDelegate extends NSObjectProtocol {

	// - (void)leaderboardViewControllerDidFinish:(GPGLeaderboardController *)viewController;
	void leaderboardViewControllerDidFinish (GPGLeaderboardController viewController);

	public static class Adapter extends NSObject implements GPGLeaderboardControllerDelegate {
		@Override
		public void leaderboardViewControllerDidFinish (GPGLeaderboardController viewController) {
		}
	}

	static class Callbacks {
		@Callback
		@BindSelector("leaderboardViewControllerDidFinish:")
		public static void leaderboardViewControllerDidFinish (GPGLeaderboardControllerDelegate __self__, Selector __cmd__,
			GPGLeaderboardController viewController) {
			__self__.leaderboardViewControllerDidFinish(viewController);
		}
	}
}

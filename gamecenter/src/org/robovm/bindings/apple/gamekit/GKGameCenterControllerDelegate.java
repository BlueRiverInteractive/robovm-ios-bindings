
package org.robovm.bindings.apple.gamekit;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;

public interface GKGameCenterControllerDelegate extends NSObjectProtocol {

	// - (void)gameCenterViewControllerDidFinish:(GKGameCenterViewController *)gameCenterViewController NS_AVAILABLE_IOS(6_0);
	/** @param viewController */
	void gameCenterViewControllerDidFinish (GKGameCenterViewController gameCenterViewController);

	public static class Adapter extends NSObject implements GKGameCenterControllerDelegate {
		@Override
		public void gameCenterViewControllerDidFinish (GKGameCenterViewController gameCenterViewController) {
		}
	}

	static class Callbacks {
		@Callback
		@BindSelector("gameCenterViewControllerDidFinish:")
		public static void gameCenterViewControllerDidFinish (GKGameCenterControllerDelegate __self__, Selector __cmd__,
			GKGameCenterViewController gameCenterViewController) {
			__self__.gameCenterViewControllerDidFinish(gameCenterViewController);
		}
	}

}

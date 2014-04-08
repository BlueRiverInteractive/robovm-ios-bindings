
package org.robovm.bindings.apple.gamekit;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;

@Deprecated
public interface GKAchievementViewControllerDelegate extends NSObjectProtocol {

	// - (void)achievementViewControllerDidFinish:(GKAchievementViewController *)viewController;
	/** The achievement view has finished
	 * @param viewController */
	void achievementViewControllerDidFinish (GKAchievementViewController viewController);

	public static class Adapter extends NSObject implements GKAchievementViewControllerDelegate {
		@Override
		public void achievementViewControllerDidFinish (GKAchievementViewController viewController) {
		}
	}

	static class Callbacks {
		@Callback
		@BindSelector("achievementViewControllerDidFinish:")
		public static void achievementViewControllerDidFinish (GKAchievementViewControllerDelegate __self__, Selector __cmd__,
			GKAchievementViewController viewController) {
			__self__.achievementViewControllerDidFinish(viewController);
		}
	}

}


package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;

public interface GPGAchievementControllerDelegate extends NSObjectProtocol {

	// Called when the user has tapped the "Done" button in the GPGAchievementController.
	// - (void) achievementViewControllerDidFinish:(GPGAchievementController *) viewController
	void achievementViewControllerDidFinish (GPGAchievementController viewController);

	public static class Adapter extends NSObject implements GPGAchievementControllerDelegate {
		@Override
		public void achievementViewControllerDidFinish (GPGAchievementController viewController) {
		}
	}

	static class Callbacks {
		@Callback
		@BindSelector("achievementViewControllerDidFinish:")
		public static void achievementViewControllerDidFinish (GPGAchievementControllerDelegate __self__, Selector __cmd__,
			GPGAchievementController viewController) {
			__self__.achievementViewControllerDidFinish(viewController);
		}
	}
}

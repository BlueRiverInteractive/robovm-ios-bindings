
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGAchievementDidSetStepsBlock {

	void invoke (boolean newlyUnlocked, int currentSteps, NSError error);

}

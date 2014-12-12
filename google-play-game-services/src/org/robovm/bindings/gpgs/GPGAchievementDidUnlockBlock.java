
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGAchievementDidUnlockBlock {

	/** Runs this block. */
	void invoke (boolean newlyUnlocked, NSError error);

}

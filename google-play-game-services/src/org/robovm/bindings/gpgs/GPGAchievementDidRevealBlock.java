
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGAchievementDidRevealBlock {

	/** Runs this block. */
	void invoke (GPGAchievementState state, NSError error);

}

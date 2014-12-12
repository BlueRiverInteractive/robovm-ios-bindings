
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGAchievementMetadataBlock {

	/** Runs this block. */
	void invoke (GPGAchievementMetadata metadata, NSError error);

}

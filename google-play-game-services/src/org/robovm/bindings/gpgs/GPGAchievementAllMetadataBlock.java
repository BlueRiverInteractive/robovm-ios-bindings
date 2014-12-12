
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSError;

public interface GPGAchievementAllMetadataBlock {

	/** Runs this block. */
	void invoke (NSArray metadata, NSError error);

}

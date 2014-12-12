
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSError;

public interface GPGLeaderboardLoadScoresBlock {
	void invoke (NSArray<GPGScore> scores, NSError error);
}

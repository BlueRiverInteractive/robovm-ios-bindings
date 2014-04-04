
package org.robovm.bindings.openkit;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSError;

public interface OKScoresResponseHandler {
	void invoke (NSArray<OKScore> scores, NSError error);
}

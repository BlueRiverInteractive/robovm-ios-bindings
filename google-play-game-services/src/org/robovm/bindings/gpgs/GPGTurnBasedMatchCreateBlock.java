package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGTurnBasedMatchCreateBlock {
	void invoke(GPGTurnBasedMatch match, NSError error);
}

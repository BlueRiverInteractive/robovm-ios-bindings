package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGTurnBasedMatchGetBlock {
	void invoke(GPGTurnBasedMatch match, NSError error);
}

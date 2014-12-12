package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGTurnBasedMatchRematchBlock {
	void invoke(GPGTurnBasedMatch rematch, NSError error);
}

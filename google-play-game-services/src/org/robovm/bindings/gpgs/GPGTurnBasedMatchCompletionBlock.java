package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGTurnBasedMatchCompletionBlock {
	void invoke(NSError error);
}

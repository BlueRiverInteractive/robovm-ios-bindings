package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGQuestCompletionBlock {
	void invoke(NSError error);
}

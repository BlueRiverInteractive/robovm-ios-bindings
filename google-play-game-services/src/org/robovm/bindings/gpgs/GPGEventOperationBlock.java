package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGEventOperationBlock {
	void invoke(GPGEvent event, NSError error);
}

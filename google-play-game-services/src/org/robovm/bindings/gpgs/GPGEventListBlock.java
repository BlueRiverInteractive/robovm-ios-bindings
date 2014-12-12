package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSError;

public interface GPGEventListBlock {
	void invoke(NSArray events, NSError error);
}

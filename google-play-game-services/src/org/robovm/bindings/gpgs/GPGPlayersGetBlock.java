package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSError;

public interface GPGPlayersGetBlock {
	void invoke(NSArray players, NSError error);
}

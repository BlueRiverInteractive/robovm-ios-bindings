package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSError;

public interface GPGListRoomsHandler {
	void invoke(NSArray rooms, NSError error);
}

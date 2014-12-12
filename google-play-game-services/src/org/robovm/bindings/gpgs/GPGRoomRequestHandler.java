package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGRoomRequestHandler {
	void invoke(GPGRealTimeRoomData data, NSError error);
}

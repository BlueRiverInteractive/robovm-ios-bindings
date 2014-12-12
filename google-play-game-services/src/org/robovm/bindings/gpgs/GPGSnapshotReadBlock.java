package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSError;

public interface GPGSnapshotReadBlock {
	void invoke(NSData data, NSError error);
}

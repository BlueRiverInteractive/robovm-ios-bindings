package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSError;

public interface GPGSnapshotListBlock {
	void invoke(NSArray snapshotMetadata, NSError error);
}

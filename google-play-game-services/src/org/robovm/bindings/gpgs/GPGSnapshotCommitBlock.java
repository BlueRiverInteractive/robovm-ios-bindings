package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGSnapshotCommitBlock {
	void invoke(GPGSnapshotMetadata snapshotMetadata, NSError error);
}

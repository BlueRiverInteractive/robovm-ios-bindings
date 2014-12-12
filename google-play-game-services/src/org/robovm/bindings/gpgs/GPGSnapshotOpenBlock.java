package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGSnapshotOpenBlock {
	void invoke(GPGSnapshotMetadata snapshot, String conflictId, GPGSnapshotMetadata conflictingSnapshot, GPGSnapshotMetadata conflictingSnapshotUnmerged, NSError error);
}

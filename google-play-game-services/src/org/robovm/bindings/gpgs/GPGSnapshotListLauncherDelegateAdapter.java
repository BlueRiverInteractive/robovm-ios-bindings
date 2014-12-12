package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NotImplemented;

public class GPGSnapshotListLauncherDelegateAdapter extends NSObject implements GPGSnapshotListLauncherDelegate {

	@NotImplemented("snapshotListLauncherDidTapSnapshotMetadata:")
	public void snapshotListLauncherDidTapSnapshotMetadata(GPGSnapshotMetadata snapshot) { throw new UnsupportedOperationException(); }

	@NotImplemented("snapshotListLauncherDidCreateNewSnapshot")
	public void snapshotListLauncherDidCreateNewSnapshot() { throw new UnsupportedOperationException(); }

	@NotImplemented("titleForSnapshotListLauncher")
	public String titleForSnapshotListLauncher() { throw new UnsupportedOperationException(); } 

	@NotImplemented("shouldAllowCreateForSnapshotListLauncher")
	public boolean shouldAllowCreateForSnapshotListLauncher() { throw new UnsupportedOperationException(); }

	@NotImplemented("shouldAllowDeleteForSnapshotListLauncher")
	public boolean shouldAllowDeleteForSnapshotListLauncher() { throw new UnsupportedOperationException(); }

	@NotImplemented("maxSaveSlotsForSnapshotListLauncher")
	public int maxSaveSlotsForSnapshotListLauncher() { throw new UnsupportedOperationException(); }

}

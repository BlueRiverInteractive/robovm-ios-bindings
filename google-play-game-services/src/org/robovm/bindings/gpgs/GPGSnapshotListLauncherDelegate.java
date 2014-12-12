package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

public interface GPGSnapshotListLauncherDelegate extends NSObjectProtocol {

	@Method(selector = "snapshotListLauncherDidTapSnapshotMetadata:")
	void snapshotListLauncherDidTapSnapshotMetadata(GPGSnapshotMetadata snapshot);
	
	@Method(selector = "snapshotListLauncherDidCreateNewSnapshot")
	void snapshotListLauncherDidCreateNewSnapshot();
	
	@Method(selector = "titleForSnapshotListLauncher")
	String titleForSnapshotListLauncher();
	
	@Method(selector = "shouldAllowCreateForSnapshotListLauncher")
	boolean shouldAllowCreateForSnapshotListLauncher();

	@Method(selector = "shouldAllowDeleteForSnapshotListLauncher")
	boolean shouldAllowDeleteForSnapshotListLauncher();

	@Method(selector = "maxSaveSlotsForSnapshotListLauncher")
	int maxSaveSlotsForSnapshotListLauncher();
}

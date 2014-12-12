package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

public enum GPGSnapshotConflictPolicy implements ValuedEnum {
	GPGSnapshotConflictPolicyManual(0),
	GPGSnapshotConflictPolicyLongestPlaytime(1),
	GPGSnapshotConflictPolicyLastKnownGood(2),
	GPGSnapshotConflictPolicyMostRecentlyModified(3);

	private final long n;

	private GPGSnapshotConflictPolicy (long n) {
	  this.n = n;
	}

	@Override
	public long value () {
	  return n;
	}
}

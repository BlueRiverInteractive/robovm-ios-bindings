
package org.robovm.bindings.facebook;

import org.robovm.rt.bro.ValuedEnum;

/** Indicates whether friends should be displayed first-name-first or last-name-first. */
public enum FBFriendDisplayOrdering implements ValuedEnum {
	/** Display friends as First Middle Last. */
	FirstName,
	/** Display friends as Last First Middle. */
	LastName;

	@Override
	public long value () {
		return ordinal();
	}
}

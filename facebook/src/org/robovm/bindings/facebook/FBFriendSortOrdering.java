
package org.robovm.bindings.facebook;

import org.robovm.rt.bro.ValuedEnum;

/** Indicates the order in which friends should be listed in the friend picker. */
public enum FBFriendSortOrdering implements ValuedEnum {
	/** Sort friends by first, middle, last names. */
	FirstName,
	/** Sort friends by last, first, middle names. */
	LastName;

	@Override
	public long value () {
		return ordinal();
	}
}

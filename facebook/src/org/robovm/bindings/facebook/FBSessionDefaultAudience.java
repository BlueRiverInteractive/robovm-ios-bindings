
package org.robovm.bindings.facebook;

import org.robovm.rt.bro.ValuedEnum;

public enum FBSessionDefaultAudience implements ValuedEnum {
	/* ! No audience needed; this value is useful for cases where data will only be read from Facebook */
	None(0),
	/* ! Indicates that only the user is able to see posts made by the application */
	OnlyMe(10),
	/* ! Indicates that the user's friends are able to see posts made by the application */
	Friends(20),
	/* ! Indicates that all Facebook users are able to see posts made by the application */
	Everyone(30);

	private final int n;

	private FBSessionDefaultAudience (int n) {
		this.n = n;
	}

	@Override
	public int value () {
		return n;
	}
}

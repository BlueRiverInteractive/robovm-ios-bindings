
package org.robovm.bindings.flurry.ads;

import org.robovm.rt.bro.ValuedEnum;

public enum FlurryAdSize implements ValuedEnum {
	BANNER_TOP(1), BANNER_BOTTOM(2), FULLSCREEN(3);

	private final long n;

	FlurryAdSize (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}

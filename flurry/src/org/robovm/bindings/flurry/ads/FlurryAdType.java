
package org.robovm.bindings.flurry.ads;

import org.robovm.rt.bro.ValuedEnum;

public enum FlurryAdType implements ValuedEnum {
	WEB_BANNER(1), WEB_TAKEOVER(2), VIDEO_TAKEOVER(3), AD_BANNER(4), AD_TAKEOVER(5), NETWORK_BANNER(6), NETWORK_TAKEOVER(7);

	private final long n;

	FlurryAdType (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}

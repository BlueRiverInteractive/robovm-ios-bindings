
package org.robovm.bindings.mopub;

import org.robovm.rt.bro.ValuedEnum;

public enum MPNativeAdOrientation implements ValuedEnum {
	Any(0), Portrait(1), Landscape(2);

	private final long n;

	private MPNativeAdOrientation (int n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}

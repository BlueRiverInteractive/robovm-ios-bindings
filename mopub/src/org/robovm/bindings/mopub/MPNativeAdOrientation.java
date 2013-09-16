package org.robovm.bindings.mopub;

import org.robovm.rt.bro.ValuedEnum;

public enum MPNativeAdOrientation implements ValuedEnum {
	Any(0), Portrait(1), Landscape(2);

	private final int n;

	private MPNativeAdOrientation(int n) {
		this.n = n;
	}

	@Override
	public int value() {
		return n;
	}
}

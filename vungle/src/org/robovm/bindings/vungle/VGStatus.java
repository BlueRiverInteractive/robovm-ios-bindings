package org.robovm.bindings.vungle;

import org.robovm.rt.bro.ValuedEnum;

public enum VGStatus implements ValuedEnum {
	Okay(0), NetworkError(1), DiskError(2);

	private final int n;

	private VGStatus(int n) {
		this.n = n;
	}

	@Override
	public int value() {
		return n;
	}
}
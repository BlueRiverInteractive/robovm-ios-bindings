package org.robovm.bindings.vungle;

import org.robovm.rt.bro.ValuedEnum;

public enum VGAdOrientation implements ValuedEnum {
	Unknown(0), Portrait(1), Landscape(2);

	private final int n;

	private VGAdOrientation(int n) {
		this.n = n;
	}

	@Override
	public int value() {
		return n;
	}
}
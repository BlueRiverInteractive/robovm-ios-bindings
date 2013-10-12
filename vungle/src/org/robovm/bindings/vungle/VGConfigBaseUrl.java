package org.robovm.bindings.vungle;

import org.robovm.rt.bro.ValuedEnum;

public enum VGConfigBaseUrl implements ValuedEnum {
	Prod(0), Test(1), Localhost(2);

	private final int n;

	private VGConfigBaseUrl(int n) {
		this.n = n;
	}

	@Override
	public int value() {
		return n;
	}
}
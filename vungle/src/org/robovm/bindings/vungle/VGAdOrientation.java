
package org.robovm.bindings.vungle;

import org.robovm.rt.bro.ValuedEnum;

public enum VGAdOrientation implements ValuedEnum {
	Unknown(0), Portrait(1), Landscape(2);

	private final long n;

	private VGAdOrientation (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}

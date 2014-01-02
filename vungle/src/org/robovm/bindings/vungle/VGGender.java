
package org.robovm.bindings.vungle;

import org.robovm.rt.bro.ValuedEnum;

public enum VGGender implements ValuedEnum {
	Unknown(0), VGGenderMale(1), VGGenderFemale(2);

	private final long n;

	private VGGender (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}

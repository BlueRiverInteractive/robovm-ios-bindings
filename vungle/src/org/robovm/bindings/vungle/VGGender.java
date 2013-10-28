
package org.robovm.bindings.vungle;

import org.robovm.rt.bro.ValuedEnum;

public enum VGGender implements ValuedEnum {
	Unknown(0), VGGenderMale(1), VGGenderFemale(2);

	private final int n;

	private VGGender (int n) {
		this.n = n;
	}

	@Override
	public int value () {
		return n;
	}
}

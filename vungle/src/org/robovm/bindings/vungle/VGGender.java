
package org.robovm.bindings.vungle;

import org.robovm.rt.bro.ValuedEnum;

public enum VGGender implements ValuedEnum {
	Unknown, VGGenderMale, VGGenderFemale;

	@Override
	public long value () {
		return ordinal();
	}
}

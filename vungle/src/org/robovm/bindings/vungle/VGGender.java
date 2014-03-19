
package org.robovm.bindings.vungle;

import org.robovm.rt.bro.ValuedEnum;

public enum VGGender implements ValuedEnum {
	Unknown, Male, Female;

	@Override
	public long value () {
		return ordinal();
	}
}

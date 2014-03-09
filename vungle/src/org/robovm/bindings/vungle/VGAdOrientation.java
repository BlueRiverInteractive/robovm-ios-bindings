
package org.robovm.bindings.vungle;

import org.robovm.rt.bro.ValuedEnum;

public enum VGAdOrientation implements ValuedEnum {
	Unknown, Portrait, Landscape;

	@Override
	public long value () {
		return ordinal();
	}
}


package org.robovm.bindings.vungle;

import org.robovm.rt.bro.ValuedEnum;

public enum VGStatus implements ValuedEnum {
	Okay, NetworkError, DiskError;

	@Override
	public long value () {
		return ordinal();
	}
}

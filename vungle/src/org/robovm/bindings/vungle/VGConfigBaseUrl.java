
package org.robovm.bindings.vungle;

import org.robovm.rt.bro.ValuedEnum;

public enum VGConfigBaseUrl implements ValuedEnum {
	Prod, Test, Localhost;

	@Override
	public long value () {
		return ordinal();
	}
}

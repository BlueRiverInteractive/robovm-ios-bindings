
package org.robovm.bindings.vungle;

import org.robovm.rt.bro.ValuedEnum;

public enum VGConfigBaseUrl implements ValuedEnum {
	Prod(0), Test(1), Localhost(2);

	private final long n;

	private VGConfigBaseUrl (int n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}

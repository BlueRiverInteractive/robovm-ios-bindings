
package org.robovm.bindings.vungle;

import org.robovm.rt.bro.ValuedEnum;

public enum VGAdType implements ValuedEnum {
	Unknown(0), Real(1), FakePreBundleHTML(2), FakePreBundleZip(3), FakePostBundleHTML(4), FakePostBundleZip(5), FakeMovie(6), FakeFirst(
		2), FakeLast(6);

	private final long n;

	private VGAdType (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}


package org.robovm.bindings.mopub;

import org.robovm.rt.bro.ValuedEnum;

public enum MPNativeAdOrientation implements ValuedEnum {
	Any, Portrait, Landscape;

	@Override
	public long value () {
		return ordinal();
	}
}

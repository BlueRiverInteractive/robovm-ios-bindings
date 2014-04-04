
package org.robovm.bindings.googleanalytics;

import org.robovm.rt.bro.ValuedEnum;

public enum GAILogLevel implements ValuedEnum {
	None, Error, Warning, Info, Verbose;

	@Override
	public long value () {
		return ordinal();
	}
}

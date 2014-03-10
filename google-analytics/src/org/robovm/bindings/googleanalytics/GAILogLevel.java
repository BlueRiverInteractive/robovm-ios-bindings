
package org.robovm.bindings.googleanalytics;

import org.robovm.rt.bro.ValuedEnum;

public enum GAILogLevel implements ValuedEnum {

	kGAILogLevelNone(0), kGAILogLevelError(1), kGAILogLevelWarning(2), kGAILogLevelInfo(3), kGAILogLevelVerbose(4);

	private final long n;

	private GAILogLevel (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}

}

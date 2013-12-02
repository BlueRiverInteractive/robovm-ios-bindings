package com.googleanalytics.robovmbindings;

import org.robovm.rt.bro.ValuedEnum;

public enum GAILogLevel implements ValuedEnum{

	kGAILogLevelNone(0),
	kGAILogLevelError(1),
	kGAILogLevelWarning(2),
	kGAILogLevelInfo(3),
	kGAILogLevelVerbose(4);
	
	private final int n;

	private GAILogLevel(int n) {
		this.n = n;
	}

	public int value() {
		return n;
	}

}

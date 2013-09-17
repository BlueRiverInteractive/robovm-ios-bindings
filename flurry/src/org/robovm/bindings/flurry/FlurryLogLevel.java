package org.robovm.bindings.flurry;

import org.robovm.rt.bro.ValuedEnum;

/**
 * Enum for setting up log output level.
 * 
 * @since 4.2.2
 */
public enum FlurryLogLevel implements ValuedEnum {
	/**
	 * No log output.
	 */
	None(0),
	/**
	 * Outputs only critical log events.
	 */
	CriticalOnly(1),
	/**
	 * Outputs critical and main log events.
	 */
	Debug(2),
	/**
	 * Outputs all log events.
	 */
	All(3);

	private final int n;

	private FlurryLogLevel(int n) {
		this.n = n;
	}

	@Override
	public int value() {
		return n;
	}
}
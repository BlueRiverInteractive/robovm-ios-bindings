
package org.robovm.bindings.flurry.analytics;

import org.robovm.rt.bro.ValuedEnum;

/** Enum for setting up log output level.
 * 
 * @since 4.2.2 */
public enum FlurryLogLevel implements ValuedEnum {
	/** No log output. */
	None,
	/** Outputs only critical log events. */
	CriticalOnly,
	/** Outputs critical and main log events. */
	Debug,
	/** Outputs all log events. */
	All;

	@Override
	public long value () {
		return ordinal();
	}
}

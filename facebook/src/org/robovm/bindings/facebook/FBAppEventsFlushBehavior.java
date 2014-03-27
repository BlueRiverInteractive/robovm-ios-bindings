
package org.robovm.bindings.facebook;

import org.robovm.rt.bro.ValuedEnum;

/** Control when {@link FBAppEvents} sends log events to the server. */
public enum FBAppEventsFlushBehavior implements ValuedEnum {
	/** Flush automatically: periodically (once a minute or every 100 logged events) and always at app reactivation. */
	Auto,
	/** Only flush when the {@link FBAppEvents#flush()} method is called. When an app is moved to background/terminated, the events
	 * are persisted and re-established at activation, but they will only be written with an explicit call to `flush`. */
	ExplicitOnly;

	@Override
	public long value () {
		return ordinal();
	}
}

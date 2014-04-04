
package org.robovm.bindings.playhaven;

import org.robovm.rt.bro.ValuedEnum;

public enum PHPublisherContentRequestState implements ValuedEnum {
	Initialized, Preloading, Preloaded, DisplayingContent, Done;

	@Override
	public long value () {
		return ordinal();
	}
}

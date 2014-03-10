
package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

/** @author Michael Hadash */

public enum GPGRevisionStatus implements ValuedEnum {
	GPGRevisionStatusUnknown(-1), GPGRevisionStatusOK(0), GPGRevisionStatusDeprecated(1), GPGRevisionStatusInvalid(2);

	private final long n;

	private GPGRevisionStatus (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}

}


package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

/** @author Michael Hadash */

public enum GPGToastPlacement implements ValuedEnum {
	GPGToastPlacementTop(0), GPGToastPlacementBottom(1), GPGToastPlacementCenter(2);

	private final long n;

	private GPGToastPlacement (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}

}

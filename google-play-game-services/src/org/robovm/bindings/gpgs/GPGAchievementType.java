
package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

/** @author Michael Hadash */

// note: these are correct
public enum GPGAchievementType implements ValuedEnum {
	GPGAchievementTypeUnknown(-1), GPGAchievementTypeStandard(0), GPGAchievementTypeIncremental(1);

	private final long n;

	private GPGAchievementType (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}

}

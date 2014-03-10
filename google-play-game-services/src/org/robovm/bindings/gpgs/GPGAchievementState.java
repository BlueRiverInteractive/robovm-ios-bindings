
package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

/** @author Michael Hadash */

// note: these are correct
public enum GPGAchievementState implements ValuedEnum {
	GPGAchievementStateUnknown(-1), GPGAchievementStateHidden(0), GPGAchievementStateRevealed(1), GPGAchievementStateUnlocked(2);

	private final long n;

	private GPGAchievementState (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}

}

package com.michingo.robovmbindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

/** 
 * @author Michael Hadash */

//note: these are correct
public enum GPGAchievementState implements ValuedEnum{
	GPGAchievementStateUnknown(-1),
	GPGAchievementStateHidden(0),
	GPGAchievementStateRevealed(1),
	GPGAchievementStateUnlocked(2);

    private final int n;

    private GPGAchievementState(int n) {
        this.n = n;
    }

    public int value() {
        return n;
    }

}

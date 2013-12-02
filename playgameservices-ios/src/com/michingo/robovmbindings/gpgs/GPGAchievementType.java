package com.michingo.robovmbindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

/** 
 * @author Michael Hadash */

//note: these are correct
public enum GPGAchievementType implements ValuedEnum{
	GPGAchievementTypeUnknown(-1),
	GPGAchievementTypeStandard(0),
	GPGAchievementTypeIncremental(1);

    private final int n;

    private GPGAchievementType(int n) {
        this.n = n;
    }

    public int value() {
        return n;
    }

}

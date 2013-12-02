package com.michingo.robovmbindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

/** 
 * @author Michael Hadash */

public enum GPGLeaderboardOrder implements ValuedEnum{
	GPGLeaderboardOrderUnknown(-1),
	GPGLeaderboardOrderLargerIsBetter(0),
	GPGLeaderboardOrderSmallerIsBetter(1);

    private final int n;

    private GPGLeaderboardOrder(int n) {
        this.n = n;
    }

    public int value() {
        return n;
    }

}

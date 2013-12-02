package com.michingo.robovmbindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

/** 
 * @author Michael Hadash */

public enum GPGLeaderboardTimeScope implements ValuedEnum{
	GPGLeaderboardTimeScopeUnknown(-1),
	GPGLeaderboardTimeScopeToday(1),
	GPGLeaderboardTimeScopeThisWeek(2),
	GPGLeaderboardTimeScopeAllTime(3);

    private final int n;

    private GPGLeaderboardTimeScope(int n) {
        this.n = n;
    }

    public int value() {
        return n;
    }

}

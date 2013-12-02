package com.michingo.robovmbindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

/** 
 * @author Michael Hadash */

public enum GPGRevisionStatus implements ValuedEnum{
	GPGRevisionStatusUnknown(-1),
	GPGRevisionStatusOK(0),
	GPGRevisionStatusDeprecated(1),
	GPGRevisionStatusInvalid(2);

    private final int n;

    private GPGRevisionStatus(int n) {
        this.n = n;
    }

    public int value() {
        return n;
    }

}

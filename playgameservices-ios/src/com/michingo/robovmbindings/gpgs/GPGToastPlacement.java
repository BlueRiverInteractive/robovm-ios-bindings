package com.michingo.robovmbindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

/** 
 * @author Michael Hadash */

public enum GPGToastPlacement implements ValuedEnum{
	GPGToastPlacementTop(0),
	GPGToastPlacementBottom(1),
	GPGToastPlacementCenter(2);

    private final int n;

    private GPGToastPlacement(int n) {
        this.n = n;
    }

    public int value() {
        return n;
    }

}

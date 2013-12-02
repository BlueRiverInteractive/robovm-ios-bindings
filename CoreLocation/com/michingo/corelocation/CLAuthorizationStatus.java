package com.michingo.corelocation;

import org.robovm.rt.bro.ValuedEnum;

public enum CLAuthorizationStatus implements ValuedEnum{
	kCLAuthorizationStatusNotDetermined(0),
	kCLAuthorizationStatusRestricted(1),
	kCLAuthorizationStatusDenied(2),
	kCLAuthorizationStatusAuthorized(3);

    private final int n;

    private CLAuthorizationStatus(int n) {
        this.n = n;
    }

    public int value() {
        return n;
    }

}

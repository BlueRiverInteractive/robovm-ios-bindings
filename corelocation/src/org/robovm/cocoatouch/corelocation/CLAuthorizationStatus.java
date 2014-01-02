
package org.robovm.cocoatouch.corelocation;

import org.robovm.rt.bro.ValuedEnum;

public enum CLAuthorizationStatus implements ValuedEnum {
	kCLAuthorizationStatusNotDetermined(0), kCLAuthorizationStatusRestricted(1), kCLAuthorizationStatusDenied(2), kCLAuthorizationStatusAuthorized(
		3);

	private final long n;

	private CLAuthorizationStatus (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}

}

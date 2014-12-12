package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

public enum GPGPushNotificationEnvironment implements ValuedEnum {
	GPGPushNotificationEnvironmentUnknown(0),
	GPGPushNotificationEnvironmentProduction(1),
	GPGPushNotificationEnvironmentSandbox(2),
	GPGPushNotificationEnvironment(3);

	private final long n;

	private GPGPushNotificationEnvironment (long n) {
	  this.n = n;
	}

	@Override
	public long value () {
	  return n;
	}
}

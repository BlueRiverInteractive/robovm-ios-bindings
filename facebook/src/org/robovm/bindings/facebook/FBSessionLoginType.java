
package org.robovm.bindings.facebook;

import org.robovm.rt.bro.ValuedEnum;

public enum FBSessionLoginType implements ValuedEnum {
	/* ! A login type has not yet been established */
	None(0),
	/* ! A system integrated account was used to log the user into the application */
	FSystemAccount(1),
	/* ! The Facebook native application was used to log the user into the application */
	FacebookApplication(2),
	/* ! Safari was used to log the user into the application */
	FacebookViaSafari(3),
	/* ! A web view was used to log the user into the application */
	WebView(4),
	/* ! A test user was used to create an open session */
	TestUser(5);

	private final int n;

	private FBSessionLoginType (int n) {
		this.n = n;
	}

	@Override
	public int value () {
		return n;
	}

}

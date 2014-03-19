
package org.robovm.bindings.facebook.session;

import org.robovm.rt.bro.ValuedEnum;

/** Used as the type of the loginType property in order to specify what underlying technology was used to login the user.
 * 
 * The {@link FBSession} object is an abstraction over five distinct mechanisms. This enum allows an application to test for the
 * mechanism used by a particular instance of FBSession. Usually the mechanism used for a given login does not matter, however for
 * certain capabilities, the type of login can impact the behavior of other Facebook functionality. */
public enum FBSessionLoginType implements ValuedEnum {
	/** A login type has not yet been established. */
	None,
	/** A system integrated account was used to log the user into the application. */
	SystemAccount,
	/** The Facebook native application was used to log the user into the application. */
	FacebookApplication,
	/** Safari was used to log the user into the application. */
	FacebookViaSafari,
	/** A web view was used to log the user into the application. */
	WebView,
	/** A test user was used to create an open session. */
	TestUser;

	@Override
	public long value () {
		return ordinal();
	}

}


package org.robovm.bindings.facebook.session;

import org.robovm.rt.bro.ValuedEnum;

/** Passed to open to indicate which default audience to use for sessions that post data to Facebook.
 * 
 * Certain operations such as publishing a status or publishing a photo require an audience. When the user grants an application
 * permission to perform a publish operation, a default audience is selected as the publication ceiling for the application. This
 * enumerated value allows the application to select which audience to ask the user to grant publish permission for. */
public enum FBSessionDefaultAudience implements ValuedEnum {
	/** No audience needed; this value is useful for cases where data will only be read from Facebook. */
	None(0),
	/** Indicates that only the user is able to see posts made by the application. */
	OnlyMe(10),
	/** Indicates that the user's friends are able to see posts made by the application. */
	Friends(20),
	/** Indicates that all Facebook users are able to see posts made by the application. */
	Everyone(30);

	private final long n;

	private FBSessionDefaultAudience (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}


package org.robovm.bindings.facebook.error;

import org.robovm.rt.bro.ValuedEnum;

/*** Indicates the Facebook SDK classification for the error. */
public enum FBErrorCategory implements ValuedEnum {
	/*** Indicates that the error category is invalid and likely represents an error that is unrelated to Facebook or the Facebook
	 * SDK. */
	Invalid(0),
	/*** Indicates that the error may be authentication related but the application should retry the operation. This case may involve
	 * user action that must be taken, and so the application should also test the fberrorShouldNotifyUser property and if YES
	 * display fberrorUserMessage to the user before retrying. */
	Retry(1),
	/** Indicates that the error is authentication related and the application should reopen the session. */
	AuthenticationReopenSession(2),
	/** Indicates that the error is permission related. */
	Permissions(3),
	/** Indicates that the error implies that the server had an unexpected failure or may be temporarily down. */
	Server(4),
	/** Indicates that the error results from the server throttling the client. */
	Throttling(5),
	/** Indicates the user cancelled the operation. */
	UserCancelled(6),
	/** Indicates that the error is Facebook-related but is uncategorizable, and likely newer than the current version of the SDK. */
	FacebookOther(-1),
	/** Indicates that the error is an application error resulting in a bad or malformed request to the server. */
	BadRequest(-2);

	private long n;

	FBErrorCategory (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}

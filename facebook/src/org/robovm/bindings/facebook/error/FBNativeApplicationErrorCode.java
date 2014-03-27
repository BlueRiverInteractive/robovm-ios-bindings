
package org.robovm.bindings.facebook.error;

import org.robovm.bindings.facebook.FBAppCall;
import org.robovm.rt.bro.ValuedEnum;

/** Error codes returned by the Facebook SDK in NSError.
 * 
 * These are valid only in the scope of FacebookNativeApplicationDomain. */
public enum FBNativeApplicationErrorCode implements ValuedEnum {
	/** A general error in processing an {@link FBAppCall}, without a known cause. Unhandled exceptions are a good example. */
	AppCallUnknown(1),
	/** The {@link FBAppCall} cannot be processed for some reason. */
	AppCallUnsupported(2),
	/** The {@link FBAppCall} is for a method that does not exist (or is turned off). */
	AppCallUnknownMethod(3),
	/** The {@link FBAppCall} cannot be processed at the moment, but can be retried at a later time. */
	AppCallServiceBusy(4),
	/** Share was called in the native Facebook app with incomplete or incorrect arguments. */
	ShareInvalidParam(100),
	/** A server error occurred while calling Share in the native Facebook app. */
	ShareServer(102),
	/** An unknown error occurred while calling Share in the native Facebook app. */
	ShareUnknown(103),
	/** Disallowed from calling Share in the native Facebook app. */
	ShareDenied(104);

	private long n;

	FBNativeApplicationErrorCode (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}

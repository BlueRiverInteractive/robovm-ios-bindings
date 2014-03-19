
package org.robovm.bindings.facebook.error;

import org.robovm.rt.bro.ValuedEnum;

/** Error codes returned by the Facebook SDK in NSError.
 * 
 * These are valid only in the scope of FacebookSDKDomain. */
public enum FBErrorCode implements ValuedEnum {
	/** Like nil for FBErrorCode values, represents an error code that has not been initialized yet. */
	Invalid,

	/** The operation failed because it was cancelled. */
	OperationCancelled,

	/** A login attempt failed. */
	LoginFailedOrCancelled,

	/** The graph API returned an error for this operation. */
	RequestConnectionApi,

	/** The operation failed because the server returned an unexpected response. You can get this error if you are not using the
	 * most recent SDK, or if you set your application's migration settings incorrectly for the version of the SDK you are using.
	 * 
	 * If this occurs on the current SDK with proper app migration settings, you may need to try changing to one request per batch. */
	ProtocolMismatch,

	/** Non-success HTTP status code was returned from the operation. */
	HTTPError,

	/** An endpoint that returns a binary response was used with FBRequestConnection; endpoints that return image/jpg, etc. should
	 * be accessed using NSURLRequest. */
	NonTextMimeTypeReturned,

	/** An error occurred while trying to display a native dialog. */
	Dialog,

	/** An error occurred using the FBAppEvents class. */
	AppEvents,

	/** An error occurred related to an iOS API call. */
	SystemAPI,

	/** An error occurred while trying to fetch publish install response data. */
	PublishInstallResponse,

	/** The application had its applicationDidBecomeActive: method called while waiting on a response from the native Facebook app
	 * for a pending FBAppCall. */
	AppActivatedWhilePendingAppCall,

	/** The application had its openURL: method called from a source that was not a Facebook app and with a URL that was intended
	 * for the AppBridge. */
	UntrustedURL,

	/** The URL passed to FBAppCall, was not able to be parsed. */
	MalformedURL,

	/** The operation failed because the session is currently busy reconnecting. */
	SessionReconnectInProgess;

	@Override
	public long value () {
		return ordinal();
	}
}

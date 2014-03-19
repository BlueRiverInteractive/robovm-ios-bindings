
package org.robovm.bindings.facebook.session;

import org.robovm.rt.bro.ValuedEnum;

/** Passed to open to indicate whether Facebook Login should allow for fallback to be attempted.
 * 
 * Facebook Login authorizes the application to act on behalf of the user, using the user's Facebook account. Usually a Facebook
 * Login will rely on an account maintained outside of the application, by the native Facebook application, the browser, or
 * perhaps the device itself. This avoids the need for a user to enter their username and password directly, and provides the most
 * secure and lowest friction way for a user to authorize the application to interact with Facebook. If a Facebook Login is not
 * possible, a fallback Facebook Login may be attempted, where the user is prompted to enter their credentials in a web-view
 * hosted directly by the application.
 * 
 * The FBSessionLoginBehavior enum specifies whether to allow fallback, disallow fallback, or force fallback login behavior. Most
 * applications will use the default, which attempts a normal Facebook Login, and only falls back if needed. In rare cases, it may
 * be preferable to disallow fallback Facebook Login completely, or to force a fallback login. */
public enum FBSessionLoginBehavior implements ValuedEnum {
	/** Attempt Facebook Login, ask user for credentials if necessary. */
	FallbackToWebView,
	/** Attempt Facebook Login, no direct request for credentials will be made. */
	NoFallbackToWebView,
	/** Only attempt WebView Login; ask user for credentials. */
	ForcingWebView,
	/** Attempt Facebook Login, prefering system account and falling back to fast app switch if necessary. */
	UseSystemAccountIfPresent;

	@Override
	public long value () {
		return ordinal();
	}
}


package org.robovm.bindings.facebook.session;

import org.robovm.apple.foundation.NSError;

/** Block type used to define blocks called by <[FBSession requestNewReadPermissions:completionHandler:]> and <[FBSession
 * requestNewPublishPermissions:defaultAudience:completionHandler:]>.
 * 
 * See https://developers.facebook.com/docs/technical-guides/iossdk/errors/ for error handling best practices.
 * 
 * Requesting additional permissions inside this handler (such as by calling `requestNewPublishPermissions`) should be avoided
 * because it is a poor user experience and its behavior may vary depending on the login type. You should request the permissions
 * closer to the operation that requires it (e.g., when the user performs some action). */
public interface FBSessionRequestPermissionResultHandler {
	void invoke (FBSession session, NSError error);
}

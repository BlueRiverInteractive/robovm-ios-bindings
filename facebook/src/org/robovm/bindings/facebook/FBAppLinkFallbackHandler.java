
package org.robovm.bindings.facebook;

import org.robovm.apple.foundation.NSError;

/** @see {@link FBAppCall#openDeferredAppLink(FBAppLinkFallbackHandler)} */
public interface FBAppLinkFallbackHandler {
	void invoke (NSError error);
}

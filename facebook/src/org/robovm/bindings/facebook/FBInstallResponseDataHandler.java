
package org.robovm.bindings.facebook;

import org.robovm.apple.foundation.NSError;

/** Block type used to get install data that is returned by server when publishInstall is called. */
public interface FBInstallResponseDataHandler {
	void invoke (FBGraphObject response, NSError error);
}


package org.robovm.bindings.facebook.dialogs;

import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSURL;

/** Defines a handler that will be called in response to the web dialog being dismissed */
public interface FBWebDialogHandler {
	void invoke (FBWebDialogResult result, NSURL url, NSError error);
}


package org.robovm.bindings.facebook.dialogs;

import org.robovm.apple.foundation.NSError;

/** Defines a handler that will be called in response to the native share dialog being displayed. */
public interface FBOSIntegratedShareDialogHandler {
	void invoke (FBOSIntegratedShareDialogResult result, NSError error);
}

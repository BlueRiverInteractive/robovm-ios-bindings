
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGAppStateWriteResultHandler {

	/** Runs this block. */
	void invoke (GPGAppStateWriteStatus status, NSError error);

}

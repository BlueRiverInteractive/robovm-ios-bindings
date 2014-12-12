
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGAppStateLoadResultHandler {

	/** Runs this block. */
	void invoke (GPGAppStateLoadStatus status, NSError error);

}

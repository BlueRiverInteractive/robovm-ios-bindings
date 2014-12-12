
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSNumber;

public interface GPGAppStateConflictHandler {

	/** Runs this block. */
	void invoke (NSNumber key,
            NSData localState,
            NSData remoteState);

}

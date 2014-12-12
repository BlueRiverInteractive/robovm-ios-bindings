
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSNumber;

public interface GPGAppStateListHandler {

	/** Runs this block. */
	void invoke (NSNumber key, NSData state, NSError error);

}


package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSNumber;

public interface GPGAppStateListKeysHandler {

	/** Runs this block. */
	void invoke (NSArray states, NSNumber maxKeyCount, NSError error);

}

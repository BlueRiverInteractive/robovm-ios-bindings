
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGModelDidLoadBlock {

	/** Runs this block. */
	void invoke (NSError error);

}

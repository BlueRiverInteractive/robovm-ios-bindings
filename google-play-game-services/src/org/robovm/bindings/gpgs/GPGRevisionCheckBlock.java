
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGRevisionCheckBlock {

	/** Runs this block. */
	void invoke (GPGRevisionStatus revisionStatus, NSError error);
}

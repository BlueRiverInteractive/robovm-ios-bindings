
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGScoreReportScoreBlock {
	void invoke (GPGScoreReport report, NSError error);
}

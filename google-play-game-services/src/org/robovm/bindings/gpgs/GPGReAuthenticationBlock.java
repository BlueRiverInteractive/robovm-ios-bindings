
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;

public interface GPGReAuthenticationBlock {
	void invoke (boolean requiresKeychainWipe, NSError error);
}

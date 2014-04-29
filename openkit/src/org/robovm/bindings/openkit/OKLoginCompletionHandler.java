
package org.robovm.bindings.openkit;

import org.robovm.apple.foundation.NSError;

public interface OKLoginCompletionHandler {
	public void invoke (OKUser user, NSError error);
}

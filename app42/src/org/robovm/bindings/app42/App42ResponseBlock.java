package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSObject;

public interface App42ResponseBlock {
	void invoke(boolean success, NSObject responseObj, App42Exception exception);
}

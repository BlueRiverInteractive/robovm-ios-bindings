
package org.robovm.bindings.cocoatouch.blocks;

import org.robovm.apple.foundation.NSError;
import org.robovm.apple.uikit.UIViewController;

public interface VoidUIViewControllerNSErrorBlock {
	public void invoke (UIViewController viewController, NSError error);
}


package org.robovm.bindings.cocoatouch.blocks;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface VoidUIViewControllerNSErrorBlock {

	public void invoke (UIViewController viewController, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, UIViewController viewController, NSError error) {
			((VoidUIViewControllerNSErrorBlock)block.object()).invoke(viewController, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (VoidUIViewControllerNSErrorBlock o) {
			return WRAPPER.toObjCBlock(o);
		}
	}

}

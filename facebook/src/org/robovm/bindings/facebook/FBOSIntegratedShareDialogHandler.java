
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

/*!
 @typedef

 @abstract Defines a handler that will be called in response to the native share dialog
 being displayed.
 */
public interface FBOSIntegratedShareDialogHandler {
	void invoke (FBShareDialogResult result, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, FBShareDialogResult result, NSError error) {
			((FBOSIntegratedShareDialogHandler)block.object()).invoke(result, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (FBOSIntegratedShareDialogHandler o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}

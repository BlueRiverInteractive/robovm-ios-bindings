
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface GPGAppStateLoadResultHandler {

	void invoke (GPGAppStateLoadStatus status, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, GPGAppStateLoadStatus status, NSError error) {
			((GPGAppStateLoadResultHandler)block.object()).invoke(status, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (GPGAppStateLoadResultHandler o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}

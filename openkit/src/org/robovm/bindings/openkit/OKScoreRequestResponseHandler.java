
package org.robovm.bindings.openkit;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface OKScoreRequestResponseHandler {
	void invoke (NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, NSError error) {
			((OKScoreRequestResponseHandler)block.object()).invoke(error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (OKScoreRequestResponseHandler o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}

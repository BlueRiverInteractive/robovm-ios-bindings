
package org.robovm.bindings.openkit;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface OKScoresResponseHandler {
	void invoke (NSArray<OKScore> scores, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, NSArray<OKScore> scores, NSError error) {
			((OKScoresResponseHandler)block.object()).invoke(scores, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (OKScoresResponseHandler o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}

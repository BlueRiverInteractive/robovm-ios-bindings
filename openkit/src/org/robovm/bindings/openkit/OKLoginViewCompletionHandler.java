
package org.robovm.bindings.openkit;

import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface OKLoginViewCompletionHandler {
	void invoke ();

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block) {
			((OKLoginViewCompletionHandler)block.object()).invoke();
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (OKLoginViewCompletionHandler o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}

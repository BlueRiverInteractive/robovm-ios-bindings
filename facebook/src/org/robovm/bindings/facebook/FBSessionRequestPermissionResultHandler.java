
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface FBSessionRequestPermissionResultHandler {
	void invoke (FBSession session, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, FBSession session, NSError error) {
			((FBSessionRequestPermissionResultHandler)block.object()).invoke(session, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (FBSessionRequestPermissionResultHandler o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}


package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface FBSessionStateHandler {
	void invoke (FBSession session, FBSessionState status, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, FBSession session, FBSessionState status, NSError error) {
			((FBSessionStateHandler)block.object()).invoke(session, status, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (FBSessionStateHandler o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}

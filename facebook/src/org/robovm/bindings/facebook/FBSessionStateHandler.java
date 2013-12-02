
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Marshaler;
import org.robovm.rt.bro.annotation.Pointer;

@Marshaler(FBSessionStateHandler.Marshaler.class)
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

		public static @Pointer
		long toNative (Object o) {
			return WRAPPER.toNative(o);
		}

		public static void updateObject (Object o, long handle) {
		}
	}
}

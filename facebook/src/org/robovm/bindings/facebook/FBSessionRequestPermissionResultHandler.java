
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Marshaler;
import org.robovm.rt.bro.annotation.Pointer;

@Marshaler(FBSessionRequestPermissionResultHandler.Marshaler.class)
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

		public static @Pointer
		long toNative (Object o) {
			return WRAPPER.toNative(o);
		}

		public static void updateObject (Object o, long handle) {
		}
	}
}

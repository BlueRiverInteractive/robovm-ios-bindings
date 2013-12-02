
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Marshaler;
import org.robovm.rt.bro.annotation.Pointer;

/*!
 @typedef

 @abstract Defines a handler that will be called in response to the web dialog
 being dismissed
 */
@Marshaler(FBWebDialogHandler.Marshaler.class)
public interface FBWebDialogHandler {
	void invoke (FBWebDialogResult result, NSURL url, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, FBWebDialogResult result, NSURL url, NSError error) {
			((FBWebDialogHandler)block.object()).invoke(result, url, error);
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

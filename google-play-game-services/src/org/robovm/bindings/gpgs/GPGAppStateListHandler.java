
package org.robovm.bindings.gpgs;

import org.robovm.bindings.other.NSData;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSNumber;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface GPGAppStateListHandler {

	void invoke (NSNumber key, NSData state, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, NSNumber key, NSData state, NSError error) {
			((GPGAppStateListHandler)block.object()).invoke(key, state, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (GPGAppStateListHandler o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}

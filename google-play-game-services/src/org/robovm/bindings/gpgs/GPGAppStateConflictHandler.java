
package org.robovm.bindings.gpgs;

import org.robovm.bindings.other.NSData;
import org.robovm.cocoatouch.foundation.NSNumber;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface GPGAppStateConflictHandler {

	NSData invoke (NSNumber key, NSData localState, NSData remoteState);

	static class Callbacks {
		@Callback
		static NSData run (ObjCBlock block, NSNumber key, NSData localState, NSData remoteState) {
			return ((GPGAppStateConflictHandler)block.object()).invoke(key, localState, remoteState);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (GPGAppStateConflictHandler o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}

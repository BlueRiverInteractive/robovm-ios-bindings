
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSNumber;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

@SuppressWarnings("rawtypes")
public interface GPGAppStateListKeysHandler {
	void invoke (NSArray states, NSNumber maxKeyCount, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, NSArray states, NSNumber maxKeyCount, NSError error) {
			((GPGAppStateListKeysHandler)block.object()).invoke(states, maxKeyCount, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (GPGAppStateListKeysHandler o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}

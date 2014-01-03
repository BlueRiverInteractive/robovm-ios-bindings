
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface GPGReAuthenticationBlock {

	void invoke (boolean requiresKeychainWipe, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, boolean requiresKeychainWipe, NSError error) {
			((GPGReAuthenticationBlock)block.object()).invoke(requiresKeychainWipe, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (GPGReAuthenticationBlock o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}

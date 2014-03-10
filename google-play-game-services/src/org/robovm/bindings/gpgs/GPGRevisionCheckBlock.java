
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface GPGRevisionCheckBlock {

	/** Runs this block. */
	void invoke (GPGRevisionStatus revisionStatus, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, GPGRevisionStatus revisionStatus, NSError error) {
			((GPGRevisionCheckBlock)block.object()).invoke(revisionStatus, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (GPGRevisionCheckBlock o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}

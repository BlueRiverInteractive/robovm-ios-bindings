
package org.robovm.bindings.cocoatouch.blocks;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface VoidNSErrorBlock {

	/** Runs this block. */
	public void invoke (NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, NSError error) {
			((VoidNSErrorBlock)block.object()).invoke(error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (VoidNSErrorBlock o) {
			return WRAPPER.toObjCBlock(o);
		}
	}

}

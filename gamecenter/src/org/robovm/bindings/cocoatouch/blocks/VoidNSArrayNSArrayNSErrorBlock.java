
package org.robovm.bindings.cocoatouch.blocks;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface VoidNSArrayNSArrayNSErrorBlock {

	/** Runs this block. */
	@SuppressWarnings("rawtypes")
	public void invoke (NSArray array, NSArray array2, NSError error);

	static class Callbacks {
		@SuppressWarnings("rawtypes")
		@Callback
		static void run (ObjCBlock block, NSArray array, NSArray array2, NSError error) {
			((VoidNSArrayNSArrayNSErrorBlock)block.object()).invoke(array, array2, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (VoidNSArrayNSArrayNSErrorBlock o) {
			return WRAPPER.toObjCBlock(o);
		}
	}

}

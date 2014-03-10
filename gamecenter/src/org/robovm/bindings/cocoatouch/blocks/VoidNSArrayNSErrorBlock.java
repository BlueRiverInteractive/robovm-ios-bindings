
package org.robovm.bindings.cocoatouch.blocks;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface VoidNSArrayNSErrorBlock {

	@SuppressWarnings("rawtypes")
	public void invoke (NSArray array, NSError error);

	static class Callbacks {
		@SuppressWarnings("rawtypes")
		@Callback
		static void run (ObjCBlock block, NSArray array, NSError error) {
			((VoidNSArrayNSErrorBlock)block.object()).invoke(array, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (VoidNSArrayNSErrorBlock o) {
			return WRAPPER.toObjCBlock(o);
		}
	}

}

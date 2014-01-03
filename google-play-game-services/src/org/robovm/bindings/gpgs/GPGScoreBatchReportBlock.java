
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface GPGScoreBatchReportBlock {

	/** Runs this block. */
	void invoke (NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, NSError error) {
			((GPGScoreBatchReportBlock)block.object()).invoke(error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (GPGScoreBatchReportBlock o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}

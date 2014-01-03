
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface GPGScoreReportScoreBlock {

	void invoke (GPGScoreReport report, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, GPGScoreReport report, NSError error) {
			((GPGScoreReportScoreBlock)block.object()).invoke(report, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (GPGScoreReportScoreBlock o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}

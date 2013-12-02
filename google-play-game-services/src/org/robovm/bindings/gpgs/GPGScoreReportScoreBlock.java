
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Marshaler;
import org.robovm.rt.bro.annotation.Pointer;

//typedef void (^GPGScoreReportScoreBlock)(GPGScoreReport *report, NSError *error);
@Marshaler(GPGScoreReportScoreBlock.Marshaler.class)
public interface GPGScoreReportScoreBlock {

	/** Runs this block. */
	void invoke (GPGScoreReport report, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, GPGScoreReport report, NSError error) {
			((GPGScoreReportScoreBlock)block.object()).invoke(report, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static @Pointer
		long toNative (Object o) {
			return WRAPPER.toNative(o);
		}

		public static void updateObject (Object o, long handle) {
		}
	}
}

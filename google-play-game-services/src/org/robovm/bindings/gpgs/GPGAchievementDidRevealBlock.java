
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface GPGAchievementDidRevealBlock {

	/** Runs this block. */
	void invoke (GPGAchievementState state, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, GPGAchievementState state, NSError error) {
			((GPGAchievementDidRevealBlock)block.object()).invoke(state, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (GPGAchievementDidRevealBlock o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}

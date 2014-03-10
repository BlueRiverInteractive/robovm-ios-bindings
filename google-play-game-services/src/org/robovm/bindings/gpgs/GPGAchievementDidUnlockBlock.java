
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface GPGAchievementDidUnlockBlock {

	/** Runs this block. */
	void invoke (boolean newlyUnlocked, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, boolean newlyUnlocked, NSError error) {
			((GPGAchievementDidUnlockBlock)block.object()).invoke(newlyUnlocked, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (GPGAchievementDidUnlockBlock o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}

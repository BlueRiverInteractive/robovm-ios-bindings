
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface GPGAchievementDidIncrementBlock {

	void invoke (boolean newlyUnlocked, int currentSteps, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, boolean newlyUnlocked, int currentSteps, NSError error) {
			((GPGAchievementDidIncrementBlock)block.object()).invoke(newlyUnlocked, currentSteps, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (GPGAchievementDidIncrementBlock o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}

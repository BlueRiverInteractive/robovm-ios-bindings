
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface GPGLeaderboardLoadScoresBlock {

	void invoke (NSArray<GPGScore> scores, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, NSArray<GPGScore> scores, NSError error) {
			GPGScore.class.getName();// TODO: test this
			((GPGLeaderboardLoadScoresBlock)block.object()).invoke(scores, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (GPGLeaderboardLoadScoresBlock o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}

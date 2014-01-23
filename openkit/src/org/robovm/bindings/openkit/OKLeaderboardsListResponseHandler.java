
package org.robovm.bindings.openkit;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

public interface OKLeaderboardsListResponseHandler {
	void invoke (NSArray<OKLeaderboard> leaderboards, int playerCount, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, NSArray<OKLeaderboard> leaderboards, int playerCount, NSError error) {
			((OKLeaderboardsListResponseHandler)block.object()).invoke(leaderboards, playerCount, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (OKLeaderboardsListResponseHandler o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}

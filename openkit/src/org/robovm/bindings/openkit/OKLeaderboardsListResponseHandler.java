
package org.robovm.bindings.openkit;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSError;

public interface OKLeaderboardsListResponseHandler {
	void invoke (NSArray<OKLeaderboard> leaderboards, int playerCount, NSError error);
}

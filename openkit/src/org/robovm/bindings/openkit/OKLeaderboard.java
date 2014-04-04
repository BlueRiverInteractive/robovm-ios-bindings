
package org.robovm.bindings.openkit;

import java.util.ArrayList;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class OKLeaderboard extends NSObject {
	@Method(selector = "getLeaderboardsWithCompletionHandler:")
	public static native void getLeaderboards (@Block OKLeaderboardsListResponseHandler handler);

	@Property
	public native String getName ();

	@Method(selector = "getScoresForTimeRange:WithCompletionhandler:")
	public native void getLeaderboardScores (OKLeaderboardTimeRange timeRange, @Block OKScoresResponseHandler handler);

	@Method(selector = "getFacebookFriendsScoresWithFacebookFriends:withCompletionHandler:")
	public native void getFacebookFriendsScoresWithFacebookFriends (ArrayList<NSString> friends,
		@Block OKScoresResponseHandler handler);

	@Property(selector = "OKLeaderboard_id")
	public native int getOKLeaderboardId ();
}

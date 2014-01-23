
package org.robovm.bindings.openkit;

import java.util.ArrayList;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class OKLeaderboard extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(OKLeaderboard.class);

	static {
		ObjCRuntime.bind(OKLeaderboard.class);
	}

	public static void getLeaderboards (OKLeaderboardsListResponseHandler handler) {
		objc_getLeaderboardsWithCompletionHandler$(objCClass, getLeaderboardsWithCompletionHandler$,
			OKLeaderboardsListResponseHandler.Marshaler.toObjCBlock(handler));
	}

	private static final Selector getLeaderboardsWithCompletionHandler$ = Selector
		.register("getLeaderboardsWithCompletionHandler:");

	@Bridge
	private native static void objc_getLeaderboardsWithCompletionHandler$ (ObjCClass __self__, Selector __cmd__, ObjCBlock handler);

	public String getName () {
		return objc_name(this, name);
	}

	private static final Selector name = Selector.register("name");

	@Bridge
	private native static String objc_name (OKLeaderboard __self__, Selector __cmd__);

	public void getLeaderboardScores (OKLeaderboardTimeRange timeRange, OKScoresResponseHandler handler) {
		objc_getScoresForTimeRange$WithCompletionhandler$(this, getScoresForTimeRange$WithCompletionhandler$, timeRange,
			OKScoresResponseHandler.Marshaler.toObjCBlock(handler));
	}

	private static final Selector getScoresForTimeRange$WithCompletionhandler$ = Selector
		.register("getScoresForTimeRange:WithCompletionhandler:");

	@Bridge
	private native static void objc_getScoresForTimeRange$WithCompletionhandler$ (OKLeaderboard __self__, Selector __cmd__,
		OKLeaderboardTimeRange timeRange, ObjCBlock handler);

	public void getFacebookFriendsScoresWithFacebookFriends (ArrayList<NSString> friends, OKScoresResponseHandler handler) {
		objc_getFacebookFriendsScoresWithFacebookFriends$withCompletionHandler$(this,
			getFacebookFriendsScoresWithFacebookFriends$withCompletionHandler$, new NSArray<NSString>(friends),
			OKScoresResponseHandler.Marshaler.toObjCBlock(handler));
	}

	private static final Selector getFacebookFriendsScoresWithFacebookFriends$withCompletionHandler$ = Selector
		.register("getFacebookFriendsScoresWithFacebookFriends:withCompletionHandler:");

	@Bridge
	private native static void objc_getFacebookFriendsScoresWithFacebookFriends$withCompletionHandler$ (OKLeaderboard __self__,
		Selector __cmd__, NSArray<NSString> friends, ObjCBlock handler);

	public int getOKLeaderboard_id () {
		return objc_OKLeaderboard_id(this, OKLeaderboard_id);
	}

	private static final Selector OKLeaderboard_id = Selector.register("OKLeaderboard_id");

	@Bridge
	private native static int objc_OKLeaderboard_id (OKLeaderboard __self__, Selector __cmd__);
}

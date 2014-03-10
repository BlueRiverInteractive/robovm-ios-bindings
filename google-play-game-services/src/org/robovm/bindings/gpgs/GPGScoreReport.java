
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGScoreReport extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGScoreReport.class);

	static {
		ObjCRuntime.bind(GPGScoreReport.class);
	}

	// @property(nonatomic, readonly, assign) BOOL isHighScoreForLocalPlayerToday;
	private static final Selector isHighScoreForLocalPlayerToday$ = Selector.register("isHighScoreForLocalPlayerToday");

	@Bridge
	private native static boolean objc_isHighScoreForLocalPlayerToday (GPGScoreReport __self__, Selector __cmd__);

	public boolean isHighScoreForLocalPlayerToday () {
		return objc_isHighScoreForLocalPlayerToday(this, isHighScoreForLocalPlayerToday$);
	}

	// @property(nonatomic, readonly, assign) BOOL isHighScoreForLocalPlayerThisWeek;
	private static final Selector isHighScoreForLocalPlayerThisWeek$ = Selector.register("isHighScoreForLocalPlayerThisWeek");

	@Bridge
	private native static boolean objc_isHighScoreForLocalPlayerThisWeek (GPGScoreReport __self__, Selector __cmd__);

	public boolean isHighScoreForLocalPlayerThisWeek () {
		return objc_isHighScoreForLocalPlayerThisWeek(this, isHighScoreForLocalPlayerThisWeek$);
	}

	// @property(nonatomic, readonly, assign) BOOL isHighScoreForLocalPlayerAllTime;
	private static final Selector isHighScoreForLocalPlayerAllTime$ = Selector.register("isHighScoreForLocalPlayerAllTime");

	@Bridge
	private native static boolean objc_isHighScoreForLocalPlayerAllTime (GPGScoreReport __self__, Selector __cmd__);

	public boolean isHighScoreForLocalPlayerAllTime () {
		return objc_isHighScoreForLocalPlayerAllTime(this, isHighScoreForLocalPlayerAllTime$);
	}

	// @property(nonatomic, readonly, copy) NSString *leaderboardId;
	private static final Selector leaderboardId$ = Selector.register("leaderboardId");

	@Bridge
	private native static NSString objc_leaderboardId (GPGScoreReport __self__, Selector __cmd__);

	public NSString leaderboardId () {
		return objc_leaderboardId(this, leaderboardId$);
	}

	// @property(nonatomic, readonly, assign) unsigned long long reportedScoreValue;
	private static final Selector reportedScoreValue$ = Selector.register("reportedScoreValue");

	@Bridge
	private native static long objc_reportedScoreValue (GPGScoreReport __self__, Selector __cmd__);

	public long reportedScoreValue () {
		return objc_reportedScoreValue(this, reportedScoreValue$);
	}

	// These scores are non-nil only if the reported score did not beat them.

	// @property(nonatomic, readonly, retain) GPGScore *highScoreForLocalPlayerToday;
	private static final Selector highScoreForLocalPlayerToday$ = Selector.register("highScoreForLocalPlayerToday");

	@Bridge
	private native static GPGScore objc_highScoreForLocalPlayerToday (GPGScoreReport __self__, Selector __cmd__);

	public GPGScore highScoreForLocalPlayerToday () {
		return objc_highScoreForLocalPlayerToday(this, highScoreForLocalPlayerToday$);
	}

	// @property(nonatomic, readonly, retain) GPGScore *highScoreForLocalPlayerThisWeek;
	private static final Selector highScoreForLocalPlayerThisWeek$ = Selector.register("highScoreForLocalPlayerThisWeek");

	@Bridge
	private native static GPGScore objc_highScoreForLocalPlayerThisWeek (GPGScoreReport __self__, Selector __cmd__);

	public GPGScore highScoreForLocalPlayerThisWeek () {
		return objc_highScoreForLocalPlayerThisWeek(this, highScoreForLocalPlayerThisWeek$);
	}

	// @property(nonatomic, readonly, retain) GPGScore *highScoreForLocalPlayerAllTime;
	private static final Selector highScoreForLocalPlayerAllTime$ = Selector.register("highScoreForLocalPlayerAllTime");

	@Bridge
	private native static GPGScore objc_highScoreForLocalPlayerAllTime (GPGScoreReport __self__, Selector __cmd__);

	public GPGScore highScoreForLocalPlayerAllTime () {
		return objc_highScoreForLocalPlayerAllTime(this, highScoreForLocalPlayerAllTime$);
	}
}

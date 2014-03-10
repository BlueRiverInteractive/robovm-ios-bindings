
package org.robovm.bindings.gpgs;

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
public class GPGLeaderboard extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGLeaderboard.class);

	static {
		ObjCRuntime.bind(GPGLeaderboard.class);
	}

	// - (id)initWithLeaderboardId:(NSString *)leaderboardId;
	private static final Selector initWithLeaderboardId$ = Selector.register("initWithLeaderboardId:");

	@Bridge
	private native static GPGAchievement objc_initWithLeaderboardId (GPGLeaderboard __self__, Selector __cmd__,
		NSString leaderboardId);

	public GPGLeaderboard (String leaderboardId) {
		objc_initWithLeaderboardId(this, initWithLeaderboardId$, new NSString(leaderboardId));
	}

	// + (id)leaderboardWithId:(NSString *)leaderboardId;
	private static final Selector leaderboardWithId$ = Selector.register("leaderboardWithId:");

	@Bridge
	private native static GPGLeaderboard objc_leaderboardWithId (ObjCClass __self__, Selector __cmd__, NSString leaderboardId);

	public static GPGLeaderboard leaderboardWithId (String leaderboardId) {
		return objc_leaderboardWithId(objCClass, leaderboardWithId$, new NSString(leaderboardId));
	}

	// @property (nonatomic, readonly, copy) NSString * leaderboardId;
	private static final Selector leaderboardId$ = Selector.register("leaderboardId");

	@Bridge
	private native static String objc_leaderboardId (GPGLeaderboard __self__, Selector __cmd__);

	public String leaderboardId () {
		return objc_leaderboardId(this, leaderboardId$);
	}

	// @property (nonatomic, readwrite, assign, getter=isPersonalWindow) BOOL personalWindow; // default: NO. NO means the window
// is focused around top players.
	private static final Selector personalWindow$ = Selector.register("isPersonalWindow");

	@Bridge
	private native static boolean objc_personalWindow (GPGLeaderboard __self__, Selector __cmd__);

	public boolean isPersonalWindow () {
		return objc_personalWindow(this, personalWindow$);
	}

	private static final Selector setPersonalWindow$ = Selector.register("setPersonalWindow:");

	@Bridge
	private native static void objc_setPersonalWindow (GPGLeaderboard __self__, Selector __cmd__, boolean personalWindow);

	public void setPersonalWindow (boolean personalWindow) {
		objc_setPersonalWindow(this, setPersonalWindow$, personalWindow);
	}

	// @property (nonatomic, readwrite, assign) GPGLeaderboardTimeScope timeScope; // default: GPGLeaderboardTimeScopeAllTime
	private static final Selector timeScope$ = Selector.register("timeScope");

	@Bridge
	private native static GPGLeaderboardTimeScope objc_timeScope (GPGLeaderboard __self__, Selector __cmd__);

	public GPGLeaderboardTimeScope timeScope () {
		return objc_timeScope(this, timeScope$);
	}

	private static final Selector setTimeScope$ = Selector.register("setTimeScope:");

	@Bridge
	private native static void objc_setTimeScope (GPGLeaderboard __self__, Selector __cmd__, GPGLeaderboardTimeScope timeScope);

	public void setTimeScope (GPGLeaderboardTimeScope timeScope) {
		objc_setTimeScope(this, setTimeScope$, timeScope);
	}

	// @property (nonatomic, readwrite, assign, getter=isSocial) BOOL social; // default: NO. NO means load the public leaderboard.
	private static final Selector social$ = Selector.register("isSocial");

	@Bridge
	private native static boolean objc_social (GPGLeaderboard __self__, Selector __cmd__);

	public boolean isSocial () {
		return objc_social(this, social$);
	}

	private static final Selector setSocial$ = Selector.register("setSocial:");

	@Bridge
	private native static void objc_setSocial (GPGLeaderboard __self__, Selector __cmd__, boolean social);

	public void setSocial (boolean social) {
		objc_setSocial(this, setSocial$, social);
	}

	// - (void)loadScoresWithCompletionHandler:(GPGLeaderboardLoadScoresBlock)completionHandler;
	private static final Selector loadScoresWithCompletionHandler$ = Selector.register("loadScoresWithCompletionHandler:");

	@Bridge
	private native static void objc_loadScoresWithCompletionHandler (GPGLeaderboard __self__, Selector __cmd__,
		ObjCBlock completionHandler);

	public void loadScoresWithCompletionHandler (GPGLeaderboardLoadScoresBlock completionHandler) {
		objc_loadScoresWithCompletionHandler(this, loadScoresWithCompletionHandler$,
			GPGLeaderboardLoadScoresBlock.Marshaler.toObjCBlock(completionHandler));
	}

	// - (void)loadNextPageOfScoresWithCompletionHandler:(GPGLeaderboardLoadScoresBlock)completionHandler;
	private static final Selector loadNextPageOfScoresWithCompletionHandler$ = Selector
		.register("loadNextPageOfScoresWithCompletionHandler:");

	@Bridge
	private native static void objc_loadNextPageOfScoresWithCompletionHandler (GPGLeaderboard __self__, Selector __cmd__,
		ObjCBlock completionHandler);

	public void loadNextPageOfScoresWithCompletionHandler (GPGLeaderboardLoadScoresBlock completionHandler) {
		objc_loadNextPageOfScoresWithCompletionHandler(this, loadNextPageOfScoresWithCompletionHandler$,
			GPGLeaderboardLoadScoresBlock.Marshaler.toObjCBlock(completionHandler));
	}

	// - (void)loadPreviousPageOfScoresWithCompletionHandler:(GPGLeaderboardLoadScoresBlock)completionHandler;
	private static final Selector loadPreviousPageOfScoresWithCompletionHandler$ = Selector
		.register("loadPreviousPageOfScoresWithCompletionHandler:");

	@Bridge
	private native static void objc_loadPreviousPageOfScoresWithCompletionHandler (GPGLeaderboard __self__, Selector __cmd__,
		ObjCBlock completionHandler);

	public void loadPreviousPageOfScoresWithCompletionHandler (GPGLeaderboardLoadScoresBlock completionHandler) {
		objc_loadPreviousPageOfScoresWithCompletionHandler(this, loadPreviousPageOfScoresWithCompletionHandler$,
			GPGLeaderboardLoadScoresBlock.Marshaler.toObjCBlock(completionHandler));
	}

	// - (BOOL)isLoading;
	private static final Selector isLoading$ = Selector.register("isLoading:");

	@Bridge
	private native static boolean objc_isLoading (GPGLeaderboard __self__, Selector __cmd__);

	public boolean isLoading () {
		return objc_isLoading(this, isLoading$);
	}

	// - (BOOL)isLoadingPreviousPage;
	private static final Selector isLoadingPreviousPage$ = Selector.register("isLoadingPreviousPage:");

	@Bridge
	private native static boolean objc_isLoadingPreviousPage (GPGLeaderboard __self__, Selector __cmd__);

	public boolean isLoadingPreviousPage () {
		return objc_isLoadingPreviousPage(this, isLoadingPreviousPage$);
	}

	// - (BOOL)isLoadingNextPage;
	private static final Selector isLoadingNextPage$ = Selector.register("isLoadingNextPage:");

	@Bridge
	private native static boolean objc_isLoadingNextPage (GPGLeaderboard __self__, Selector __cmd__);

	public boolean isLoadingNextPage () {
		return objc_isLoadingNextPage(this, isLoadingNextPage$);
	}

	// @property (nonatomic, readonly, copy) NSArray *scores; // [GPGScore,...]
	private static final Selector scores$ = Selector.register("scores");

	@Bridge
	private native static NSArray<GPGScore> objc_scores (GPGLeaderboard __self__, Selector __cmd__);

	public NSArray<GPGScore> scores () {
		return objc_scores(this, scores$);
	}

	// @property (nonatomic, readonly, retain) GPGLocalPlayerScore *localPlayerScore;
	private static final Selector localPlayerScore$ = Selector.register("localPlayerScore");

	@Bridge
	private native static GPGLocalPlayerScore objc_localPlayerScore (GPGLeaderboard __self__, Selector __cmd__);

	public GPGLocalPlayerScore localPlayerScore () {
		return objc_localPlayerScore(this, localPlayerScore$);
	}

	// @property (nonatomic, readonly, copy) NSString *name;
	private static final Selector name$ = Selector.register("name");

	@Bridge
	private native static NSString objc_name (GPGLeaderboard __self__, Selector __cmd__);

	public NSString name () {
		return objc_name(this, name$);
	}

	// @property (nonatomic, readonly, assign) BOOL hasPreviousPage;
	private static final Selector hasPreviousPage$ = Selector.register("hasPreviousPage");

	@Bridge
	private native static boolean objc_hasPreviousPage (GPGLeaderboard __self__, Selector __cmd__);

	public boolean hasPreviousPage () {
		return objc_hasPreviousPage(this, hasPreviousPage$);
	}

	// @property (nonatomic, readonly, assign) BOOL hasNextPage;
	private static final Selector hasNextPage$ = Selector.register("hasNextPage");

	@Bridge
	private native static boolean objc_hasNextPage (GPGLeaderboard __self__, Selector __cmd__);

	public boolean hasNextPage () {
		return objc_hasNextPage(this, hasNextPage$);
	}
}

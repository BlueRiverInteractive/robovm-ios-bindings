
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGScore extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGScore.class);

	static {
		ObjCRuntime.bind(GPGScore.class);
	}

	// - (id)initWithLeaderboardId:(NSString *)leaderboardId;
	private static final Selector initWithLeaderboardId$ = Selector.register("initWithLeaderboardId:");

	@Bridge
	private native static GPGScore objc_initWithLeaderboardId (GPGScore __self__, Selector __cmd__, NSString leaderboardId);

	public GPGScore (String leaderboardId) {
		objc_initWithLeaderboardId(this, initWithLeaderboardId$, new NSString(leaderboardId));
	}

	// + (id)scoreWithLeaderboardId:(NSString *)leaderboardId;
	private static final Selector scoreWithLeaderboardId$ = Selector.register("scoreWithLeaderboardId:");

	@Bridge
	private native static GPGScore objc_scoreWithLeaderboardId (ObjCClass __self__, Selector __cmd__, NSString leaderboardId);

	public static GPGScore scoreWithLeaderboardId (String leaderboardId) {
		return objc_scoreWithLeaderboardId(objCClass, scoreWithLeaderboardId$, new NSString(leaderboardId));
	}

	// @property (nonatomic, readonly, copy) NSString *leaderboardId;
	private static final Selector leaderboardId$ = Selector.register("leaderboardId");

	@Bridge
	private native static String objc_leaderboardId (GPGScore __self__, Selector __cmd__);

	public String leaderboardId () {
		return objc_leaderboardId(this, leaderboardId$);
	}

	// @property (nonatomic, readwrite, assign) unsigned long long value;
	private static final Selector value$ = Selector.register("value");

	@Bridge
	private native static long objc_value (GPGScore __self__, Selector __cmd__);

	public long value () {
		return objc_value(this, value$);
	}

	private static final Selector setValue$ = Selector.register("setValue:");

	@Bridge
	private native static long objc_setValue (GPGScore __self__, Selector __cmd__, long value);

	public void setValue (long value) {
		objc_setValue(this, setValue$, value);
	}

	// - (BOOL)submitScoreWithCompletionHandler:(GPGScoreReportScoreBlock)completionHandler;
	private static final Selector submitScoreWithCompletionHandler$ = Selector.register("submitScoreWithCompletionHandler:");

	@Bridge
	private native static boolean objc_submitScoreWithCompletionHandler (GPGScore __self__, Selector __cmd__,
		ObjCBlock completionHandler);

	public boolean submitScoreWithCompletionHandler (GPGScoreReportScoreBlock completionHandler) {
		return objc_submitScoreWithCompletionHandler(this, submitScoreWithCompletionHandler$,
			GPGScoreReportScoreBlock.Marshaler.toObjCBlock(completionHandler));
	}

	// + (void)submitScores:(NSArray *)scores withCompletionHandler:(GPGScoreBatchReportBlock)completionHandler
// __attribute__((deprecated));
	private static final Selector submitScores$ = Selector.register("submitScores:withCompletionHandler:");

	@Bridge
	private native static boolean objc_submitScores (ObjCClass __self__, Selector __cmd__, NSArray scores,
		ObjCBlock completionHandler);

	@Deprecated
	public static void submitScores (NSArray scores, GPGScoreBatchReportBlock completionHandler) {
		objc_submitScores(objCClass, submitScores$, scores, GPGScoreBatchReportBlock.Marshaler.toObjCBlock(completionHandler));
	}

	// + (void)batchSubmitScores:(NSArray *)scores withCompletionHandler:(GPGScoreReportScoreBlock)completionHandler;
	private static final Selector batchSubmitScores$ = Selector.register("batchSubmitScores:withCompletionHandler:");

	@Bridge
	private native static boolean objc_batchSubmitScores (ObjCClass __self__, Selector __cmd__, NSArray scores,
		ObjCBlock completionHandler);

	public static void batchSubmitScores (NSArray scores, GPGScoreReportScoreBlock completionHandler) {
		objc_batchSubmitScores(objCClass, batchSubmitScores$, scores,
			GPGScoreReportScoreBlock.Marshaler.toObjCBlock(completionHandler));
	}

	// @property (nonatomic, readonly, copy) NSString *formattedRank;
	private static final Selector formattedRank$ = Selector.register("formattedRank");

	@Bridge
	private native static String objc_formattedRank (GPGScore __self__, Selector __cmd__);

	public String formattedRank () {
		return objc_formattedRank(this, formattedRank$);
	}

	// @property (nonatomic, readonly, copy) NSString *formattedScore;
	private static final Selector formattedScore$ = Selector.register("formattedScore");

	@Bridge
	private native static String objc_formattedScore (GPGScore __self__, Selector __cmd__);

	public String formattedScore () {
		return objc_formattedScore(this, formattedScore$);
	}

	// @property (nonatomic, readonly, assign) unsigned long long rank;
	private static final Selector rank$ = Selector.register("rank");

	@Bridge
	private native static long objc_rank (GPGScore __self__, Selector __cmd__);

	public long rank () {
		return objc_rank(this, rank$);
	}

	// @property (nonatomic, readonly, copy) NSString *playerId;
	private static final Selector playerId$ = Selector.register("playerId");

	@Bridge
	private native static String objc_playerId (GPGScore __self__, Selector __cmd__);

	public String playerId () {
		return objc_playerId(this, playerId$);
	}

	// @property (nonatomic, readonly, copy) NSString *displayName;
	private static final Selector displayName$ = Selector.register("displayName");

	@Bridge
	private native static String objc_displayName (GPGScore __self__, Selector __cmd__);

	public String displayName () {
		return objc_displayName(this, displayName$);
	}

	// @property (nonatomic, readonly, copy) NSURL *avatarUrl;
	private static final Selector avatarUrl$ = Selector.register("avatarUrl");

	@Bridge
	private native static NSURL objc_avatarUrl (GPGScore __self__, Selector __cmd__);

	public NSURL avatarUrl () {
		return objc_avatarUrl(this, avatarUrl$);
	}

	// @property (nonatomic, readonly, assign) long long writeTimestamp;
	private static final Selector writeTimestamp$ = Selector.register("writeTimestamp");

	@Bridge
	private native static long objc_writeTimestamp (GPGScore __self__, Selector __cmd__);

	public long writeTimestamp () {
		return objc_writeTimestamp(this, writeTimestamp$);
	}
}

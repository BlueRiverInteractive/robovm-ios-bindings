
package org.robovm.bindings.apple.gamekit;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSRange;
import org.robovm.bindings.apple.blocks.VoidNSArrayNSArrayNSErrorBlock;
import org.robovm.bindings.apple.blocks.VoidNSArrayNSErrorBlock;
import org.robovm.bindings.apple.blocks.VoidNSErrorBlock;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.ObjCSuper;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

/** GKLeaderboard represents the set of high scores for the current game, always including the local player's best score. */
@Library("GameKit")
@NativeClass
public class GKLeaderboard extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GKLeaderboard.class);

	static {
		ObjCRuntime.bind(GKLeaderboard.class);
	}

	// - (id)init;
	private static final Selector init = Selector.register("init");

	@Bridge
	private native static void objc_init (GKLeaderboard __self__, Selector __cmd__);

	@Bridge
	private native static void objc_initSuper (ObjCSuper __super__, Selector __cmd__);

	/** Designated initializer Default is the range 1-10 with Global/AllTime scopes if you want to change the scopes or range, set
	 * the properites before loading the scores.
	 * @param identifier */
	public GKLeaderboard () {
		if (customClass) {
			objc_initSuper(getSuper(), init);
		} else {
			objc_init(this, init);
		}
	}

	// - (id)initWithPlayerIDs:(NSArray *)playerIDs;
	private static final Selector initWithPlayerIDs = Selector.register("initWithPlayerIDs:");

	@SuppressWarnings("rawtypes")
	@Bridge
	private native static void objc_init (GKLeaderboard __self__, Selector __cmd__, NSArray playerIDs);

	@SuppressWarnings("rawtypes")
	@Bridge
	private native static void objc_initSuper (ObjCSuper __super__, Selector __cmd__, NSArray playerIDs);

	/** Specify an array of players ids, for example, the players who are in a match together Defaults to AllTime score, if you want
	 * to change the timeScope, set the property before loading the scores. Range and playerScope are not applicable. playerIDs may
	 * not be nil.
	 * @param identifier */
	@SuppressWarnings("rawtypes")
	public GKLeaderboard (NSArray playerIDs) {
		if (customClass) {
			objc_initSuper(getSuper(), initWithPlayerIDs, playerIDs);
		} else {
			objc_init(this, initWithPlayerIDs, playerIDs);
		}
	}

	// @property(assign, NS_NONATOMIC_IOSONLY) GKLeaderboardTimeScope timeScope;
	private static final Selector timeScope = Selector.register("timeScope");

	@Bridge
	private native static GKLeaderboardTimeScope objc_timeScope (GKLeaderboard __self__, Selector __cmd__);

	@Bridge
	private native static GKLeaderboardTimeScope objc_timeScopeSuper (ObjCSuper __super__, Selector __cmd__);

	/** Getter - timeScope
	 * @return */
	public GKLeaderboardTimeScope getTimeScope () {
		if (customClass) {
			return objc_timeScopeSuper(getSuper(), timeScope);
		} else {
			return objc_timeScope(this, timeScope);
		}
	}

	private static final Selector setTimeScope = Selector.register("setTimeScope:");

	@Bridge
	private native static void objc_setTimeScope (GKLeaderboard __self__, Selector __cmd__, GKLeaderboardTimeScope timeScope);

	@Bridge
	private native static void objc_setTimeScopeSuper (ObjCSuper __super__, Selector __cmd__, GKLeaderboardTimeScope timeScope);

	/** Setter - timeScope
	 * @return */
	public void setTimeScope (GKLeaderboardTimeScope timeScope) {
		if (customClass) {
			objc_setTimeScopeSuper(getSuper(), setTimeScope, timeScope);
		} else {
			objc_setTimeScope(this, setTimeScope, timeScope);
		}
	}

	// @property(assign, NS_NONATOMIC_IOSONLY) GKLeaderboardPlayerScope playerScope;
	private static final Selector playerScope = Selector.register("playerScope");

	@Bridge
	private native static GKLeaderboardPlayerScope objc_playerScope (GKLeaderboard __self__, Selector __cmd__);

	@Bridge
	private native static GKLeaderboardPlayerScope objc_playerScopeSuper (ObjCSuper __super__, Selector __cmd__);

	/** Getter - Filter on friends. Does not apply to leaderboard initialized with players.
	 * @return */
	public GKLeaderboardPlayerScope getPlayerScope () {
		if (customClass) {
			return objc_playerScopeSuper(getSuper(), playerScope);
		} else {
			return objc_playerScope(this, playerScope);
		}
	}

	private static final Selector setPlayerScope = Selector.register("setPlayerScope:");

	@Bridge
	private native static void objc_setPlayerScope (GKLeaderboard __self__, Selector __cmd__, GKLeaderboardPlayerScope playerScope);

	@Bridge
	private native static void objc_setPlayerScopeSuper (ObjCSuper __super__, Selector __cmd__,
		GKLeaderboardPlayerScope playerScope);

	/** Setter - Filter on friends. Does not apply to leaderboard initialized with players.
	 * @return */
	public void setPlayerScope (GKLeaderboardPlayerScope playerScope) {
		if (customClass) {
			objc_setPlayerScopeSuper(getSuper(), setPlayerScope, playerScope);
		} else {
			objc_setPlayerScope(this, setPlayerScope, playerScope);
		}
	}

	// @property(copy, NS_NONATOMIC_IOSONLY) NSString *category __OSX_AVAILABLE_BUT_DEPRECATED(__MAC_10_8, __MAC_NA, __IPHONE_4_1,
// __IPHONE_7_0);
	private static final Selector category = Selector.register("category");

	@Bridge
	private native static String objc_category (GKLeaderboard __self__, Selector __cmd__);

	@Bridge
	private native static String objc_categorySuper (ObjCSuper __super__, Selector __cmd__);

	/** Getter - Deprecated. Use identifier instead.
	 * @return */
	@Deprecated
	public String getCategory () {
		if (customClass) {
			return objc_categorySuper(getSuper(), category);
		} else {
			return objc_category(this, category);
		}
	}

	private static final Selector setCategory = Selector.register("setCategory:");

	@Bridge
	private native static void objc_setCategory (GKLeaderboard __self__, Selector __cmd__, String category);

	@Bridge
	private native static void objc_setCategorySuper (ObjCSuper __super__, Selector __cmd__, String category);

	/** Setter - Deprecated. Use identifier instead.
	 * @return */
	@Deprecated
	public void setCategory (String category) {
		if (customClass) {
			objc_setCategorySuper(getSuper(), setCategory, category);
		} else {
			objc_setCategory(this, setCategory, category);
		}
	}

	// @property(copy, NS_NONATOMIC_IOSONLY) NSString *identifier __OSX_AVAILABLE_STARTING( __MAC_NA, __IPHONE_7_0);
	private static final Selector identifier = Selector.register("identifier");

	@Bridge
	private native static String objc_identifier (GKLeaderboard __self__, Selector __cmd__);

	@Bridge
	private native static String objc_identifierSuper (ObjCSuper __super__, Selector __cmd__);

	/** Getter - leaderboardID. If nil, fetch the aggregate leaderboard.
	 * @return */
	public String getIdentifier () {
		if (customClass) {
			return objc_identifierSuper(getSuper(), identifier);
		} else {
			return objc_identifier(this, identifier);
		}
	}

	private static final Selector setIdentifier = Selector.register("setIdentifier:");

	@Bridge
	private native static void objc_setIdentifier (GKLeaderboard __self__, Selector __cmd__, String identifier);

	@Bridge
	private native static void objc_setIdentifierSuper (ObjCSuper __super__, Selector __cmd__, String identifier);

	/** Setter - leaderboardID. If nil, fetch the aggregate leaderboard.
	 * @return */
	public void setIdentifier (String identifier) {
		if (customClass) {
			objc_setIdentifierSuper(getSuper(), setIdentifier, identifier);
		} else {
			objc_setIdentifier(this, setIdentifier, identifier);
		}
	}

	// @property(readonly, copy, NS_NONATOMIC_IOSONLY) NSString *title;
	private static final Selector title = Selector.register("title");

	@Bridge
	private native static String objc_title (GKLeaderboard __self__, Selector __cmd__);

	@Bridge
	private native static String objc_titleSuper (ObjCSuper __super__, Selector __cmd__);

	/** Getter - Localized category title. Defaults to nil until loaded.
	 * @return */
	public String getTitle () {
		if (customClass) {
			return objc_titleSuper(getSuper(), title);
		} else {
			return objc_title(this, title);
		}
	}

	// @property(assign, NS_NONATOMIC_IOSONLY) NSRange range;
	private static final Selector range = Selector.register("range");

	@Bridge
	private native static NSRange objc_range (GKLeaderboard __self__, Selector __cmd__);

	@Bridge
	private native static NSRange objc_rangeSuper (ObjCSuper __super__, Selector __cmd__);

	/** Getter - Leaderboards start at index 1 and the length should be less than 100. Does not apply to leaderboards initialized
	 * with players. Exception will be thrown if developer tries to set an invalid range
	 * @return */
	public NSRange getRange () {
		if (customClass) {
			return objc_rangeSuper(getSuper(), range);
		} else {
			return objc_range(this, range);
		}
	}

	private static final Selector setRange = Selector.register("setRange:");

	@Bridge
	private native static void objc_setRange (GKLeaderboard __self__, Selector __cmd__, NSRange range);

	@Bridge
	private native static void objc_setRangeSuper (ObjCSuper __super__, Selector __cmd__, NSRange range);

	/** Setter - Leaderboards start at index 1 and the length should be less than 100. Does not apply to leaderboards initialized
	 * with players. Exception will be thrown if developer tries to set an invalid range
	 * @return */
	public void setRange (NSRange range) {
		if (customClass) {
			objc_setRangeSuper(getSuper(), setIdentifier, range);
		} else {
			objc_setRange(this, setIdentifier, range);
		}
	}

	// @property(readonly, retain, NS_NONATOMIC_IOSONLY) NSArray *scores;
	private static final Selector scores = Selector.register("scores");

	@SuppressWarnings("rawtypes")
	@Bridge
	private native static NSArray objc_scores (GKLeaderboard __self__, Selector __cmd__);

	@SuppressWarnings("rawtypes")
	@Bridge
	private native static NSArray objc_scoresSuper (ObjCSuper __super__, Selector __cmd__);

	/** Getter - Scores are not valid until loadScores: has completed.
	 * @return */
	@SuppressWarnings("rawtypes")
	public NSArray getScores () {
		if (customClass) {
			return objc_scoresSuper(getSuper(), scores);
		} else {
			return objc_scores(this, scores);
		}
	}

	// @property(readonly, assign, NS_NONATOMIC_IOSONLY) NSUInteger maxRange;
	private static final Selector maxRange = Selector.register("maxRange");

	@Bridge
	private native static int objc_maxRange (GKLeaderboard __self__, Selector __cmd__);

	@Bridge
	private native static int objc_maxRangeSuper (ObjCSuper __super__, Selector __cmd__);

	/** Getter - The maxRange which represents the size of the leaderboard is not valid until loadScores: has completed.
	 * @return */
	public int getMaxRange () {
		if (customClass) {
			return objc_maxRangeSuper(getSuper(), maxRange);
		} else {
			return objc_maxRange(this, maxRange);
		}
	}

	// @property(readonly, retain, NS_NONATOMIC_IOSONLY) GKScore *localPlayerScore;
	private static final Selector localPlayerScore = Selector.register("localPlayerScore");

	@Bridge
	private native static GKScore objc_localPlayerScore (GKLeaderboard __self__, Selector __cmd__);

	@Bridge
	private native static GKScore objc_localPlayerScoreSuper (ObjCSuper __super__, Selector __cmd__);

	/** Getter - The local player's score
	 * @return */
	public GKScore getLocalPlayerScore () {
		if (customClass) {
			return objc_localPlayerScoreSuper(getSuper(), localPlayerScore);
		} else {
			return objc_localPlayerScore(this, localPlayerScore);
		}
	}

	// @property(readonly, getter=isLoading) BOOL loading;
	private static final Selector isLoading = Selector.register("isLoading");

	@Bridge
	private native static boolean objc_isLoading (GKLeaderboard __self__, Selector __cmd__);

	@Bridge
	private native static boolean objc_isLoadingSuper (ObjCSuper __super__, Selector __cmd__);

	/** Getter - true if the leaderboard is currently loading
	 * @return */
	public boolean isLoading () {
		if (customClass) {
			return objc_isLoadingSuper(getSuper(), isLoading);
		} else {
			return objc_isLoading(this, isLoading);
		}
	}

	// @property(nonatomic, readonly, retain) NSString *groupIdentifier __OSX_AVAILABLE_STARTING(__MAC_10_8,__IPHONE_6_0);
	private static final Selector groupIdentifier = Selector.register("groupIdentifier");

	@Bridge
	private native static String objc_groupIdentifier (GKLeaderboard __self__, Selector __cmd__);

	@Bridge
	private native static String objc_groupIdentifierSuper (ObjCSuper __super__, Selector __cmd__);

	/** Getter - set when leaderboards have been designated a game group; set when loadLeaderboardsWithCompletionHandler has been
	 * called for leaderboards that support game groups
	 * @return */
	public String getGroupIdentifier () {
		if (customClass) {
			return objc_groupIdentifierSuper(getSuper(), groupIdentifier);
		} else {
			return objc_groupIdentifier(this, groupIdentifier);
		}
	}

	/** Load the scores for this leader board asynchronously. Error will be nil on success. Possible reasons for error: 1.
	 * Communications problem 2. Unauthenticated player
	 * @return */
	@Method(selector = "loadScoresWithCompletionHandler:")
	public native void loadScores (@Block VoidNSArrayNSErrorBlock completionHandler);

	/** Loads parallel arrays that maps categories to their title strings Possible reasons for error: 1. Communications problem 2.
	 * Unauthenticated player 3. Leaderboard not present
	 * @param completionHandler */
	@Deprecated
	@Method(selector = "loadCategoriesWithCompletionHandler:")
	public static native void loadCategories (@Block VoidNSArrayNSArrayNSErrorBlock completionHandler);

	/** @param completionHandler */
	@Method(selector = "loadLeaderboardsWithCompletionHandler:")
	public static native void loadLeaderboards (@Block VoidNSArrayNSErrorBlock completionHandler);

	/** Set the default leaderboard for the local player per game Possible reasons for error:d 1. Communications problem 2.
	 * Unauthenticated player 3. Leaderboard not present Deprecated: Use setDefaultLeaderboardIdentifier:completionHandler: on
	 * GKLocalPlayer instead
	 * @param completionHandler */
	@Deprecated
	@Method(selector = "setDefaultLeaderboard:withCompletionHandler:")
	public static native void setDefaultLeaderboard (String leaderboardIdentifier, @Block VoidNSErrorBlock completionHandler);

}


package org.robovm.bindings.apple.gamekit;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSDate;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIDevice;
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
import org.robovm.rt.bro.annotation.Pointer;

@Library("GameKit")
@NativeClass
public class GKScore extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GKScore.class);

	static {
		ObjCRuntime.bind(GKScore.class);
	}

	protected GKScore (SkipInit skipInit) {
		super(skipInit);
	}

	public GKScore () {
	}

	// - (id)initWithLeaderboardIdentifier:(NSString *)identifier __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_7_0);
	private static final Selector initWithLeaderboardIdentifier = Selector.register("initWithLeaderboardIdentifier:");
	// - (id)initWithCategory:(NSString *)category __OSX_AVAILABLE_BUT_DEPRECATED(__MAC_10_8,__MAC_NA,__IPHONE_4_1,__IPHONE_7_0);
	private static final Selector initWithCategory = Selector.register("initWithCategory:");

	@Bridge
	private native static @Pointer
	long objc_initWithLeaderboardIdentifier (GKScore __self__, Selector __cmd__, String identifier);

	@Bridge
	private native static @Pointer
	long objc_initWithCategory (GKScore __self__, Selector __cmd__, String category);

	/** Designated initializer. Will initialize the score with the local player and current date.
	 * @param identifier */
	public GKScore (String identifier) {
		super((SkipInit)null);

		// Get the current iOS version. The constructor is diferent in iOS7
		String systemVersion = UIDevice.getCurrentDevice().getSystemVersion();
		int version = Character.getNumericValue(systemVersion.charAt(0));

		if (version >= 7)
			initObject(objc_initWithLeaderboardIdentifier(this, initWithLeaderboardIdentifier, identifier));
		else
			initObject(objc_initWithCategory(this, initWithCategory, identifier));
	}

	// - (id)initWithLeaderboardIdentifier:(NSString *)identifier forPlayer:(NSString *)playerID
// __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_7_0);
	private static final Selector initWithLeaderboardIdentifier$forPlayer = Selector
		.register("initWithLeaderboardIdentifier:forPlayer:");

	@Bridge
	private native static @Pointer
	long objc_init (GKScore __self__, Selector __cmd__, String identifier, String playerID);

	/** Will initialize the score for a player. Can be used for submitting participant scores when ending a turn-based match.
	 * @param identifier
	 * @param playerID */
	public GKScore (String identifier, String playerID) {
		super((SkipInit)null);
		initObject(objc_init(this, initWithLeaderboardIdentifier$forPlayer, identifier, playerID));
	}

	// @property(assign, NS_NONATOMIC_IOSONLY) int64_t value;
	private static final Selector value = Selector.register("value");

	@Bridge
	private native static long objc_value (GKScore __self__, Selector __cmd__);

	@Bridge
	private native static long objc_valueSuper (ObjCSuper __super__, Selector __cmd__);

	/** Getter - The score value as a 64bit integer.
	 * @return */
	public long getValue () {
		if (customClass) {
			return objc_valueSuper(getSuper(), value);
		} else {
			return objc_value(this, value);
		}
	}

	private static final Selector setValue = Selector.register("setValue:");

	@Bridge
	private native static void objc_setValue (GKScore __self__, Selector __cmd__, long value);

	@Bridge
	private native static void objc_setValueSuper (ObjCSuper __super__, Selector __cmd__, long value);

	/** Setter - The score value as a 64bit integer.
	 * @return */
	public void setValue (long value) {
		if (customClass) {
			objc_setValueSuper(getSuper(), setValue, value);
		} else {
			objc_setValue(this, setValue, value);
		}
	}

	// @property(readonly, copy, NS_NONATOMIC_IOSONLY) NSString *formattedValue;
	private static final Selector formattedValue = Selector.register("formattedValue");

	@Bridge
	private native static String objc_formattedValue (GKScore __self__, Selector __cmd__);

	@Bridge
	private native static String objc_formattedValueSuper (ObjCSuper __super__, Selector __cmd__);

	/** The score formatted as a string, localized with a label
	 * @return */
	public String getFormattedValue () {
		if (customClass) {
			return objc_formattedValueSuper(getSuper(), formattedValue);
		} else {
			return objc_formattedValue(this, formattedValue);
		}
	}

	// @property(copy, NS_NONATOMIC_IOSONLY) NSString *category
// __OSX_AVAILABLE_BUT_DEPRECATED(__MAC_10_8,__MAC_NA,__IPHONE_4_1,__IPHONE_7_0);
	private static final Selector category = Selector.register("category");

	@Bridge
	private native static String objc_category (GKScore __self__, Selector __cmd__);

	@Bridge
	private native static String objc_categorySuper (ObjCSuper __super__, Selector __cmd__);

	/** Getter - Deprecated. Use leaderboardIdentifier instead
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
	private native static void objc_setCategory (GKScore __self__, Selector __cmd__, String category);

	@Bridge
	private native static void objc_setCategorySuper (ObjCSuper __super__, Selector __cmd__, String category);

	/** Setter - Deprecated. Use leaderboardIdentifier instead
	 * @return */
	@Deprecated
	public void setCategory (String category) {
		if (customClass) {
			objc_setCategorySuper(getSuper(), setCategory, category);
		} else {
			objc_setCategory(this, setCategory, category);
		}
	}

	// @property(copy, NS_NONATOMIC_IOSONLY) NSString *leaderboardIdentifier __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_7_0);
	private static final Selector leaderboardIdentifier = Selector.register("leaderboardIdentifier");

	@Bridge
	private native static String objc_leaderboardIdentifier (GKScore __self__, Selector __cmd__);

	@Bridge
	private native static String objc_leaderboardIdentifierSuper (ObjCSuper __super__, Selector __cmd__);

	/** Getter - leaderboard identifier (required)
	 * @return */
	public String getLeaderboardIdentifier () {
		if (customClass) {
			return objc_leaderboardIdentifierSuper(getSuper(), leaderboardIdentifier);
		} else {
			return objc_leaderboardIdentifier(this, leaderboardIdentifier);
		}
	}

	private static final Selector setLeaderboardIdentifier = Selector.register("setLeaderboardIdentifier:");

	@Bridge
	private native static void objc_setLeaderboardIdentifier (GKScore __self__, Selector __cmd__, String leaderboardIdentifier);

	@Bridge
	private native static void objc_setLeaderboardIdentifierSuper (ObjCSuper __super__, Selector __cmd__,
		String leaderboardIdentifier);

	/** Setter - leaderboard identifier (required)
	 * @return */
	public void setLeaderboardIdentifier (String leaderboardIdentifier) {
		if (customClass) {
			objc_setLeaderboardIdentifierSuper(getSuper(), setLeaderboardIdentifier, leaderboardIdentifier);
		} else {
			objc_setLeaderboardIdentifier(this, setLeaderboardIdentifier, leaderboardIdentifier);
		}
	}

	// @property(nonatomic, assign) uint64_t context __OSX_AVAILABLE_STARTING(__MAC_10_8,__IPHONE_5_0);
	private static final Selector context = Selector.register("context");

	@Bridge
	private native static long objc_context (GKScore __self__, Selector __cmd__);

	@Bridge
	private native static long objc_contextSuper (ObjCSuper __super__, Selector __cmd__);

	/** Getter - optional additional context that allows a game to store and retrieve additional data associated with the store.
	 * Default value of zero is returned if no value is set.
	 * @return */
	public long getContext () {
		if (customClass) {
			return objc_contextSuper(getSuper(), context);
		} else {
			return objc_context(this, context);
		}
	}

	private static final Selector setContext = Selector.register("setContext:");

	@Bridge
	private native static void objc_setContext (GKScore __self__, Selector __cmd__, long context);

	@Bridge
	private native static void objc_setContextSuper (ObjCSuper __super__, Selector __cmd__, long context);

	/** Setter - optional additional context that allows a game to store and retrieve additional data associated with the store.
	 * Default value of zero is returned if no value is set.
	 * @return */
	public void setContext (long context) {
		if (customClass) {
			objc_setContextSuper(getSuper(), setLeaderboardIdentifier, context);
		} else {
			objc_setContext(this, setLeaderboardIdentifier, context);
		}
	}

	// @property(readonly, retain, NS_NONATOMIC_IOSONLY) NSDate *date;
	private static final Selector date = Selector.register("date");

	@Bridge
	private native static NSDate objc_date (GKScore __self__, Selector __cmd__);

	@Bridge
	private native static NSDate objc_dateSuper (ObjCSuper __super__, Selector __cmd__);

	/** The date the score was recorded, defaults to [NSDate date].
	 * @return */
	public NSDate getDate () {
		if (customClass) {
			return objc_dateSuper(getSuper(), date);
		} else {
			return objc_date(this, date);
		}
	}

	// @property(readonly, retain, NS_NONATOMIC_IOSONLY) NSString *playerID;
	private static final Selector playerID = Selector.register("playerID");

	@Bridge
	private native static String objc_playerID (GKScore __self__, Selector __cmd__);

	@Bridge
	private native static String objc_playerIDSuper (ObjCSuper __super__, Selector __cmd__);

	/** The identifier of the player that recorded the score.
	 * @return */
	public String getPlayerID () {
		if (customClass) {
			return objc_playerIDSuper(getSuper(), playerID);
		} else {
			return objc_playerID(this, playerID);
		}
	}

	// @property(readonly, assign, NS_NONATOMIC_IOSONLY) NSInteger rank;
	private static final Selector rank = Selector.register("rank");

	@Bridge
	private native static int objc_rank (GKScore __self__, Selector __cmd__);

	@Bridge
	private native static int objc_rankSuper (ObjCSuper __super__, Selector __cmd__);

	/** The rank of the player within the leaderboard, only valid when returned from GKLeaderboard
	 * @return */
	public int getRank () {
		if (customClass) {
			return objc_rankSuper(getSuper(), rank);
		} else {
			return objc_rank(this, rank);
		}
	}

	// @property(nonatomic, assign) BOOL shouldSetDefaultLeaderboard __OSX_AVAILABLE_STARTING(__MAC_10_8,__IPHONE_5_0);
	private static final Selector shouldSetDefaultLeaderboard = Selector.register("shouldSetDefaultLeaderboard");

	@Bridge
	private native static boolean objc_shouldSetDefaultLeaderboard (GKScore __self__, Selector __cmd__);

	@Bridge
	private native static boolean objc_shouldSetDefaultLeaderboardSuper (ObjCSuper __super__, Selector __cmd__);

	/** Getter - Convenience property to make the leaderboard associated with this GKScore, the default leaderboard for this player.
	 * Default value is false. If true, reporting that score will make the category this score belongs to, the default leaderboard
	 * for this user
	 * @return */
	public boolean isShouldSetDefaultLeaderboard () {
		if (customClass) {
			return objc_shouldSetDefaultLeaderboardSuper(getSuper(), shouldSetDefaultLeaderboard);
		} else {
			return objc_shouldSetDefaultLeaderboard(this, shouldSetDefaultLeaderboard);
		}
	}

	private static final Selector setShouldSetDefaultLeaderboard = Selector.register("setShouldSetDefaultLeaderboard:");

	@Bridge
	private native static void objc_setShouldSetDefaultLeaderboard (GKScore __self__, Selector __cmd__,
		boolean shouldSetDefaultLeaderboard);

	@Bridge
	private native static void objc_setShouldSetDefaultLeaderboardSuper (ObjCSuper __super__, Selector __cmd__,
		boolean shouldSetDefaultLeaderboard);

	/** Setter - Convenience property to make the leaderboard associated with this GKScore, the default leaderboard for this player.
	 * Default value is false. If true, reporting that score will make the category this score belongs to, the default leaderboard
	 * for this user
	 * @return */
	public void setShouldSetDefaultLeaderboard (boolean shouldSetDefaultLeaderboard) {
		if (customClass) {
			objc_setShouldSetDefaultLeaderboardSuper(getSuper(), setShouldSetDefaultLeaderboard, shouldSetDefaultLeaderboard);
		} else {
			objc_setShouldSetDefaultLeaderboard(this, setShouldSetDefaultLeaderboard, shouldSetDefaultLeaderboard);
		}
	}

	/** Report this score to the server. The value must be set, and date may be changed. Possible reasons for error: 1. Value not
	 * set 2. Local player not authenticated 3. Communications problem
	 * @return */
	@Method(selector = "reportScores:withCompletionHandler:")
	public static native void reportScores (NSArray<?> scores, @Block VoidNSErrorBlock completionHandler);

	/** Setter - Convenience property to make the leaderboard associated with this GKScore, the default leaderboard for this player.
	 * Default value is false. If true, reporting that score will make the category this score belongs to, the default leaderboard
	 * for this user
	 * @return */
	@Deprecated
	@Method(selector = "reportScoreWithCompletionHandler:")
	public native void reportScore (@Block VoidNSErrorBlock completionHandler);

}

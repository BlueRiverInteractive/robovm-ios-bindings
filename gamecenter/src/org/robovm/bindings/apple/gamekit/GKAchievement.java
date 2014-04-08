
package org.robovm.bindings.apple.gamekit;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSDate;
import org.robovm.apple.foundation.NSObject;
import org.robovm.bindings.apple.blocks.VoidNSArrayNSErrorBlock;
import org.robovm.bindings.apple.blocks.VoidNSErrorBlock;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCSuper;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("GameKit")
@NativeClass
public class GKAchievement extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GKAchievement.class);

	// - (id)initWithIdentifier:(NSString *)identifier;
	private static final Selector initWithIdentifier = Selector.register("initWithIdentifier:");

	@Bridge
	private native static void objc_initWithIdentifier (GKAchievement __self__, Selector __cmd__, String identifier);

	@Bridge
	private native static void objc_initWithIdentifierSuper (ObjCSuper __super__, Selector __cmd__, String identifier);

	/** Designate initializer
	 * @param identifier */
	public GKAchievement (String identifier) {
		if (customClass) {
			objc_initWithIdentifierSuper(getSuper(), initWithIdentifier, identifier);
		} else {
			objc_initWithIdentifier(this, initWithIdentifier, identifier);
		}
	}

	// - (id)initWithIdentifier:(NSString *)identifier forPlayer:(NSString *)playerID
// __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_7_0);
	private static final Selector initWithIdentifier$forPlayer = Selector.register("initWithIdentifier:forPlayer:");

	@Bridge
	private native static void objc_initWithIdentifier (GKAchievement __self__, Selector __cmd__, String identifier,
		String playerID);

	@Bridge
	private native static void objc_initWithIdentifierSuper (ObjCSuper __super__, Selector __cmd__, String identifier,
		String playerID);

	/** Will initialize the achievement for a player. Can be used for submitting participant achievements when ending a turn-based
	 * match.
	 * @param identifier
	 * @param playerID */
	public GKAchievement (String identifier, String playerID) {
		if (customClass) {
			objc_initWithIdentifierSuper(getSuper(), initWithIdentifier$forPlayer, identifier, playerID);
		} else {
			objc_initWithIdentifier(this, initWithIdentifier$forPlayer, identifier, playerID);
		}
	}

	// @property(copy, NS_NONATOMIC_IOSONLY) NSString *identifier;
	private static final Selector identifier = Selector.register("identifier");

	@Bridge
	private native static String objc_getIdentifier (GKAchievement __self__, Selector __cmd__);

	@Bridge
	private native static String objc_getIdentifierSuper (ObjCSuper __super__, Selector __cmd__);

	/** Get the Achievement identifier
	 * @return */
	public String getIdentifier () {
		if (customClass) {
			return objc_getIdentifierSuper(getSuper(), identifier);
		} else {
			return objc_getIdentifier(this, identifier);
		}
	}

	// @property(assign, NS_NONATOMIC_IOSONLY) double percentComplete;
	private static final Selector percentComplete = Selector.register("percentComplete");

	@Bridge
	private native static double objc_getPercentComplete (GKAchievement __self__, Selector __cmd__);

	@Bridge
	private native static double objc_getPercentCompleteSuper (ObjCSuper __super__, Selector __cmd__);

	/** Get the Percentage of achievement completion.
	 * @return */
	public double getPercentComplete () {
		if (customClass) {
			return objc_getPercentCompleteSuper(getSuper(), percentComplete);
		} else {
			return objc_getPercentComplete(this, percentComplete);
		}
	}

	private static final Selector setPercentComplete = Selector.register("setPercentComplete:");

	@Bridge
	private native static void objc_setPercentComplete (GKAchievement __self__, Selector __cmd__, double percentComplete);

	@Bridge
	private native static void objc_setPercentCompleteSuper (ObjCSuper __super__, Selector __cmd__, double percentComplete);

	/** Set the Percentage of achievement completion.
	 * @param percentComplete */
	public void setPercentComplete (double percentComplete) {
		if (customClass) {
			objc_setPercentCompleteSuper(getSuper(), setPercentComplete, percentComplete);
		} else {
			objc_setPercentComplete(this, setPercentComplete, percentComplete);
		}
	}

	// @property(readonly, getter=isCompleted, NS_NONATOMIC_IOSONLY) BOOL completed;
	private static final Selector isCompleted = Selector.register("isCompleted");

	@Bridge
	private native static boolean objc_isCompleted (GKAchievement __self__, Selector __cmd__);

	@Bridge
	private native static boolean objc_isCompletedSuper (ObjCSuper __super__, Selector __cmd__);

	/** Set to NO until percentComplete = 100.
	 * @return */
	public boolean isCompleted () {
		if (customClass) {
			return objc_isCompletedSuper(getSuper(), isCompleted);
		} else {
			return objc_isCompleted(this, isCompleted);
		}
	}

	// @property(copy, readonly, NS_NONATOMIC_IOSONLY) NSDate *lastReportedDate;
	private static final Selector lastReportedDate = Selector.register("lastReportedDate");

	@Bridge
	private native static NSDate objc_lastReportedDate (GKAchievement __self__, Selector __cmd__);

	@Bridge
	private native static NSDate objc_lastReportedDateSuper (ObjCSuper __super__, Selector __cmd__);

	/** Date the achievement was last reported. Read-only. Created at initialization
	 * @return */
	public NSDate getLastReportedDate () {
		if (customClass) {
			return objc_lastReportedDateSuper(getSuper(), lastReportedDate);
		} else {
			return objc_lastReportedDate(this, lastReportedDate);
		}
	}

	// @property(assign, NS_NONATOMIC_IOSONLY) BOOL showsCompletionBanner
	private static final Selector setShowsCompletionBanner = Selector.register("setShowsCompletionBanner:");

	@Bridge
	private native static void objc_setShowsCompletionBanner (GKAchievement __self__, Selector __cmd__,
		boolean showsCompletionBanner);

	@Bridge
	private native static void objc_setShowsCompletionBannerSuper (ObjCSuper __super__, Selector __cmd__,
		boolean showsCompletionBanner);

	/** A banner will be momentarily displayed after reporting a completed achievement if set to true
	 * @param showsCompletionBanner */
	public void setShowsCompletionBanner (boolean showsCompletionBanner) {
		if (customClass) {
			objc_setShowsCompletionBannerSuper(getSuper(), setShowsCompletionBanner, showsCompletionBanner);
		} else {
			objc_setShowsCompletionBanner(this, setShowsCompletionBanner, showsCompletionBanner);
		}
	}

	/** Report this achievement to the server. Percent complete is required. Points, completed state are set based on
	 * percentComplete. isHidden is set to NO anytime this method is invoqued. Date is optional. Error will be nil on success.
	 * Possible reasons for error: 1. Local player not authenticated 2. Communications failure 3. Reported Achievement does not
	 * exist
	 * @param completionHandler */
	@Deprecated
	@Method(selector = "reportAchievementWithCompletionHandler:")
	public native void reportAchievement (@Block VoidNSErrorBlock completionHandler);

	/** Report an array of achievements to the server. Percent complete is required. Points, completed state are set based on
	 * percentComplete. isHidden is set to NO anytime this method is invoked. Date is optional. Error will be nil on success.
	 * Possible reasons for error: 1. Local player not authenticated 2. Communications failure 3. Reported Achievement does not
	 * exist
	 * @param achievements
	 * @param completionHandler */
	@Method(selector = "reportAchievements:withCompletionHandler:")
	public static native void reportAchievements (NSArray<?> achievements, @Block VoidNSErrorBlock completionHandler);

	/** Asynchronously load all achievements for the local player
	 * @param completionHandler */
	@Method(selector = "loadAchievementsWithCompletionHandler:")
	public static native void loadAchievements (@Block VoidNSArrayNSErrorBlock completionHandler);

	/** Reset the achievements progress for the local player. All the entries for the local player are removed from the server.
	 * Error will be nil on success. Possible reasons for error: 1. Local player not authenticated 2. Communications failure
	 * @param completionHandler */
	@Method(selector = "resetAchievementsWithCompletionHandler:")
	public static native void resetAchievements (@Block VoidNSErrorBlock completionHandler);

}

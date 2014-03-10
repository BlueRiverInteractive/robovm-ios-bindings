
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGAchievementMetadata extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGAchievementMetadata.class);

	static {
		ObjCRuntime.bind(GPGAchievementMetadata.class);
	}

	// @property(nonatomic, readonly, copy) NSString *achievementId;
	private static final Selector achievementId$ = Selector.register("achievementId");

	@Bridge
	private native static String objc_achievementId (GPGAchievementMetadata __self__, Selector __cmd__);

	public String achievementId () {
		return objc_achievementId(this, achievementId$);
	}

	// @property(nonatomic, readonly, assign) GPGAchievementState state;
	private static final Selector state$ = Selector.register("state");

	@Bridge
	private native static GPGAchievementState objc_state (GPGAchievementMetadata __self__, Selector __cmd__);

	public GPGAchievementState state () {
		return objc_state(this, state$);
	}

	// @property(nonatomic, readonly, assign) GPGAchievementType type;
	private static final Selector type$ = Selector.register("type");

	@Bridge
	private native static GPGAchievementType objc_type (GPGAchievementMetadata __self__, Selector __cmd__);

	public GPGAchievementType type () {
		return objc_type(this, type$);
	}

	// @property(nonatomic, readonly, copy) NSString *name;
	private static final Selector name$ = Selector.register("name");

	@Bridge
	private native static String objc_name (GPGAchievementMetadata __self__, Selector __cmd__);

	public String name () {
		return objc_name(this, name$);
	}

	// @property(nonatomic, readonly, copy) NSString *achievementDescription;
	private static final Selector achievementDescription$ = Selector.register("achievementDescription");

	@Bridge
	private native static String objc_achievementDescription (GPGAchievementMetadata __self__, Selector __cmd__);

	public String achievementDescription () {
		return objc_achievementDescription(this, achievementDescription$);
	}

	// @property(nonatomic, readonly, copy) NSURL *revealedIconUrl;
	private static final Selector revealedIconUrl$ = Selector.register("revealedIconUrl");

	@Bridge
	private native static NSURL objc_revealedIconUrl (GPGAchievementMetadata __self__, Selector __cmd__);

	public NSURL revealedIconUrl () {
		return objc_revealedIconUrl(this, revealedIconUrl$);
	}

	// @property(nonatomic, readonly, copy) NSURL *unlockedIconUrl;
	private static final Selector unlockedIconUrl$ = Selector.register("unlockedIconUrl");

	@Bridge
	private native static NSURL objc_unlockedIconUrl (GPGAchievementMetadata __self__, Selector __cmd__);

	public NSURL unlockedIconUrl () {
		return objc_unlockedIconUrl(this, unlockedIconUrl$);
	}

	// @property(nonatomic, readonly, assign) NSInteger completedSteps;
	private static final Selector completedSteps$ = Selector.register("completedSteps");

	@Bridge
	private native static int objc_completedSteps (GPGAchievementMetadata __self__, Selector __cmd__);

	public int completedSteps () {
		return objc_completedSteps(this, completedSteps$);
	}

	// @property(nonatomic, readonly, assign) NSInteger numberOfSteps;
	private static final Selector numberOfSteps$ = Selector.register("numberOfSteps");

	@Bridge
	private native static int objc_numberOfSteps (GPGAchievementMetadata __self__, Selector __cmd__);

	public int numberOfSteps () {
		return objc_numberOfSteps(this, numberOfSteps$);
	}

	// @property(nonatomic, readonly, copy) NSString *formattedCompletedSteps;
	private static final Selector formattedCompletedSteps$ = Selector.register("formattedCompletedSteps");

	@Bridge
	private native static String objc_formattedCompletedSteps (GPGAchievementMetadata __self__, Selector __cmd__);

	public String formattedCompletedSteps () {
		return objc_formattedCompletedSteps(this, formattedCompletedSteps$);
	}

	// @property(nonatomic, readonly, copy) NSString *formattedNumberOfSteps;
	private static final Selector formattedNumberOfSteps$ = Selector.register("formattedNumberOfSteps");

	@Bridge
	private native static String objc_formattedNumberOfSteps (GPGAchievementMetadata __self__, Selector __cmd__);

	public String formattedNumberOfSteps () {
		return objc_formattedNumberOfSteps(this, formattedNumberOfSteps$);
	}

	// @property(nonatomic, readonly, assign) long long lastUpdatedTimestamp;
	private static final Selector lastUpdatedTimestamp$ = Selector.register("lastUpdatedTimestamp");

	@Bridge
	private native static long objc_lastUpdatedTimestamp (GPGAchievementMetadata __self__, Selector __cmd__);

	public long lastUpdatedTimestamp () {
		return objc_lastUpdatedTimestamp(this, lastUpdatedTimestamp$);
	}

	// @property(nonatomic, readonly, assign) CGFloat progress;
	private static final Selector progress$ = Selector.register("progress");

	@Bridge
	private native static float objc_progress (GPGAchievementMetadata __self__, Selector __cmd__);

	public float progress () {
		return objc_progress(this, progress$);
	}
}

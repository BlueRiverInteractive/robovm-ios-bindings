
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

/** An object that represents the completion of a task or goal. Achievement objects must be created with an achievement ID. Once an
 * achievement object is created, you may interact with it using the provided set of actions.
 * @author Michael Hadash */
@Library(Library.INTERNAL)
@NativeClass()
public class GPGAchievement extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGAchievement.class);

	static {
		ObjCRuntime.bind(GPGAchievement.class);
	}

	// - (id)initWithAchievementId:(NSString *)achievementId;
	private static final Selector initWithAchievementId$ = Selector.register("initWithAchievementId:");

	@Bridge
	private native static GPGAchievement objc_initWithAchievementId (GPGAchievement __self__, Selector __cmd__,
		NSString achievementId);

	/** Initializes a newly allocated achievement object with the given achievement identifier. This is the designated initializer.
	 * @param achievementId The achievement identifier to bind to this object.
	 * @return The achievement identifier to bind to this object. */
	public GPGAchievement (String achievementId) {
		objc_initWithAchievementId(this, initWithAchievementId$, new NSString(achievementId));
	}

	// + (id)achievementWithId:(NSString *)achievementId;
	private static final Selector achievementWithId$ = Selector.register("achievementWithId:");

	@Bridge
	private native static GPGAchievement objc_achievementWithId (ObjCClass __self__, Selector __cmd__, NSString achievementId);

	/** Convenience method for initWithAchievementId:.
	 * @param achievementId The achievement identifier to bind to this object.
	 * @return A newly allocated and initialized GPGAchievement object. */
	public static GPGAchievement achievementWithId (String achievementId) {
		return objc_achievementWithId(objCClass, achievementWithId$, new NSString(achievementId));
	}

	// @property(nonatomic, readonly, copy) NSString *achievementId;
	private static final Selector achievementId$ = Selector.register("achievementId");

	@Bridge
	private native static String objc_getAchievementId (GPGAchievement __self__, Selector __cmd__);

	/** @return The unique identifier for this achievement object. */
	public String getAchievementId () {
		return objc_getAchievementId(this, achievementId$);
	}

	// @property(nonatomic, readwrite, assign) BOOL showsCompletionNotification;
	private static final Selector showsCompletionNotification$ = Selector.register("showsCompletionNotification");

	@Bridge
	private native static boolean objc_getShowsCompletionNotification (GPGAchievement __self__, Selector __cmd__);

	/** @return Whether or not to display a visual notification when this achievement is unlocked. */
	public boolean getShowsCompletionNotification () {
		return objc_getShowsCompletionNotification(this, showsCompletionNotification$);
	}

	private static final Selector setShowsCompletionNotification$ = Selector.register("setShowsCompletionNotification:");

	@Bridge
	private native static void objc_setShowsCompletionNotification (GPGAchievement __self__, Selector __cmd__,
		boolean showsCompletionNotification);

	/** @param showsCompletionNotification Whether or not to display a visual notification when this achievement is unlocked. */
	public void setShowsCompletionNotification (boolean showsCompletionNotification) {
		objc_setShowsCompletionNotification(this, setShowsCompletionNotification$, showsCompletionNotification);
	}

	// - (void)unlockAchievementWithCompletionHandler:(GPGAchievementDidUnlockBlock)completionHandler;
	private static final Selector unlockAchievementWithCompletionHandler$ = Selector
		.register("unlockAchievementWithCompletionHandler:");

	@Bridge
	private native static void objc_unlockAchievementWithCompletionHandler (GPGAchievement __self__, Selector __cmd__,
		ObjCBlock completionHandler);

	/** Initiates a request to mark this achievement as unlocked. If showsCompletionNotification is YES and this achievement has not
	 * previously been unlocked, then an achievement completion notification will be shown immediately. The completionHandler block
	 * will be called upon completion of the request. If the request fails in any way then the error parameter will be non-nil and
	 * newlyUnlocked undefined. Completing an achievement implicitly reveals it. Calling the unlock action will cancel any active
	 * reveal actions. If the device is offline when an achievement is unlocked then the achievement's state will be synced with
	 * the Google Play Games server once the Internet connection returns. The achievement will still be marked as unlocked locally.
	 * @param completionHandler (optional) A block of the form: ^(BOOL newlyUnlocked, NSError *error). newlyUnlocked will be YES if
	 *           the achievement was newly unlocked after this request was made. */
	public void unlockAchievementWithCompletionHandler (GPGAchievementDidUnlockBlock completionHandler) {
		objc_unlockAchievementWithCompletionHandler(this, unlockAchievementWithCompletionHandler$,
			GPGAchievementDidUnlockBlock.Marshaler.toObjCBlock(completionHandler));
	}

	// - (void)revealAchievementWithCompletionHandler:(GPGAchievementDidRevealBlock)completionHandler;
	private static final Selector revealAchievementWithCompletionHandler$ = Selector
		.register("revealAchievementWithCompletionHandler:");

	@Bridge
	private native static void objc_revealAchievementWithCompletionHandler (GPGAchievement __self__, Selector __cmd__,
		ObjCBlock completionHandler);

	/** Initiates a request to reveal this achievement. The completionHandler block will be called upon completion of the request.
	 * If the request fails in any way then the error parameter will be non-nil. If the device is offline when an achievement is
	 * revealed then the achievement's state will be synced with the Google Play Games server once the Internet connection returns.
	 * @param completionHandler (optional) A block of the form: ^(GPGAchievementState state, NSError *error). */
	public void revealAchievementWithCompletionHandler (GPGAchievementDidRevealBlock completionHandler) {
		objc_revealAchievementWithCompletionHandler(this, revealAchievementWithCompletionHandler$,
			GPGAchievementDidRevealBlock.Marshaler.toObjCBlock(completionHandler));
	}

	// - (void)incrementAchievementNumSteps:(NSInteger)steps completionHandler:(GPGAchievementDidIncrementBlock)completionHandler;
	private static final Selector incrementAchievementNumSteps$ = Selector
		.register("incrementAchievementNumSteps:completionHandler:");

	@Bridge
	private native static void objc_incrementAchievementNumSteps (GPGAchievement __self__, Selector __cmd__, int steps,
		ObjCBlock completionHandler);

	/** Initiates a request to increment this achievement. The completionHandler block will be called upon completion of the
	 * request. If the request fails in any way then the error parameter will be non-nil. If the device is offline when an
	 * achievement is incremented then the achievement's state will be synced with the Google Play Games server once the Internet
	 * connection returns.
	 * @param steps The number of steps by which to increment this partial achievement.
	 * @param completionHandler (optional) A block of the form: ^(BOOL newlyUnlocked, int currentSteps, NSError *error). */
	public void incrementAchievementNumSteps (int steps, GPGAchievementDidIncrementBlock completionHandler) {
		objc_incrementAchievementNumSteps(this, incrementAchievementNumSteps$, steps,
			GPGAchievementDidIncrementBlock.Marshaler.toObjCBlock(completionHandler));
	}
}

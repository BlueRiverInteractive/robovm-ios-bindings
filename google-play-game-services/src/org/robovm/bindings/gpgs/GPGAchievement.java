package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Library;
import org.robovm.rt.bro.annotation.Pointer;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGAchievement extends NSObject {


//- (instancetype)initWithAchievementId:(NSString *)achievementId;
	@Method(selector = "initWithAchievementId:")
	private native @Pointer long init(String achievementId);
	
	/*Constructor*/
	public GPGAchievement(String achievementId) {
	    super((SkipInit)null);
	    initObject(init(achievementId));
	}

//+ (instancetype)achievementWithId:(NSString *)achievementId;
	@Method(selector = "achievementWithId:")
	public static native GPGAchievement getAchievementWithId(String achievementId);

//	@property(nonatomic, readonly, copy) NSString *achievementId;
	@Property(selector = "achievementId")
	public native String getAchievementId();
//	@property(nonatomic, assign) BOOL showsCompletionNotification;
	@Property(selector = "showsCompletionNotification")
	public native boolean getShowsCompletionNotification();
	@Property(selector = "setShowsCompletionNotification:", strongRef = true)
	public native void setShowsCompletionNotification(boolean showsCompletionNotification);

//	- (void)unlockAchievementWithCompletionHandler:(GPGAchievementDidUnlockBlock)completionHandler;
//
//	- (void)revealAchievementWithCompletionHandler:(GPGAchievementDidRevealBlock)completionHandler;
//
//	- (void)incrementAchievementNumSteps:(NSInteger)steps
//	                   completionHandler:(GPGAchievementDidIncrementBlock)completionHandler;
//
//	- (void)setSteps:(NSInteger)steps
//	  completionHandler:(GPGAchievementDidSetStepsBlock)completionHandler;
//
//	- (void)resetAchievementWithCompletionHandler:(GPGAchievementDidResetBlock)completionHandler;
//
//	+ (void)resetAllAchievementsWithCompletionHandler:
//	      (GPGAllAchievementsDidResetBlock)completionHandler;
	@Method(selector = "unlockAchievementWithCompletionHandler:")
	public native void unlockAchievementWithCompletionHandler(@Block GPGAchievementDidUnlockBlock completionHandler);
	@Method(selector = "revealAchievementWithCompletionHandler:")
	public native void revealAchievementWithCompletionHandler(@Block GPGAchievementDidRevealBlock completionHandler);
	@Method(selector = "incrementAchievementNumSteps:completionHandler:")
	public native void incrementAchievementNumSteps(int steps, @Block GPGAchievementDidIncrementBlock completionHandler);
	@Method(selector = "setSteps:completionHandler:")
	public native void setSteps(@Block GPGAchievementDidSetStepsBlock completionHandler);
	@Method(selector = "resetAchievementWithCompletionHandler:")
	public native void resetAchievementWithCompletionHandler(@Block GPGAchievementDidResetBlock completionHandler);
	@Method(selector = "resetAllAchievementsWithCompletionHandler:")
	public native void resetAllAchievementsWithCompletionHandler(@Block GPGAllAchievementsDidResetBlock completionHandler);
	
}

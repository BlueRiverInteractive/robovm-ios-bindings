
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.uikit.UINavigationController;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGAchievementController extends UINavigationController {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGAchievementController.class);

	static {
		ObjCRuntime.bind(GPGAchievementController.class);
	}

	// Initializes a newly allocated achievement controller.
	// This is the designated initializer.
	// - (id)init;
	private static final Selector init$ = Selector.register("init");

	@Bridge
	private native static GPGAchievementController objc_init (GPGAchievementController __self__, Selector __cmd__);

	public GPGAchievementController () {
		objc_init(this, init$);
	}

	// The delegate through which the user will dismiss the controller.
	// @property (nonatomic, readwrite, assign) id<GPGAchievementControllerDelegate> achievementDelegate;
	private static final Selector achievementDelegate$ = Selector.register("achievementDelegate");

	@Bridge
	private native static GPGAchievementControllerDelegate objc_achievementDelegate (GPGAchievementController __self__,
		Selector __cmd__);

	public GPGAchievementControllerDelegate getAchievementDelegate () {
		return objc_achievementDelegate(this, achievementDelegate$);
	}

	private static final Selector setAchievementDelegate$ = Selector.register("setAchievementDelegate:");

	@Bridge
	private native static void objc_setAchievementDelegate (GPGAchievementController __self__, Selector __cmd__,
		GPGAchievementControllerDelegate achievementDelegate);

	public void setAchievementDelegate (GPGAchievementControllerDelegate achievementDelegate) {
		objc_setAchievementDelegate(this, setAchievementDelegate$, achievementDelegate);
	}
}


package org.robovm.bindings.apple.gamekit;

import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.ObjCSuper;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("GameKit")
@NativeClass
@Deprecated
public class GKAchievementViewController extends GKGameCenterViewController {
	private static final ObjCClass objCClass = ObjCClass.getByType(GKAchievementViewController.class);

	static {
		ObjCRuntime.bind(GKAchievementViewController.class);
	}

	protected GKAchievementViewController (SkipInit skipInit) {
		super(skipInit);
	}

	public GKAchievementViewController () {
	}

	// @property (nonatomic, assign) id<GKAchievementViewControllerDelegate> achievementDelegate;
	private static final Selector setAchievementDelegate = Selector.register("setAchievementDelegate:");

	@Bridge
	private native static void objc_setAchievementDelegate (GKAchievementViewController __self__, Selector __cmd__,
		GKAchievementViewControllerDelegate delegate);

	@Bridge
	private native static void objc_setAchievementDelegateSuper (ObjCSuper __super__, Selector __cmd__,
		GKAchievementViewControllerDelegate delegate);

	public void setAchievementDelegate (GKAchievementViewControllerDelegate delegate) {
		if (customClass) {
			objc_setAchievementDelegateSuper(getSuper(), setAchievementDelegate, delegate);
		} else {
			objc_setAchievementDelegate(this, setAchievementDelegate, delegate);
		}
	}
}

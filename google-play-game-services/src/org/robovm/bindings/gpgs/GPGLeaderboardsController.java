
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
public class GPGLeaderboardsController extends UINavigationController {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGLeaderboardsController.class);

	static {
		ObjCRuntime.bind(GPGLeaderboardsController.class);
	}

	// @property (nonatomic, readwrite, assign) id<GPGLeaderboardsControllerDelegate> leaderboardsDelegate;
	private static final Selector leaderboardsDelegate$ = Selector.register("leaderboardsDelegate");

	@Bridge
	private native static GPGLeaderboardsControllerDelegate objc_leaderboardsDelegate (GPGLeaderboardsController __self__,
		Selector __cmd__);

	public GPGLeaderboardsControllerDelegate getLeaderboardsDelegate () {
		return objc_leaderboardsDelegate(this, leaderboardsDelegate$);
	}

	private static final Selector setLeaderboardsDelegate$ = Selector.register("setLeaderboardsDelegate:");

	@Bridge
	private native static void objc_setLeaderboardsDelegate (GPGLeaderboardsController __self__, Selector __cmd__,
		GPGLeaderboardsControllerDelegate leaderboardsDelegate);

	public void setLeaderboardsDelegate (GPGLeaderboardsControllerDelegate leaderboardsDelegate) {
		objc_setLeaderboardsDelegate(this, setLeaderboardsDelegate$, leaderboardsDelegate);
	}
}

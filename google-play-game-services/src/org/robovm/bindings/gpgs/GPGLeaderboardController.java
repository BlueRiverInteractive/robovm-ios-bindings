
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.uikit.UINavigationController;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGLeaderboardController extends UINavigationController {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGLeaderboardController.class);

	static {
		ObjCRuntime.bind(GPGLeaderboardController.class);
	}

	// - (id)initWithLeaderboardId:(NSString *)leaderboardId;
	private static final Selector initWithLeaderboardId$ = Selector.register("initWithLeaderboardId:");

	@Bridge
	private native static GPGLeaderboardController objc_initWithLeaderboardId (GPGLeaderboardController __self__,
		Selector __cmd__, NSString leaderboardId);

	public GPGLeaderboardController (String leaderboardId) {
		objc_initWithLeaderboardId(this, initWithLeaderboardId$, new NSString(leaderboardId));
	}

	// @property (nonatomic, readwrite, assign) GPGLeaderboardTimeScope timeScope; // Default: GPGLeaderboardTimeScopeAllTime
	private static final Selector timeScope$ = Selector.register("timeScope");

	@Bridge
	private native static GPGLeaderboardTimeScope objc_timeScope (GPGLeaderboardController __self__, Selector __cmd__);

	public GPGLeaderboardTimeScope timeScope () {
		return objc_timeScope(this, timeScope$);
	}

	private static final Selector setTimeScope$ = Selector.register("setTimeScope:");

	@Bridge
	private native static void objc_setTimeScope (GPGLeaderboardController __self__, Selector __cmd__,
		GPGLeaderboardTimeScope scope);

	public void setTimeScope (GPGLeaderboardTimeScope scope) {
		objc_setTimeScope(this, setTimeScope$, scope);
	}

	// @property (nonatomic, readwrite, assign) id<GPGLeaderboardControllerDelegate> leaderboardDelegate;
	private static final Selector leaderboardDelegate$ = Selector.register("leaderboardDelegate");

	@Bridge
	private native static GPGLeaderboardControllerDelegate objc_leaderboardDelegate (GPGLeaderboardController __self__,
		Selector __cmd__);

	public GPGLeaderboardControllerDelegate getLeaderboardDelegate () {
		return objc_leaderboardDelegate(this, leaderboardDelegate$);
	}

	private static final Selector setLeaderboardDelegate$ = Selector.register("setLeaderboardDelegate:");

	@Bridge
	private native static void objc_setLeaderboardDelegate (GPGLeaderboardController __self__, Selector __cmd__,
		GPGLeaderboardControllerDelegate leaderboardDelegate);

	public void setLeaderboardDelegate (GPGLeaderboardControllerDelegate leaderboardDelegate) {
		objc_setLeaderboardDelegate(this, setLeaderboardDelegate$, leaderboardDelegate);
	}
}

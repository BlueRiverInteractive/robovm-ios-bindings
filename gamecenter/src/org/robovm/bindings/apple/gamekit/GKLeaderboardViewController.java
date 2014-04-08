
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
public class GKLeaderboardViewController extends GKGameCenterViewController {
	private static final ObjCClass objCClass = ObjCClass.getByType(GKLeaderboardViewController.class);

	static {
		ObjCRuntime.bind(GKLeaderboardViewController.class);
	}

	protected GKLeaderboardViewController (SkipInit skipInit) {
		super(skipInit);
	}

	public GKLeaderboardViewController () {
	}

	// @property (nonatomic, assign) id <GKLeaderboardViewControllerDelegate> leaderboardDelegate;
	private static final Selector setLeaderboardDelegate = Selector.register("setLeaderboardDelegate:");

	@Bridge
	private native static void objc_setLeaderboardDelegate (GKLeaderboardViewController __self__, Selector __cmd__,
		GKLeaderboardViewControllerDelegate leaderboardDelegate);

	@Bridge
	private native static void objc_setLeaderboardDelegateSuper (ObjCSuper __super__, Selector __cmd__,
		GKLeaderboardViewControllerDelegate leaderboardDelegate);

	public void setLeaderboardDelegate (GKLeaderboardViewControllerDelegate leaderboardDelegate) {
		if (customClass) {
			objc_setLeaderboardDelegateSuper(getSuper(), setLeaderboardDelegate, leaderboardDelegate);
		} else {
			objc_setLeaderboardDelegate(this, setLeaderboardDelegate, leaderboardDelegate);
		}
	}

	// @property (nonatomic, assign) GKLeaderboardTimeScope timeScope;
	private static final Selector setTimeScope = Selector.register("setTimeScope:");

	@Bridge
	private native static void objc_setTimeScope (GKLeaderboardViewController __self__, Selector __cmd__,
		GKLeaderboardTimeScope timeScope);

	@Bridge
	private native static void objc_setTimeScopeSuper (ObjCSuper __super__, Selector __cmd__, GKLeaderboardTimeScope timeScope);

	/** @param leaderboardTimeScope */
	public void setTimeScope (GKLeaderboardTimeScope timeScope) {
		if (customClass) {
			objc_setTimeScopeSuper(getSuper(), setTimeScope, timeScope);
		} else {
			objc_setTimeScope(this, setTimeScope, timeScope);
		}
	}

	// @property (nonatomic, retain) NSString *category;
	private static final Selector setCategory = Selector.register("setCategory:");

	@Bridge
	private native static void objc_setCategory (GKLeaderboardViewController __self__, Selector __cmd__, String category);

	@Bridge
	private native static void objc_setCategorySuper (ObjCSuper __super__, Selector __cmd__, String category);

	/** @param leaderboardIdentifier */
	public void setCategory (String category) {
		if (customClass) {
			objc_setCategorySuper(getSuper(), setCategory, category);
		} else {
			objc_setCategory(this, setCategory, category);
		}
	}

}

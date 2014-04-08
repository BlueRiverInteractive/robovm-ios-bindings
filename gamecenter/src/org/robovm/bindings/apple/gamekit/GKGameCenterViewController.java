
package org.robovm.bindings.apple.gamekit;

import org.robovm.apple.uikit.UINavigationController;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCObject;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.ObjCSuper;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

/**
 *	// View controller that provides the standard user interface for leaderboards, achievements, and challenges. Present modally from the top view controller.
 *	NS_CLASS_AVAILABLE(NA, 6_0)	
 */
/** @author CremaGamesMac27 */
@Library("GameKit")
@NativeClass
public class GKGameCenterViewController extends UINavigationController {
	private static final ObjCClass objCClass = ObjCClass.getByType(GKGameCenterViewController.class);

	static {
		ObjCRuntime.bind(GKGameCenterViewController.class);
	}

	protected GKGameCenterViewController (SkipInit skipInit) {
		super(skipInit);
	}

	public GKGameCenterViewController () {
	}

	// @property (nonatomic, assign) id<GKGameCenterControllerDelegate> gameCenterDelegate;
	private static final Selector setGameCenterDelegate = Selector.register("setGameCenterDelegate:");

	@Bridge
	private native static void objc_setGameCenterDelegate (GKGameCenterViewController __self__, Selector __cmd__,
		GKGameCenterControllerDelegate delegate);

	@Bridge
	private native static void objc_setGameCenterDelegateSuper (ObjCSuper __super__, Selector __cmd__,
		GKGameCenterControllerDelegate delegate);

	public void setGameCenterDelegate (GKGameCenterControllerDelegate delegate) {
		addStrongRef((ObjCObject)delegate);

		if (customClass) {
			objc_setGameCenterDelegateSuper(getSuper(), setGameCenterDelegate, delegate);
		} else {
			objc_setGameCenterDelegate(this, setGameCenterDelegate, delegate);
		}
	}

	// @property (nonatomic, assign) GKGameCenterViewControllerState viewState;
	private static final Selector setViewState = Selector.register("setViewState:");

	@Bridge
	private native static void objc_setViewState (GKGameCenterViewController __self__, Selector __cmd__,
		GKGameCenterViewControllerState viewState);

	@Bridge
	private native static void objc_setViewStateSuper (ObjCSuper __super__, Selector __cmd__,
		GKGameCenterViewControllerState viewState);

	public void setViewState (GKGameCenterViewControllerState viewState) {
		if (customClass) {
			objc_setViewStateSuper(getSuper(), setViewState, viewState);
		} else {
			objc_setViewState(this, setViewState, viewState);
		}
	}

	// @property (nonatomic, assign) GKLeaderboardTimeScope leaderboardTimeScope __OSX_AVAILABLE_BUT_DEPRECATED_MSG(NA, NA,
// __IPHONE_4_1, __IPHONE_7_0,
// "GKGameCenterViewController no longer supports leaderboard time scopes. Will always default to GKLeaderboardTimeScopeAllTime.");
	private static final Selector setLeaderboardTimeScope = Selector.register("setLeaderboardTimeScope:");

	@Bridge
	private native static void objc_setLeaderboardTimeScope (GKGameCenterViewController __self__, Selector __cmd__,
		GKLeaderboardTimeScope leaderboardTimeScope);

	@Bridge
	private native static void objc_setLeaderboardTimeScopeSuper (ObjCSuper __super__, Selector __cmd__,
		GKLeaderboardTimeScope leaderboardTimeScope);

	/** GKGameCenterViewController no longer supports leaderboard time scopes. Will always default to GKLeaderboardTimeScopeAllTime.
	 * @param leaderboardTimeScope */
	@Deprecated
	public void setLeaderboardTimeScope (GKLeaderboardTimeScope leaderboardTimeScope) {
		if (customClass) {
			objc_setLeaderboardTimeScopeSuper(getSuper(), setLeaderboardTimeScope, leaderboardTimeScope);
		} else {
			objc_setLeaderboardTimeScope(this, setLeaderboardTimeScope, leaderboardTimeScope);
		}
	}

	// @property (nonatomic, retain) NSString *leaderboardIdentifier __OSX_AVAILABLE_STARTING( __MAC_NA, __IPHONE_7_0);
	private static final Selector setLeaderboardIdentifier = Selector.register("setLeaderboardIdentifier:");

	@Bridge
	private native static void objc_setLeaderboardIdentifier (GKGameCenterViewController __self__, Selector __cmd__,
		String leaderboardIdentifier);

	@Bridge
	private native static void objc_setLeaderboardIdentifierSuper (ObjCSuper __super__, Selector __cmd__,
		String leaderboardIdentifier);

	/** Showing specified leaderboard
	 * @param leaderboardIdentifier */
	public void setLeaderboardIdentifier (String leaderboardIdentifier) {
		if (customClass) {
			objc_setLeaderboardIdentifierSuper(getSuper(), setLeaderboardIdentifier, leaderboardIdentifier);
		} else {
			objc_setLeaderboardIdentifier(this, setLeaderboardIdentifier, leaderboardIdentifier);
		}
	}

	// @property (nonatomic, retain) NSString *leaderboardCategory __OSX_AVAILABLE_BUT_DEPRECATED(__MAC_10_8, __MAC_NA,
// __IPHONE_4_1, __IPHONE_7_0);
	private static final Selector setLeaderboardCategory = Selector.register("setLeaderboardCategory:");

	@Bridge
	private native static void objc_setLeaderboardCategory (GKGameCenterViewController __self__, Selector __cmd__,
		String leaderboardCategory);

	@Bridge
	private native static void objc_setLeaderboardCategorySuper (ObjCSuper __super__, Selector __cmd__, String leaderboardCategory);

	/** Deprecated. Use leaderboardIdentifier instead.
	 * @param leaderboardIdentifier */
	@Deprecated
	public void setLeaderboardCategory (String leaderboardCategory) {
		if (customClass) {
			objc_setLeaderboardCategorySuper(getSuper(), setLeaderboardCategory, leaderboardCategory);
		} else {
			objc_setLeaderboardCategory(this, setLeaderboardCategory, leaderboardCategory);
		}
	}

}

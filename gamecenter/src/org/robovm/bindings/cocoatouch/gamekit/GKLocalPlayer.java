
package org.robovm.bindings.cocoatouch.gamekit;

import org.robovm.bindings.cocoatouch.blocks.VoidNSErrorBlock;
import org.robovm.bindings.cocoatouch.blocks.VoidUIViewControllerNSErrorBlock;
import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.ObjCSuper;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("GameKit")
@NativeClass
public class GKLocalPlayer extends NSObject {

	static {
		ObjCRuntime.bind(GKLocalPlayer.class);
	}

	private static final ObjCClass objCClass = ObjCClass.getByType(GKLocalPlayer.class);

	protected GKLocalPlayer (SkipInit skipInit) {
		super(skipInit);
	}

	public GKLocalPlayer () {
	}

	// + (GKLocalPlayer *)localPlayer;
	private static final Selector localPlayer = Selector.register("localPlayer");

	@Bridge
	private native static GKLocalPlayer objc_localPlayer (ObjCClass __self__, Selector __cmd__);

	/** Obtain the GKLocalPlayer object. The player is only available for offline play until logged in. A temporary player is
	 * created if no account is set up.
	 * @return */
	public static GKLocalPlayer getLocalPlayer () {
		return objc_localPlayer(objCClass, localPlayer);
	}

	// @property(readonly, getter=isAuthenticated, NS_NONATOMIC_IOSONLY) BOOL authenticated;
	private static final Selector isAuthenticated = Selector.register("isAuthenticated");

	@Bridge
	private native static boolean objc_isAuthenticated (GKLocalPlayer __self__, Selector __cmd__);

	@Bridge
	private native static boolean objc_isAuthenticatedSuper (ObjCSuper __super__, Selector __cmd__);

	/** Authentication state
	 * @return */
	public boolean isAuthenticated () {
		if (customClass) {
			return objc_isAuthenticatedSuper(getSuper(), isAuthenticated);
		} else {
			return objc_isAuthenticated(this, isAuthenticated);
		}
	}

	// @property(readonly, getter=isUnderage, NS_NONATOMIC_IOSONLY) BOOL underage;
	private static final Selector isUnderage = Selector.register("isUnderage");

	@Bridge
	private native static boolean objc_isUnderage (GKLocalPlayer __self__, Selector __cmd__);

	@Bridge
	private native static boolean objc_isUnderageSuper (ObjCSuper __super__, Selector __cmd__);

	/** Underage state
	 * @return */
	public boolean isUnderage () {
		if (customClass) {
			return objc_isUnderageSuper(getSuper(), isUnderage);
		} else {
			return objc_isUnderage(this, isUnderage);
		}
	}

	/** The authenticate handler will be called whenever the authentication process finishes or needs to show UI. The handler may be
	 * called multiple times. Authentication will happen automatically when the handler is first set and whenever the app returns
	 * to the foreground. If the authentication process needs to display UI the viewController property will be non-nil. Your
	 * application should present this view controller and continue to wait for another call of the authenticateHandler. The view
	 * controller will be dismissed automatically. Possible reasons for error: 1. Communications problem 2. User credentials
	 * invalid 3. User cancelled
	 * @param authenticateHandlerBlock */
	@Method(selector = "setAuthenticateHandler:")
	public native void setAuthenticateHandler (@Block VoidUIViewControllerNSErrorBlock authenticateHandlerBlock);

	// @property(nonatomic, readonly, retain) NSArray *friends;
	private static final Selector friends = Selector.register("friends");

	@SuppressWarnings("rawtypes")
	@Bridge
	private native static NSArray objc_friends (GKLocalPlayer __self__, Selector __cmd__);

	@SuppressWarnings("rawtypes")
	@Bridge
	private native static NSArray objc_friendsSuper (ObjCSuper __super__, Selector __cmd__);

	/** Array of player identifiers of friends for the local player. Not valid until loadFriendsWithCompletionHandler: has
	 * completed.
	 * @return */
	@SuppressWarnings("rawtypes")
	public NSArray getFriends () {
		if (customClass) {
			return objc_friendsSuper(getSuper(), friends);
		} else {
			return objc_friends(this, friends);
		}
	}

	/** Deprecated, set the authenticateHandler instead. Authentication happens automatically when the handler is set and when the
	 * app returns to foreground.
	 * @param completionHandler */
	@Deprecated
	@Method(selector = "authenticateWithCompletionHandler:")
	public native void authenticateWithCompletionHandler (@Block VoidNSErrorBlock completionHandler);

}

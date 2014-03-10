
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGApplicationModel extends GPGKeyedModel {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGApplicationModel.class);

	static {
		ObjCRuntime.bind(GPGApplicationModel.class);
	}

	// - (id)initWithApplicationId:(NSString *)applicationId;
	private static final Selector initWithApplicationId$ = Selector.register("initWithApplicationId:");

	@Bridge
	private native static GPGApplicationModel objc_initWithApplicationId (GPGApplicationModel __self__, Selector __cmd__,
		NSString applicationId);

	public GPGApplicationModel (String applicationId) {
		objc_initWithApplicationId(this, initWithApplicationId$, new NSString(applicationId));
	}

	// @property(nonatomic, readonly, retain) GPGAchievementModel *achievement;
	private static final Selector achievement$ = Selector.register("achievement");

	@Bridge
	private native static GPGAchievementModel objc_achievement (GPGApplicationModel __self__, Selector __cmd__);

	public GPGAchievementModel achievement () {
		return objc_achievement(this, achievement$);
	}

	// @property(nonatomic, readonly, retain) GPGGameMetadataModel *application;
	private static final Selector application$ = Selector.register("application");

	@Bridge
	private native static GPGGameMetadataModel objc_application (GPGApplicationModel __self__, Selector __cmd__);

	public GPGGameMetadataModel application () {
		return objc_application(this, application$);
	}

	// @property(nonatomic, readonly, retain) GPGLeaderboardModel *leaderboard;
	private static final Selector leaderboard$ = Selector.register("leaderboard");

	@Bridge
	private native static GPGLeaderboardModel objc_leaderboard (GPGApplicationModel __self__, Selector __cmd__);

	public GPGLeaderboardModel leaderboard () {
		return objc_leaderboard(this, leaderboard$);
	}

	// @property(nonatomic, readonly, retain) GPGPlayerModel *player;
	private static final Selector player$ = Selector.register("player");

	@Bridge
	private native static GPGPlayerModel objc_player (GPGApplicationModel __self__, Selector __cmd__);

	public GPGPlayerModel player () {
		return objc_player(this, player$);
	}

	// @property(nonatomic, readonly, retain) GPGAppStateModel *appState;
	private static final Selector appState$ = Selector.register("appState");

	@Bridge
	private native static GPGAppStateModel objc_appState (GPGApplicationModel __self__, Selector __cmd__);

	public GPGAppStateModel appState () {
		return objc_appState(this, appState$);
	}
}

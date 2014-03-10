
package org.robovm.bindings.gpgs.libgdx;

import java.nio.ByteBuffer;
import java.util.ArrayList;

import org.robovm.bindings.gpgs.GPGAchievementMetadata;
import org.robovm.bindings.gpgs.GPGAppStateConflictHandler;
import org.robovm.bindings.gpgs.GPGAppStateLoadResultHandler;
import org.robovm.bindings.gpgs.GPGAppStateLoadStatus;
import org.robovm.bindings.gpgs.GPGAppStateModel;
import org.robovm.bindings.gpgs.GPGAppStateWriteResultHandler;
import org.robovm.bindings.gpgs.GPGAppStateWriteStatus;
import org.robovm.bindings.gpgs.GPGLeaderboardMetadata;
import org.robovm.bindings.gpgs.GPGLeaderboardTimeScope;
import org.robovm.bindings.gpgs.GPGManager;
import org.robovm.bindings.gpgs.GPGToastPlacement;
import org.robovm.bindings.gpp.GPPURLHandler;
import org.robovm.bindings.other.NSData;
import org.robovm.bindings.playservices.PlayServicesManager;
import org.robovm.bindings.playservices.PlayServicesManager.LoginCallback;
import org.robovm.bindings.playservices.PlayServicesManager.ScoresLoaded;
import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSNumber;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.cocoatouch.glkit.GLKViewDrawableStencilFormat;
import org.robovm.cocoatouch.uikit.UIApplication;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;

public class RobovmLauncher extends IOSApplication.Delegate implements GPGSInterface {
	private IOSApplication gdxApp;
	private PlayServicesManager manager;
	private MyGame game;

	/** Option: do you want to load the savegame after login? */
	private boolean performLoadGameAfterLogin = true;

	// enter your identifiers
	private final String clientID = "349069207524-m9oi4dh8okmdfqppfk975u6ub56l3a3m.apps.googleusercontent.com";

	@Override
	protected IOSApplication createApplication () {
		final IOSApplicationConfiguration config = new IOSApplicationConfiguration();
		config.orientationPortrait = true;
		config.orientationLandscape = false;
		config.useAccelerometer = false;
		config.useCompass = false;
		config.stencilFormat = GLKViewDrawableStencilFormat.fromValue(1);

		game = new MyGame(this);
		gdxApp = new IOSApplication(game, config);

		return gdxApp;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean didFinishLaunching (UIApplication application, NSDictionary launchOptions) {
		final boolean result = super.didFinishLaunching(application, launchOptions);

		manager = new PlayServicesManager();
		manager.setClientId(clientID);
		manager.setViewController(gdxApp.getUIViewController());
		manager.setToastLocation(PlayServicesManager.TOAST_BOTH, GPGToastPlacement.GPGToastPlacementTop);
		manager.setUserDataToRetrieve(true, false);
		manager.setLoginCallback(loginCallback);
		manager.didFinishLaunching();

		return result;
	}

	private final LoginCallback loginCallback = new LoginCallback() {
		@Override
		public void success () {
			// you will probably want to let your game know somehow. Example:
			// game.gpgsLoggedIn();

			// if the savegame is to be loaded, load it now.
			if (performLoadGameAfterLogin) {
				getGameState(0);
			}
		}

		@Override
		public void error (NSError error) {
		}
	};

	@Override
	public boolean openURL (UIApplication application, NSURL url, String sourceApplication, NSObject annotation) {
		return GPPURLHandler.handleURL(url, sourceApplication, annotation);
	}

	public IOSApplication getApplication () {
		return gdxApp;
	}

	public static void main (String[] args) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(args, null, RobovmLauncher.class);
		pool.drain();
	}

	@Override
	public void login () {
		manager.login();
	}

	@Override
	public void logout () {
		manager.logout();
	}

	@Override
	public void updateGameState (int statekey, byte[] data) {
		Gdx.app.log("Google Play Game Services", "Attempt to save savegame in the cloud");

		ByteBuffer b = ByteBuffer.allocate(data.length);
		b.put(data);
		manager.cloudSave(statekey, NSData.createFromByteBuffer(b), conflictHandler, writeResultHandler);
	}

	@Override
	public void getGameState (int statekey) {
		Gdx.app.log("Google Play Game Services", "Attempt to load savegame from the cloud.");
		manager.cloudLoad(statekey, conflictHandler, loadResultHandler);
	}

	/** Called when a savegame conflict occured. */
	private final GPGAppStateConflictHandler conflictHandler = new GPGAppStateConflictHandler() {

		@Override
		public NSData invoke (NSNumber key, NSData localState, NSData remoteState) {

			// for each save state, you may implement this differently
			if (key.intValue() == 0) {
				Gdx.app.log("Google Play Game Services", "savegame state conflict!");

				// TODO: this is up to you to implement. Check the google docs for additional information. Example:
				/*
				 * ByteBuffer local = localState.getBytes(); ByteBuffer remote = remoteState.getBytes(); local.position(0);
				 * remote.position(0); byte[] localArr = new byte[local.capacity()]; byte[] remoteArr = new byte[remote.capacity()];
				 * local.get(localArr); local.get(remoteArr); byte[] b = game.getSavegameManager().resolveGameStateConflict(localArr,
				 * remoteArr); ByteBuffer buffer = ByteBuffer.allocate(b.length); buffer.put(b); NSData resolvedState =
				 * NSData.createFromByteBuffer(buffer); return resolvedState;
				 */
			}
			return remoteState;
		}
	};

	/** Called when the savegame is loaded from the cloud. */
	private final GPGAppStateLoadResultHandler loadResultHandler = new GPGAppStateLoadResultHandler() {

		@Override
		public void invoke (GPGAppStateLoadStatus status, NSError error) {
			Gdx.app.log("Google Play Game Services", "AppState load result handler invoked. Status: " + status);
			if (status == GPGAppStateLoadStatus.GPGAppStateLoadStatusSuccess) {

				Gdx.app.log("Google Play Game Services", "received savegame from the cloud.");

				// pass the received data to the game.
				GPGAppStateModel model = GPGManager.sharedInstance().applicationModel().appState();
				NSData data = model.stateDataForKey(0);
				if (data == null) {
					Gdx.app.log("Google Play Game Services", "savegame is empty.");
					return;
				}
				ByteBuffer buffer = data.getBytes();
				buffer.position(0);
				byte[] savegame = new byte[buffer.capacity()];
				buffer.get(savegame);

				// TODO: pass the savegame to your game. Example:
				// game.getSavegameManager().setSaveState(savegame);
			} else {
				performLoadGameAfterLogin = true;
			}
		}
	};

	/** Called when the savegame is stored (or failed to store) in the cloud. */
	private final GPGAppStateWriteResultHandler writeResultHandler = new GPGAppStateWriteResultHandler() {
		@Override
		public void invoke (GPGAppStateWriteStatus status, NSError error) {
			Gdx.app.log("Google Play Game Services", "AppState write result handler invoked. Status: " + status);
			if (status == GPGAppStateWriteStatus.GPGAppStateWriteStatusSuccess) {
				Gdx.app.log("Google Play Game Services", "savegame successfully saved in the cloud.");
			}
		}
	};

	@Override
	public ArrayList<GPGAchievementMetadata> getAchievements () {
		return manager.getAchievementsList();
	}

	@Override
	public void getScoresOfLeaderboard (String leaderboardId, boolean social, GPGLeaderboardTimeScope timeScope,
		ScoresLoaded callback) {
		manager.getScoresOfLeaderboard(leaderboardId, social, timeScope, callback);
	}

	@Override
	public ArrayList<GPGLeaderboardMetadata> getLeaderboards () {
		return manager.getLeaderboardsList();
	}
}

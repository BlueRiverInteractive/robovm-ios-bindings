
package org.robovm.bindings.playservices;

import java.util.ArrayList;

import org.robovm.bindings.gpgs.GPGAchievement;
import org.robovm.bindings.gpgs.GPGAchievementController;
import org.robovm.bindings.gpgs.GPGAchievementControllerDelegate;
import org.robovm.bindings.gpgs.GPGAchievementDidIncrementBlock;
import org.robovm.bindings.gpgs.GPGAchievementDidRevealBlock;
import org.robovm.bindings.gpgs.GPGAchievementDidUnlockBlock;
import org.robovm.bindings.gpgs.GPGAchievementMetadata;
import org.robovm.bindings.gpgs.GPGAchievementModel;
import org.robovm.bindings.gpgs.GPGAchievementState;
import org.robovm.bindings.gpgs.GPGAppStateConflictHandler;
import org.robovm.bindings.gpgs.GPGAppStateLoadResultHandler;
import org.robovm.bindings.gpgs.GPGAppStateModel;
import org.robovm.bindings.gpgs.GPGAppStateWriteResultHandler;
import org.robovm.bindings.gpgs.GPGAppStateWriteStatus;
import org.robovm.bindings.gpgs.GPGLeaderboard;
import org.robovm.bindings.gpgs.GPGLeaderboardController;
import org.robovm.bindings.gpgs.GPGLeaderboardControllerDelegate;
import org.robovm.bindings.gpgs.GPGLeaderboardLoadScoresBlock;
import org.robovm.bindings.gpgs.GPGLeaderboardMetadata;
import org.robovm.bindings.gpgs.GPGLeaderboardModel;
import org.robovm.bindings.gpgs.GPGLeaderboardTimeScope;
import org.robovm.bindings.gpgs.GPGLeaderboardsController;
import org.robovm.bindings.gpgs.GPGLeaderboardsControllerDelegate;
import org.robovm.bindings.gpgs.GPGManager;
import org.robovm.bindings.gpgs.GPGReAuthenticationBlock;
import org.robovm.bindings.gpgs.GPGScore;
import org.robovm.bindings.gpgs.GPGScoreReport;
import org.robovm.bindings.gpgs.GPGScoreReportScoreBlock;
import org.robovm.bindings.gpgs.GPGToastPlacement;
import org.robovm.bindings.gpp.GPPShare;
import org.robovm.bindings.gpp.GPPSignIn;
import org.robovm.bindings.gpp.GPPSignInDelegate;
import org.robovm.bindings.gt.GTMOAuth2Authentication;
import org.robovm.bindings.other.NSData;
import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.objc.ObjCClass;

/** Manager that handles the most common usage of Google Play Game Services.
 * @author Michael Hadash */
public class PlayServicesManager extends NSObject implements GPPSignInDelegate, GPGAchievementControllerDelegate,
	GPGLeaderboardControllerDelegate, GPGLeaderboardsControllerDelegate {

	public static final int TOAST_WELCOME = 0;
	public static final int TOAST_ACHIEVEMENTS = 1;
	public static final int TOAST_BOTH = 2;
	public static final int DATA_NAME = 0;
	public static final int DATA_AVATAR = 1;
	public static final int DATA_ID = 2;

	// identifiers
	private String clientId;

	// view controller
	private UIViewController viewController;

	// blocks
	private GPGReAuthenticationBlock gamesAuthBlock;
	private GPGAchievementDidRevealBlock revealBlock;
	private GPGAchievementDidIncrementBlock incrementBlock;
	private GPGAchievementDidUnlockBlock unlockBlock;
	private GPGAppStateWriteResultHandler cloudCompletionHandler;
	private GPGScoreReportScoreBlock postScoreCompletionHandler;

	// options
	private boolean fetchName = false;
	private boolean fetchEmail = false;
	private boolean fetchId = true;

	// used to fix a RoboVM bug with NSArray
	static {
		ObjCClass.getByType(GPGAchievementMetadata.class);
		ObjCClass.getByType(GPGLeaderboardMetadata.class);
		ObjCClass.getByType(GPGScore.class);
	}

	/** interface to get a callback when the login finished. */
	public interface LoginCallback {
		public void success ();

		public void error (NSError error);
	};

	/** interface to get a callback when the scores have loaded. */
	public interface ScoresLoaded {
		public void invoke (ArrayList<GPGScore> scores);
	};

	private GPGLeaderboardLoadScoresBlock loadScoresBlock = new GPGLeaderboardLoadScoresBlock() {
		@Override
		public void invoke (NSArray<GPGScore> scores, NSError error) {
			if (error != null) {
				System.out.println("[Error] PlayServicesManager: An error occured while loading the scores: " + error.description());
				return;
			}

			// convert to an ArrayList
			ArrayList<GPGScore> list = new ArrayList<GPGScore>();
			for (int i = 0; i < scores.size(); i++) {
				list.add(scores.get(i));
			}

			// invoke the callback
			scoresLoaded.invoke(list);
		}
	};

	private LoginCallback loginCallback;
	private ScoresLoaded scoresLoaded;

	/** Call this in your app's didFinishLaunching() method. You must specify your clientID and, if you need user data, what data to
	 * load during login before calling this. */
	public void didFinishLaunching () {
		GPPSignIn signIn = GPPSignIn.sharedInstance();
		signIn.setClientID(clientId);

		// set scopes
		ArrayList<NSString> scopes = new ArrayList<NSString>();
		scopes.add(new NSString("https://www.googleapis.com/auth/plus.login"));
		scopes.add(new NSString("https://www.googleapis.com/auth/games"));
		scopes.add(new NSString("https://www.googleapis.com/auth/appstate"));
		signIn.setScopes(new NSArray<NSString>(scopes));

		signIn.setDelegate(this);
		signIn.setShouldFetchGoogleUserID(fetchId);
		signIn.setShouldFetchGoogleUserEmail(fetchEmail);
		signIn.setShouldFetchGooglePlusUser(fetchName);

		// try to sign in silently
		signIn.trySilentAuthentication();

		// define blocks
		revealBlock = new GPGAchievementDidRevealBlock() {
			@Override
			public void invoke (GPGAchievementState state, NSError error) {
				if (error != null) {
					System.out.println("Error while revealing achievement!");
				}
			}
		};
		incrementBlock = new GPGAchievementDidIncrementBlock() {
			@Override
			public void invoke (boolean newlyUnlocked, int currentSteps, NSError error) {
				if (error != null) {
					System.out.println("Error while revealing!");
				}
			}
		};
		unlockBlock = new GPGAchievementDidUnlockBlock() {
			@Override
			public void invoke (boolean newlyUnlocked, NSError error) {
				if (error != null) {
					System.out.println("Error while unlocking!");
				}
			}
		};
		cloudCompletionHandler = new GPGAppStateWriteResultHandler() {
			@Override
			public void invoke (GPGAppStateWriteStatus status, NSError error) {
				switch (status) {
				case GPGAppStateWriteStatusSuccess:
					System.out.println("cloud save succeeded!");
					break;
				case GPGAppStateWriteStatusBadKeyDataOrVersion:
					System.out.println("cloud save failed: bad key or version");
					break;
				case GPGAppStateWriteStatusConflict:
					System.out.println("cloud save failed: conflict");
					break;
				case GPGAppStateWriteStatusKeysQuotaExceeded:
					System.out.println("cloud save failed: keys quota exceeded");
					break;
				case GPGAppStateWriteStatusNotFound:
					System.out.println("cloud save failed: not found");
					break;
				case GPGAppStateWriteStatusSizeExceeded:
					System.out.println("cloud save failed: size exceeded");
					break;
				case GPGAppStateWriteStatusUnknownError:
					System.out.println("cloud save failed: unknown error");
					break;
				}
			}
		};
		postScoreCompletionHandler = new GPGScoreReportScoreBlock() {
			@Override
			public void invoke (GPGScoreReport report, NSError error) {
				if (error != null) {
					System.out.println("score posting failed!");
				}
			}
		};
	}

	@Override
	public void finishedWithAuth (GTMOAuth2Authentication auth, NSError error) {
		if (error == null) {

			// after the google+ sign-in is done, we must continue the sign-in of 'games'.
			startGoogleGamesSignIn();

			// invoke the callback if it is set.
			if (loginCallback != null) {
				loginCallback.success();
			}
		} else {

			// invoke the callback if it is set.
			if (loginCallback != null) {
				loginCallback.error(error);
			}

			System.out.println("error during login: " + error.description());
		}
	}

	/** Continues the sign-in process. */
	private void startGoogleGamesSignIn () {
		final GPPSignIn s = GPPSignIn.sharedInstance();
		GPGManager m = GPGManager.sharedInstance();

		gamesAuthBlock = new GPGReAuthenticationBlock() {
			@Override
			public void invoke (boolean requiresKeychainWipe, NSError error) {
				// If you hit this, auth has failed and you need to authenticate.
				// Most likely you can refresh behind the scenes
				if (requiresKeychainWipe) {
					s.signOut();
				}
				s.authenticate();
			}
		};

		// pass the GPPSignIn to the GPGManager.
		m.signIn(s, gamesAuthBlock);
	}

	/** Do not use this. This could not be a private member, but do as if it doesn't exists. */
	@Override
	public void achievementViewControllerDidFinish (GPGAchievementController viewController) {
		viewController.dismissViewController(true, null);
	}

	/** Do not use this. This could not be a private member, but do as if it doesn't exists. */
	@Override
	public void leaderboardViewControllerDidFinish (GPGLeaderboardController viewController) {
		viewController.dismissViewController(true, null);
	}

	/** Do not use this. This could not be a private member, but do as if it doesn't exists. */
	@Override
	public void leaderboardsViewControllerDidFinish (GPGLeaderboardsController viewController) {
		viewController.dismissViewController(true, null);
	}

	/** Logs you in into Google Play Game Services using the 'games' and 'appstate' scopes. Only call this when the user pressed a
	 * designated login button. */
	public void login () {
		GPPSignIn.sharedInstance().authenticate();
	}

	/** Sets a callback that will be invoked when the user is logged in successfully.
	 * @param callback the callback. */
	public void setLoginCallback (LoginCallback callback) {
		loginCallback = callback;
	}

	/** Logs you in into Google Play Game Services using the 'games' and 'appstate' scopes. Only call this when the user pressed a
	 * designated login button. */
	public void login (LoginCallback callback) {
		loginCallback = callback;
		GPPSignIn.sharedInstance().authenticate();
	}

	/** Signs the user out of the services. */
	public void logout () {
		if (isLoggedIn()) {
			GPPSignIn.sharedInstance().signOut();
			GPGManager.sharedInstance().signout();
		}
	}

	/** @return whether the user is logged in. */
	public boolean isLoggedIn () {
		if (GPGManager.sharedInstance() == null) {
			return false;
		} else {
			return GPGManager.sharedInstance().hasAuthorizer();
		}
	}

	/** Call this to pass your client identifier.
	 * @param clientId the identifier. You can find the identifier in the Google Play Developers Console. */
	public void setClientId (String clientId) {
		this.clientId = clientId;
	}

	/** Changes the location where toast messages are displayed.
	 * @param toastType the type of toast of which you would like to change the location. Choose from the manager's static fields.
	 * @param placement the placement that you want for the toasts. */
	public void setToastLocation (int toastType, GPGToastPlacement placement) {
		switch (toastType) {
		case TOAST_ACHIEVEMENTS:
			GPGManager.sharedInstance().setAchievementUnlockedToastPlacement(placement);
			break;

		case TOAST_WELCOME:
			GPGManager.sharedInstance().setWelcomeBackToastPlacement(placement);
			break;

		case TOAST_BOTH:
			GPGManager.sharedInstance().setAchievementUnlockedToastPlacement(placement);
			GPGManager.sharedInstance().setWelcomeBackToastPlacement(placement);
			break;
		}
	}

	/** Select the data that you would like to receive from google about the user.
	 * @param name the full name.
	 * @param email the email address. */
	public void setUserDataToRetrieve (boolean name, boolean email) {
		fetchName = name;
		fetchEmail = email;
	}

	/** Let the manager know of your root view controller. */
	public void setViewController (UIViewController viewController) {
		this.viewController = viewController;
	}

	/** Pops the achievements view controller. This displays all the achievements and the user's progress. */
	public void showAchievements () {
		GPGAchievementController achController = new GPGAchievementController();
		achController.setAchievementDelegate(this);
		viewController.presentViewController(achController, true, null);
	}

	/** @return an ArrayList containing all data about your achievements and your user's progress. */
	public ArrayList<GPGAchievementMetadata> getAchievementsList () {

		// get the achievement model
		GPGAchievementModel model = GPGManager.sharedInstance().applicationModel().achievement();

		// obtain the data and put it in a list
		ArrayList<GPGAchievementMetadata> list = new ArrayList<GPGAchievementMetadata>();
		NSArray<GPGAchievementMetadata> dat = model.allMetadata();
		for (int i = 0; i < dat.size(); i++) {
			GPGAchievementMetadata n = dat.get(i);
			if (n != null) {
				list.add(n);
			} else {
				System.out.println("[Warning] PlayServicesManager: One of your achievements could not be listed.");
			}
		}

		// return the list
		return list;
	}

	/** Reveals a hidden achievement.
	 * @param identifier the achievement identifier. */
	public void revealAchievement (String identifier) {
		GPGAchievement a = GPGAchievement.achievementWithId(identifier);
		a.revealAchievementWithCompletionHandler(revealBlock);
	}

	/** Reveals a hidden achievement.
	 * @param identifier the achievement identifier.
	 * @param block a block that is invoked when the reveal process ends. Used to check whether it succeeded. Note: make the block
	 *           an instance member to be sure it is not garbage collected. */
	public void revealAchievement (String identifier, GPGAchievementDidRevealBlock block) {
		GPGAchievement a = GPGAchievement.achievementWithId(identifier);
		a.revealAchievementWithCompletionHandler(block);
	}

	/** Increments an achievement.
	 * @param identifier the achievement identifier.
	 * @param steps number of steps to increment. */
	public void incrementAchievement (String identifier, int steps) {
		GPGAchievement a = GPGAchievement.achievementWithId(identifier);
		a.incrementAchievementNumSteps(steps, incrementBlock);
	}

	/** Increments an achievement.
	 * @param identifier the achievement identifier.
	 * @param steps number of steps to increment.
	 * @param block a block that is invoked when the increment process ends. Used to check whether it succeeded. Note: make the
	 *           block an instance member to be sure it is not garbage collected. */
	public void incrementAchievement (String identifier, int steps, GPGAchievementDidIncrementBlock block) {
		GPGAchievement a = GPGAchievement.achievementWithId(identifier);
		a.incrementAchievementNumSteps(steps, block);
	}

	/** Unlocks an achievement.
	 * @param identifier the achievement identifier. */
	public void unlockAchievement (String identifier) {
		GPGAchievement a = GPGAchievement.achievementWithId(identifier);
		a.unlockAchievementWithCompletionHandler(unlockBlock);
	}

	/** Unlocks an achievement.
	 * @param identifier the achievement identifier.
	 * @param block a block that is invoked when the unlock process ends. Used to check whether it succeeded. Note: make the block
	 *           an instance member to be sure it is not garbage collected. */
	public void unlockAchievement (String identifier, GPGAchievementDidUnlockBlock block) {
		GPGAchievement a = GPGAchievement.achievementWithId(identifier);
		a.unlockAchievementWithCompletionHandler(block);
	}

	/** Posts data (savegame) to google.
	 * @param stateKey your state slot. Can be: 0, 1, 2, 3.
	 * @param data the data that you wish to store. It has a maximum size, which can be found in google's documentation.
	 * @param conflictHandler handler that defines what to do when a conflict occured. It is very important for the user experience
	 *           to implement this correctly. */
	public void cloudSave (int stateKey, NSData data, GPGAppStateConflictHandler conflictHandler) {
		// get the model
		GPGAppStateModel model = GPGManager.sharedInstance().applicationModel().appState();

		// add the data
		model.setStateData(data, stateKey);

		// post the data
		model.updateForKey(stateKey, cloudCompletionHandler, conflictHandler);
	}

	/** Posts data (savegame) to google.
	 * @param stateKey your state slot. Can be: 0, 1, 2, 3.
	 * @param data the data that you wish to store. It has a maximum size, which can be found in google's documentation.
	 * @param conflictHandler handler that defines what to do when a conflict occured. It is very important for the user experience
	 *           to implement this correctly.
	 * @param resultHandler handler that is invoked to inform you whether it succeeded or not. */
	public void cloudSave (int stateKey, NSData data, GPGAppStateConflictHandler conflictHandler,
		GPGAppStateWriteResultHandler resultHandler) {
		// get the model
		GPGAppStateModel model = GPGManager.sharedInstance().applicationModel().appState();

		// add the data
		model.setStateData(data, stateKey);

		// post the data
		model.updateForKey(stateKey, resultHandler, conflictHandler);
	}

	/** Loads data (savegame) from google.
	 * @param stateKey your state slot. Can be: 0, 1, 2, 3.
	 * @param conflictHandler handler that defines what to do when a conflict occured. It is very important for the user experience
	 *           to implement this correctly.
	 * @param resultHandler handler that is invoked to inform you whether it is succeeded or not. If it succeeded, the handler will
	 *           also contain the data that you requested. */
	public void cloudLoad (int stateKey, GPGAppStateConflictHandler conflictHandler, GPGAppStateLoadResultHandler resultHandler) {

		// get the model
		final GPGAppStateModel model = GPGManager.sharedInstance().applicationModel().appState();

		// start the load request
		model.loadForKey(stateKey, resultHandler, conflictHandler);
	}

	/** Clears data at google.
	 * @param stateKey your state slot. Can be: 0, 1, 2, 3.
	 * @param conflictHandler handler that defines what to do when a conflict occured. It is very important for the user experience
	 *           to implement this correctly.
	 * @param resultHandler handler that is invoked to inform you whether it is succeeded or not. If it succeeded, the handler will
	 *           also contain the data that you requested. */
	public void cloudClear (int stateKey, GPGAppStateConflictHandler conflictHandler, GPGAppStateWriteResultHandler resultHandler) {

		// get the model
		final GPGAppStateModel model = GPGManager.sharedInstance().applicationModel().appState();

		// clear the state
		model.clearForKey(stateKey, resultHandler, conflictHandler);
	}

	/** Retrieves data about the local player.
	 * @param dataType the data that you want. Choose from DATA_NAME, DATA_AVATAR and DATA_ID. These values are available as static
	 *           members of PlayServicesManager. */
	public String getUserData (int dataType) {
		switch (dataType) {
		case DATA_NAME:
			return GPGManager.sharedInstance().applicationModel().player().localPlayer().name();
		case DATA_AVATAR:
			return GPGManager.sharedInstance().applicationModel().player().localPlayer().avatarUrl().toString();
		case DATA_ID:
			return GPGManager.sharedInstance().applicationModel().player().localPlayer().playerId();
		}
		return "";
	}

	/** Call to display a specific leaderboard.
	 * @param identifier the leaderboard identifier. */
	public void showLeaderboard (String identifier) {
		showLeaderboard(identifier, GPGLeaderboardTimeScope.GPGLeaderboardTimeScopeAllTime);
	}

	/** Call to display a specific leaderboard.
	 * @param identifier the leaderboard identifier.
	 * @param timeScope the default time scope to display. */
	public void showLeaderboard (String identifier, GPGLeaderboardTimeScope timeScope) {
		// create the view controller
		GPGLeaderboardController leadController = new GPGLeaderboardController(identifier);
		leadController.setLeaderboardDelegate(this);

		// you can choose the default time scope to display in the view controller.
		leadController.setTimeScope(timeScope);

		// present the leaderboard view controller
		viewController.presentViewController(leadController, true, null);
	}

	/** Displays a list of all leaderboards. The user can then select a leaderboard to display any leaderboard they want from your
	 * app. */
	public void showLeaderboardsPicker () {
		// create the view controller
		GPGLeaderboardsController leadsController = new GPGLeaderboardsController();
		leadsController.setLeaderboardsDelegate(this);

		// present the leaderboard picker view controller
		viewController.presentViewController(leadsController, true, null);
	}

	/** Posts a score to a leaderboard.
	 * @param leaderboardId the identifier of the leaderboard.
	 * @param score the score. */
	public void postScore (String leaderboardId, long score) {
		postScore(leaderboardId, score, postScoreCompletionHandler);
	}

	/** Posts a score to a leaderboard.
	 * @param leaderboardId the identifier of the leaderboard.
	 * @param score the score.
	 * @param block a block that is invoked when the posting is completed. It contains data about whether it succeeded and whether
	 *           it is a highscore or not (and in which time scopes). It will also contain the actual high score if the posted
	 *           score is not the highscore in the particular time scope. */
	public void postScore (String leaderboardId, long score, GPGScoreReportScoreBlock block) {
		// create the score instance
		GPGScore gpgScore = new GPGScore(leaderboardId);
		gpgScore.setValue(score);

		// post the score
		gpgScore.submitScoreWithCompletionHandler(block);
	}

	/** @return an ArrayList containing all data about your leaderboards. */
	public ArrayList<GPGLeaderboardMetadata> getLeaderboardsList () {

		// get the leaderboard model
		GPGLeaderboardModel model = GPGManager.sharedInstance().applicationModel().leaderboard();

		// obtain the data and put it in a list
		ArrayList<GPGLeaderboardMetadata> list = new ArrayList<GPGLeaderboardMetadata>();
		NSArray<GPGLeaderboardMetadata> dat = model.allMetadata();
		for (int i = 0; i < dat.size(); i++) {
			GPGLeaderboardMetadata n = dat.get(i);
			if (n != null) {
				list.add(n);
			} else {
				System.out.println("[Warning] PlayServicesManager: One of your leaderboards could not be listed.");
			}
		}

		// return the list
		return list;
	}

	/** Loads the scores of a leaderboard.
	 * @param leaderboardId the leaderboard identifier.
	 * @param social whether you want social or global scores.
	 * @param timeScope the time scopes where you want the scores for.
	 * @param callback the completion handler. This is invoked when the scores are received. */
	public void getScoresOfLeaderboard (String leaderboardId, boolean social, GPGLeaderboardTimeScope timeScope,
		ScoresLoaded callback) {

		// set the callback
		scoresLoaded = callback;

		// create the leaderboard class
		GPGLeaderboard b = GPGLeaderboard.leaderboardWithId(leaderboardId);

		// set options
		b.setSocial(social);
		b.setTimeScope(timeScope);

		// load the scores
		b.loadScoresWithCompletionHandler(loadScoresBlock);
	}

	// share dialog
	/** the most basic way to open the share dialog */
	public void gppShare_openBasicShareDialog () {
		GPPShare.sharedInstance().shareDialog().open();
	}

	/** Sets the URL resource to be shared. and opens the dialog
	 * 
	 * @param the url the user will be directed to when clicking through */
	public void gppShare_setURLToShareAndOpen (String urlToShare) {
		GPPShare.sharedInstance().shareDialog().setURLToShare(new NSURL(urlToShare)).open();
	}

	/** Sets the text to prefill user's comment in the share dialog. and opens the dialog
	 * 
	 * @param the prefilled coment that wil be displayd on the google plus wall */
	public void gppShare_setPrefillTextAndOpen (String prefillText) {
		GPPShare.sharedInstance().shareDialog().setPrefillText(new NSString(prefillText)).open();
	}

	/** Sets the title, description, and thumbnail URL of the shared content preview in the share dialog. Only set these fields if
	 * you are sharing with a content deep link and don't have a URL resource. |title| is required.
	 * @param title
	 * @param description
	 * @param thumbnailURL */
	public void gppShare_setTitleAndOpen (String title, String description, String thumbnailURL) {
		GPPShare.sharedInstance().shareDialog().setTitle(new NSString(title), new NSString(description), new NSURL(thumbnailURL))
			.open();
	}

	/** Sets the content deep-link ID that takes the user straight to your shared content. Only set this field if you want the
	 * content deep-linking feature. The content deep-link ID can either be a fully qualified URI, or URI path, which can be up to
	 * 512 characters in length.
	 * @param title
	 * @param description
	 * @param thumbnailURL
	 * @param contentDeepLinkID */
	public void gppShare_setTitleDeepLinkAndOpen (String title, String description, String thumbnailURL, String contentDeepLinkID) {
		GPPShare.sharedInstance().shareDialog().setTitle(new NSString(title), new NSString(description), new NSURL(thumbnailURL))
			.setContentDeepLinkID(new NSString(contentDeepLinkID)).open();
	}

	/** Sets the call-to-action button of the shared content preview. The call-to-action button consists of a label, URL, and
	 * deep-link ID. The |label| is a string key defined under "data-calltoactionlabel" on
	 * http://developers.google.com/+/web/share/interactive#button_attr_calltoactionlabel that maps to the actual button text. The
	 * |url| is where the user is taken to after tapping on the button. The optional |deepLinkID| is the call-to-action deep-link
	 * ID that takes the user straight to a specific action in your app. It can either be a fully qualified URI, or URI path, which
	 * can be up to 512 characters in length. Note: In order to set the call-to-action button: User must have been authenticated
	 * with scopes including "https://www.googleapis.com/auth/plus.login".
	 * @param label
	 * @param urlToShare
	 * @param contentDeepLinkID */
	public void gppShare_setCallToActionButtonWithLabel (String label, String urlToShare, String contentDeepLinkID) {
		GPPShare.sharedInstance().shareDialog().setURLToShare(new NSURL(urlToShare))
			.setCallToActionButtonWithLabel(new NSString(label), new NSURL(urlToShare), new NSString(contentDeepLinkID)).open();
	}
}

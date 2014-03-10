
package org.robovm.bindings.gpgs.sample;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Random;

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
import org.robovm.bindings.gpgs.GPGAppStateLoadStatus;
import org.robovm.bindings.gpgs.GPGAppStateModel;
import org.robovm.bindings.gpgs.GPGAppStateWriteResultHandler;
import org.robovm.bindings.gpgs.GPGAppStateWriteStatus;
import org.robovm.bindings.gpgs.GPGLeaderboardController;
import org.robovm.bindings.gpgs.GPGLeaderboardControllerDelegate;
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
import org.robovm.bindings.gpp.GPPSignIn;
import org.robovm.bindings.gpp.GPPSignInDelegate;
import org.robovm.bindings.gpp.GPPURLHandler;
import org.robovm.bindings.gt.GTMOAuth2Authentication;
import org.robovm.bindings.other.NSData;
import org.robovm.cocoatouch.coregraphics.CGRect;
import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSNumber;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;
import org.robovm.cocoatouch.uikit.UIButton;
import org.robovm.cocoatouch.uikit.UIColor;
import org.robovm.cocoatouch.uikit.UIControl;
import org.robovm.cocoatouch.uikit.UIControl.OnTouchUpInsideListener;
import org.robovm.cocoatouch.uikit.UIControlState;
import org.robovm.cocoatouch.uikit.UIEvent;
import org.robovm.cocoatouch.uikit.UIScreen;
import org.robovm.cocoatouch.uikit.UITextView;
import org.robovm.cocoatouch.uikit.UIView;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.cocoatouch.uikit.UIWindow;

/** Sample implementation of Google Play Game Services.
 * @author Michael Hadash */
public class Sample extends UIApplicationDelegate.Adapter implements GPPSignInDelegate, GPGAchievementControllerDelegate,
	GPGLeaderboardControllerDelegate, GPGLeaderboardsControllerDelegate {

	// identifiers
	static final String kClientId = "349069207524-m9oi4dh8okmdfqppfk975u6ub56l3a3m.apps.googleusercontent.com";
	static final String ACH1 = "xxx";
	static final String ACH2 = "xxx";
	static final String ACH3 = "xxx";
	static final String ACH4 = "xxx";
	static final String ACH5 = "xxx";
	static final String ACH6 = "xxx";
	static final String LEAD1 = "xxx";
	static final String LEAD2 = "xxx";

	// layout components
	private UITextView tv;
	private UIWindow window;
	private UIViewController viewController;
	private UIView view;
	private UIButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15;
	private OnTouchUpInsideListener b1tl, b2tl, b3tl, b4tl, b5tl, b6tl, b7tl, b8tl, b9tl, b10tl, b11tl, b12tl, b13tl, b14tl,
		b15tl;

	// google play fields
	private boolean signedIn = false;
	private GPGAchievementDidRevealBlock revealBlock;
	private GPGAchievementDidIncrementBlock incrementBlock;
	private GPGAchievementDidUnlockBlock unlockBlock;
	private GPGAppStateWriteResultHandler cloudCompletionHandler;
	private GPGAppStateConflictHandler cloudConflictHandler;
	private GPGAppStateLoadResultHandler cloudLoadCompletionHandler;
	private GPGScoreReportScoreBlock postScoreCompletionHandler;

	@Override
	public void didFinishLaunching (UIApplication application) {

		// create user interface
		window = new UIWindow(UIScreen.getMainScreen().getBounds());
		window.makeKeyAndVisible();
		viewController = new UIViewController();

		// create text view
		tv = new UITextView(new CGRect(10, 10, 200, 30));
		tv.setBackgroundColor(UIColor.whiteColor());
		tv.setTextColor(UIColor.blackColor());
		tv.setText("not authenticated.");

		final Sample cThis = this;

		// create login button
		b1 = new UIButton(new CGRect(10, 60, 200, 30));
		b1.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		b1.setTitle("Login", UIControlState.Normal);
		b1tl = new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				System.out.println("Starting login flow.");

				GPPSignIn.sharedInstance().authenticate();
			}
		};
		b1.addOnTouchUpInsideListener(b1tl);

		// create get logged in button
		b2 = new UIButton(new CGRect(10, 110, 200, 30));
		b2.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		b2.setTitle("Ask Logged In", UIControlState.Normal);
		b2tl = new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				System.out.println("requesting state.");

				GPPSignIn signIn = GPPSignIn.sharedInstance();
				GTMOAuth2Authentication auth = signIn.getAuthentication();
				if (auth == null) {
					tv.setText("Not logged in.");
					System.out.println("Not logged in.");
				} else {
					tv.setText("Logged in.");
					System.out.println("Logged in.");
				}
			}
		};
		b2.addOnTouchUpInsideListener(b2tl);

		// create sign out button
		b3 = new UIButton(new CGRect(10, 160, 200, 30));
		b3.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		b3.setTitle("Sign out", UIControlState.Normal);
		b3tl = new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				System.out.println("signing out.");

				GPPSignIn signIn = GPPSignIn.sharedInstance();
				signIn.signOut();
				GPGManager m = GPGManager.sharedInstance();
				if (m.hasAuthorizer()) {
					m.signout();
				}
				signedIn = false;
			}
		};
		b3.addOnTouchUpInsideListener(b3tl);

		// create sign out button
		b4 = new UIButton(new CGRect(10, 210, 200, 30));
		b4.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		b4.setTitle("Show Achievements", UIControlState.Normal);
		b4tl = new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				if (signedIn) {
					System.out.println("showing achievements.");
					GPGAchievementController achController = new GPGAchievementController();
					achController.setAchievementDelegate(cThis);
					cThis.viewController.presentViewController(achController, true, null);
				} else {
					System.out.println("sign in first.");
				}
			}
		};
		b4.addOnTouchUpInsideListener(b4tl);

		// create output achievements button
		b5 = new UIButton(new CGRect(10, 260, 200, 30));
		b5.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		b5.setTitle("List Achievements", UIControlState.Normal);
		b5tl = new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				if (signedIn) {
					System.out.println("listing achievements.");

					// The most appropriate way produces an error due to a casting bug. You cannot use this until it is fixed.
					/*
					 * NSArray<GPGAchievementMetadata> arr =
					 * GPGManager.sharedInstance().applicationModel().achievement().allMetadata();
					 * 
					 * //display all achievements for(int i=0;i<arr.size();i++){ System.out.println("Achievement: "+arr.get(i).name());
					 * //... }
					 */

					// a simple other way to do it:
					GPGAchievementModel model = GPGManager.sharedInstance().applicationModel().achievement();

					ArrayList<String> achievements = new ArrayList<String>();
					achievements.add(ACH1);
					achievements.add(ACH2);
					achievements.add(ACH3);
					achievements.add(ACH4);
					achievements.add(ACH5);
					achievements.add(ACH6);

					for (int i = 0; i < achievements.size(); i++) {
						GPGAchievementMetadata a = model.metadataForAchievementId(achievements.get(i));
						System.out.println("Achievement #" + (i + 1));
						System.out.println("- identifier: " + a.achievementId());
						System.out.println("- state: " + a.state());
						System.out.println("- type: " + a.type());
						System.out.println("- name: " + a.name());
						System.out.println("- description: " + a.achievementDescription());
						System.out.println("- revealed icon: " + a.revealedIconUrl());
						System.out.println("- unlocked icon: " + a.unlockedIconUrl());
						System.out.println("- completed steps: " + a.completedSteps());
						System.out.println("- total steps: " + a.numberOfSteps());
						System.out.println("- formatted completed steps: " + a.formattedCompletedSteps());
						System.out.println("- formatted total steps: " + a.formattedNumberOfSteps());
						System.out.println("- last update timestamp: " + a.lastUpdatedTimestamp());
						System.out.println("- progress: " + a.progress());
					}
				} else {
					System.out.println("sign in first.");
				}
			}
		};
		b5.addOnTouchUpInsideListener(b5tl);

		// create reveal button
		b6 = new UIButton(new CGRect(10, 310, 200, 30));
		b6.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		b6.setTitle("Reveal Achievement #3", UIControlState.Normal);
		b6tl = new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				if (signedIn) {
					System.out.println("revealing achievement #3: " + ACH3);

					GPGAchievement a = GPGAchievement.achievementWithId(ACH3);
					revealBlock = new GPGAchievementDidRevealBlock() {
						@Override
						public void invoke (GPGAchievementState state, NSError error) {
							if (error != null) {
								System.out.println("Error while revealing!");
							} else {
								System.out.println("reveal succeeded.");
								System.out.println("current state: " + state);
							}
						}
					};
					a.revealAchievementWithCompletionHandler(revealBlock);
				} else {
					System.out.println("sign in first.");
				}
			}
		};
		b6.addOnTouchUpInsideListener(b6tl);

		// create increment button
		b7 = new UIButton(new CGRect(10, 360, 200, 30));
		b7.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		b7.setTitle("Incr. Achievement #2", UIControlState.Normal);
		b7tl = new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				if (signedIn) {
					System.out.println("increasing achievement #2 by 1: " + ACH2);

					GPGAchievement a = GPGAchievement.achievementWithId(ACH2);
					incrementBlock = new GPGAchievementDidIncrementBlock() {
						@Override
						public void invoke (boolean newlyUnlocked, int currentSteps, NSError error) {
							if (error != null) {
								System.out.println("Error while revealing!");
							} else {
								System.out.println("increment succeeded. newlyUnlocked: " + newlyUnlocked + ", currentSteps: "
									+ currentSteps);
							}
						}
					};

					// increment the achievement by 1
					a.incrementAchievementNumSteps(1, incrementBlock);
				} else {
					System.out.println("sign in first.");
				}
			}
		};
		b7.addOnTouchUpInsideListener(b7tl);

		// create unlock button
		b8 = new UIButton(new CGRect(10, 410, 200, 30));
		b8.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		b8.setTitle("Unlock Achievement #1", UIControlState.Normal);
		b8tl = new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				if (signedIn) {
					System.out.println("unlocking achievement #1: " + ACH1);

					GPGAchievement a = GPGAchievement.achievementWithId(ACH6);
					unlockBlock = new GPGAchievementDidUnlockBlock() {
						@Override
						public void invoke (boolean newlyUnlocked, NSError error) {
							if (error != null) {
								System.out.println("Error while unlocking!");
							} else {
								System.out.println("unlock succeeded. newlyUnlocked: " + newlyUnlocked);
							}
						}
					};

					// unlock the achievement
					a.unlockAchievementWithCompletionHandler(unlockBlock);
				} else {
					System.out.println("sign in first.");
				}
			}
		};
		b8.addOnTouchUpInsideListener(b8tl);

		// create save button
		b9 = new UIButton(new CGRect(220, 60, 90, 30));
		b9.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		b9.setTitle("Save", UIControlState.Normal);
		b9tl = new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				if (signedIn) {
					saveState();
				} else {
					System.out.println("sign in first.");
				}
			}
		};
		b9.addOnTouchUpInsideListener(b9tl);

		// create load button
		b10 = new UIButton(new CGRect(220, 110, 90, 30));
		b10.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		b10.setTitle("Load", UIControlState.Normal);
		b10tl = new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				if (signedIn) {
					loadState();
				} else {
					System.out.println("sign in first.");
				}
			}
		};
		b10.addOnTouchUpInsideListener(b10tl);

		// create user button
		b11 = new UIButton(new CGRect(220, 160, 90, 30));
		b11.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		b11.setTitle("User", UIControlState.Normal);
		b11tl = new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				if (signedIn) {
					System.out
						.println("Welcome " + GPGManager.sharedInstance().applicationModel().player().localPlayer().name() + "!");
					System.out.println("Your avatar url is located here: "
						+ GPGManager.sharedInstance().applicationModel().player().localPlayer().avatarUrl());
					System.out.println("Your playerId is: "
						+ GPGManager.sharedInstance().applicationModel().player().localPlayer().playerId());
				} else {
					System.out.println("sign in first.");
				}
			}
		};
		b11.addOnTouchUpInsideListener(b11tl);

		// create leaderboard button
		b12 = new UIButton(new CGRect(220, 210, 90, 30));
		b12.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		b12.setTitle("Board", UIControlState.Normal);
		b12tl = new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				if (signedIn) {
					System.out.println("Showing leaderboard #1.");

					// create the view controller
					GPGLeaderboardController leadController = new GPGLeaderboardController(LEAD1);
					leadController.setLeaderboardDelegate(cThis);

					// you can choose the default time scope to display in the view controller.
					leadController.setTimeScope(GPGLeaderboardTimeScope.GPGLeaderboardTimeScopeThisWeek);

					// present the leaderboard view controller
					cThis.viewController.presentViewController(leadController, true, null);
				} else {
					System.out.println("sign in first.");
				}
			}
		};
		b12.addOnTouchUpInsideListener(b12tl);

		// create leaderboards button
		b13 = new UIButton(new CGRect(220, 260, 90, 30));
		b13.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		b13.setTitle("Boards", UIControlState.Normal);
		b13tl = new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				if (signedIn) {
					System.out.println("Showing all leaderboards.");

					// create the view controller
					GPGLeaderboardsController leadsController = new GPGLeaderboardsController();
					leadsController.setLeaderboardsDelegate(cThis);

					// present the leaderboard picker view controller
					cThis.viewController.presentViewController(leadsController, true, null);
				} else {
					System.out.println("sign in first.");
				}
			}
		};
		b13.addOnTouchUpInsideListener(b13tl);

		// create post score button
		b14 = new UIButton(new CGRect(220, 310, 90, 30));
		b14.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		b14.setTitle("Score post", UIControlState.Normal);
		b14tl = new OnTouchUpInsideListener() {

			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				if (signedIn) {
					// generate a random score, and choose a leaderboard
					Random rand = new Random();
					int score = rand.nextInt(10000);
					int nr = rand.nextBoolean() ? 1 : 0;
					String leaderboard = nr == 0 ? LEAD1 : LEAD2;
					System.out.println("Posting score " + score + " to leaderboard #" + nr);

					// create the score instance
					GPGScore gpgScore = new GPGScore(leaderboard);
					gpgScore.setValue(score);

					// set the completion handler
					postScoreCompletionHandler = new GPGScoreReportScoreBlock() {
						@Override
						public void invoke (GPGScoreReport report, NSError error) {
							if (error == null) {
								System.out.println("score post succeeded!");
								System.out.println("score analyzation:");
								System.out.println("- leaderboard identifier: " + report.leaderboardId());
								System.out.println("- reported value: " + report.reportedScoreValue());
								System.out.println("- is daily highscore: " + report.isHighScoreForLocalPlayerToday());
								if (!report.isHighScoreForLocalPlayerToday()) {
									System.out.println("- daily highscore: " + report.highScoreForLocalPlayerToday().value());
								}
								System.out.println("- is weekly highscore: " + report.isHighScoreForLocalPlayerThisWeek());
								if (!report.isHighScoreForLocalPlayerThisWeek()) {
									System.out.println("- weekly highscore: " + report.highScoreForLocalPlayerThisWeek().value());
								}
								System.out.println("- is all time highscore: " + report.isHighScoreForLocalPlayerAllTime());
								if (!report.isHighScoreForLocalPlayerAllTime()) {
									System.out.println("- all time highscore: " + report.highScoreForLocalPlayerAllTime().value());
								}
							} else {
								System.out.println("score post failed: " + error.description());
							}
						}
					};

					gpgScore.submitScoreWithCompletionHandler(postScoreCompletionHandler);
				} else {
					System.out.println("sign in first.");
				}
			}
		};
		b14.addOnTouchUpInsideListener(b14tl);

		// create list score button
		b15 = new UIButton(new CGRect(220, 360, 90, 30));
		b15.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		b15.setTitle("Score list", UIControlState.Normal);
		b15tl = new OnTouchUpInsideListener() {

			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				if (signedIn) {
					System.out.println("listing leaderboards:");

					// as well as achievement listing, this produces an annoying error...
					// java.lang.ClassCastException: org.robovm.cocoatouch.foundation.NSObject cannot be cast to
// com.michingo.robovmbindings.gpgs.GPGLeaderboardMetadata

					/*
					 * //obtain all metadata for the leaderboards NSArray<GPGLeaderboardMetadata> allLeaderboards = .allMetadata();
					 * 
					 * //iterate through the leaderboards for(GPGLeaderboardMetadata leaderboard : allLeaderboards){
					 * System.out.println("- identifier: "+leaderboard.leaderboardId()+", name: "+leaderboard.title()); }
					 */

					// So I avoid it like this:
					GPGLeaderboardModel model = GPGManager.sharedInstance().applicationModel().leaderboard();
					ArrayList<String> leaderboards = new ArrayList<String>();
					leaderboards.add(LEAD1);
					leaderboards.add(LEAD2);

					for (int i = 0; i < leaderboards.size(); i++) {
						GPGLeaderboardMetadata leaderboard = model.metadataForLeaderboardId(leaderboards.get(i));
						System.out.println("- identifier: " + leaderboard.leaderboardId() + ", name: " + leaderboard.title());
					}
				} else {
					System.out.println("sign in first.");
				}
			}
		};
		b15.addOnTouchUpInsideListener(b15tl);

		// add views to the screen
		view = new UIView(UIScreen.getMainScreen().getBounds());
		view.addSubview(tv);
		view.addSubview(b1);
		view.addSubview(b2);
		view.addSubview(b3);
		view.addSubview(b4);
		view.addSubview(b5);
		view.addSubview(b6);
		view.addSubview(b7);
		view.addSubview(b8);
		view.addSubview(b9);
		view.addSubview(b10);
		view.addSubview(b11);
		view.addSubview(b12);
		view.addSubview(b13);
		view.addSubview(b14);
		view.addSubview(b15);
		viewController.setView(view);
		window.setRootViewController(viewController);

		// INITIALIZE SIGN-IN

		// set google plus settings
		GPPSignIn signIn = GPPSignIn.sharedInstance();
		signIn.setClientID(kClientId);

		ArrayList<NSString> scopes = new ArrayList<NSString>();
		scopes.add(new NSString("https://www.googleapis.com/auth/games"));
		scopes.add(new NSString("https://www.googleapis.com/auth/appstate"));
		signIn.setScopes(new NSArray<NSString>(scopes));

		signIn.setDelegate(cThis);
		signIn.setShouldFetchGoogleUserID(true);
		signIn.setShouldFetchGoogleUserEmail(false);
		signIn.setShouldFetchGooglePlusUser(false);

		// try to sign in silently
		signIn.trySilentAuthentication();

		// adjust toast locations. This is handy if you do not want game center and gpgs 'welcome back'-notifications overlapping
		GPGManager.sharedInstance().setWelcomeBackToastPlacement(GPGToastPlacement.GPGToastPlacementBottom);
		GPGManager.sharedInstance().setWelcomeBackOffset((char)30);

		// you can also set the location for achievement toasts
		GPGManager.sharedInstance().setAchievementUnlockedToastPlacement(GPGToastPlacement.GPGToastPlacementTop);
		GPGManager.sharedInstance().setAchievementUnlockedOffset((char)30);

		// pass your supported orientations. This will prevent google from displaying their messages in the wrong direction.
		// TODO: implement
		// GPGManager.sharedInstance().setValidOrientationFlags(UIDeviceOrientationPortraitTop);
	}

	/** Saves data in the cloud. */
	public void saveState () {
		System.out.println("saving state.");

		// get the model
		GPGAppStateModel model = GPGManager.sharedInstance().applicationModel().appState();

		// choose a save state
		int playerAvatarKey = 2;// the state number. use 0 to 3.

		// add the data that you wish to save
		ByteBuffer b = ByteBuffer.allocate(5);
		b.put(new byte[] {1, 2, 3, 4, 5});
		NSData newAvatarData = NSData.createFromByteBuffer(b);// add data that you wist to upload.
		// (NOTE: NSData is not implemented by robovm, so you can't actually add data until it is implemented.)
		model.setStateData(newAvatarData, playerAvatarKey);

		// the completion handler
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

		// the conflict handler
		cloudConflictHandler = new GPGAppStateConflictHandler() {
			@Override
			public NSData invoke (NSNumber key, NSData localState, NSData remoteState) {
				System.out.println("conflict handler running! key: " + key);
				// it is important that you implement this. Read the google docs for more information.
				return remoteState;
			}
		};

		// post the data
		model.updateForKey(playerAvatarKey, cloudCompletionHandler, cloudConflictHandler);
	}

	/** Loads data from the cloud. */
	public void loadState () {
		System.out.println("loading state.");

		// get the model
		final GPGAppStateModel model = GPGManager.sharedInstance().applicationModel().appState();

		// choose a save state
		final int playerAvatarKey = 2;// the state number. use 0 to 3.

		// the completion handler
		cloudLoadCompletionHandler = new GPGAppStateLoadResultHandler() {
			@Override
			public void invoke (GPGAppStateLoadStatus status, NSError error) {
				switch (status) {
				case GPGAppStateLoadStatusNotFound:
					System.out.println("cloud load failed: not found. This must be the first time the user plays the game.");
					break;
				case GPGAppStateLoadStatusUnknownError:
					System.out.println("cloud load failed: unknown error");
					break;
				case GPGAppStateLoadStatusSuccess:
					System.out.println("cloud load succeeded");
					NSData savegame = model.stateDataForKey(playerAvatarKey);
					ByteBuffer savegameBB = savegame.getBytes();
					System.out.print("Received savegame: ");
					for (int i = 0; i < savegameBB.capacity(); i++) {
						System.out.print(savegameBB.get(i) + ((i == savegameBB.capacity() - 1) ? "" : ", "));
					}
					break;
				}
			}
		};

		// the conflict handler
		cloudConflictHandler = new GPGAppStateConflictHandler() {
			@Override
			public NSData invoke (NSNumber key, NSData localState, NSData remoteState) {
				System.out.println("conflict handler running! key: " + key);
				// it is important that you implement this. Read the google docs for more information.
				return remoteState;
			}
		};

		// start the load request
		model.loadForKey(playerAvatarKey, cloudLoadCompletionHandler, cloudConflictHandler);
	}

	public static void main (String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
	}

	// copy-paste this to your app delegate.
	@Override
	public boolean openURL (UIApplication application, NSURL url, String sourceApplication, NSObject annotation) {
		return GPPURLHandler.handleURL(url, sourceApplication, annotation);
	}

	@Override
	public void finishedWithAuth (GTMOAuth2Authentication auth, NSError error) {
		if (error == null) {
			System.out.println("logged in succesfully.");
			tv.setText("logged in succesfully.");

			// after the google+ sign-in is done, we must continue the sign-in of 'games'.
			startGoogleGamesSignIn();
		} else {
			System.out.println("error during login: " + error.description());
			tv.setText("error during login: " + error.description());
			signedIn = false;
		}
	}

	private GPGReAuthenticationBlock gamesAuthBlock;

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
				signedIn = false;
			}
		};

		// pass the GPPSignIn to the GPGManager.
		m.signIn(s, gamesAuthBlock);
		signedIn = true;
	}

	/** Called when you return from the achievement view controller. */
	@Override
	public void achievementViewControllerDidFinish (GPGAchievementController viewController) {
		viewController.dismissViewController(true, null);
		System.out.println("returned from achievements.");
	}

	/** Called when you return from the leaderboard view controller. */
	@Override
	public void leaderboardViewControllerDidFinish (GPGLeaderboardController viewController) {
		viewController.dismissViewController(true, null);
		System.out.println("returned from leaderboard #1.");
	}

	@Override
	public void leaderboardsViewControllerDidFinish (GPGLeaderboardsController viewController) {
		viewController.dismissViewController(true, null);
		System.out.println("returned from leaderboards picker.");
	}
}

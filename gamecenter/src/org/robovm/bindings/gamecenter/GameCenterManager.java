
package org.robovm.bindings.gamecenter;

import java.util.ArrayList;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.uikit.UIDevice;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.apple.uikit.UIWindow;
import org.robovm.bindings.apple.blocks.VoidNSArrayNSArrayNSErrorBlock;
import org.robovm.bindings.apple.blocks.VoidNSArrayNSErrorBlock;
import org.robovm.bindings.apple.blocks.VoidNSErrorBlock;
import org.robovm.bindings.apple.blocks.VoidUIViewControllerNSErrorBlock;
import org.robovm.bindings.apple.gamekit.GKAchievement;
import org.robovm.bindings.apple.gamekit.GKAchievementViewController;
import org.robovm.bindings.apple.gamekit.GKAchievementViewControllerDelegate;
import org.robovm.bindings.apple.gamekit.GKGameCenterControllerDelegate;
import org.robovm.bindings.apple.gamekit.GKGameCenterViewController;
import org.robovm.bindings.apple.gamekit.GKGameCenterViewControllerState;
import org.robovm.bindings.apple.gamekit.GKLeaderboard;
import org.robovm.bindings.apple.gamekit.GKLeaderboardTimeScope;
import org.robovm.bindings.apple.gamekit.GKLeaderboardViewController;
import org.robovm.bindings.apple.gamekit.GKLeaderboardViewControllerDelegate;
import org.robovm.bindings.apple.gamekit.GKLocalPlayer;
import org.robovm.bindings.apple.gamekit.GKScore;

@SuppressWarnings("deprecation")
public class GameCenterManager {
	private static final int IOS_6 = 6;
	private static final int IOS_7 = 7;

	private final UIWindow keyWindow;
	private final GameCenterListener listener;

	/** Constructor.
	 * @param keyWindow KeyWindow can't be accessed from the Delegates sometimes, so we need to save a reference
	 * @param listener */
	public GameCenterManager (UIWindow keyWindow, GameCenterListener listener) {
		this.keyWindow = keyWindow;
		this.listener = listener;
	}

	/** Do the login logic. If the user has never loged, a dialog will be shown. */
	public void login () {
		// If iOS version is 6 or more we use the new method
		if (getIosVersion() >= IOS_6) {
			GKLocalPlayer.getLocalPlayer().setAuthenticateHandler(new VoidUIViewControllerNSErrorBlock() {
				@Override
				public void invoke (UIViewController viewController, NSError error) {
					// If the device does not have an authenticated player, show the login dialog
					if (viewController != null) {
						keyWindow.getRootViewController().presentViewController(viewController, true, null);
					}
					// If the viewController is null and the player is authenticated, the login is completed
					else if (GKLocalPlayer.getLocalPlayer().isAuthenticated()) {
						listener.playerLoginCompleted();
					}
					// If the viewController is null and the player is not authenticated the login has failed
					else {
						listener.playerLoginFailed(error);
					}
				}
			});
		} else { // If iOS version is 5 or less we use the deprecated method
			GKLocalPlayer.getLocalPlayer().authenticateWithCompletionHandler(new VoidNSErrorBlock() {
				@Override
				public void invoke (NSError error) {
					if (GKLocalPlayer.getLocalPlayer().isAuthenticated()) {
						listener.playerLoginCompleted();
					} else {
						listener.playerLoginFailed(error);
					}
				}
			});
		}
	}

	/** Report an achievement completed (100 as percentComplete)
	 * 
	 * @param identifier */
	public void reportAchievement (String identifier) {
		reportAchievement(identifier, 100);
	}

	/** Report an achievement with a percentComplete
	 * 
	 * @param identifier
	 * @param percentComplete */
	public void reportAchievement (String identifier, double percentComplete) {
		// If player is not authenticated, do nothing
		if (!GKLocalPlayer.getLocalPlayer().isAuthenticated()) {
			listener.achievementReportFailed();
			return;
		}

		GKAchievement achievement = new GKAchievement(identifier);
		achievement.setPercentComplete(percentComplete);
		achievement.setShowsCompletionBanner(true);

		// If iOS version is 6 or more we use the new method
		if (getIosVersion() >= IOS_6) {
			// Create an array with the achievement
			NSArray<NSObject> achievements = new NSArray<NSObject>(achievement);

			GKAchievement.reportAchievements(achievements, new VoidNSErrorBlock() {
				@Override
				public void invoke (NSError error) {
					if (error != null) {
						listener.achievementReportFailed();
					} else {
						listener.achievementReportCompleted();
					}
				}
			});
		} else { // If iOS version is 5 or less we use the deprecated method
			achievement.reportAchievement(new VoidNSErrorBlock() {
				@Override
				public void invoke (NSError error) {
					if (error != null) {
						listener.achievementReportFailed();
					} else {
						listener.achievementReportCompleted();
					}
				}
			});
		}
	}

	/** Load all the achievements for the local player */
	public void loadAchievements () {
		// If player is not authenticated, do nothing
		if (!GKLocalPlayer.getLocalPlayer().isAuthenticated()) {
			listener.achievementsLoadFailed();
			return;
		}

		GKAchievement.loadAchievements(new VoidNSArrayNSErrorBlock() {
			@SuppressWarnings({"unchecked", "rawtypes"})
			@Override
			public void invoke (NSArray array, NSError error) {
				if (error != null) {
					listener.achievementsLoadFailed();
				} else {
					ArrayList<GKAchievement> achievements = new ArrayList<GKAchievement>();
					for (NSObject achievement : (NSArray<NSObject>)array) {
						achievements.add((GKAchievement)achievement);
					}
					listener.achievementsLoadCompleted(achievements);
				}
			}
		});
	}

	/** Reset the achievements progress for the local player. All the entries for the local player are removed from the server. */
	public void resetAchievements () {
		// If player is not authenticated, do nothing
		if (!GKLocalPlayer.getLocalPlayer().isAuthenticated()) {
			listener.achievementsResetFailed();
			return;
		}

		GKAchievement.resetAchievements(new VoidNSErrorBlock() {
			@Override
			public void invoke (NSError error) {
				if (error != null) {
					listener.achievementsResetFailed();
				} else {
					listener.achievementsResetCompleted();
				}
			}
		});
	}

	/** Report a score to GameCenter
	 * @param identifier
	 * @param score */
	public void reportScore (String identifier, long score) {
		// If player is not authenticated, do nothing
		if (!GKLocalPlayer.getLocalPlayer().isAuthenticated()) {
			listener.scoreReportFailed();
			return;
		}

		GKScore scoreReporter = new GKScore(identifier);
		scoreReporter.setValue(score);

		// If iOS version is 7 or more we use the new method
		if (getIosVersion() >= IOS_7) {
			NSArray<NSObject> scores = new NSArray<NSObject>(scoreReporter);

			GKScore.reportScores(scores, new VoidNSErrorBlock() {
				@Override
				public void invoke (NSError error) {
					if (error != null) {
						listener.scoreReportFailed();
					} else {
						listener.scoreReportCompleted();
					}
				}
			});
		} else { // If iOS version is 6 or less we use the deprecated method
			scoreReporter.reportScore(new VoidNSErrorBlock() {
				@Override
				public void invoke (NSError error) {
					if (error != null) {
						listener.scoreReportFailed();
					} else {
						listener.scoreReportCompleted();
					}
				}
			});
		}
	}

	/** Load all the Leaderboards for the Game. Warning: If using iOS5 or less the Leaderboard object will only include the Category
	 * (identifier) */
	public void loadLeaderboards () {
		// If player is not authenticated, do nothing
		if (!GKLocalPlayer.getLocalPlayer().isAuthenticated()) {
			listener.leaderboardsLoadFailed();
			return;
		}

		// If iOS version is 6 or more we use the new method
		if (getIosVersion() >= IOS_6) {
			GKLeaderboard.loadLeaderboards(new VoidNSArrayNSErrorBlock() {
				@SuppressWarnings({"rawtypes", "unchecked"})
				@Override
				public void invoke (NSArray array, NSError error) {
					if (error != null) {
						listener.leaderboardsLoadFailed();
					} else {
						ArrayList<GKLeaderboard> leaderboards = new ArrayList<GKLeaderboard>();
						for (NSObject leaderboard : (NSArray<NSObject>)array) {
							leaderboards.add((GKLeaderboard)leaderboard);
						}
						listener.leaderboardsLoadCompleted(leaderboards);
					}
				}
			});
		} else { // If iOS version is 6 or less we use the deprecated method
			GKLeaderboard.loadCategories(new VoidNSArrayNSArrayNSErrorBlock() {
				@SuppressWarnings({"rawtypes", "unchecked"})
				@Override
				public void invoke (NSArray array, NSArray array2, NSError error) {
					if (error != null) {
						listener.leaderboardsLoadFailed();
					} else {
						ArrayList<GKLeaderboard> leaderboards = new ArrayList<GKLeaderboard>();
						for (NSObject category : (NSArray<NSObject>)array) {
							GKLeaderboard leaderboard = new GKLeaderboard();
							leaderboard.setCategory(((NSString)category).toString());

							leaderboards.add(leaderboard);
						}
						listener.leaderboardsLoadCompleted(leaderboards);
					}
				}
			});
		}
	}

	/** Return the id of a leaderboard (category or identifier, depending on iOS version)
	 * @param leaderboard
	 * @return */
	public String getLeaderboardId (GKLeaderboard leaderboard) {
		if (getIosVersion() >= IOS_7) {
			return leaderboard.getIdentifier();
		} else {
			return leaderboard.getCategory();
		}
	}

	/** Shows GameCenter standard interface for Achievements */
	public void showAchievementsView () {
		// If player is not authenticated, do nothing
		if (!GKLocalPlayer.getLocalPlayer().isAuthenticated()) {
			return;
		}

		// If iOS version is 6 or more we use the new method
		if (getIosVersion() >= IOS_6) {
			GKGameCenterViewController gameCenterView = new GKGameCenterViewController();
			gameCenterView.setGameCenterDelegate(new GKGameCenterControllerDelegate.Adapter() {
				@Override
				public void gameCenterViewControllerDidFinish (GKGameCenterViewController gameCenterViewController) {
					gameCenterViewController.dismissViewController(true, null);
				}
			});
			gameCenterView.setViewState(GKGameCenterViewControllerState.GKGameCenterViewControllerStateAchievements);
			keyWindow.getRootViewController().presentViewController(gameCenterView, true, null);
		} else { // If iOS version is 6 or less we use the deprecated method
			GKAchievementViewController gameCenterView = new GKAchievementViewController();
			gameCenterView.setAchievementDelegate(new GKAchievementViewControllerDelegate.Adapter() {
				@Override
				public void achievementViewControllerDidFinish (GKAchievementViewController viewController) {
					viewController.dismissViewController(true, null);
				}
			});
			keyWindow.getRootViewController().presentViewController(gameCenterView, true, null);
		}
	}

	/** Shows GameCenter standard interface for Leaderboards */
	public void showLeaderboardsView () {
		// If player is not authenticated, do nothing
		if (!GKLocalPlayer.getLocalPlayer().isAuthenticated()) {
			return;
		}

		// If iOS version is 6 or more we use the new method
		if (getIosVersion() >= IOS_6) {
			GKGameCenterViewController gameCenterView = new GKGameCenterViewController();
			gameCenterView.setGameCenterDelegate(new GKGameCenterControllerDelegate.Adapter() {
				@Override
				public void gameCenterViewControllerDidFinish (GKGameCenterViewController gameCenterViewController) {
					gameCenterViewController.dismissViewController(true, null);
				}
			});
			gameCenterView.setViewState(GKGameCenterViewControllerState.GKGameCenterViewControllerStateLeaderboards);
			gameCenterView.setLeaderboardTimeScope(GKLeaderboardTimeScope.GKLeaderboardTimeScopeAllTime);
			// gameCenterView.setLeaderboardIdentifier("CgkI4OvQqOcSEAIQBg");
			keyWindow.getRootViewController().presentViewController(gameCenterView, true, null);
		} else { // If iOS version is 6 or less we use the deprecated method
			GKLeaderboardViewController gameCenterView = new GKLeaderboardViewController();
			gameCenterView.setTimeScope(GKLeaderboardTimeScope.GKLeaderboardTimeScopeAllTime);
			gameCenterView.setLeaderboardDelegate(new GKLeaderboardViewControllerDelegate.Adapter() {
				@Override
				public void leaderboardViewControllerDidFinish (GKLeaderboardViewController viewController) {
					viewController.dismissViewController(true, null);
				}
			});
			keyWindow.getRootViewController().presentViewController(gameCenterView, true, null);
		}
	}

	/** Shows GameCenter standard interface for one Leaderboard
	 * @param identifier */
	public void showLeaderboardView (String identifier) {
		// If player is not authenticated, do nothing
		if (!GKLocalPlayer.getLocalPlayer().isAuthenticated()) {
			return;
		}

		// If iOS version is 6 or more we use the new method
		if (getIosVersion() >= IOS_6) {
			GKGameCenterViewController gameCenterView = new GKGameCenterViewController();
			gameCenterView.setGameCenterDelegate(new GKGameCenterControllerDelegate.Adapter() {
				@Override
				public void gameCenterViewControllerDidFinish (GKGameCenterViewController gameCenterViewController) {
					gameCenterViewController.dismissViewController(true, null);
				}
			});
			gameCenterView.setViewState(GKGameCenterViewControllerState.GKGameCenterViewControllerStateLeaderboards);
			gameCenterView.setLeaderboardTimeScope(GKLeaderboardTimeScope.GKLeaderboardTimeScopeAllTime);
			if (getIosVersion() >= IOS_7)
				gameCenterView.setLeaderboardIdentifier(identifier);
			else
				gameCenterView.setLeaderboardCategory(identifier);

			keyWindow.getRootViewController().presentViewController(gameCenterView, true, null);
		} else { // If iOS version is 6 or less we use the deprecated method
			GKLeaderboardViewController gameCenterView = new GKLeaderboardViewController();
			gameCenterView.setCategory(identifier);
			gameCenterView.setTimeScope(GKLeaderboardTimeScope.GKLeaderboardTimeScopeAllTime);
			gameCenterView.setLeaderboardDelegate(new GKLeaderboardViewControllerDelegate.Adapter() {
				@Override
				public void leaderboardViewControllerDidFinish (GKLeaderboardViewController viewController) {
					viewController.dismissViewController(true, null);
				}
			});

			keyWindow.getRootViewController().presentViewController(gameCenterView, true, null);
		}
	}

	/** Returns the iOS version of the current device
	 * 
	 * @return */
	private int getIosVersion () {
		String systemVersion = UIDevice.getCurrentDevice().getSystemVersion();
		int version = Character.getNumericValue(systemVersion.charAt(0));
		return version;
	}

}

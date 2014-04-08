
package org.robovm.bindings.gamecenter;

import java.util.ArrayList;

import org.robovm.bindings.apple.gamekit.GKAchievement;
import org.robovm.bindings.apple.gamekit.GKLeaderboard;

/** Listener for GameCenter events */
public interface GameCenterListener {

	public void playerLoginCompleted ();

	public void playerLoginFailed ();

	public void achievementReportCompleted ();

	public void achievementReportFailed ();

	public void achievementsLoadCompleted (ArrayList<GKAchievement> achievements);

	public void achievementsLoadFailed ();

	public void achievementsResetCompleted ();

	public void achievementsResetFailed ();

	public void scoreReportCompleted ();

	public void scoreReportFailed ();

	public void leaderboardsLoadCompleted (ArrayList<GKLeaderboard> scores);

	public void leaderboardsLoadFailed ();

}

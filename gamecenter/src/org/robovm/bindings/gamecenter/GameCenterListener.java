
package org.robovm.bindings.gamecenter;

import java.util.ArrayList;

import org.robovm.apple.foundation.NSError;
import org.robovm.apple.gamekit.GKAchievement;
import org.robovm.apple.gamekit.GKLeaderboard;

/** Listener for GameCenter events */
public interface GameCenterListener {

    public void playerLoginCompleted ();

    public void playerLoginFailed (NSError error);

    public void achievementReportCompleted ();

    public void achievementReportFailed (NSError error);

    public void achievementsLoadCompleted (ArrayList<GKAchievement> achievements);

    public void achievementsLoadFailed (NSError error);

    public void achievementsResetCompleted ();

    public void achievementsResetFailed (NSError error);

    public void scoreReportCompleted ();

    public void scoreReportFailed (NSError error);

    public void leaderboardsLoadCompleted (ArrayList<GKLeaderboard> scores);

    public void leaderboardsLoadFailed (NSError error);

    public void leaderboardViewDismissed ();

    public void achievementViewDismissed ();

}

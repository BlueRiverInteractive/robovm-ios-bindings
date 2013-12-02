
package org.robovm.bindings.gpgs.libgdx;

import java.util.ArrayList;

import org.robovm.bindings.gpgs.GPGAchievementMetadata;
import org.robovm.bindings.gpgs.GPGLeaderboardMetadata;
import org.robovm.bindings.gpgs.GPGLeaderboardTimeScope;
import org.robovm.bindings.playservices.PlayServicesManager.ScoresLoaded;

public interface GPGSInterface {

	/** Logs you into the services. Only call after an actual user click. */
	public void login ();

	/** Logs you out of the services. Only call after an actual user click. */
	public void logout ();

	/** Saves the game in the cloud.
	 * @param statekey the save slot. Choose from 0 to 3.
	 * @param the data. */
	public void updateGameState (int statekey, byte[] data);

	/** Retrieves the savegame from the cloud.
	 * @param statekey the save slot. Choose from 0 to 3. */
	public void getGameState (int statekey);

	/** Returns a list of all achievements. */
	public ArrayList<GPGAchievementMetadata> getAchievements ();

	/** Returns a list of all leaderboards. */
	public ArrayList<GPGLeaderboardMetadata> getLeaderboards ();

	/** Returns a list of all scores. */
	public void getScoresOfLeaderboard (String leaderboardId, boolean social, GPGLeaderboardTimeScope timeScope,
		ScoresLoaded callback);
}

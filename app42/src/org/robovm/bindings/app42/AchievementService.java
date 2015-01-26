package org.robovm.bindings.app42;

import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class AchievementService extends App42Service
{
	public AchievementService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
	/**
	 *  You can create multiple achievement or badge for your app.
	 *
	 * @param achievementName
	 *            - Name of achievement to be cretaed
	 * @param description
	 *            - description of the achievement
	 * @return Achievement Object
	 * @throws App42Exception
	 */

	@Method(selector = "createAchievementWithName:description:completionBlock:")
	public native void createAchievementWithName(String achievementName, String description, @Block App42ResponseBlock completionBlock);
	
	/**
	 *   App users can earn achievements based on your custom rules in your game.
	 *
	 * @param userName - Name of the user for which avatar has to earn
	 * @param achievementName - Name of the achievement which is to be earn
	 * @param gameName - Name of the for which avatar has to be earn
	 * @return Achievement Object
	 * @throws App42Exception
	 */

	@Method(selector = "earnAchievementWithName:userName:gameName:description:completionBlock:")
	public native void earnAchievementWithName(String achievementName, String userName, String gameName, String description, @Block App42ResponseBlock completionBlock);
	
	/**
	 *  Fetch all the achievements of user.
	 *
	 * @param userName - Name of user for which all achievement is to fetch
	 * @return Achievement Object
	 * @throws App42Exception
	 */

	@Method(selector = "getAllAchievementsForUser:completionBlock:")
	public native void getAllAchievementsForUser(String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 *   Fetch all the achievements by user in a particular game.
	 *
	 * @param userName - Name of the user for which achievement has to fetch
	 * @param gameName - Name of the game for which achievement has to fetch
	 * @return Achievement Object
	 * @throws App42Exception
	 */

	@Method(selector = "getAllAchievementsForUser:inGame:completionBlock:")
	public native void getAllAchievementsForUser(String userName, String gameName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * View detail description of all achievements created in app.
	 *
	 *
	 * @return Achievement Object
	 * @throws App42Exception
	 */

	@Method(selector = "getAllAchievements:")
	public native void getAllAchievements(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch detail description of achievement by achievement name.
	 *
	 * @param achievementName - Name of the achievement whose detail is to be fetched.
	 * @return Achievement Object
	 * @throws App42Exception
	 */

	@Method(selector = "getAchievementByName:completionBlock:")
	public native void getAchievementByName(String achievementName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch all users who have earn particular achievement in specific game.
	 *
	 * @param achievementName - Name of the achievement whose detail is to fetch.
	 * @param gameName - Name of the game for which achievement has to fetch.
	 * @return Achievement Object
	 * @throws App42Exception
	 */

	@Method(selector = "getAllUsersWithAchievement:inGame:completionBlock:")
	public native void getAllUsersWithAchievement(String achievementName, String gameName, @Block App42ResponseBlock completionBlock);
}

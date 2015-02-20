package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSArray;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class RewardService extends App42Service
{
	public RewardService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
	/**
	 * Creates Reward. Reward can be Sword, Energy etc. When Reward Points have
	 * to be added the Reward name created using this method has to be
	 * specified.
	 *
	 * @param rewardName
	 *            - The reward that has to be created
	 * @param rewardDescription
	 *            - The description of the reward to be created
	 *
	 * @return Reward object containing the reward that has been created
	 * 
	 */
	@Method(selector = "createReward:rewardDescription:completionBlock:")
	public native void createReward(String rewardName, String rewardDescription, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches the count of all the Rewards
	 *
	 * @return App42Response objects containing count of all the rewards of the
	 *         App
	 *
	 */
	@Method(selector = "getAllRewardsCount:")
	public native void getAllRewardsCount(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches all the Rewards
	 *
	 * @return List of Reward objects containing all the rewards of the App
	 *
	 */
	@Method(selector = "getAllRewards:")
	public native void getAllRewards(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches all the Rewards by paging.
	 *
	 * @param max
	 *            - Maximum number of records to be fetched
	 * @param offset
	 *            - From where the records are to be fetched
	 *
	 * @return List of Reward objects containing all the rewards of the App
	 *
	 */
	@Method(selector = "getAllRewards:offset:completionBlock:")
	public native void getAllRewards(int max, int offset, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Retrieves the reward for the specified name
	 *
	 * @param rewardName
	 *            - Name of the reward that has to be fetched
	 *
	 * @return Reward object containing the reward based on the rewardName
	 *
	 */
	@Method(selector = "getRewardByName:completionBlock:")
	public native void getRewardByName(String rewardName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Adds the reward points to an users account. Reward Points can be earned
	 * by the user which can be redeemed later.
	 *
	 * @param gameName
	 *            - Name of the game for which reward points have to be added
	 * @param gameUserName
	 *            - The user for whom reward points have to be added
	 * @param rewardName
	 *            - The rewards for which reward points have to be added
	 * @param rewardPoints
	 *            - The points that have to be added
	 *
	 * @return Reward object containing the reward points that has been added
	 *
	 */
	@Method(selector = "earnRewards:gameUserName:rewardName:rewardPoints:completionBlock:")
	public native void earnRewards(String gameName, String gameUserName, String rewardName, double rewardPoints, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Deducts the reward points from the earned rewards by a user.
	 *
	 * @param gameName
	 *            - Name of the game for which reward points have to be deducted
	 * @param gameUserName
	 *            - The user for whom reward points have to be deducted
	 * @param rewardName
	 *            - The rewards for which reward points have to be deducted
	 * @param rewardPoints
	 *            - The points that have to be deducted
	 *
	 * @return Reward object containing the reward points that has been deducted
	 *
	 */
	@Method(selector = "redeemRewards:gameUserName:rewardName:rewardPoints:completionBlock:")
	public native void redeemRewards(String gameName, String gameUserName, String rewardName, double rewardPoints, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches the reward points for a particular user
	 *
	 * @param gameName
	 *            - Name of the game for which reward points have to be fetched
	 * @param userName
	 *            - The user for whom reward points have to be fetched
	 *
	 * @return Reward object containing the reward points for the specified user
	 *
	 * @throws App42Exception
	 *
	 */
	@Method(selector = "getGameRewardPointsForUser:userName:completionBlock:")
	public native void getGameRewardPointsForUser(String gameName, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * This function provides a list of specified number of top reward earners
	 * for a specific game.
	 *
	 * @param gameName
	 *            - Name of the game for which reward earners are to be fetched
	 * @param rewardName
	 *            - Name of the reward for which list of earners is to be
	 *            fetched
	 * @param max
	 *            - Specifies the number of top earners to be fetched
	 * @return ArrayList of Reward object
	 * @throws App42Exception
	 */
	@Method(selector = "getTopNRewardEarners:rewardName:max:completionBlock:")
	public native void getTopNRewardEarners(String gameName, String rewardName, int max, @Block App42ResponseBlock completionBlock);

	/**
	 * This function returns you the details of all the specific rewards earned
	 * by the specified user.
	 *
	 * @param userName
	 *            - Name of the user whose rewards are to be fetched
	 * @param rewardName
	 *            - Name of the reward for which details are to be fetched
	 * @return ArrayList of Reward object
	 * @throws App42Exception
	 */
	@Method(selector = "getAllRewardsByUser:rewardName:completionBlock:")
	public native void getAllRewardsByUser(String userName, String rewardName, @Block App42ResponseBlock completionBlock);

	/**
	 * This function returns you a list of group wise users who earned the top
	 * rewards in the specified game .
	 *
	 * @param gameName
	 *            - Name of the game for which top reward earners are to be
	 *            fetched
	 * @param rewardName
	 *            - Name of the reward for which top earners are to be listed
	 * @param userList
	 *            - List of group wise users earning specified rewards
	 * @return ArrayList of Reward object
	 * @throws App42Exception
	 */
	@Method(selector = "getTopNRewardEarnersByGroup:rewardName:userList:completionBlock:")
	public native void getTopNRewardEarnersByGroup(String gameName, String rewardName, NSArray<?> userList, @Block App42ResponseBlock completionBlock);

	/**
	 * This function returns you a list of group wise users who earned the top
	 * rewards in the specified game .
	 *
	 * @param gameName
	 *            - Name of the game for which top reward earners are to be
	 *            fetched
	 * @param rewardName
	 *            - Name of the reward for which top earners are to be listed
	 * @param userName
	 *            - Name of the user whose rewards are to be fetched
	 * @return Reward object containing the ranking for the specified user
	 * @throws App42Exception
	 */
	@Method(selector = "getUserRankingOnReward:rewardName:userName:completionBlock:")
	public native void getUserRankingOnReward(String gameName, String rewardName, String userName, @Block App42ResponseBlock completionBlock);
}

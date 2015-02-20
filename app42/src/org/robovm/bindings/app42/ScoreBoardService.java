package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSDate;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class ScoreBoardService extends App42Service
{
	public ScoreBoardService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
	/**
	 * Saves the User score for a game
	 *
	 * @param gameName
	 *            - Name of the game for which score has to be saved
	 * @param gameUserName
	 *            - The user for which score has to be saved
	 * @param gameScore
	 *            - The sore that has to be saved
	 *
	 * @return the saved score for a game
	 * 
	 */
	@Method(selector = "saveUserScore:gameUserName:gameScore:completionBlock:")
	public native void saveUserScore(String gameName, String gameUserName, double gameScore, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Retrieves the scores for a game for the specified name
	 *
	 * @param gameName
	 *            - Name of the game for which score has to be fetched
	 * @param userName
	 *            - The user for which score has to be fetched
	 *
	 * @return the game score for the specified user
	 *
	 */
	@Method(selector = "getScoresByUser:gameUserName:completionBlock:")
	public native void getScoresByUser(String gameName, String gameUserName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Retrieves the highest game score for the specified user
	 *
	 * @param gameName
	 *            - Name of the game for which highest score has to be fetched
	 * @param userName
	 *            - The user for which highest score has to be fetched
	 *
	 * @return the highest game score for the specified user
	 *
	 */
	@Method(selector = "getHighestScoreByUser:gameUserName:completionBlock:")
	public native void getHighestScoreByUser(String gameName, String gameUserName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Retrieves the lowest game score for the specified user
	 *
	 * @param gameName
	 *            - Name of the game for which lowest score has to be fetched
	 * @param userName
	 *            - The user for which lowest score has to be fetched
	 *
	 * @return the lowest game score for the specified user
	 *
	 */
	@Method(selector = "getLowestScoreByUser:gameUserName:completionBlock:")
	public native void getLowestScoreByUser(String gameName, String gameUserName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Retrieves the Top Rankings for the specified game
	 *
	 * @param gameName
	 *            - Name of the game for which ranks have to be fetched
	 *
	 * @return the Top rankings for a game
	 *
	 */
	@Method(selector = "getTopRankings:completionBlock:")
	public native void getTopRankings(String gameName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Retrieves the average game score for the specified user
	 *
	 * @param gameName
	 *            - Name of the game for which average score has to be fetched
	 * @param userName
	 *            - The user for which average score has to be fetched
	 *
	 * @return the average game score for the specified user
	 *
	*/
	@Method(selector = "getAverageScoreByUser:userName:completionBlock:")
	public native void getAverageScoreByUser(String gameName, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Retrieves the Top Rankings for the specified game
	 *
	 * @param gameName
	 *            - Name of the game for which ranks have to be fetched
	 * @param max
	 *            - Maximum number of records to be fetched
	 *
	 * @return the Top rankings for a game
	 *
	 */
	@Method(selector = "getTopNRankings:max:completionBlock:")
	public native void getTopNRankings(String gameName, int max, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Retrieves the Top N Rankers/Scorers for the specified game
	 *
	 * @param gameName
	 *            - Name of the game for which ranks have to be fetched
	 * @param max
	 *            - Maximum number of records to be fetched
	 *
	 * @return the Top rankers for a game
	 *
	 */
	@Method(selector = "getTopNRankers:max:completionBlock:")
	public native void getTopNRankers(String gameName, int max, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Retrieves the Top N Rankers/Scorers for the specified game within the
	 * given group
	 * @param gameName
	 *            - Name of the game for which ranks have to be fetched
	 * @param group
	 *            - array of usernames in the group
	 *
	 * @return the Top rankers for a game
	 *
	 */
	@Method(selector = "getTopRankersByGroup:group:completionBlock:")
	public native void getTopNRankers(String gameName, NSArray<?> group, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Retrieves the Top N Rankings for the specified game within the
	 * given group
	 * @param gameName
	 *            - Name of the game for which ranks have to be fetched
	 * @param group
	 *            - array of usernames in the group
	 *
	 * @return the Top rankers for a game
	 *
	 */
	@Method(selector = "getTopRankingsByGroup:group:completionBlock:")
	public native void getTopRankingsByGroup(String gameName, NSArray<?> group, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Retrieves the Top Rankings for the specified game
	 *
	 * @param gameName
	 *            - Name of the game for which ranks have to be fetched
	 * @param startDate
	 *            -Start date from which the ranking have to be fetched
	 * @param endDate
	 *            - End date up to which the ranking have to be fetched
	 * @return the Top rankings for a game
	 * @throws App42Exception
	 */
	@Method(selector = "getTopRankings:startDate:endDate:completionBlock:")
	public native void getTopRankings(String gameName, NSDate startDate, NSDate endDate, @Block App42ResponseBlock completionBlock);

	/**
	 *
	 * @param gameName
	 * @param startDate
	 * @param endDate
	 * @param max
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "getTopNRankers:startDate:endDate:max:completionBlock:")
	public native void getTopNRankers(String gameName, NSDate startDate, NSDate endDate, int max, @Block App42ResponseBlock completionBlock);

	/**
	 * Retrieves the last score made by the user in all games
	 *
	 * @param userName
	 *            - Name of the user for which the last score has to be fetched
	 *
	 * @return the Top rankers for a game
	 *
	 */
	@Method(selector = "getLastGameScore:completionBlock:")
	public native void getLastGameScore(String userName, @Block App42ResponseBlock completionBlock);

	/**
	 * Retrieves the User Ranking for the specified game
	 *
	 * @param gameName
	 *            - Name of the game for which ranks have to be fetched
	 * @param userName
	 *            - Name of the user for which ranks have to be fetched
	 *
	 * @return the rank of the User
	 *
	 */
	@Method(selector = "getUserRanking:userName:completionBlock:")
	public native void getUserRanking(String gameName, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * This function returns the top score attained by the specified user in the
	 * game.
	 *
	 * @param gameName
	 *            - Name of the game
	 * @param userName
	 *            - Name of the user for which score has to retrieve
	 * @return Game Object
	 * @throws App42Exception
	 */
	@Method(selector = "getLastScoreByUser:userName:completionBlock:")
	public native void getLastScoreByUser(String gameName, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param scoreId
	 * @param gameScore
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "editScoreValueById:gameScore:completionBlock:")
	public native void editScoreValueById(String scoreId, double gameScore, @Block App42ResponseBlock completionBlock);
	
	/**
	 * This function returns the specified number of top rankers in a specific
	 * game in buddy group.
	 *
	 * @param gameName
	 *            - Name of the game
	 * @param userName
	 *            - Name of the user who fetch scores in group
	 * @param owerName
	 *            - Group owner name
	 * @param GroupName
	 *            - Name of group
	 * @return Game Object
	 * @throws App42Exception
	 */
  	@Method(selector = "getTopRankersFromBuddyGroup:userName:ownerName:groupName:completionBlock:")
	public native void getTopRankersFromBuddyGroup(String gameName, String userName, String ownerName, String groupName, @Block App42ResponseBlock completionBlock);
	                          
	/**
	 *
	 * @param gameName
	 * @param userName
	 * @param fbAccessToken
	 * @param max
	 * @return Game Object
	 * @throws App42Exception
	 */
 	@Method(selector = "getTopNRankersFromFacebook:fbAccessToken:max:completionBlock:")
	public native void getTopNRankersFromFacebook(String gameName, String fbAccessToken, int max, @Block App42ResponseBlock completionBlock);
	                               
	/**
	 * This function returns the specified number of top rankers among facebook friends in specified
	 * range of dates for a specific game.
	 *
	 * @param gameName
	 *            - Name of the game
	 * @param fbAccessToken
	 * @param startDate
	 * @param endDate
	 * @param max
	 * @return Game Object
	 * @throws App42Exception
	 */
	@Method(selector = "getTopNRankersFromFacebook:fbAccessToken:startDate:endDate:max:completionBlock:")
	public native void getTopNRankersFromFacebook(String gameName, String fbAccessToken, NSDate startDate, NSDate endDate, int max, @Block App42ResponseBlock completionBlock);
	                               
	/**
	 *
	 * @param gameName
	 * @param max
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "getTopNTargetRankers:max:completionBlock:")
	public native void getTopNTargetRankers(String gameName, int max, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param gameName
	 * @param minScore
	 * @param maxScore
	 * @return Game object
	 * @throws App42Exception
	 */
	@Method(selector = "getUsersWithScoreRange:minScore:maxScore:completionBlock:")
	public native void getUsersWithScoreRange(String gameName, double minScore, double maxScore, @Block App42ResponseBlock completionBlock);
	
	@Method(selector = "addCustomScore:collectionName:completionBlock:")
	public native void addCustomScore(NSDictionary<?, ?> scoreDict, String collectionName,@Block App42ResponseBlock completionBlock);
}

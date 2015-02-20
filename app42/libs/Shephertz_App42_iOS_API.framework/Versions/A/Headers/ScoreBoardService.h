//
//  ScoreBoardService.h
//  App42_iOS_SERVICE_APIs
//
//  Created by Shephertz Technology on 21/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Service.h"

@class Game;
/**
 * ScoreBoard allows storing, retrieving, querying and ranking scores for users
 * and Games across Game Session. The Game service allows Game, User, Score and
 * ScoreBoard Management on the Cloud. The service allows Game Developer to
 * create a Game and then do in Game Scoring using the Score service. It also
 * allows to maintain a Scoreboard across game sessions using the ScoreBoard
 * service. One can query for average or highest score for user for a Game and
 * highest and average score across users for a Game. It also gives ranking of
 * the user against other users for a particular game. The Reward and
 * RewardPoints allows the Game Developer to assign rewards to a user and redeem
 * the rewards. E.g. One can give Swords or Energy etc. The services Game,
 * Score, ScoreBoard, Reward, RewardPoints can be used in Conjunction for
 * complete Game Scoring and Reward Management.
 *
 * @see Game, RewardPoint, RewardPoint, Score
 *
 */
@interface ScoreBoardService : App42Service
{
    
}

-(id)init __attribute__((unavailable));
-(id)initWithAPIKey:(NSString *)apiKey  secretKey:(NSString *)secretKey;


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
-(void)saveUserScore:(NSString*)gameName gameUserName:(NSString*)gameUserName gameScore:(double)gameScore completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)getScoresByUser:(NSString*)gameName gameUserName:(NSString*)gameUserName completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)getHighestScoreByUser:(NSString*)gameName gameUserName:(NSString*)gameUserName completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)getLowestScoreByUser:(NSString*)gameName gameUserName:(NSString*)gameUserName completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Retrieves the Top Rankings for the specified game
 *
 * @param gameName
 *            - Name of the game for which ranks have to be fetched
 *
 * @return the Top rankings for a game
 *
 */
-(void)getTopRankings:(NSString*)gameName completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)getAverageScoreByUser:(NSString*)gameName userName:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)getTopNRankings:(NSString*)gameName max:(int)max completionBlock:(App42ResponseBlock)completionBlock;

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
-(void)getTopNRankers:(NSString*)gameName max:(int)max completionBlock:(App42ResponseBlock)completionBlock;

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
-(void)getTopRankersByGroup:(NSString*)gameName group:(NSArray*)group completionBlock:(App42ResponseBlock)completionBlock;

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
-(void)getTopRankingsByGroup:(NSString*)gameName group:(NSArray*)group completionBlock:(App42ResponseBlock)completionBlock;

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
-(void)getTopRankings:(NSString*)gameName startDate:(NSDate*) startDate endDate:(NSDate*) endDate completionBlock:(App42ResponseBlock)completionBlock;


/**
 *
 * @param gameName
 * @param startDate
 * @param endDate
 * @param max
 * @return
 * @throws App42Exception
 */
-(void)getTopNRankers:(NSString*)gameName startDate:(NSDate*) startDate endDate:(NSDate*) endDate max:(int)max completionBlock:(App42ResponseBlock)completionBlock;


/**
 * Retrieves the last score made by the user in all games
 *
 * @param userName
 *            - Name of the user for which the last score has to be fetched
 *
 * @return the Top rankers for a game
 *
 */

-(void)getLastGameScore:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;


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
-(void)getUserRanking:(NSString*)gameName userName:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

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
-(void)getLastScoreByUser:(NSString*)gameName userName:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

/**
 *
 * @param scoreId
 * @param gameScore
 * @return
 * @throws App42Exception
 */
-(void)editScoreValueById:(NSString*)scoreId gameScore:(double)gameScore completionBlock:(App42ResponseBlock)completionBlock;

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
-(void)getTopRankersFromBuddyGroup:(NSString*) gameName
                           userName:(NSString*) userName
                          ownerName:(NSString*)ownerName
                          groupName:(NSString*)groupName
                    completionBlock:(App42ResponseBlock)completionBlock;

/**
 *
 * @param gameName
 * @param userName
 * @param fbAccessToken
 * @param max
 * @return Game Object
 * @throws App42Exception
 */
-(void)getTopNRankersFromFacebook:(NSString*) gameName
                     fbAccessToken:(NSString*)fbAccessToken
                               max:(int)max
                   completionBlock:(App42ResponseBlock)completionBlock;

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

-(void)getTopNRankersFromFacebook:(NSString*)gameName
                     fbAccessToken:(NSString*)fbAccessToken
                         startDate:(NSDate*)startDate
                           endDate:(NSDate*)endDate
                               max:(int)max
                   completionBlock:(App42ResponseBlock)completionBlock;

/**
 *
 * @param gameName
 * @param max
 * @return
 * @throws App42Exception
 */
-(void)getTopNTargetRankers:(NSString*)gameName max:(int) max completionBlock:(App42ResponseBlock)completionBlock;

/**
 *
 * @param gameName
 * @param minScore
 * @param maxScore
 * @return Game object
 * @throws App42Exception
 */
-(void)getUsersWithScoreRange:(NSString*)gameName minScore:(double) minScore maxScore:(double)maxScore completionBlock:(App42ResponseBlock)completionBlock;

-(void)addCustomScore:(NSDictionary*)scoreDict collectionName:(NSString*) collectionName completionBlock:(App42ResponseBlock)completionBlock;
@end

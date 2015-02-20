//
//  RewardService.h
//  App42_iOS_SERVICE_APIs
//
//  Created by Shephertz Technology on 21/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Service.h"

@class Reward;

/**
 * Define a Reward e.g. Sword, Energy etc. Is needed for Reward Points
 *
 * The Game service allows Game, User, Score and ScoreBoard Management on the
 * Cloud. The service allows Game Developer to create a Game and then do in Game
 * Scoring using the Score service. It also allows to maintain a Scoreboard
 * across game sessions using the ScoreBoard service. One can query for average
 * or highest score for user for a Game and highest and average score across
 * users for a Game. It also gives ranking of the user against other users for a
 * particular game. The Reward and RewardPoints allows the Game Developer to
 * assign rewards to a user and redeem the rewards. E.g. One can give Swords or
 * Energy etc. The services Game, Score, ScoreBoard, Reward, RewardPoints can be
 * used in Conjunction for complete Game Scoring and Reward Management.
 *
 * @see Game, RewardPoint, Score, ScoreBoard
 */
@interface RewardService : App42Service
{
    
    
}

-(id)init __attribute__((unavailable));
-(id)initWithAPIKey:(NSString *)apiKey  secretKey:(NSString *)secretKey;

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
-(void)createReward:(NSString*)rewardName rewardDescription:(NSString*)rewardDescription completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Fetches the count of all the Rewards
 *
 * @return App42Response objects containing count of all the rewards of the
 *         App
 *
 */
-(void)getAllRewardsCount:(App42ResponseBlock)completionBlock;
/**
 * Fetches all the Rewards
 *
 * @return List of Reward objects containing all the rewards of the App
 *
 */
-(void)getAllRewards:(App42ResponseBlock)completionBlock;
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
-(void)getAllRewards:(int)max offset:(int)offset completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Retrieves the reward for the specified name
 *
 * @param rewardName
 *            - Name of the reward that has to be fetched
 *
 * @return Reward object containing the reward based on the rewardName
 *
 */
-(void)getRewardByName:(NSString*)rewardName completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)earnRewards:(NSString*)gameName gameUserName:(NSString*)gameUserName rewardName:(NSString*)rewardName rewardPoints:(double)rewardsPoints completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)redeemRewards:(NSString*)gameName gameUserName:(NSString*)gameUserName rewardName:(NSString*)rewardName rewardPoints:(double)rewardsPoints completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)getGameRewardPointsForUser:(NSString*)gameName userName:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

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
-(void)getTopNRewardEarners:(NSString*)gameName rewardName:(NSString*)rewardName max:(int)max completionBlock:(App42ResponseBlock)completionBlock;


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
-(void)getAllRewardsByUser:(NSString*)userName rewardName:(NSString*)rewardName completionBlock:(App42ResponseBlock)completionBlock;


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
-(void)getTopNRewardEarnersByGroup:(NSString*)gameName rewardName:(NSString*)rewardName userList:(NSArray*)userList completionBlock:(App42ResponseBlock)completionBlock;


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
-(void) getUserRankingOnReward:(NSString*)gameName rewardName:(NSString*)rewardName userName:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

@end

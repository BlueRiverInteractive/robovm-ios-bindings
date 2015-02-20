//
//  ScoreService.h
//  App42_iOS_SERVICE_APIs
//
//  Created by Shephertz Technology on 21/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Service.h"

@class Game;
/**
 * Allows game scoring. It has to be used for scoring for a particular Game
 * Session. If scores have to be stored across Game sessions then the service
 * ScoreBoard has to be used. It is especially useful for Multiplayer online or
 * mobile games. The Game service allows Game, User, Score and ScoreBoard
 * Management on the Cloud. The service allows Game Developer to create a Game
 * and then do in Game Scoring using the Score service. It also allows to
 * maintain a Scoreboard across game sessions using the ScoreBoard service. One
 * can query for average or highest score for user for a Game and highest and
 * average score across users for a Game. It also gives ranking of the user
 * against other users for a particular game. The Reward and RewardPoints allows
 * the Game Developer to assign rewards to a user and redeem the rewards. E.g.
 * One can give Swords or Energy etc. The services Game, Score, ScoreBoard,
 * Reward, RewardPoints can be used in Conjunction for complete Game Scoring and
 * Reward Management.
 *
 * @see Game, RewardPoint, RewardPoint, ScoreBoard
 *
 */
@interface ScoreService : App42Service
{
    
}

-(id)init __attribute__((unavailable));
-(id)initWithAPIKey:(NSString *)apiKey  secretKey:(NSString *)secretKey;

/**
 * Adds game score for the specified user.
 *
 * @param gameName
 *            - Name of the game for which scores have to be added
 * @param gameUserName
 *            - The user for whom scores have to be added
 * @param gameScore
 *            - The scores that have to be added
 *
 * @return Game object containing the scores that has been added
 *
 */
-(void)addScore:(NSString*)gameName gameUserName:(NSString*)gameUserName gScore:(double)gameScore completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Deducts the score from users account for a particular Game
 *
 * @param gameName
 *            - Name of the game for which scores have to be deducted
 * @param gameUserName
 *            - The user for whom scores have to be deducted
 * @param gameScore
 *            - The scores that have to be deducted
 *
 * @return Game object containing the scores that has been deducted
 *
 */
-(void)deductScore:(NSString*)gameName gameUserName:(NSString*)gameUserName gameScore:(double)gameScore completionBlock:(App42ResponseBlock)completionBlock;


@end

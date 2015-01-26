//
//  GameService.h
//  App42_iOS_SERVICE_APIs
//
//  Created by shephertz technologies on 17/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Service.h"
/**
 * The Game service allows Game, User, Score and ScoreBoard Management on the
 * Cloud. The service allows Game Developer to create a Game and then do in Game
 * Scoring using the Score service. It also allows to maintain a Score board
 * across game sessions using the ScoreBoard service. One can query for average
 * or highest score for user for a Game and highest and average score across
 * users for a Game. It also gives ranking of the user against other users for a
 * particular game. The Reward and RewardPoints allows the Game Developer to
 * assign rewards to a user and redeem the rewards. E.g. One can give Swords or
 * Energy etc. The services Game, Score, ScoreBoard, Reward, RewardPoints can be
 * used in Conjunction for complete Game Scoring and Reward Management.
 *
 * @see Reward, RewardPoint, Score, ScoreBoard
 */
@interface GameService : App42Service
{
    
    
}

-(id)init __attribute__((unavailable));
-(id)initWithAPIKey:(NSString *)apiKey  secretKey:(NSString *)secretKey;

/**
 * Creates a game on the cloud
 *
 * @param gameName
 *            - Name of the game that has to be created
 * @param gameDescription
 *            - Description of the game to be created
 *
 * @return Game object containing the game which has been created
 *
 */
-(void)createGame:(NSString*)gameName gameDescription:(NSString*)gameDescription completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Fetches the count of all games for the App
 *
 * @return App42Response object containing count of all the Game for the App
 * 
 */
-(void)getAllGamesCount:(App42ResponseBlock)completionBlock;
/**
 * Fetches all games for the App
 *
 * @return List of Game object containing all the games for the App
 *
 *
 */
-(void)getAllGames:(App42ResponseBlock)completionBlock;
/**
 * Fetches all games for the App by paging.
 *
 * @param max
 *            - Maximum number of records to be fetched
 * @param offset
 *            - From where the records are to be fetched
 *
 * @return List of Game object containing all the games for the App
 *
 */
-(void)getAllGames:(int)max offset:(int)offset completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Retrieves the game by the specified name
 *
 * @param gameName
 *            - Name of the game that has to be fetched
 *
 * @return Game object containing the game which has been created
 *
 */
-(void)getGameByName:(NSString*)gameName completionBlock:(App42ResponseBlock)completionBlock;


@end

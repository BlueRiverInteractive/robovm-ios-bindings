//
//  AchievementService.h
//  PAE_iOS_SDK
//
//  Created by Rajeev on 19/12/13.
//  Copyright (c) 2013 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Shephertz_App42_iOS_API/Shephertz_App42_iOS_API.h>

@class Achievement;
@interface AchievementService : App42Service

- (id) init __attribute__((unavailable));
/**
 * This is a constructor that takes
 *
 * @param apiKey
 * @param secretKey
 * @param baseURL
 *
 */
-(id)initWithAPIKey:(NSString *)apiKey  secretKey:(NSString *)secretKey;

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

-(void)createAchievementWithName:(NSString*)achievementName description:(NSString*)description completionBlock:(App42ResponseBlock)completionBlock;

/**
 *   App users can earn achievements based on your custom rules in your game.
 *
 * @param userName - Name of the user for which avatar has to earn
 * @param achievementName - Name of the achievement which is to be earn
 * @param gameName - Name of the for which avatar has to be earn
 * @return Achievement Object
 * @throws App42Exception
 */

-(void)earnAchievementWithName:(NSString*)achievementName userName:(NSString*)userName gameName:(NSString*)gameName description:(NSString*)description completionBlock:(App42ResponseBlock)completionBlock;

/**
 *  Fetch all the achievements of user.
 *
 * @param userName - Name of user for which all achievement is to fetch
 * @return Achievement Object
 * @throws App42Exception
 */

-(void)getAllAchievementsForUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

/**
 *   Fetch all the achievements by user in a particular game.
 *
 * @param userName - Name of the user for which achievement has to fetch
 * @param gameName - Name of the game for which achievement has to fetch
 * @return Achievement Object
 * @throws App42Exception
 */

-(void)getAllAchievementsForUser:(NSString*)userName inGame:(NSString*)gameName completionBlock:(App42ResponseBlock)completionBlock;

/**
 * View detail description of all achievements created in app.
 *
 *
 * @return Achievement Object
 * @throws App42Exception
 */

-(void)getAllAchievements:(App42ResponseBlock)completionBlock;

/**
 * Fetch detail description of achievement by achievement name.
 *
 * @param achievementName - Name of the achievement whose detail is to be fetched.
 * @return Achievement Object
 * @throws App42Exception
 */

-(void)getAchievementByName:(NSString*)achievementName completionBlock:(App42ResponseBlock)completionBlock;

/**
 * Fetch all users who have earn particular achievement in specific game.
 *
 * @param achievementName - Name of the achievement whose detail is to fetch.
 * @param gameName - Name of the game for which achievement has to fetch.
 * @return Achievement Object
 * @throws App42Exception
 */
-(void)getAllUsersWithAchievement:(NSString*)achievementName inGame:(NSString*)gameName completionBlock:(App42ResponseBlock)completionBlock;

@end

//
//  App42API.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 20/06/13.
//  Copyright (c) 2013 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface App42API : NSObject
{

}

+(NSArray*) getDefaultACL;
+(void) setDefaultACL:(NSArray*)l_defaultACL;
+(NSString*) getLoggedInUser;
+(void) setLoggedInUser:(NSString*)l_loggedInUser;
+(NSString*) getUserSessionId;
+(void) setUserSessionId:(NSString*)l_userSessionId;
+(void)initializeWithAPIKey:(NSString*)l_apiKey andSecretKey:(NSString*)l_secretKey;
+(void) setFbAccesToken:(NSString*)l_fbAccesToken;
+(NSString*) getFbAccesToken;
+(void) setInstallId:(NSString*)l_installId;
+(NSString*) getInstallId;
+(void)removeSession;

+(void)enableAppStateEventTracking:(BOOL)isEnable;
+(void)enableEventService:(BOOL)isEnable;

+(void)setBaseUrl:(NSString*)baseUrl;

+(void)setCacheStoragePolicy:(NSURLRequestCachePolicy)cachePolicy;
+(NSURLRequestCachePolicy)getCacheStoragePolicy;

+(void)enableApp42Trace:(BOOL)isEnable;
+(void)enableCrashEventHandler:(BOOL)isEnable;
+(NSString*) getDbName;
+(void) setDbName:(NSString*) l_dbName;

+(NSString*)getSecretKey;
+(void)setOfflineStorage:(BOOL)_offlineStorage;
+(void)setOfflineStorage:(BOOL)_offlineStorage withCacheSize:(long)cacheSize;
+(BOOL)getOfflineStorage;


/*!
 *@return Returns the instance of User API
 */
+(id)buildUserService;
/*!
 *@return Returns the instance of EmailSender API
 */
+(id)buildEmailService;
/*!
 *@return Returns the instance of Storage API
 */
+(id)buildStorageService;
/*!
 *@return Returns the instance of Session API
 */
+(id)buildSessionService;
/*!
 *@return Returns the instance of Photo API
 */
+(id)buildPhotoService;
/*!
 *@return Returns the instance of User API
 */
+(id)buildQueueService;
/*!
 *@return Returns the instance of Recommender API
 */
+(id)buildRecommenderService;
/*!
 *@return Returns the instance of Upload API
 */
+(id)buildUploadService;
/*!
 *@return Returns the instance of Catalogue API
 */
+(id)buildCatalogueService;
/*!
 *@return Returns the instance of Cart API
 */
+(id)buildCartService;
/*!
 *@return Returns the instance of Album API
 */
+(id)buildAlbumService;
/*!
 *@return Returns the instance of Log API
 */
+(id)buildLogService;
/*!
 *@return Returns the instance of Review API
 */
+(id)buildReviewService;
/*!
 *@return Returns the instance of Geo API
 */
+(id)buildGeoService;
/*!
 *@return Returns the instance of Game API
 */
+(id)buildGameService;
/*!
 *@return Returns the instance of Reward API
 */
+(id)buildRewardService;
/*!
 *@return Returns the instance of Score API
 */
+(id)buildScoreService;
/*!
 *@return Returns the instance of ScoreBoard API
 */
+(id)buildScoreBoardService;
/*!
 *@return Returns the instance of Image Processor API
 */
+(id)buildImageProcessorService;
/*!
 *@return Returns the instance of Push API
 */
+(id)buildPushService;
/*!
 *@return Returns the instance of Social API
 */
+(id)buildSocialService;
/*!
 *@return Returns the instance of Buddy API
 */
+(id)buildBuddyService;

/*!
 *@return Returns the instance of ABTestService API
 */
+(id)buildABTestService;

/*!
 *@return Returns the instance of AvatarService API
 */
+(id)buildAvatarService;

/*!
 *@return Returns the instance of CustomCode API
 */
+(id)buildCustomCodeService;

/*!
 *@return Returns the instance of AchievementService API
 */
+(id)buildAchievementService;

/*!
 *@return Returns the instance of GiftService API
 */
+(id)buildGiftService;

/*!
 *@return Returns the instance of TimerService API
 */
+(id)buildTimerService;

/*!
 *@return Returns the instance of EventService API
 */
+(id)buildEventService;

@end

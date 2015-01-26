//
//  RecommenderService.h
//  App42_iOS_SERVICE_APIs
//
//  Created by shephertz technologies on 13/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Service.h"


@class Recommender;
@class PreferenceData;
/**
 * Recommendation engine which provides reommendation based on customer id, item
 * id and the preference of the customer for a particular Item. Recommendations
 * can be fetched based on User Similarity which finds similarity based on Users
 * and Item Similarity which finds similarity based on Items. The Recommendation
 * Engine currently supports two types of Similarity Algorithms i.e.
 * EuclideanDistanceSimilarity and PearsonCorrelationSimilarity. By default when
 * similarity is not specified PearsonCorrelationSimilarity is used e.g. in the
 * method itemBased(String preferenceFileName, long userId, int howMany), it
 * uses PearsonCorrelationSimilarity. In the method itemBasedBySimilarity(String
 * similarity, String preferenceFileName, long userId, int howMany) one can
 * specify which similarity algorithm has to be used e.g.
 * Recommender.EUCLIDEAN_DISTANCE or Recommender.PEARSON_CORRELATION.
 *
 * Preference file can be loaded using the method loadPreferenceFile(String
 * fileName, String preferenceFilePath, String description) in csv format. This
 * prefernce file has to be uploaded once which can be a batch process The csv
 * format for the file is given below. customerId, itemId, preference e.g.
 * 1,101,5.0 1,102,3.0 1,103,2.5
 *
 * 2,101,2.0 2,102,2.5 2,103,5.0 2,104,2.0
 *
 * 3,101,2.5 3,104,4.0 3,105,4.5 3,107,5.0
 *
 * 4,101,5.0 4,103,3.0 4,104,4.5 4,106,4.0
 *
 * 5,101,4.0 5,102,3.0 5,103,2.0 5,104,4.0 5,105,3.5 5,106,4.0 The customer Id
 * and item id can be any alphanumaric character(s) and preference values can be
 * in any range.
 *
 * If app developers have used the Review Service. The Recommendation Engine can
 * be used in conjunction with Review. In this case a CSV preference file need
 * not be uploaded. The customerId, itemId and preference will be taken from
 * Review where customerId is mapped with userName, itemId is mapped with itemId
 * and preference with rating. The methods for recommendations based on Reviews
 * are part of the Review service
 *
 *
 * @see ReviewService
 *
 */
extern NSString *const EUCLIDEAN_DISTANCE;
extern NSString *const PEARSON_CORRELATION;

@interface RecommenderService : App42Service
{

}

-(id)init __attribute__((unavailable));
-(id)initWithAPIKey:(NSString *)apiKey  secretKey:(NSString *)secretKey;

/**
 * Uploads peference file on the cloud. The preference file should be in CSV
 * format. This prefernce file has to be uploaded once which can be a batch
 * process. New versions of preference file either can be uploaded in a
 * different name or the older one has to be removed and the uploaded in the
 * same name. The csv format for the file is given below. customerId,
 * itemId, preference e.g. 1,101,5.0 1,102,3.0 1,103,2.5
 *
 * 2,101,2.0 2,102,2.5 2,103,5.0 2,104,2.0
 *
 * 3,101,2.5 3,104,4.0 3,105,4.5 3,107,5.0
 *
 * 4,101,5.0 4,103,3.0 4,104,4.5 4,106,4.0
 *
 * 5,101,4.0 5,102,3.0 5,103,2.0 5,104,4.0 5,105,3.5 5,106,4.0 The customer
 * Id and item id can be any alphanumaric character(s) and preference values
 * can be in any range. If the recommendations have to be done based on
 * Reviews then this file need not be uploaded.
 *
 * @param preferenceFilePath
 *            - Path of the preference file to be loaded
 *
 * @return App42Response object.
 *
 *
 */

-(void)loadPreferenceFile:(NSString*)preferenceFilePath completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Uploads peference file on the cloud via Stream. The preference file should be in CSV
 * format. This prefernce file has to be uploaded once which can be a batch
 * process. New versions of preference file either can be uploaded in a
 * different name or the older one has to be removed and the uploaded in the
 * same name. The csv format for the file is given below. customerId,
 * itemId, preference e.g. 1,101,5.0 1,102,3.0 1,103,2.5
 *
 * 2,101,2.0 2,102,2.5 2,103,5.0 2,104,2.0
 *
 * 3,101,2.5 3,104,4.0 3,105,4.5 3,107,5.0
 *
 * 4,101,5.0 4,103,3.0 4,104,4.5 4,106,4.0
 *
 * 5,101,4.0 5,102,3.0 5,103,2.0 5,104,4.0 5,105,3.5 5,106,4.0 The customer
 * Id and item id can be any alphanumaric character(s) and preference values
 * can be in any range. If the recommendations have to be done based on
 * Reviews then this file need not be uploaded.
 *
 * @param inputStream
 *            - InputStream of the file to load.
 *
 * @return App42Response object.
 *
 *
 */
-(void)loadPreferenceFileWithData:(NSData*)preferenceData completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Add or Update preference list on the cloud.
 *
 * @param preferenceDataList
 *            - List of PreferenceData which contains customerId, itemId,
 *            preference
 *
 * @return App42Response object
 *
 *
 */
-(void)addOrUpdatePreference:(NSMutableArray*)preferenceDataList completionBlock:(App42ResponseBlock)completionBlock;
/**
 * User based recommendations based on Neighborhood. Recommendations are
 * found based on similar users in the Neighborhood of the given user. The
 * size of the neighborhood can be found.
 *
 * @param userId
 *            - The user Id for whom recommendations have to be found
 * @param size
 *            - Size of the Neighborhood
 * @param howMany
 *            - Specifies that how many recommendations have to be found
 *
 * @returns Recommender Object
 *
 *
 */
-(void)userBasedNeighborhood:(long)userId size:(int)size howMany:(int)howMany completionBlock:(App42ResponseBlock)completionBlock;
/**
 * User based neighborhood recommendations based on Threshold.
 * Recommendations are found based on Threshold where thereshold represents
 * similarity threshold where user are atleast that similar. Threshold
 * values can vary from -1 to 1
 *
 * @param userId
 *            - The user Id for whom recommendations have to be found
 * @param threshold
 *            - Threshold size. Values can vary from -1 to 1
 * @param howMany
 *            - Specifies that how many recommendations have to be found
 *
 * @returns Recommender Object
 *
 *
 */
-(void)userBasedThreshold:(long)userId threshold:(double)threshold howMany:(int)howMany completionBlock:(App42ResponseBlock)completionBlock;
/**
 * User based recommendations based on Neighborhood and Similarity.
 * Recommendations and found based on the similar users in the Neighborhood
 * with the specified Similarity Algorithm. Algorithm can be specified using
 * the constants Recommender.EUCLIDEAN_DISTANCE and
 * Recommender.PEARSON_CORRELATION
 *
 * @param recommenderSimilarity
 *            - Similarity algorithm e.g. Recommender.EUCLIDEAN_DISTANCE and
 *            Recommender.PEARSON_CORRELATION
 * @param userId
 *            - The user Id for whom recommendations have to be found
 * @param size
 *            - Size of the Neighborhood
 * @param howMany
 *            - Specifies that how many recommendations have to be found
 *
 * @returns Recommender Object
 *
 *
 */
-(void)userBasedNeighborhoodBySimilarity:(NSString*)recommenderSimilarity userId:(long)userId size:(int)size howMany:(int)howMany completionBlock:(App42ResponseBlock)completionBlock;
/**
 * User based neighbourhood recommendations based on Threshold.
 * Recommendations are found based on Threshold where threshold represents
 * similarity threshold where user are at least that similar. Threshold
 * values can vary from -1 to 1
 *
 * @param recommenderSimilarity
 *            - Similarity algorithm e.g. Recommender.EUCLIDEAN_DISTANCE and
 *            Recommender.PEARSON_CORRELATION
 * @param userId
 *            - The user Id for whom recommendations have to be found
 * @param threshold
 *            - Threshold size. Values can vary from -1 to 1
 * @param howMany
 *            - Specifies that how many recommendations have to be found
 *
 * @returns Recommender Object
 *
 *
 */
-(void)userBasedThresholdBySimilarity:(NSString*)recommenderSimilarity userId:(long)userId threshold:(double)threshold howMany:(int)howMany completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Item based recommendations. Recommendations and found based item
 * similarity of the given user. The size of the neighborhood can be found.
 *
 * @param userId
 *            - The user Id for whom recommendations have to be found
 * @param howMany
 *            - Specifies that how many recommendations have to be found
 *
 * @returns Recommender Object
 *
 *
 */
-(void)itemBased:(long)userId howMany:(int)howMany completionBlock:(App42ResponseBlock)completionBlock;

/**
 * Recommendations based on SlopeOne Algorithm
 *
 * @param userId
 *            - The user Id for whom recommendations have to be found
 * @param howMany
 *            - Specifies that how many recommendations have to be found
 *
 * @returns Recommender Object
 *
 *
 */
-(void)slopeOne:(long)userId howMany:(int)howMany completionBlock:(App42ResponseBlock)completionBlock;
/**
 * User based neighbourhood recommendations based on Threshold for all
 * Users. Recommendations are found based on Threshold where threshold
 * represents similarity threshold where user are at least that similar.
 * Threshold values can vary from -1 to 1
 *
 * @param threshold
 *            - Threshold size. Values can vary from -1 to 1
 * @param howMany
 *            - Specifies that how many recommendations have to be found
 *
 * @returns Recommender Object for all Users
 *
 *
 */
-(void)userBasedThresholdForAll:(double)threshold howMany:(int)howMany completionBlock:(App42ResponseBlock)completionBlock;
/**
 * User based recommendations based on Neighborhood and Similarity for all
 * Users. Recommendations and found based similar users in the Neighborhood
 * with the specified Similarity Algorithm. Algorithm can be specified using
 * the constants Recommender.EUCLIDEAN_DISTANCE and
 * Recommender.PEARSON_CORRELATION
 *
 * @param recommenderSimilarity
 *            - Similarity algorithm e.g. Recommender.EUCLIDEAN_DISTANCE and
 *            Recommender.PEARSON_CORRELATION
 * @param size
 *            - Size of the Neighborhood
 * @param howMany
 *            - Specifies that how many recommendations have to be found
 *
 * @returns Recommender Object for all Users
 *
 *
 */
-(void)userBasedNeighborhoodBySimilarityForAll:(NSString*)recommenderSimilarity size:(int)size howMany:(int)howMany completionBlock:(App42ResponseBlock)completionBlock;
/**
 * User based neighbourhood recommendations based on Threshold for All.
 * Recommendations are found based on Threshold where threshold represents
 * similarity threshold where user are at least that similar. Threshold
 * values can vary from -1 to 1
 *
 * @param recommenderSimilarity
 *            - Similarity algorithm e.g. Recommender.EUCLIDEAN_DISTANCE and
 *            Recommender.PEARSON_CORRELATION
 * @param threshold
 *            - Threshold size. Values can vary from -1 to 1
 * @param howMany
 *            - Specifies that how many recommendations have to be found
 *
 * @returns Recommender Object for All
 *
 *
 */
-(void)userBasedThresholdBySimilarityForAll:(NSString*)recommenderSimilarity threshold:(double)threshold howMany:(int)howMany completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Item based recommendations for all Users. Recommendations and found based
 * item similarity of the given user. The size of the neighborhood can be
 * found.
 *
 * @param howMany
 *            - Specifies that how many recommendations have to be found
 *
 * @returns Recommender Object for all Users
 *
 *
 */
-(void)itemBasedForAll:(int)howMany completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Item based recommendations for all Users. Recommendations and found based
 * one item similarity. Similarity algorithm can be specified. of the given
 * user. The size of the neighborhood can be found.
 *
 * @param recommenderSimilarity
 *            - Similarity algorithm e.g. Recommender.EUCLIDEAN_DISTANCE and
 *            Recommender.PEARSON_CORRELATION
 * @param howMany
 *            - Specifies that how many recommendations have to be found
 *
 * @returns Recommender Object for all Users
 *
 *
 */
-(void)itemBasedBySimilarityForAll:(NSString*)recommenderSimilarity howMany:(int)howMany completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Recommendations based on SlopeOne Algorithm for all Users
 *
 * @param howMany
 *            - Specifies that how many recommendations have to be found
 *
 * @returns Recommender Object for all Users
 *
 *
 */
-(void)slopeOneForAll:(int)howMany completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Item based recommendations. Recommendations and found based one item
 * similarity. Similarity algorithm can be specified. of the given user. The
 * size of the neighborhood can be found.
 *
 * @param recommenderSimilarity
 *            - Similarity algorithm e.g. Recommender.EUCLIDEAN_DISTANCE and
 *            Recommender.PEARSON_CORRELATION
 * @param userId
 *            - The user Id for whom recommendations have to be found
 * @param howMany
 *            - Specifies that how many recommendations have to be found
 *
 * @returns Recommender Object
 *
 *
 */
-(void)itemBasedBySimilarity:(NSString*)recommenderSimilarity userId:(long)userId howMany:(int)howMany completionBlock:(App42ResponseBlock)completionBlock;
/**
 * User based recommendations based on Neighborhood for All Users.
 * Recommendations and found based similar users in the Neighborhood of the
 * given user. The size of the neighborhood can be found.
 *
 * @param size
 *            - Size of the Neighborhood
 * @param howMany
 *            - Specifies that how many recommendations have to be found
 *
 * @returns Recommender Object for All users
 *
 *
 */
-(void)userBasedNeighborhoodForAll:(int)size howMany:(int)howMany completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Delete existing preference file.
 *
 * @returns App42Response Object.
 *
 */
-(void)deleteAllPreferences:(App42ResponseBlock)completionBlock;

@end

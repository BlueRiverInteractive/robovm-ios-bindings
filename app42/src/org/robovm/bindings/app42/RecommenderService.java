package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class RecommenderService extends App42Service
{
	public RecommenderService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
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
	@Method(selector = "loadPreferenceFile:completionBlock:")
	public native void loadPreferenceFile(String preferenceFilePath, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "loadPreferenceFileWithData:completionBlock:")
	public native void loadPreferenceFileWithData(NSData preferenceData, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "addOrUpdatePreference:completionBlock:")
	public native void addOrUpdatePreference(NSMutableArray<?> preferenceDataList, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "userBasedNeighborhood:userId:size:howMany:completionBlock:")
	public native void userBasedNeighborhood(long userId, int size, int howMany, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "userBasedThreshold:threshold:howMany:completionBlock:")
	public native void userBasedThreshold(long userId, double threshold, int howMany, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "userBasedNeighborhoodBySimilarity:userId:size:howMany:completionBlock:")
	public native void userBasedNeighborhoodBySimilarity(String recommenderSimilarity, long userId, int size, int howMany, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "userBasedNeighborhoodBySimilarity:userId:threshold:howMany:completionBlock:")
	public native void userBasedNeighborhoodBySimilarity(String recommenderSimilarity, long userId, double threshold, int howMany, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "itemBased:howMany:completionBlock:")
	public native void itemBased(long userId, int howMany, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "slopeOne:howMany:completionBlock:")
	public native void slopeOne(long userId, int howMany, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "userBasedThresholdForAll:howMany:completionBlock:")
	public native void userBasedThresholdForAll(double threshold, int howMany, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "userBasedNeighborhoodBySimilarityForAll:size:howMany:completionBlock:")
	public native void userBasedNeighborhoodBySimilarityForAll(String recommenderSimilarity, int size, int howMany, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "userBasedThresholdBySimilarityForAll:size:howMany:completionBlock:")
	public native void userBasedThresholdBySimilarityForAll(String recommenderSimilarity, double threshold, int howMany, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "itemBasedForAll:completionBlock:")
	public native void itemBasedForAll(int howMany, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "itemBasedBySimilarityForAll:howMany:completionBlock:")
	public native void itemBasedBySimilarityForAll(String recommenderSimilarity, int howMany, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "slopeOneForAll:completionBlock:")
	public native void slopeOneForAll(int howMany, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "itemBasedBySimilarity:userId:howMany:completionBlock:")
	public native void itemBasedBySimilarity(String recommenderSimilarity, long userId, int howMany, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "userBasedNeighborhoodForAll:howMany:completionBlock:")
	public native void userBasedNeighborhoodForAll(int size, int howMany, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Delete existing preference file.
	 *
	 * @returns App42Response Object.
	 *
	 */
	@Method(selector = "deleteAllPreferences:")
	public native void deleteAllPreferences(@Block App42ResponseBlock completionBlock);
}

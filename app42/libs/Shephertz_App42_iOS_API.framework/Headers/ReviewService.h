//
//  ReviewService.h
//  App42_iOS_SERVICE_APIs
//
//  Created by shephertz technologies on 15/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Service.h"

@class Review;
/**
 * The service is a Review & Rating manager for any item. The item can be
 * anything which has an id e.g. App on a AppStore/Marketplace, items in a
 * catalogue, articles, blogs etc. It manages the comments and its associated
 * rating. It also provides methods to fetch average, highest etc. Reviews.
 * Reviews can be also be muted or unmuted if it has any objectionable content.
 *
 * @see Review
 *
 */


@interface ReviewService : App42Service
{
   
}
-(id)init __attribute__((unavailable));
-(id)initWithAPIKey:(NSString *)apiKey  secretKey:(NSString *)secretKey;

/**
 * Creates review for the specified item on the cloud
 *
 * @param userID
 *            - The user who has created the review
 * @param itemID
 *            - The item for which the review has to be created
 * @param reviewComment
 *            - The review comment
 * @param reviewRating
 *            - Review rating in double
 *
 * @return Review object containing the review which has been created
 *
 */
-(void)createReview:(NSString*)userId itemID:(NSString*)itemId reviewComment:(NSString*)reviewComment reviewRating:(double)reviewRating completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Fetches all reviews for the App
 *
 * @return list of Review object containing all the reviews for the App
 *
 */
-(void)getAllReviews:(App42ResponseBlock)completionBlock;
/**
 * Fetches count of all reviews for the App
 *
 * @return App42Response containing count of all the reviews for the App
 *
 */
-(void)getAllReviewsCount:(App42ResponseBlock)completionBlock;
/**
 * Fetches all reviews for the App by Paging.
 *
 * @param max
 *            - Maximum number of records to be fetched
 * @param offset
 *            - From where the records are to be fetched
 *
 * @return list of Review object containing all the reviews for the App
 *
 */
-(void)getAllReviews:(int)max offset:(int)offset completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Fetches the average review for the specified itemId
 *
 * @param itemId
 *            - The item for which the average review has to be fetched
 *
 * @return Review object containing the average review for a item
 *
 */
-(void)getAverageReviewByItem:(NSString*)itemId completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Fetches count of All Reviews based on the itemId
 *
 * @param itemId
 *            - The item for which count of reviews have to be fetched
 *
 * @return App42Response containing count of all the reviews for a item
 *
 */
-(void)getReviewsCountByItem:(NSString*)itemId completionBlock:(App42ResponseBlock)completionBlock;
-(void)getReviewsCountByItem:(NSString*)itemId andRating:(double)rating completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Fetches All Reviews based on the itemId
 *
 * @param itemId
 *            - The item for which reviews have to be fetched
 *
 * @return list of Review object containing all the reviews for a item
 *
 */
-(void)getReviewsByItem:(NSString*)itemId completionBlock:(App42ResponseBlock)completionBlock;

/**
 * Fetches All Reviews based on the itemId by Paging.
 *
 * @param itemId
 *            - The item for which reviews have to be fetched
 * @param max
 *            - Maximum number of records to be fetched
 * @param offset
 *            - From where the records are to be fetched
 *
 * @return list of Review object containing all the reviews for a item
 *
 */

-(void)getReviewsByItem:(NSString*)itemId max:(int)max offset:(int)offset completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Fetches the highest review for the specified itemId
 *
 * @param itemId
 *            - The item for which the highest review has to be fetched
 *
 * @return Review object containing the highest review for a item
 *
 */
-(void)getHighestReviewByItem:(NSString*)itemId completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Fetches the lowest review for the specified itemId
 *
 * @param itemId
 *            - The item for which the lowest review has to be fetched
 *
 * @return Review object containing the lowest review for a item
 *
 */
-(void)getLowestReviewByItem:(NSString*)itemId completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Mutes the specified review
 *
 * @param reviewId
 *            - The Id of the review which has to be muted
 *
 * @return App42Response if muted successfully
 *
 */
-(void)mute:(NSString*)reviewId completionBlock:(App42ResponseBlock)completionBlock;
/**
 * UnMutes the specified review
 *
 * @param reviewId
 *            - The Id of the review which has to be unmuted
 *
 * @return App42Response if unmuted successfully
 *
 */
-(void)unmute:(NSString*)reviewId completionBlock:(App42ResponseBlock)completionBlock;

-(void)addComment:(NSString*)comment byUser:(NSString*)userID forItem:(NSString*)itemID completionBlock:(App42ResponseBlock)completionBlock;
-(void)getCommentsByItem:(NSString*)itemID completionBlock:(App42ResponseBlock)completionBlock;

/**
 *
 * @param reviewId
 * @return
 * @throws App42Exception
 */

-(void)deleteReviewByReviewId:(NSString*)reviewId completionBlock:(App42ResponseBlock)completionBlock;

/**
 *
 * @param commentId
 * @return
 * @throws App42Exception
 */
-(void)deleteCommentByCommentId:(NSString*)commentId completionBlock:(App42ResponseBlock)completionBlock;

/**
 *
 * @param userId
 * @return
 * @throws App42Exception
 */
-(void)getAllReviewsByUser:(NSString*)userId completionBlock:(App42ResponseBlock)completionBlock;

@end

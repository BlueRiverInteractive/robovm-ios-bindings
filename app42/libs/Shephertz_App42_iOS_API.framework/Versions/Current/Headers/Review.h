//
//  Review.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 11/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"

/**
 *
 * This Review object is the value object which contains the properties of
 * Review along with the setter & getter for those properties.
 *
 */


@interface Review : App42Response{
    
    NSString *userId;
    NSString *itemId;
    NSString *status;
    NSString *reviewId;
    NSString *comment;
    NSString *commentId;
    double rating;
    NSDate *createdOn;
    
}
/*!
 *set and get the userId of the User.
 */
@property(nonatomic,retain)NSString *userId;
/*!
 *set and get the itemId of the User.
 */
@property(nonatomic,retain)NSString *itemId;
/*!
 *set and get the status of the User.
 */
@property(nonatomic,retain)NSString *status;
/*!
 *set and get the reviewId of the User.
 */
@property(nonatomic,retain)NSString *reviewId;
/*!
 *set and get the comment of the User.
 */
@property(nonatomic,retain)NSString *comment;
/*!
 *set and get the commentId For a comment.
 */
@property(nonatomic,retain)NSString *commentId;
/*!
 *set and get the rating given by the User.
 */
@property(nonatomic,assign)double rating;
/*!
 *set and get the time, day and date of the review when it was created by the
 * User.
 *
 * @return the createdOn information of the review by the User.
 */
@property(nonatomic,retain)NSDate *createdOn;

@end

//
//  Gift.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technologies Pvt Ltd on 12/06/14.
//  Copyright (c) 2014 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Shephertz_App42_iOS_API/Shephertz_App42_iOS_API.h>

@interface Gift : App42Response

/*!
 *set and get the name for the Gift.
 */
@property(nonatomic,retain) NSString *name;
/*!
 *set and get the displayName for the Gift.
 */
@property(nonatomic,retain) NSString *displayName;
/*!
 *set and get the icon for the Gift.
 */
@property(nonatomic,retain) NSString *icon;
/*!
 *set and get the description of the gift.
 */
@property(nonatomic,retain) NSString *description;
/*!
 *set and get the tag for the Gift.
 */
@property(nonatomic,retain) NSString *tag;
/*!
 *set and get the creation time of the gift.
 */
@property(nonatomic,retain) NSDate *createdOn;
/*!
 *set and get the list of all the requests in the gift.
 */
@property(nonatomic,retain) NSMutableArray *requests;

@end

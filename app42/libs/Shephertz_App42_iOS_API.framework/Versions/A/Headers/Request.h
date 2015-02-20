//
//  Request.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technologies Pvt Ltd on 12/06/14.
//  Copyright (c) 2014 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Request : NSObject

/*!
 *set and get the sender for the items in Gift.
 */
@property(nonatomic,retain) NSString *sender;
/*!
 *set and get the recipient of the Requests.
 */
@property(nonatomic,retain) NSString *recipient;
/*!
 *set and get the request message.
 */
@property(nonatomic,retain) NSString *message;
/*!
 *set and get the requestId of the Requests.
 */
@property(nonatomic,retain) NSString *requestId;
/*!
 *set and get the type of the Gift.
 */
@property(nonatomic,assign) NSString *type;
/*!
 *set and get the expiration time of the gift.
 */
@property(nonatomic,retain) NSDate *expiration;
/*!
 *set and get the sent time of the gift.
 */
@property(nonatomic,retain) NSDate *sentOn;
/*!
 *set and get the received time of the gift.
 */
@property(nonatomic,retain) NSDate *receivedOn;


@end

//
//  Session.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 04/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"

/**
 *
 * This Session object is the value object which contains the properties of
 * Session along with the setter & getter for those properties.
 *
 */


@interface Session : App42Response{
    
    NSString *userName;
    NSString *sessionId;
    NSDate *invalidatedOn;
    NSDate *createdOn;
    NSMutableArray *attributeArray;
    
}
/*!
 *set and get the userName for the session. 
 */
@property(nonatomic,retain)NSString *userName;
/*!
 *set and get the sessionId for the session.
 */
@property(nonatomic,retain)NSString *sessionId;
/*!
 *set and get the invalidatedOn information for the session.
 */
@property(nonatomic,retain)NSDate *invalidatedOn;
/*!
 *set and get the time, date and day the session was created on.
 */
@property(nonatomic,retain)NSDate *createdOn;
/*!
 *set and get the List of the Attributed for the Session.
 */
@property(nonatomic,retain)NSMutableArray *attributeArray;

@end

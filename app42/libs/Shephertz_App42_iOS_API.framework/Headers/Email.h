//
//  Email.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 10/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"

/**
 *
 * This Email object is the value object which contains the properties of Email
 * along with the setter & getter for those properties.
 *
 */

@interface Email : App42Response{
    
    NSString *from;
    NSString *to;
    NSString *subject;
    NSString *body;
    NSMutableArray *configurationArray;
    
}
/*!
 *set and get the ID from where the email is received. 
 */
@property(nonatomic,retain)NSString *from;
/*!
 *set and get the ID to whom the email has to be sent.
 */
@property(nonatomic,retain)NSString *to;
/*!
 *set and get the subject of the Email.
 */
@property(nonatomic,retain)NSString *subject;
/*!
 *set and get the body of the Email.
 */
@property(nonatomic,retain)NSString *body;
/*!
 *set and get the list of email configuration.
 */
@property(nonatomic,retain)NSMutableArray *configurationArray;
-(id)init;

@end

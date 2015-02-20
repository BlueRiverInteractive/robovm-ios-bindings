//
//  LogMessage.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 11/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"
#import "Log.h"

/**
 * An inner class that contains the remaining properties of the Log.
 *
 */

@interface LogMessage : App42Response
{
    Log *logObject;
    
    NSString *message;
    NSString *type;
    NSDate *logTime;
    NSString *module;
    
}
/*!
 *set and get the logObject for LogMessage Object 
 */
@property(nonatomic,retain)Log *logObject;
/*!
 *set and get the message in a log. 
 */
@property(nonatomic,retain)NSString *message;
/*!
 *set and get the type of the message in the log. 
 */
@property(nonatomic,retain)NSString *type;
/*!
 *set and get the time the log was created. 
 */
@property(nonatomic,retain)NSDate *logTime;
/*!
 *set and get the appModule name. 
 */
@property(nonatomic,retain)NSString *module;
- (id) init __attribute__((unavailable));
-(id)initWithLog:(Log*)logObj;
@end
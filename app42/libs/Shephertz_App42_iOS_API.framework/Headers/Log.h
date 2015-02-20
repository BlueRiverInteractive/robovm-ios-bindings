//
//  Log.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 11/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"

/**
 *
 * This Log object is the value object which contains the properties of Log
 * along with the setter & getter for those properties.
 *
 */

@interface Log : App42Response{
    
    NSMutableArray *logMessageArray;
    
}
/*!
 *set and get the list of all the messages in the log.
 */
@property(nonatomic,retain) NSMutableArray *logMessageArray;

@end

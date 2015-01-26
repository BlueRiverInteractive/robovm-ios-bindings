//
//  Queue.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 11/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"

/**
 *
 * This Queue object is the value object which contains the properties of Queue
 * along with the setter & getter for those properties.
 *
 */


@interface Queue :App42Response
{
    NSString *queueType;
    NSString *queueName;
    NSString *description;
    NSMutableArray *messageArray;
}
/*!
 *set and get the type of the message in queue. 
 */
@property(nonatomic,retain)NSString *queueType;
/*!
 *set and get the name of the queue. 
 */
@property(nonatomic,retain)NSString *queueName;
/*!
 *set and get the description of the queue. 
 */
@property(nonatomic,retain)NSString *description;
/*!
 *set and get the list of all the messages in the queue.
 */
@property(nonatomic,retain)NSMutableArray *messageArray;

-(id)init;

@end

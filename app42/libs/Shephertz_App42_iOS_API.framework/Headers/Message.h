//
//  Message.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 11/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
@class Queue;

/**
 * An inner class that contains the remaining properties of the Queue.
 *
 */

@interface Message : NSObject{
    NSString *correlationId;
    NSString *payLoad;
    NSString *messageId;
    Queue *queueObject;
}
/*!
 *set and get the queueObject for Message Object 
 */
@property(nonatomic,retain)Queue *queueObject;
/*!
 *set and get the correlationId of the messages in queue.
 */
@property(nonatomic,retain)NSString *correlationId;
/*!
 *set and get the payLoad of the messages in queue. 
 */
@property(nonatomic,retain)NSString *payLoad;
/*!
 *set and get the messageId of the messages in queue. 
 */
@property(nonatomic,retain)NSString *messageId;
- (id) init __attribute__((unavailable));
-(id)initWithQueue:(Queue*)queueObj;
@end

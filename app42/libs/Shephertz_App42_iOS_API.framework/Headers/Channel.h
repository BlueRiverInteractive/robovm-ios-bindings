//
//  Channel.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 02/07/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import "App42Response.h"
@class PushNotification;

@interface Channel : App42Response

/*!
 *set and get the name for File Object 
 */
@property(nonatomic,retain)NSString *channelName;
/*!
 *set and get the description for File Object 
 */
@property(nonatomic,retain)NSString *description;
/*!
 *set and get the uploadObject for File Object 
 */
@property(nonatomic,retain)PushNotification *pushNotificationObject;

- (id) init __attribute__((unavailable));

-(id)initWithPush:(PushNotification*)pushObj;


@end

//
//  PushNotification.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 20/06/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import "App42Response.h"

/**
 *PushNotification class contain the member variables and allowed to be set and get.
 * 
 */


@interface PushNotification : App42Response
{
    
    NSMutableArray *channelList;
}

/*!
 *set and get the fileListArray for Upload Object where fileListArray contain the File Object
 */
@property(nonatomic,retain)NSMutableArray *channelList;

@property(nonatomic,retain)NSString *message;

@property(nonatomic,retain)NSString *userName;
@property(nonatomic,retain)NSString *expiry;
@property(nonatomic,retain)NSString *type;
@property(nonatomic,retain)NSString *deviceToken;

@end

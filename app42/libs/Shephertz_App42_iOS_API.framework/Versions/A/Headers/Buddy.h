//
//  Buddy.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 21/06/13.
//  Copyright (c) 2013 ShephertzTechnology PVT LTD. All rights reserved.
//

#import "App42Response.h"
#import "BuddyPoint.h"
@interface Buddy : App42Response
{
    
}

@property(nonatomic,retain) NSString        *userName;
@property(nonatomic,retain) NSString        *buddyName;
@property(nonatomic,retain) NSString        *groupName;
@property(nonatomic,retain) NSString        *ownerName;
@property(nonatomic,retain) NSString        *message;
@property(nonatomic,retain) NSString        *messageId;
@property(nonatomic,retain) NSDate          *sendedOn;
@property(nonatomic,retain) NSDate          *acceptedOn;
@property(nonatomic,retain) NSMutableArray  *buddyList;
@property(nonatomic,retain) NSMutableArray  *pointList;

@end



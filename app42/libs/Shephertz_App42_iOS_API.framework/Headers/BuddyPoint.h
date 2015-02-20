//
//  BuddyPoint.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 21/06/13.
//  Copyright (c) 2013 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface BuddyPoint : NSObject
{
}
@property(nonatomic,assign) double latitude;
@property(nonatomic,assign) double longitude;
@property(nonatomic,retain) NSString    *buddyName;
@property(nonatomic,retain) NSString    *markerName;
@property(nonatomic,retain) NSDate      *createdOn;

-(NSDictionary*) getBuddyPointDict;
@end

//
//  Achievement.h
//  PAE_iOS_SDK
//
//  Created by Rajeev on 19/12/13.
//  Copyright (c) 2013 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Shephertz_App42_iOS_API/Shephertz_App42_iOS_API.h>

@interface Achievement : App42Response
{
}
@property(nonatomic,retain)    NSString *userName;
@property(nonatomic,retain)    NSString *description;
@property(nonatomic,retain)    NSString *name;
@property(nonatomic,retain)    NSString *gameName;
@property(nonatomic,retain)    NSDate   *achievedOn;

@end

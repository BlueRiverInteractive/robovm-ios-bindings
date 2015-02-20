//
//  Timer.h
//  PAE_iOS_SDK
//
//  Created by Rajeev on 14/06/14.
//  Copyright (c) 2014 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Shephertz_App42_iOS_API/Shephertz_App42_iOS_API.h>

@interface Timer : App42Response

@property(nonatomic,retain) NSString *name;
@property(nonatomic,retain) NSString *userName;
@property(nonatomic,retain) NSDate   *currentTime;
@property(nonatomic,retain) NSDate   *startTime;
@property(nonatomic,retain) NSDate   *endTime;
@property(nonatomic,assign) long timeInSeconds;
@property(nonatomic,assign) BOOL isTimerActive;

@end

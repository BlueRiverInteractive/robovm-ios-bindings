//
//  TimerService.h
//  PAE_iOS_SDK
//
//  Created by Rajeev on 14/06/14.
//  Copyright (c) 2014 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Shephertz_App42_iOS_API/Shephertz_App42_iOS_API.h>

@class Timer;
@interface TimerService : App42Service

- (id) init __attribute__((unavailable));
/**
 * This is a constructor that takes
 *
 * @param apiKey
 * @param secretKey
 * @param baseURL
 *
 */
-(id)initWithAPIKey:(NSString *)apiKey  secretKey:(NSString *)secretKey;


-(void)createOrUpdateTimerWithName:(NSString*)timerName timeInSeconds:(long)timeInSeconds completionBlock:(App42ResponseBlock)completionBlock;

-(void)startTimerWithName:(NSString*)timerName forUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

-(void)isTimerActive:(NSString*)timerName forUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

-(void)cancelTimerWithName:(NSString*)timerName forUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

-(void)deleteTimerWithName:(NSString*)timerName completionBlock:(App42ResponseBlock)completionBlock;

-(void)getCurrentTime:(App42ResponseBlock)completionBlock;

@end

//
//  EventService.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technologies Pvt Ltd on 23/09/14.
//  Copyright (c) 2014 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <Shephertz_App42_iOS_API/Shephertz_App42_iOS_API.h>


@interface EventService : App42Service
{
    
}



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

-(void)trackEventWithName:(NSString*)eventName andProperties:(NSDictionary*)properties completionBlock:(App42ResponseBlock)completionBlock;
-(void)startActivityWithName:(NSString*)eventName andProperties:(NSDictionary*)properties completionBlock:(App42ResponseBlock)completionBlock;
-(void)endActivityWithName:(NSString*)eventName andProperties:(NSDictionary*)properties completionBlock:(App42ResponseBlock)completionBlock;
-(void)setLoggedInUserProperties:(NSDictionary*)properties completionBlock:(App42ResponseBlock)completionBlock;
-(void)updateLoggedInUserProperties:(NSDictionary*)properties completionBlock:(App42ResponseBlock)completionBlock;

@end

//
//  App42CacheManager.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technologies Pvt Ltd on 21/11/14.
//  Copyright (c) 2014 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Constants.h"



@interface App42CacheManager : NSObject

@property(nonatomic) BOOL isCacheEnabled;
@property(nonatomic) long cacheSize;

/*!
 * Returns Singleton instance
 */
+(instancetype)sharedCacheManager;

/*!
 * Terminates cache manager
 */
+(void)terminateApp42CacheManager;

/*!
 * Returns current network status
 */
-(BOOL)isNetworkAvailable;

/*!
 * Sets cachePolicy
 */
-(void)setPolicy:(App42CachePolicy)app42CachePolicy;

/*!
 * Returns cachePolicy
 */
-(App42CachePolicy)getPolicy;

/*!
 * Sets cacheExpiryInMinutes
 */
-(void)setExpiryInMinutes:(long)expiryInMinutes;

/*!
 * Returns cacheExpiryInMinutes
 */
-(long)getExpiryInMinutes;


@end

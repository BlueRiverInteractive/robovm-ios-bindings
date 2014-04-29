//  Created by Manuel Martinez-Almeida and Lou Zell
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>

#define OK_UNSUBSCRIBED_USER_ERROR_CODE 410

@interface OKNetworker : NSObject

+(int)getStatusCodeFromAFNetworkingError:(NSError*)error;

+ (void)requestWithMethod:(NSString *)method
                     path:(NSString *)path
               parameters:(NSDictionary *)params
                  handler:(void (^)(id responseObject, NSError *error))handler;

+ (void)getFromPath:(NSString *)path
         parameters:(NSDictionary *)params
            handler:(void (^)(id responseObject, NSError *error))handler;

+ (void)postToPath:(NSString *)path
        parameters:(NSDictionary *)params
           handler:(void (^)(id responseObject, NSError *error))handler;

+ (void)putToPath:(NSString *)path
       parameters:(NSDictionary *)params
          handler:(void (^)(id responseObject, NSError *error))handler;

@end

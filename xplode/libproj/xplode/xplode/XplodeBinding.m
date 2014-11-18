//
//  xplode.m
//  xplode
//
//  Created by Sargis Sargsyan on 11/18/14.
//  Copyright (c) 2014 Sargis Sargsyan. All rights reserved.
//

#import "XplodeBinding.h"
#import <XplodeSDK/XplodeSDK.h>

@implementation XplodeBinding
+ (void)initializeWithAppHandle:(NSString *)appHandle
                      appSecret:(NSString *)appSecret
           andCompletionHandler:(void(^)(NSError *error))completionHandler{
    
    [Xplode initializeWithAppHandle:appHandle
                          appSecret:appSecret
               andCompletionHandler:completionHandler];
    
    
}

+ (void)presentPromotionForBreakpoint:(NSString *)breakpoint
                withCompletionHandler:(void(^)(BOOL isReadyToPresent, NSError *error))completionHandler
                    andDismissHandler:(void(^)(void))dismissHandler{
    
    [Xplode presentPromotionForBreakpoint:breakpoint
                    withCompletionHandler:completionHandler
                        andDismissHandler:dismissHandler];
}

@end

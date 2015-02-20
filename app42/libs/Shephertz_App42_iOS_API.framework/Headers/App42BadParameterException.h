//
//  App42BadParameterException.h
//  App42_iOS_SERVICE_APIs
//
//  Created by Shephertz Technology on 29/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Exception.h"

@interface App42BadParameterException : App42Exception
-(id)initWithreason:(NSString *)aReason userInfo:(NSDictionary *)aUserInfo :(int)httpCode :(int)appCode;
@end

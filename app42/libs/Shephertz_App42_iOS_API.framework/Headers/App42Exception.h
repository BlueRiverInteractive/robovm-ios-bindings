//
//  App42Exception.h
//  App42_iOS_SERVICE_APIs
//
//  Created by Shephertz Technology on 19/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface App42Exception : NSException{
    
    int httpErrorCode;
    int appErrorCode;
    
}
@property(nonatomic)int httpErrorCode;
@property(nonatomic)int appErrorCode;

+(App42Exception*)exceptionWithReason:(NSString *)aReason userInfo:(NSDictionary *)aUserInfo httpStatusCode:(int)httpCode appErrorCode:(int)appCode;
-(id)initWithreason:(NSString *)aReason userInfo:(NSDictionary *)aUserInfo :(int)httpCode :(int)appCode;

@end

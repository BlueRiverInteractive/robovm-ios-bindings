//
//  OKError.h
//  OpenKit
//
//  Created by Suneet Shah on 4/24/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface OKError : NSObject

+(NSError*)userNotLoggedInError;
+(NSError*)noOKUserError;
+(NSError*)unknownError;
+(NSError*)noGameCenterIDError;
+(NSError*)unknownGameCenterError;
+(NSError*)unknownFacebookRequestError;
+(NSError*)gameCenterNotAvailableError;
+(NSError*)OKServerRespondedWithDifferentUserIDError;
+(NSError*)OKScoreNotSubmittedError;
+(NSError*)noOKUserErrorScoreCached;
+(NSError*)noBodyError;

@end

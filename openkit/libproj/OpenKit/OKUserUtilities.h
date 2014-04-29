//
//  OKUserUtilities.h
//  OKClient
//
//  Created by Suneet Shah on 1/8/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>

typedef enum {
    FacebookIDType,
    TwitterIDType,
    GoogleIDType,
    //GameCenterIDType,
    CustomIDType
} OKUserIDType;

@class OKUser;
@interface OKUserUtilities : NSObject

+ (OKUser *)createOKUserWithJSONData:(NSDictionary *)jsonData;
+ (NSDictionary *)getJSONRepresentationOfUser:(OKUser *)user;
+ (void)updateUserNickForOKUser:(OKUser *)user withNewNick:(NSString *)newNick withCompletionHandler:(void(^)(NSError *error))completionHandler;
+(void)createOKUserWithUserIDType:(OKUserIDType)userIDtype withUserID:(NSString*)userID withUserNick:(NSString *)userNick withCompletionHandler:(void(^)(OKUser *user, NSError *errror))completionHandler;

+(void)updateOKUser:(OKUser *)user withCompletionHandler:(void(^)(NSError *error))completionHandler;
+(void)checkIfErrorIsUnsubscribedUserError:(NSError *)error;

+(OKUser*)guestUser;

@end

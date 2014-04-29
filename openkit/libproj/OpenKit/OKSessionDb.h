//
//  OKSessionDb.h
//  OpenKit
//
//  Created by Louis Zell on 8/22/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//
//
#import <Foundation/Foundation.h>

#import "OKLocalCache.h"


@interface OKSessionDb : OKLocalCache

+ (OKSessionDb *)db;
- (void)activate;

- (void)registerPush:(NSString *)pushToken;
- (void)loginFB:(NSString *)aFacebookId;
- (void)logoutFB;
- (void)loginGoogle:(NSString *)aGoogleId;
- (void)logoutGoogle;
- (void)loginCustom:(NSString *)aCustomId;
- (void)logoutCustom;

// Temporary.
- (void)loginOpenKit:(NSString *)anOpenKitId;
- (void)logoutOpenKit;


@end


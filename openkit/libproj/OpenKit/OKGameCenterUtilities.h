//
//  OKGameCenterUtilities.h
//  OpenKit
//
//  Created by Suneet Shah on 6/12/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <GameKit/GameKit.h>

#define OK_GAMECENTER_AUTH_NOTIFICATION @"OKGameCenterAuthNotification"

typedef void(^OKGameCenterLoginCompletionHandler)(NSError *error);

@interface OKGameCenterUtilities : NSObject

+(void)loadPlayerPhotoForGameCenterID:(NSString*)gameCenterID withPhotoSize:(GKPhotoSize)photoSize withCompletionHandler:(void(^)(UIImage *photo, NSError *error))completionhandler;
+(BOOL)isPlayerAuthenticatedWithGameCenter;
+(BOOL)isGameCenterAvailable;
+(void)authenticateLocalPlayerWithCompletionHandler:(OKGameCenterLoginCompletionHandler)completionHandler;
+(void)authorizeUserWithGameCenterAndallowUI:(BOOL)allowUI withPresentingViewController:(UIViewController*)presenter withCompletionHandler:(OKGameCenterLoginCompletionHandler)completionHandler;
+(void)authorizeUserWithGameCenterWithBlockToHandleShowingGameCenterUI:(void(^)(UIViewController* viewControllerFromGC))showUIHandler withGameCenterUICompletionHandler:(OKGameCenterLoginCompletionHandler)completionHandler;
+(void)authorizeUserWithGameCenterLegacyWithCompletionHandler:(OKGameCenterLoginCompletionHandler)completionHandler;



@end

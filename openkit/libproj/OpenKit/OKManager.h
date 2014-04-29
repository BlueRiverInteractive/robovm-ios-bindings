//
//  OKManager.h
//  OKManager
//
//  Created by Suneet Shah on 12/27/12.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>


@class OKUser;
@interface OKManager : NSObject

+ (void)configureWithAppKey:(NSString *)appKey secretKey:(NSString *)secretKey;
+ (void)configureWithAppKey:(NSString *)appKey secretKey:(NSString *)secretKey endpoint:(NSString *)endpoint;
+ (id)sharedManager;
- (void)saveCurrentUser:(OKUser *)aCurrentUser;
- (void)logoutCurrentUser;
- (void)registerToken:(NSData *)deviceToken;

@property (nonatomic) BOOL hasShownFBLoginPrompt;
@property (nonatomic, strong) NSString *leaderboardListTag;
@property (nonatomic, strong) NSArray *cachedFbFriendsList;


// See OKManagerDelegate protocol, below.
@property (nonatomic, assign) id delegate;

// Let's stop creating class helpers for getting / setting.  Instead, grab the sharedManager
// and set properties on that.  E.g.
//
//    OKManager *manager = [OKManager sharedManager];
//    manager.delegate   = anObject;
//    manager.endpoint   = "whatever";
//    manager.appKey     = "foo";
//    manager.secretKey  = "bar";
//

+ (NSString *)appKey;
+ (NSString *)endpoint;
+ (NSString *)secretKey;

+ (BOOL)handleOpenURL:(NSURL*)url;
+ (void)handleDidBecomeActive;
+ (void)handleWillTerminate;

@end

#pragma mark - OKManagerDelegate Protocol
@protocol OKManagerDelegate <NSObject>
@optional

- (void)openkitManagerWillShowDashboard:(OKManager *)manager;
- (void)openkitManagerDidShowDashboard:(OKManager *)manager;
- (void)openkitManagerWillHideDashboard:(OKManager *)manager;
- (void)openkitManagerDidHideDashboard:(OKManager *)manager;

@end


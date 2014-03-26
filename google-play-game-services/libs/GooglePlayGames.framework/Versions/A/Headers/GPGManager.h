//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <Foundation/Foundation.h>

#import "GPGEnums.h"

typedef void (^GPGReAuthenticationBlock)(BOOL requiresKeychainWipe, NSError *error);
typedef void (^GPGRevisionCheckBlock)(GPGRevisionStatus revisionStatus, NSError *error);

@class GPGApplicationModel;
@class GPGError;
@class GPPSignIn;
@class GPGTurnBasedParticipant;
@class GPGRealTimeRoomData;
@class GPGTurnBasedMatch;
@class GPGTurnBasedMatchRematch;
@class GPGTurnBasedMatchSync;
@class GPGRealTimeRoom;
@class GPGRealTimeRoomData;
@class GPGRealTimeParticipant;
@class GPGRealTimeRoomViewController;

@protocol GPGRealTimeRoomDelegate;

@protocol GPGStatusDelegate <NSObject>

@optional

- (void)didFinishGamesSignInWithError:(NSError *)error;

- (void)didFinishGamesSignOutWithError:(NSError *)error;

@end

@protocol GPGTurnBasedMatchDelegate <NSObject>

@optional

- (void)didReceiveTurnBasedInviteForMatch:(GPGTurnBasedMatch *)match
                              participant:(GPGTurnBasedParticipant *)participant
                     fromPushNotification:(BOOL)fromPushNotification;

- (void)didReceiveTurnEventForMatch:(GPGTurnBasedMatch *)match
                        participant:(GPGTurnBasedParticipant *)participant
               fromPushNotification:(BOOL)fromPushNotification;

- (void)matchEnded:(GPGTurnBasedMatch *)match
             participant:(GPGTurnBasedParticipant *)participant
    fromPushNotification:(BOOL)fromPushNotification;

- (void)failedToProcessMatchUpdate:(GPGTurnBasedMatch *)match error:(NSError *)error;

@end

extern NSString * const GPGUserDidSignOutNotification  __attribute__((deprecated));

@interface GPGManager : NSObject

+ (GPGManager *)sharedInstance;

#pragma mark Application State 

- (GPGApplicationModel *)applicationModel;
- (NSString *)applicationId;

#pragma mark Authentication 
- (BOOL)hasAuthorizer;

- (void)signout __attribute__((deprecated));

- (void)signOut;

- (void)signIn:(GPPSignIn *)signIn
    reauthorizeHandler:(GPGReAuthenticationBlock)reauthenticationBlock;

#pragma mark Push Notifications 
- (BOOL)tryHandleRemoteNotification:(NSDictionary *)userInfo;

- (void)registerDeviceToken:(NSData *)deviceTokenData
             forEnvironment:(GPGPushNotificationEnvironment)environment;

- (void)unregisterCurrentDeviceToken;


@property(nonatomic, readwrite, assign) id<GPGTurnBasedMatchDelegate> turnBasedMatchDelegate;

@property(nonatomic, readwrite, assign) id<GPGRealTimeRoomDelegate> realTimeRoomDelegate;

@property(nonatomic, readwrite, assign) id<GPGStatusDelegate> statusDelegate;

@property(nonatomic, readonly, assign, getter = isSignedIn) BOOL signedIn;

#pragma mark Device Orientation 
@property(nonatomic, readwrite, assign) NSUInteger validOrientationFlags;

@property(nonatomic, readwrite, assign) NSUInteger welcomeBackOffset;

@property(nonatomic, readwrite, assign) GPGToastPlacement welcomeBackToastPlacement;

@property(nonatomic, readwrite, assign) NSUInteger achievementUnlockedOffset;

@property(nonatomic, readwrite, assign) GPGToastPlacement achievementUnlockedToastPlacement;

@property(nonatomic, readwrite, assign) NSUInteger sdkTag;

#pragma mark - SDK Deprecation Check

- (void)refreshRevisionStatus:(GPGRevisionCheckBlock)revisionCheckHandler;

- (GPGRevisionStatus)revisionStatus;

- (BOOL)isRevisionValid;

@end

//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <Foundation/Foundation.h>

#import "GPGEnums.h"

typedef void (^GPGReAuthenticationBlock)(BOOL requiresKeychainWipe, NSError *error);
typedef void (^GPGRevisionCheckBlock)(GPGRevisionStatus revisionStatus, NSError *error);

@class GPGApplicationModel;
@class GPPSignIn;
@class GPGTurnBasedParticipant;
@class GPGRealTimeRoomData;
@class GPGTurnBasedMatch;
@class GPGTurnBasedMatchRematch;
@class GPGTurnBasedMatchSync;
@class GPGRealTimeRoom;
@class GPGRealTimeRoomData;
@class GPGRealTimeParticipant;

@protocol GPGRealTimeRoomDelegate;
@protocol GPGQuestDelegate;

@protocol GPGStatusDelegate <NSObject>

@optional

- (void)didFinishGamesSignInWithError:(NSError *)error;

- (void)didFinishGamesSignOutWithError:(NSError *)error;

- (void)didFinishGoogleAuthWithError:(NSError *)error;

- (BOOL)shouldReauthenticateWithError:(NSError *)error;

- (void)willReauthenticate:(NSError *)error;

- (void)didDisconnectWithError:(NSError *)error;

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

@interface GPGManager : NSObject

+ (instancetype)sharedInstance;

#pragma mark Application State 

@property(nonatomic, readonly, strong) GPGApplicationModel *applicationModel
    __attribute__((deprecated));

- (NSString *)applicationId __attribute__((deprecated));

#pragma mark Authentication 
- (BOOL)hasAuthorizer __attribute__((deprecated));

- (void)signOut;

- (void)signIn:(GPPSignIn *)signIn
    reauthorizeHandler:(GPGReAuthenticationBlock)reauthenticationBlock __attribute__((deprecated));

- (void)signIn;

- (BOOL)signInWithClientID:(NSString *)clientID silently:(BOOL)silently;

- (BOOL)signInWithClientID:(NSString *)clientID silently:(BOOL)silently withExtraScopes:(NSArray *)scopes;

#pragma mark Push Notifications 
- (BOOL)tryHandleRemoteNotification:(NSDictionary *)userInfo;

- (BOOL)tryHandleRemoteNotification:(NSDictionary *)userInfo
            forActionWithIdentifier:(NSString *)identifier
                  completionHandler:(void (^)())completionHandler;

- (void)registerDeviceToken:(NSData *)deviceTokenData
             forEnvironment:(GPGPushNotificationEnvironment)environment;

- (void)unregisterCurrentDeviceToken;

#if defined(__IPHONE_8_0) && (__IPHONE_OS_VERSION_MAX_ALLOWED >= __IPHONE_8_0)
+ (void)registerForInteractiveGamesNotificationsWithType:(UIUserNotificationType)type;
#endif

#pragma mark - Properties 
@property(nonatomic, weak) id<GPGTurnBasedMatchDelegate> turnBasedMatchDelegate;

@property(nonatomic, weak) id<GPGRealTimeRoomDelegate> realTimeRoomDelegate;

@property(nonatomic, weak) id<GPGStatusDelegate> statusDelegate;

@property(nonatomic, weak) id<GPGQuestDelegate> questDelegate;

@property(nonatomic, readonly, assign, getter = isSignedIn) BOOL signedIn;

@property(nonatomic, assign) BOOL appStateEnabled;

@property(nonatomic, assign) BOOL snapshotsEnabled;

@property(nonatomic, assign) NSUInteger sdkTag;

#pragma mark Device Orientation 
@property(nonatomic, assign) NSUInteger validOrientationFlags __attribute__((deprecated));

@property(nonatomic, assign) NSUInteger welcomeBackOffset;

@property(nonatomic, assign) GPGToastPlacement welcomeBackToastPlacement;

@property(nonatomic, assign) NSUInteger achievementUnlockedOffset;

@property(nonatomic, assign) GPGToastPlacement achievementUnlockedToastPlacement;

@property(nonatomic, assign) NSUInteger questCompletedOffset;

@property(nonatomic, assign) GPGToastPlacement questCompletedToastPlacement;

#pragma mark - SDK Revision Check 
- (void)refreshRevisionStatus:(GPGRevisionCheckBlock)revisionCheckHandler;

@property(nonatomic, readonly) GPGRevisionStatus revisionStatus;

@property(nonatomic, getter=isRevisionValid, readonly) BOOL revisionValid;

@end

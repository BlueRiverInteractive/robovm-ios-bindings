//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <Foundation/Foundation.h>

extern NSString *const GPGErrorDomain;

enum {
  GPGInvalidAuthenticationError = 1, // No valid authentication found. You must authenticate the user before executing the action that returned this error.

  GPGNetworkUnavailableError, // The network is offline, a network operation cannot be completed.

  GPGServiceMethodFailedError, // A method from the games service failed.

  GPGRevisionStaleError, // Current SDK version is either deprecated or invalid.

   // When a queue of service operations for a single delegate has reached max capacity (200
  // operations), GPGService will not take anymore operations for that delegate. The operation's
  // completion handler will be called with a GPGExceedsMaxQueueCapacityError.
  GPGExceedsMaxQueueCapacityError,

  GPGRealTimeErrorCreationParameters, // Invalid real-time room creation parameters

  GPGTurnBasedErrorCreationParameters, // Invalid turn-based match creation parameters

  // A connection error occurred with a real-time participant
  GPGRealTimeErrorParticipantConnection,

  GPGPushNotificationParseError, // Can't parse push notification

  GPGPushNotificationRegisterError, // Can't register push token

  GPGPushNotificationUnregisterError, // Can't unregister push token

  GPGGameIsNotRealTimeEnabled, // Game is not set to use real-time multiplayer in the developer console

  GPGGameIsNotTurnBasedEnabled, // Game is not set to use turn-based multiplayer in the developer console

  GPGNotSignedInToPlayGames, // Not currently signed into the Play Games Service

  GPGHasPendingOperationsError, // New operations are blocked due to pending ones.
};

@interface GPGError : NSError
@end


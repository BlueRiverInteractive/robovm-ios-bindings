//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//


#pragma mark - Achievements

// Achievement types.
typedef enum {
  GPGAchievementTypeUnknown = -1,
  // Standard achievement.
  GPGAchievementTypeStandard,
  // Incremental achievement.
  GPGAchievementTypeIncremental,
} GPGAchievementType;

// Achievement states.
typedef enum {
  GPGAchievementStateUnknown = -1,
  // Achievement is hidden.
  GPGAchievementStateHidden,
  // Achievement is revealed.
  GPGAchievementStateRevealed,
  // Achievement is unlocked.
  GPGAchievementStateUnlocked,
} GPGAchievementState;

#pragma mark - Leaderboards

// Leaderboard time scopes.
typedef enum {
  GPGLeaderboardTimeScopeUnknown = -1,
  // Custom values to match enum values from PlayLog event
  // Today's leaderboard scores.
  GPGLeaderboardTimeScopeToday = 1,
  // This week's leaderboard scores.
  GPGLeaderboardTimeScopeThisWeek = 2,
  // All time leaderboard scores.
  GPGLeaderboardTimeScopeAllTime = 3
} GPGLeaderboardTimeScope;

typedef enum {
  GPGLeaderboardOrderUnknown = -1,
  GPGLeaderboardOrderLargerIsBetter,
  GPGLeaderboardOrderSmallerIsBetter,
} GPGLeaderboardOrder;

#pragma mark - Push Notifications

typedef enum {
  GPGPushNotificationEnvironmentUnknown,
  GPGPushNotificationEnvironmentProduction,
  GPGPushNotificationEnvironmentSandbox
} GPGPushNotificationEnvironment;

#pragma mark - App State

// Status returned when a client tries to load app state data.
typedef enum {
  // Unknown error
  GPGAppStateLoadStatusUnknownError = -1,
  // App State loaded successfully.
  GPGAppStateLoadStatusSuccess,
  // No data stored for key
  GPGAppStateLoadStatusNotFound,
} GPGAppStateLoadStatus;

// Status returned when a client tries to update app state.
typedef enum {
  // Unknown error.
  GPGAppStateWriteStatusUnknownError = -1,
  // App State updated successfully.
  GPGAppStateWriteStatusSuccess,
  // Key, data, or version string invalid or missing
  GPGAppStateWriteStatusBadKeyDataOrVersion,
  // Need to create new key but number of keys allowed is exceeded
  GPGAppStateWriteStatusKeysQuotaExceeded,
  // Data not found for clear action
  GPGAppStateWriteStatusNotFound,
  // Tried to update with older version than on server,
  // or no existing version on server
  GPGAppStateWriteStatusConflict,
  // Key or data oversized.
  GPGAppStateWriteStatusSizeExceeded,
} GPGAppStateWriteStatus;

// Toast view placement.
typedef enum {
  kGPGToastPlacementTop,
  kGPGToastPlacementBottom,
  kGPGToastPlacementCenter,
} GPGToastPlacement;

#pragma mark - Revision status

// SDK revision check status
typedef enum {
  GPGRevisionStatusUnknown = -1,
  // Revision is up-to-date
  GPGRevisionStatusOK,
  // Revision is deprecated and should upgrade soon.
  GPGRevisionStatusDeprecated,
  // Revision is invalid and will not work.
  GPGRevisionStatusInvalid,
} GPGRevisionStatus;

#pragma mark - Multiplayer Common

extern const int kGPGMultiplayerVariantDefault;
extern const int kGPGMultiplayerVariantMin;

#pragma mark - Real-Time Multiplayer

extern const int kGPGRealTimeMinPlayers;
extern const int kGPGRealTimeMaxPlayers;

extern const int kGPGRealTimeInvalidReliableSendId;

typedef enum {
  GPGRealTimeRoomCreationSuccess,
  GPGRealTimeRoomCreationFailedMissingCreationData,
  GPGRealTimeRoomCreationFailedMissingDelegate,
  GPGRealTimeRoomCreationFailedInvalidVariant,
  GPGRealTimeRoomCreationFailedInvalidAutoMatchCount,
  GPGRealTimeRoomCreationFailedInvalidPlayerCount,
  GPGRealTimeRoomCreationFailedRoomNotInviting,
  GPGRealTimeRoomCreationFailedMultiplayerNotEnabled,
  GPGRealTimeRoomCreationFailedNotSignedIn,
  GPGRealTimeRoomCreationFailedNotOnline,
  GPGRealTimeRoomCreationFailedUnknown
} GPGRealTimeRoomCreationResult;

typedef enum {
  GPGRealTimeRoomStatusInviting,
  GPGRealTimeRoomStatusConnecting,
  GPGRealTimeRoomStatusAutoMatching,
  GPGRealTimeRoomStatusActive,
  GPGRealTimeRoomStatusDeleted,
} GPGRealTimeRoomStatus;

typedef enum {
  GPGRealTimeParticipantStatusInvited,
  GPGRealTimeParticipantStatusJoined,
  GPGRealTimeParticipantStatusDeclined,
  GPGRealTimeParticipantStatusLeft,
  GPGRealTimeParticipantStatusConnectionEstablished,
} GPGRealTimeParticipantStatus;

typedef enum {
  GPGRealTimeDataModeUnreliable,
  GPGRealTimeDataModeReliable,
} GPGRealTimeDataMode;

#pragma mark - Turn-Based Multiplayer

extern const int kGPGTurnBasedMinPlayers;
extern const int kGPGTurnBasedMaxPlayers;

typedef enum {
  GPGTurnBasedMatchCreationSuccess,
  GPGTurnBasedMatchCreationFailedMissingCreationData,
  GPGTurnBasedMatchCreationFailedInvalidVariant,
  GPGTurnBasedMatchCreationFailedInvalidAutoMatchCount,
  GPGTurnBasedMatchCreationFailedInvalidPlayerCount,
  GPGTurnBasedMatchCreationFailedRoomNotInviting,
  GPGTurnBasedMatchCreationFailedMultiplayerNotEnabled,
  GPGTurnBasedMatchCreationFailedNotSignedIn,
  GPGTurnBasedMatchCreationFailedNotOnline,
  GPGTurnBasedMatchCreationFailedUnknown
} GPGTurnBasedMatchCreationResult;

// Status for a player in a match.
typedef enum {
  GPGTurnBasedParticipantStatusUnknown = -1,
  // The Participant is slated to be invited to the match, but the invitation has
  // not been sent; the invite will be sent when it becomes their turn.
  GPGTurnBasedParticipantStatusNotInvited,
  // The Participant has been invited to join the match, but has not yet responded.
  GPGTurnBasedParticipantStatusInvited,
  // The Participant has joined the match (either after creating it or accepting an
  // invitation.)
  GPGTurnBasedParticipantStatusJoined,
  // The Participant declined an invitation to join the match.
  GPGTurnBasedParticipantStatusDeclined,
  // The Participant joined the match and then left it.
  GPGTurnBasedParticipantStatusLeft,
  // The Participant finished the match.
  GPGTurnBasedParticipantStatusFinished,
  // The Participant did not take their turn in the allotted time.
  GPGTurnBasedParticipantStatusUnresponsive,
} GPGTurnBasedParticipantStatus;

// The status of the current user in the match. Derived from the match type,
// match status, the user's participant status, and the pending participant for
// the match.
typedef enum {
  // The user has been invited to join the match and has not responded yet.
  GPGTurnBasedUserMatchStatusInvited,
  // The user is waiting for their turn.
  GPGTurnBasedUserMatchStatusAwaitingTurn,
  // The user has an action to take in the match.
  GPGTurnBasedUserMatchStatusTurn,
  // The match has ended (it is completed, canceled, or expired.)
  GPGTurnBasedUserMatchStatusMatchCompleted,
} GPGTurnBasedUserMatchStatus;

typedef enum {
  // One or more slots need to be filled by auto-matching; the match cannot
  // be established until they are filled.
  GPGTurnBasedMatchStatusAutoMatching,
  // The match has started.
  GPGTurnBasedMatchStatusActive,
  // The match has finished.
  GPGTurnBasedMatchStatusComplete,
  // The match was canceled
  GPGTurnBasedMatchStatusCanceled,
  // The match expired due to inactivity
  GPGTurnBasedMatchStatusExpired,
  // The match should no longer be shown on the client.
  GPGTurnBasedMatchStatusDeleted,
} GPGTurnBasedMatchStatus;

// A result status for a participant that has finished a match.
typedef enum {
  // The participant won the match.
  GPGTurnBasedParticipantResultStatusWin,
  // The participant lost the match.
  GPGTurnBasedParticipantResultStatusLoss,
  // The participant tied the match.
  GPGTurnBasedParticipantResultStatusTie,
  // There was no winner for the match (nobody wins or loses this kind of game.)
  GPGTurnBasedParticipantResultStatusNone,
  // The participant disconnected / left during the match.
  GPGTurnBasedParticipantResultStatusDisconnect,
  // Different clients reported different results for this participant.
  GPGTurnBasedParticipantResultStatusDisagreed,
} GPGTurnBasedParticipantResultStatus;

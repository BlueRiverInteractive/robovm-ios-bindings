//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#pragma mark - Error

extern NSString *const GPGErrorDomain;

// NSError codes in GPGErrorDomain.
enum {
  // No valid authentication found. You must authenticate the user before executing the action that
  // returned this error.
  GPGInvalidAuthenticationError = 1,
  // The network is offline, a network operation cannot be completed.
  GPGNetworkUnavailableError,
  // A method from the games service failed.
  GPGServiceMethodFailedError,
  // Current SDK version is either deprecated or invalid.
  GPGRevisionStaleError,
  // When a queue of service operations for a single delegate has reached max capacity (200
  // operations), GPGService will not take anymore operations for that delegate. The operation's
  // completion handler will be called with a GPGExceedsMaxQueueCapacityError.
  GPGExceedsMaxQueueCapacityError,
  // Invalid real-time room creation parameters
  GPGRealTimeErrorCreationParameters,
  // Invalid turn-based match creation parameters
  GPGTurnBasedErrorCreationParameters,
  // A connection error occurred with a real-time participant
  GPGRealTimeErrorParticipantConnection,
  // Can't parse push notification
  GPGPushNotificationParseError,
  // Can't register push token
  GPGPushNotificationRegisterError,
  // Can't unregister push token
  GPGPushNotificationUnregisterError,
  // Game is not set to use real-time multiplayer in the developer console
  GPGGameIsNotRealTimeEnabled,
  // Game is not set to use turn-based multiplayer in the developer console
  GPGGameIsNotTurnBasedEnabled,
  // Not currently signed into the Play Games Service
  GPGNotSignedInToPlayGames,
  // New operations are blocked due to pending ones.
  GPGHasPendingOperationsError,
};

// Data source from where to load.
typedef enum {
  // Try valid cache data first, then network request.
  GPGDataSourceCacheOrNetwork,
  // Force network request.
  GPGDataSourceNetwork,
} GPGDataSource;

#pragma mark - Launcher types
// Launcher types.
typedef NS_ENUM(NSInteger, GPGLauncherType) {
  GPGLauncherTypeUnknown = -1,
  GPGLauncherTypePlayerProfile,
  GPGLauncherTypePlayerPicker,
  GPGLauncherTypeTurnBasedMatchList,
  GPGLauncherTypeQuestList,
  GPGLauncherTypeSnapshotList,
  GPGLauncherTypeLeaderboard,
  GPGLauncherTypeLeaderboardList,
  GPGLauncherTypeAchievementList,
  GPGLauncherTypeRTMPInviteFlow,
  GPGLauncherTypeRTMPInvitesList,
  GPGLauncherTypeRTMPWaitingRoom,
  GPGLauncherTypeSettings,
};

#pragma mark - Achievements

// Achievement types.
typedef NS_ENUM(NSInteger, GPGAchievementType) {
  GPGAchievementTypeUnknown = -1,
  // Standard achievement.
  GPGAchievementTypeStandard,
  // Incremental achievement.
  GPGAchievementTypeIncremental,
};

// Achievement states.
typedef NS_ENUM(NSInteger, GPGAchievementState) {
  GPGAchievementStateUnknown = -1,
  // Achievement is hidden.
  GPGAchievementStateHidden,
  // Achievement is revealed.
  GPGAchievementStateRevealed,
  // Achievement is unlocked.
  GPGAchievementStateUnlocked,
};

#pragma mark - Leaderboards

// Leaderboard time scopes.
typedef NS_ENUM(NSInteger, GPGLeaderboardTimeScope) {
  GPGLeaderboardTimeScopeUnknown = -1,
  // Custom values to match enum values from PlayLog event
  // Today's leaderboard scores.
  GPGLeaderboardTimeScopeToday = 1,
  // This week's leaderboard scores.
  GPGLeaderboardTimeScopeThisWeek = 2,
  // All time leaderboard scores.
  GPGLeaderboardTimeScopeAllTime = 3
};

typedef NS_ENUM(NSInteger, GPGLeaderboardOrder) {
  GPGLeaderboardOrderUnknown = -1,
  GPGLeaderboardOrderLargerIsBetter,
  GPGLeaderboardOrderSmallerIsBetter,
};

#pragma mark - Push Notifications

typedef NS_ENUM(NSInteger, GPGPushNotificationEnvironment) {
  GPGPushNotificationEnvironmentUnknown,
  GPGPushNotificationEnvironmentProduction,
  GPGPushNotificationEnvironmentSandbox
};

#pragma mark - App State

// Status returned when a client tries to load app state data.
typedef NS_ENUM(NSInteger, GPGAppStateLoadStatus) {
  // Unknown error
  GPGAppStateLoadStatusUnknownError = -1,
  // App State loaded successfully.
  GPGAppStateLoadStatusSuccess,
  // No data stored for key
  GPGAppStateLoadStatusNotFound,
};

// Status returned when a client tries to update app state.
typedef NS_ENUM(NSInteger, GPGAppStateWriteStatus) {
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
};

// Toast view placement.
typedef NS_ENUM(NSInteger, GPGToastPlacement) {
  kGPGToastPlacementTop,
  kGPGToastPlacementBottom,
  kGPGToastPlacementCenter,
};

#pragma mark - Revision status

// SDK revision check status
typedef NS_ENUM(NSInteger, GPGRevisionStatus) {
  GPGRevisionStatusUnknown = -1,
  // Revision is up-to-date
  GPGRevisionStatusOK,
  // Revision is deprecated and should upgrade soon.
  GPGRevisionStatusDeprecated,
  // Revision is invalid and will not work.
  GPGRevisionStatusInvalid,
};

#pragma mark - Multiplayer Common

extern const int kGPGMultiplayerVariantDefault;
extern const int kGPGMultiplayerVariantMin;

#pragma mark - Real-Time Multiplayer

extern const int kGPGRealTimeMinPlayers;
extern const int kGPGRealTimeMaxPlayers;

extern const int kGPGRealTimeInvalidReliableSendId;

typedef NS_ENUM(NSInteger, GPGRealTimeRoomCreationResult) {
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
};

typedef NS_ENUM(NSInteger, GPGRealTimeRoomStatus) {
  GPGRealTimeRoomStatusInviting,
  GPGRealTimeRoomStatusConnecting,
  GPGRealTimeRoomStatusAutoMatching,
  GPGRealTimeRoomStatusActive,
  GPGRealTimeRoomStatusDeleted,
};

typedef NS_ENUM(NSInteger, GPGRealTimeParticipantStatus) {
  GPGRealTimeParticipantStatusInvited,
  GPGRealTimeParticipantStatusJoined,
  GPGRealTimeParticipantStatusDeclined,
  GPGRealTimeParticipantStatusLeft,
  GPGRealTimeParticipantStatusConnectionEstablished,
};

typedef NS_ENUM(NSInteger, GPGRealTimeDataMode) {
  GPGRealTimeDataModeUnreliable,
  GPGRealTimeDataModeReliable,
};

#pragma mark - Turn-Based Multiplayer

extern const int kGPGTurnBasedMinPlayers;
extern const int kGPGTurnBasedMaxPlayers;
extern const int kGPGTurnBasedParticipantResultPlacingUninitialized;

typedef NS_ENUM(NSInteger, GPGTurnBasedMatchCreationResult) {
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
};

// Status for a player in a match.
typedef NS_ENUM(NSInteger, GPGTurnBasedParticipantStatus) {
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
};

// The status of the current user in the match. Derived from the match type,
// match status, the user's participant status, and the pending participant for
// the match.
typedef NS_ENUM(NSInteger, GPGTurnBasedUserMatchStatus) {
  // The user has been invited to join the match and has not responded yet.
  GPGTurnBasedUserMatchStatusInvited,
  // The user is waiting for their turn.
  GPGTurnBasedUserMatchStatusAwaitingTurn,
  // The user has an action to take in the match.
  GPGTurnBasedUserMatchStatusTurn,
  // The match has ended (it is completed, canceled, or expired.)
  GPGTurnBasedUserMatchStatusMatchCompleted,
};

typedef NS_ENUM(NSInteger, GPGTurnBasedMatchStatus) {
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
};

// A result status for a participant that has finished a match.
typedef NS_ENUM(NSInteger, GPGTurnBasedParticipantResultStatus) {
  // The participant result status was never set.
  GPGTurnBasedParticipantResultStatusUninitialized = -1,
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
};

#pragma mark - Quests

// State for a quest.
typedef NS_ENUM(NSInteger, GPGQuestState) {
  // Upcoming quest, before start time.
  GPGQuestStateUpcoming,
  // Open quest, in between start time and expiration time.
  GPGQuestStateOpen,
  // Quest accepted by player, in between start time and expiration time.
  GPGQuestStateAccepted,
  // Quest completed by player, rewards been claimed.
  GPGQuestStateCompleted,
  // Quest expired, not accepted by player, after expiration time.
  GPGQuestStateExpired,
  // Quest expired, accepted by player, after expiration time.
  GPGQuestStateFailed,
};

// State for a quest milestone.
typedef NS_ENUM(NSInteger, GPGQuestMilestoneState) {
  // The Quest has not been accepted. Note that this is new in v3.1.
  GPGQuestMilestoneStateNotStarted,
  // The Quest has been accepted but the milestone is not completed.
  GPGQuestMilestoneStateNotCompleted,
  // Milestone is completed, not claimed.
  GPGQuestMilestoneStateCompletedNotClaimed,
  // Milestone is completed, claimed.
  GPGQuestMilestoneStateClaimed,
};

#pragma mark - Snapshots

// Values used to specify the Snapshot conflict resolution policy.
typedef NS_ENUM(NSInteger, GPGSnapshotConflictPolicy) {
  // In the event of a conflict, the conflict data will be returned to you, and you must resolve
  // the conflict. This is the only policy where the conflicts will be visible to you. Use this for
  // a custom merge. This policy ensures that no user changes to the state of the save game
  // will ever be lost.
  GPGSnapshotConflictPolicyManual,
  // In the event of a conflict, the snapshot with the largest playtime value will be used.
  // This policy is a good choice if the length of play time is a reasonable
  // proxy for the "best" save game. Note that you must use
  // |SnapshotMetadataChange.playedTime| when saving games for this policy to be meaningful.
  GPGSnapshotConflictPolicyLongestPlaytime,
  // In the event of a conflict, the conflictSnapshot, or the last agreed upon
  // good version of the snapshot will be used.
  // This policy is a reasonable choice if your game requires stability from
  // the snapshot data. This policy ensures that only writes which are not
  // contested are seen by the player, which guarantees that all clients
  // converge.
  // Note: previously |GPGSnapshotConflictPolicyBaseWins|.
  GPGSnapshotConflictPolicyLastKnownGood,
  // In the event of a conflict, the most recently modified snapshot will be used.
  // This policy is a reasonable choice if your game can tolerate players
  // on multiple devices clobbering their own changes. Because this policy
  // blindly chooses the most recent data, it is possible that a player's
  // changes may get lost.
  // Note: previously |GPGSnapshotConflictPolicyRemoteWins|.
  GPGSnapshotConflictPolicyMostRecentlyModified,
};

//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <Foundation/Foundation.h>

#import "GPGEnums.h"

@class GPGMultiplayerConfig;
@class GPGTurnBasedParticipant;
@class GPGPlayer;
@class GPGTurnBasedMatch;
@class GPGTurnBasedParticipantResult;

typedef void (^GPGTurnBasedMatchCreateBlock)(GPGTurnBasedMatch *match, NSError *error);

typedef void (^GPGTurnBasedMatchGetBlock)(GPGTurnBasedMatch *match, NSError *error);

typedef void (^GPGTurnBasedMatchesBlock)(NSArray *matches, NSError *error);

typedef void (^GPGTurnBasedMatchListBlock)(NSArray *matches, NSString *pageToken, NSError *error);

typedef void (^GPGTurnBasedMatchRematchBlock)(GPGTurnBasedMatch *rematch, NSError *error);

typedef void (^GPGTurnBasedMatchCompletionBlock)(NSError *error);

@interface GPGTurnBasedMatch : NSObject

@property(nonatomic, readonly, copy) GPGMultiplayerConfig *matchConfig;

@property(nonatomic, readonly, assign) int64_t creationTimestamp;

@property(nonatomic, readonly, copy) GPGTurnBasedParticipant *creationParticipant;

@property(nonatomic, readonly, copy) NSData *data;

@property(nonatomic, readonly, assign) BOOL dataAvailable;

@property(nonatomic, readonly, copy) GPGTurnBasedParticipant *inviterParticipant;

@property(nonatomic, readonly, assign) int64_t lastUpdateTimestamp;

@property(nonatomic, readonly, copy) GPGTurnBasedParticipant *lastUpdateParticipant;

@property(nonatomic, readonly, copy) NSString *matchDescription;

@property(nonatomic, readonly, copy) NSString *matchId;

@property(nonatomic, readonly, assign) int matchNumber;

@property(nonatomic, readonly, assign) int matchVersion;

@property(nonatomic, readonly, copy) NSArray *participants;

@property(nonatomic, readonly, copy) GPGTurnBasedParticipant *pendingParticipant;

@property(nonatomic, readonly, copy) NSData *previousMatchData;

@property(nonatomic, readonly, assign) BOOL previousMatchDataAvailable;

@property(nonatomic, readonly, copy) NSString *rematchId;

@property(nonatomic, readonly, copy) NSArray *results;

@property(nonatomic, readonly, assign) GPGTurnBasedMatchStatus status;

@property(nonatomic, readonly, assign) GPGTurnBasedUserMatchStatus userMatchStatus;

#pragma mark - Convenience Functions

- (BOOL)canParticipantTakeTurn:(NSString *)participantId;

@property(nonatomic, readonly, copy) NSString *localParticipantId;

- (NSString *)participantIdForPlayerId:(NSString *)playerId;

@property(nonatomic, readonly, strong) GPGTurnBasedParticipant *localParticipant;

- (GPGTurnBasedParticipant *)participantForId:(NSString *)participantId;

@property(nonatomic, readonly, strong) GPGPlayer *pendingPlayer;

@property(nonatomic, getter=isMyTurn, readonly) BOOL myTurn;

@property(nonatomic, readonly, strong) GPGTurnBasedParticipantResult *myResult;

- (GPGTurnBasedParticipantResult *)resultForParticipantId:(NSString *)participantId;

- (GPGTurnBasedParticipantStatus)statusForPlayerId:(NSString *)playerId;

@property(nonatomic, readonly) GPGTurnBasedParticipantStatus myStatus;

+ (GPGTurnBasedMatchCreationResult)createMatchWithConfig:(GPGMultiplayerConfig *)config
                                       completionHandler:(GPGTurnBasedMatchCreateBlock)completionHandler;

+ (void)fetchMatchWithId:(NSString *)matchId
        includeMatchData:(BOOL)includeMatchData
       completionHandler:(GPGTurnBasedMatchGetBlock)completionHandler;

+ (void)listForIncludeMatchData:(BOOL)includeMatchData
            maxCompletedMatches:(int)maxCompletedMatches
                     maxResults:(int)maxResults
                      pageToken:(NSString *)pageToken
              completionHandler:(GPGTurnBasedMatchListBlock)completionHandler;

+ (void)allMatchesWithCompletionHandler:(GPGTurnBasedMatchesBlock)completionHandler;

+ (void)allMatchesFromDataSource:(GPGDataSource)dataSource
               completionHandler:(GPGTurnBasedMatchesBlock)completionHandler;

+ (void)matchesForMatchStatus:(GPGTurnBasedMatchStatus)status
            completionHandler:(GPGTurnBasedMatchesBlock)completionHandler;

+ (void)matchesForMatchStatus:(GPGTurnBasedMatchStatus)status
                   dataSource:(GPGDataSource)dataSource
            completionHandler:(GPGTurnBasedMatchesBlock)completionHandler;

+ (void)matchesForUserMatchStatus:(GPGTurnBasedUserMatchStatus)status
                completionHandler:(GPGTurnBasedMatchesBlock)completionHandler;

+ (void)matchesForUserMatchStatus:(GPGTurnBasedUserMatchStatus)status
                       dataSource:(GPGDataSource)dataSource
                completionHandler:(GPGTurnBasedMatchesBlock)completionHandler;

- (void)cancelWithCompletionHandler:(GPGTurnBasedMatchCompletionBlock)completionHandler;

- (void)declineWithCompletionHandler:(GPGTurnBasedMatchCompletionBlock)completionHandler;

- (void)dismissWithCompletionHandler:(GPGTurnBasedMatchCompletionBlock)completionHandler;

- (void)finishWithData:(NSData *)data
               results:(NSArray *)results
     completionHandler:(GPGTurnBasedMatchCompletionBlock)completionHandler;

- (void)joinWithCompletionHandler:(GPGTurnBasedMatchCompletionBlock)completionHandler;

- (void)leaveOutOfTurnWithCompletionHandler:(GPGTurnBasedMatchCompletionBlock)completionHandler;

- (void)leaveDuringTurnWithNextParticipantId:(NSString *)nextParticipantId
                           completionHandler:(GPGTurnBasedMatchCompletionBlock)completionHandler;

- (void)rematchWithCompletionHandler:(GPGTurnBasedMatchRematchBlock)completionHandler;

- (void)takeTurnWithNextParticipantId:(NSString *)nextParticipantId
                                 data:(NSData *)data
                              results:(NSArray *)results
                    completionHandler:(GPGTurnBasedMatchCompletionBlock)completionHandler;

@end

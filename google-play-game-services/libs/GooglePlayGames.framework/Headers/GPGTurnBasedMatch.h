//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "GPGEnums.h"

@class GPGError;
@class GPGMultiplayerConfig;
@class GPGTurnBasedParticipant;
@class GPGPlayer;
@class GPGTurnBasedMatch;
@class GPGTurnBasedParticipantResult;

typedef void (^GPGTurnBasedMatchCreateBlock)(GPGTurnBasedMatch *match, NSError *error);

typedef void (^GPGTurnBasedMatchGetBlock)(GPGTurnBasedMatch *match, NSError *error);

typedef void (^GPGTurnBasedMatchListBlock)(NSArray *matches, NSString *pageToken, NSError *error);

typedef void (^GPGTurnBasedMatchRematchBlock)(GPGTurnBasedMatch *rematch, NSError *error);

typedef void (^GPGTurnBasedMatchCompletionBlock)(NSError *error);

@interface GPGTurnBasedMatch : NSObject

@property(nonatomic, readonly, retain) GPGMultiplayerConfig *matchConfig;

@property(nonatomic, readonly, assign) long long creationTimestamp;

@property(nonatomic, readonly, copy) GPGTurnBasedParticipant *creationParticipant;

@property(nonatomic, readonly, assign) long long lastUpdateTimestamp;

@property(nonatomic, readonly, copy) GPGTurnBasedParticipant *lastUpdateParticipant;

@property(nonatomic, readonly, retain) NSData *data;

@property(nonatomic, readonly, assign) BOOL dataAvailable;

@property(nonatomic, readonly, copy) NSString *matchDescription;

@property(nonatomic, readonly, copy) NSString *matchId;

@property(nonatomic, readonly, assign) int matchNumber;

@property(nonatomic, readonly, assign) int matchVersion;

@property(nonatomic, readonly, retain) NSArray *participants;

@property(nonatomic, readonly, copy) GPGTurnBasedParticipant *pendingParticipant;

@property(nonatomic, readonly, retain) NSData *previousMatchData;

@property(nonatomic, readonly, assign) BOOL previousMatchDataAvailable;

@property(nonatomic, readonly, copy) NSString *rematchId;

@property(nonatomic, readonly, retain) NSArray *results;

@property(nonatomic, readonly, assign) GPGTurnBasedMatchStatus status;


@property(nonatomic, readonly, assign) GPGTurnBasedUserMatchStatus userMatchStatus;

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

#pragma mark - Convenience Functions

- (BOOL)canParticipantTakeTurn:(NSString *)participantId;

- (NSString *)localParticipantId;

- (NSString *)participantIdForPlayerId:(NSString *)playerId;

- (GPGTurnBasedParticipant *)localParticipant;

- (GPGTurnBasedParticipant *)participantForId:(NSString *)participantId;

- (GPGPlayer *)pendingPlayer;

- (BOOL)isMyTurn;

- (GPGTurnBasedParticipantResult *)myResult;

- (GPGTurnBasedParticipantResult *)resultForParticipantId:(NSString *)participantId;

- (GPGTurnBasedParticipantStatus)statusForPlayerId:(NSString *)playerId;

- (GPGTurnBasedParticipantStatus)myStatus;

@end
